package Registro;

import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.util.Conversor;
import log.HardwareType;
import log.Log;
import log.LogLevel;
import log.LogManager;
import modelo.Computador;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LeituraComputador extends Leitura{
    private Integer qtdCpusLogicas;
    private Integer qtdCpusFisicas;
    private String usoMemoria;
    private Double porcentagemConsumoMemoria;
    private String nomeProcessador;
    private String qtdMaximaMemoria;
    private Double porcentagemConsumosCpus;
    private Double menorPorcentDisco;


    public String getNomeProcessador() {
        return nomeProcessador;
    }

    public Double getPorcentagemConsumosCpus() {
        return porcentagemConsumosCpus;
    }

    public Double getPorcentagemConsumoMemoria() {
        return porcentagemConsumoMemoria;
    }

    private Memoria memoria = looca.getMemoria();
    private Double maxDisco = 0.0;
    private DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
    private List<Volume> volumes = grupoDeDiscos.getVolumes();
    private List<Long> porcentagemVolumes;

    // constructor

    public LeituraComputador(Computador computador) {
        super(computador);
        this.porcentagemVolumes = new ArrayList<>();
        realizarLeitura();
    }

    // outros métodos

    public void realizarLeitura(){
        this.qtdMaximaMemoria = Conversor.formatarBytes(memoria.getTotal());
        this.usoMemoria = Conversor.formatarBytes(memoria.getEmUso());
        this.porcentagemConsumoMemoria = memoria.getEmUso() * 100.0 / memoria.getTotal();

        for (Volume volume : volumes) {
            if(volume.getTotal() > 0){
                maxDisco += volume.getTotal();
                porcentagemVolumes.add(((volume.getTotal() - volume.getDisponivel()) * 100) / volume.getTotal());
            }
        }

        // percorrer a lista de % de consumo de discos e pegar o maior número da lista
        Optional<Double> menorPorcentDisco = porcentagemVolumes.stream()
                .map(e -> e.doubleValue())
                .max(Comparator.naturalOrder());

        this.menorPorcentDisco = menorPorcentDisco.get();

        this.nomeProcessador = looca.getProcessador().getNome();
        this.qtdCpusFisicas = looca.getProcessador().getNumeroCpusFisicas();
        this.qtdCpusLogicas = looca.getProcessador().getNumeroCpusLogicas();
        this.porcentagemConsumosCpus = looca.getProcessador().getUso();
    }


    @Override
    public void inserirLeitura() throws InterruptedException, IOException {
        for (int i = 1; true; i++) {

            this.realizarLeitura();

            String queryRamCpu = "INSERT INTO leituraRamCpu (ram, cpu, fkComputador, fkDepartamento, fkHospital) VALUES("
                + this.porcentagemConsumoMemoria + ", "
                + this.porcentagemConsumosCpus + ", "
                + super.getComputador().getIdComputador() + ", "
                + super.getComputador().getFkDepartamento() + ", "
                + super.getComputador().getFkHospital() + "); ";

            System.out.printf("""
                    COMANDO DE INSERÇÃO DE LEITURAS DE RAM E CPU:
                    %s \n
                    """, queryRamCpu);
            executarQuery(conn, queryRamCpu, LeituraComputador.class);
            executarQuery(connSQL, queryRamCpu, LeituraComputador.class);


            new LeituraJanela(super.getComputador());

            if (i > 9) {
                String queryDisco = "INSERT INTO leituraDisco (disco, fkComputador, fkDepartamento, fkHospital) VALUES ("
                        + this.menorPorcentDisco + ","
                        + super.getComputador().getIdComputador() + ", "
                        + super.getComputador().getFkDepartamento() + ", "
                        + super.getComputador().getFkHospital() + "); ";

                System.out.printf("""
                        COMANDO DE INSERÇÃO DE DISCO EM USO: \n
                        %s \n
                        """, queryDisco);
                executarQuery(conn, queryDisco, LeituraComputador.class);
                executarQuery(connSQL, queryDisco, LeituraComputador.class);

                i = 0;
            }
            Thread.sleep(5000);
        }
    }
}