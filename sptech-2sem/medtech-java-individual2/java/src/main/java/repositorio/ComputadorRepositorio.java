package repositorio;

import com.github.britooo.looca.api.group.discos.Volume;
import modelo.Computador;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import modelo.Departamento;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ComputadorRepositorio {

    final JdbcTemplate conn;
    final JdbcTemplate connSQL;

    public ComputadorRepositorio(JdbcTemplate conn, JdbcTemplate connSQL) {
        this.conn = conn;
        this.connSQL = connSQL;
    }

    public List<Computador> autenticarComputador(String senha, String codPatrimonio) {
        DepartamentoRepositorio departamentoRepositorio = new DepartamentoRepositorio(this.conn, this.connSQL);

        String querySelect = """
                SELECT
                c.idComputador,
                c.nome,
                c.modeloProcessador,
                c.codPatrimonio,
                c.gbRam as maxRam,
                c.gbDisco as maxDisco,
                c.fkDepartamento,
                c.fkHospital
                FROM computador c
                WHERE senha = ?
                AND codPatrimonio = ?;
                """;
        List<Computador> computadorEncontrado = new ArrayList<>();
        JdbcTemplate connExec = connSQL;
        try {
            computadorEncontrado = connSQL.query(querySelect, new BeanPropertyRowMapper<>(Computador.class), senha, codPatrimonio);
        } catch (CannotGetJdbcConnectionException e) {
            /*connExec = conn;
            computadorEncontrado = conn.query(querySelect, new BeanPropertyRowMapper<>(Computador.class), senha, codPatrimonio);*/
        }

        if (!computadorEncontrado.isEmpty()) {
            if(!Objects.equals(computadorEncontrado.get(0).getModeloProcessador(), computadorEncontrado.get(0).getProcessador().getNome())
               ||computadorEncontrado.get(0).getMaxRam() != (computadorEncontrado.get(0).getMemoria().getTotal() / 1000000000.0)
               || !Objects.equals(computadorEncontrado.get(0).getMaxDisco(), capturarTotalDisco(computadorEncontrado.get(0)))
            ){
                connExec.update(
                        "update computador set modeloProcessador = '" + computadorEncontrado.get(0).getProcessador().getNome() + "', gbRam = "+ computadorEncontrado.get(0).getMemoria().getTotal() / 1000000000.0 +", gbDisco = "+ capturarTotalDisco(computadorEncontrado.get(0)) + " where idComputador = "+ computadorEncontrado.get(0).getIdComputador() +";");
                computadorEncontrado = connExec.query(querySelect, new BeanPropertyRowMapper<>(Computador.class), senha, codPatrimonio);
            }
            computadorEncontrado.get(0).setDepartamento(departamentoRepositorio.buscarDepartamentoPorId(computadorEncontrado.get(0).getFkDepartamento(), connExec));
        }
        return computadorEncontrado;

    }
    public Double capturarTotalDisco(Computador computadorDiscos){
        Integer porcentagemMenorDiscoDisponivel = 0;
        Volume menorVolume = computadorDiscos.getVolumes().get(0);
        for (Volume volume : computadorDiscos.getVolumes()) {
            if(porcentagemMenorDiscoDisponivel < (int)(((volume.getTotal() - volume.getDisponivel()) * 100 / volume.getTotal())) ){
                porcentagemMenorDiscoDisponivel = (int) (((volume.getTotal() - volume.getDisponivel()) * 100 / volume.getTotal()));
                menorVolume = volume;
            }
        }
        return (menorVolume.getTotal() / 1000000000.0);
    }
}