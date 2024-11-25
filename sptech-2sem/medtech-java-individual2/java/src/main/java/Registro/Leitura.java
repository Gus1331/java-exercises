package Registro;

import Persistencia.Conexao;
import Persistencia.ConexaoSQL;
import com.github.britooo.looca.api.core.Looca;
import log.Log;
import log.LogLevel;
import log.LogManager;
import modelo.Computador;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;

public abstract class Leitura {
    private Computador computador;

    protected Looca looca = new Looca();
    static Conexao conexao = new Conexao();
    static ConexaoSQL conexaoSQL = new ConexaoSQL();
    static JdbcTemplate conn = conexao.getConn();
    static JdbcTemplate connSQL = conexaoSQL.getConn();
    // constructor

    public Leitura(Computador computador) {
        this.computador = computador;
    }

    // outros métodos

    public void executarQuery(JdbcTemplate jdbcTemplate, String query, Class<?> clazz){
        try {
            jdbcTemplate.execute(query);
        } catch (CannotGetJdbcConnectionException e) {
            System.err.println("Erro de conexão com o banco de dados ao executar query: " + e.getMessage());
            LogManager.salvarLog(new Log(clazz, "ERRO DE CONEXÃO: " + e.getMessage(), LogLevel.INFO));
        } catch (DataAccessException e) {
            LogManager.salvarLog(new Log(clazz, "Erro ao executar query: " + e.getMessage(), LogLevel.WARNING));
        } catch (Exception e) {
            LogManager.salvarLog(new Log(clazz, "Erro inesperado ao executar query: " + e.getMessage(), LogLevel.ERROR));
        }
    }
    public abstract void inserirLeitura() throws InterruptedException, IOException;
    public abstract  void realizarLeitura() throws IOException, InterruptedException;

    // getter

    public Computador getComputador() {
        return computador;
    }
}
