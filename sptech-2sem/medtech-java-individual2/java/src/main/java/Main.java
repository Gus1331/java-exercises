import Persistencia.Conexao;
import Persistencia.ConexaoSQL;
import Registro.Leitura;
import Registro.LeituraComputador;
import Registro.LeituraJanela;
import com.github.britooo.looca.api.group.janelas.Janela;
import modelo.Departamento;
import modelo.Hospital;
import org.springframework.jdbc.core.JdbcTemplate;
import repositorio.ComputadorRepositorio;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import modelo.Computador;
import log.HardwareType;
import log.Log;
import log.LogLevel;
import log.LogManager;

import java.util.Timer;
import java.util.TimerTask;


public class Main {


    static Conexao conexao = new Conexao();
    static JdbcTemplate conn = conexao.getConn();

    static ConexaoSQL conexaoSQL = new ConexaoSQL();
    static JdbcTemplate connSQL = conexaoSQL.getConn();

    public static void main(String[] args) throws InterruptedException, IOException {
        telaInicial();
    }

    static void telaInicial() throws InterruptedException {

        System.out.println("""
                         
                         :JJJ~        !JJ?.      !JJJJJJJJJ?:     :JJJJJJJJJ7~:      !JJJJJJJJJJJ~    .?JJJJJJJJJ7.      .^7?JJJJJ?!:     .?J!       ^JJ:            \s
                         :YYYY~     .7YYYJ.      75J:.......      :YY!....:^7YY7.    ....:J57.....    :J57........      ~JY?~:..:^!?~     .J5!       ^YY:            \s
                         :YY!?Y!   .757!YJ.      75?:......       :YY!       :J57.       .J5!         :JY!.......      ~YY~               .JY7.......~YY:            \s
                         :YY^.J5! .?57 ~YJ.      7YYJJJJJJJ^      :YY!        !YJ:       .J5!         :JYYJJJJJJ?.     75?.               .JYYJJJJJJJJYY:            \s
                         :YY^ .?Y?JY!  !YJ.      75?:......       :YY!       :J57.       .J5!         :JY!.......      ~YY~               .JY7:::::::~YY:            \s
                         :YY^  .?YY!   !YJ.      75?:........     :YY!....:^!YY7.        .J5!         :J5!........      ~JY?~:...^!?^     .J5!       ^YY:            \s
                         :JJ^   .::    ~Y?.      !YJJJJJJJJJ~     :JYJJJJJJJ?~:          .?Y!         :?YJJJJJJJJ?:      .~7JJJJJJ?~:     .?Y!       ^YY:            \s
                """);
        System.out.println("""
                BEM-VINDO(A) AO NOSSO SISTEMA DE MONITORAMENTO DE COMPUTADORES!
                """);
        login();
    }


    static void login() throws InterruptedException {
        System.out.println("Login iniciado! \n");

        ComputadorRepositorio repositorioComputador = new ComputadorRepositorio(conn, connSQL);

        List computadorAutenticado;
        do {
            System.out.println("Código do patrimônio:");
            String codPatrimonio = System.getenv("CODIGO_PATRIMONIO");
            System.out.println("Senha:");
            String senhaH = System.getenv("SENHA_PC");


            computadorAutenticado = repositorioComputador.autenticarComputador(senhaH, codPatrimonio);

            if (computadorAutenticado.size() != 1) {
                System.out.println("Código do patrimônio ou senha incorreta. \nPor favor, tente novamente. \n");
            }

        } while (computadorAutenticado.size() != 1);

        System.out.println("""
                \n
                Login realizado com sucesso!
                Estes são os dados da conta acessada:
                \n
                """);

        Computador computador = (Computador) computadorAutenticado.get(0);
        System.out.println(computador);

        System.out.println("\nAGORA ESTE COMPUTADOR ESTÁ SENDO MONITORADO EM TEMPO REAL.");

        LeituraComputador leitura = new LeituraComputador(computador);

        try{
            leitura.inserirLeitura();
        } catch (InterruptedException interruptedException){
            System.out.println("Erro na Classe Main metodo login()");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
