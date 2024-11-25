package repositorio;

import modelo.Hospital;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class HospitalRepositorio {
    
    final JdbcTemplate conn;
    final JdbcTemplate connSQL;

    public HospitalRepositorio(JdbcTemplate conn, JdbcTemplate connSQL)
    {
        this.conn = conn;
        this.connSQL = connSQL;

    };

    public Hospital buscarHospitalPorId(int id, JdbcTemplate connExec){
        return connExec.queryForObject("SELECT * FROM hospital WHERE idHospital = ?;", new BeanPropertyRowMapper<>(Hospital.class), id);
    }
}
