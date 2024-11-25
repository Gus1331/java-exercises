package Registro;

import com.github.britooo.looca.api.group.janelas.Janela;
import com.github.britooo.looca.api.group.janelas.JanelaGrupo;
import log.Log;
import log.LogLevel;
import log.LogManager;
import modelo.Computador;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Comunicacao.Slack;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.SingleColumnRowMapper;

// meu individual
import java.util.Optional;

public class LeituraJanela extends Leitura{
    private List<Janela> listaGuias;

    private List<String> redesSociais;
    // constructor

    public LeituraJanela(Computador computador) throws IOException, InterruptedException {
        super(computador);
        this.listaGuias = new ArrayList<>();
        this.redesSociais = buscarJanelas();
        realizarLeitura();
    }

    // outros métodos
    public void realizarLeitura() throws IOException, InterruptedException {
        JanelaGrupo janelaGrupo = looca.getGrupoDeJanelas();
        List<Janela> listaJanelas = janelaGrupo.getJanelas();
        for (Janela listaJanela : listaJanelas) {
            if (listaJanela.getTitulo().contains("Google Chrome") || listaJanela.getTitulo().contains("Google Chrome") || listaJanela.getTitulo().contains("Firefox") || listaJanela.getTitulo().contains("Opera")) {
                for (String redeSocial : this.redesSociais) {
                    if(listaJanela.getTitulo().toUpperCase().contains(redeSocial.toUpperCase())){
                        System.out.println("Enviando slack referente a guia: " + redeSocial);

                        JSONObject json = new JSONObject();
                        json.put("text","\uD83D\uDEA8" + "o computador acessou " +getComputador().getNome() + " acessou a guia " + redeSocial +  "\n" + "INFORMAÇÕES DO COMPUTADOR: \n"+ getComputador());
                        Slack.enviarMensagem(json);
                    }
                }
                listaGuias.add(listaJanela);
                if(listaJanela.getTitulo().toLowerCase().contains("facebook")){
                    System.out.println("Facebook detectado, PID: " + (int)(long)listaJanela.getPid());
                    Long pid = listaJanela.getPid();

                    Optional<ProcessHandle> optionalProcessHandle = ProcessHandle.of(pid);

                    ProcessHandle processHandle = optionalProcessHandle.get();
                    boolean killed = processHandle.destroy();
                    if (killed) {
                        System.out.println("Processo " + pid + " foi terminado com sucesso.");

                    } else {
                        System.out.println("Falha ao terminar o processo " + pid + ".");
                    }
                }
            }
        }
        this.inserirLeitura();
    }

    @Override
    public void inserirLeitura() {
        for (Janela janela : this.listaGuias) {
            String queryFerramenta =
                    "INSERT INTO leituraFerramenta (nomeApp, caminho, fkComputador, fkDepartamento, fkHospital) VALUES( '"
                            + janela.getTitulo() + "', '"
                            + janela.getComando() + "', "
                            + super.getComputador().getIdComputador() + ", "
                            + super.getComputador().getFkDepartamento() + ", "
                            + super.getComputador().getFkHospital() + "); ";

            System.out.printf("""
                        COMANDO DE INSERÇÃO DE LEITURAS DE FERRAMENTAS EM USO: \n
                        %s \n
                        """, queryFerramenta);
            executarQuery(conn, queryFerramenta, LeituraJanela.class);
            executarQuery(connSQL, queryFerramenta, LeituraJanela.class);
        }
    }
    public List<String> buscarJanelas(){
        List<String> blackListJanelas = new ArrayList<>();
        try{
            blackListJanelas = connSQL.query("SELECT nome FROM filtroFerramenta WHERE fkHospital = ?;",  new SingleColumnRowMapper<>(String.class), super.getComputador().getFkHospital());
        }catch (CannotGetJdbcConnectionException e){
            LogManager.salvarLog(new Log(LeituraJanela.class, "ERRO DE CONEXÃO: " + e.getMessage(), LogLevel.INFO));
            try{
                blackListJanelas = conn.query("SELECT nome FROM filtroFerramenta WHERE fkHospital = ?;",  new SingleColumnRowMapper<>(String.class), super.getComputador().getFkHospital());
            }catch (Exception ex){
                LogManager.salvarLog(new Log(LeituraJanela.class, "Erro ao executar query: " + ex.getMessage(), LogLevel.ERROR));
            }
        }
        return blackListJanelas;
    }
}
