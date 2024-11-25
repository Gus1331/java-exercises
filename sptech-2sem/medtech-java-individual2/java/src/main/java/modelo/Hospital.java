package modelo;
import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private int idHospital;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;

    private List<Departamento> departamentos;

    public Hospital(int idHospital, String nomeFantasia, String razaoSocial, String cnpj, String senha){
        this.idHospital = idHospital;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.departamentos = new ArrayList<>();
    }

    public Hospital(){
        this.departamentos = new ArrayList<>();
    }

    // outros métodos

    public void addDepartamento(Departamento departamento){
        if(this.departamentos.contains(departamento)){
            return;
        }
        this.departamentos.add(departamento);
    }

    //Getters

    public int getIdHospital() {
        return this.idHospital;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    //Setters

    public void setIdHospital(int idHospital)
    {
        this.idHospital = idHospital;
    }

    public void setNomeFantasia(String nomeFantasia)
    {
        this.nomeFantasia = nomeFantasia;
    }

    public void setRazaoSocial(String razaoSocial)
    {
        this.razaoSocial = razaoSocial;
    }

    public void setCnpj(String cnpj)
    {
        this.cnpj = cnpj;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
}
