    package Persistencia;
    
    import org.apache.commons.dbcp2.BasicDataSource;
    import org.springframework.jdbc.core.JdbcTemplate;
    
    public class Conexao {
        private JdbcTemplate conn;
    
        public Conexao(){
            BasicDataSource ds = new BasicDataSource();
    
            ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
            // Para VM
            // ds.setUrl("jdbc:mysql://mysql:3306/medtech");
            ds.setUrl("jdbc:mysql://localhost:3306/medtech");
            ds.setUsername("root");
            ds.setPassword("1331");

            this.conn = new JdbcTemplate(ds);
        }
    
        public JdbcTemplate getConn() {
            return this.conn;
        }
    }