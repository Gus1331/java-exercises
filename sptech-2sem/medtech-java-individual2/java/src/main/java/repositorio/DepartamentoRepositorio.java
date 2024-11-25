package repositorio;

import modelo.Departamento;
import modelo.Hospital;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoRepositorio {

    final JdbcTemplate conn;
    final JdbcTemplate connSQL;


    public DepartamentoRepositorio(JdbcTemplate conn, JdbcTemplate connSQL)
    {
        this.conn = conn;
        this.connSQL = connSQL;
    }

    public Departamento buscarDepartamentoPorId(int id, JdbcTemplate connExec){

        HospitalRepositorio hospitalRepositorio = new HospitalRepositorio(conn, connSQL);

        List<Departamento> departamento = connExec.query("SELECT * FROM departamento WHERE idDepartamento = ?;", new BeanPropertyRowMapper<>(Departamento.class), id);


        departamento.get(0).setHospital(hospitalRepositorio.buscarHospitalPorId(departamento.get(0).getFkHospital(), connExec));

        return departamento.get(0);
    }

}
