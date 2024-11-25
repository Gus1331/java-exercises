package Persistencia;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConexaoSQL {
    private JdbcTemplate conn;

    public ConexaoSQL(){
        BasicDataSource ds = new BasicDataSource();

        ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ds.setUrl("jdbc:sqlserver://34.195.43.136:1433;encrypt=false;databaseName=medtech;");
        ds.setUsername("sa");
        ds.setPassword("medtech");


        this.conn = new JdbcTemplate(ds);
    }

    public JdbcTemplate getConn() {
        return this.conn;
    }
}
