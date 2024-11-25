package school.sptech.projeto_05_validations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.constraints.br.TituloEleitoral;

import java.time.LocalDate;

@Entity
public class BoletoBancario{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Size(min = 4, max = 4)
    private String banco;

    @NotBlank
    @Size(min = 4, max = 4)
    private String conta;

    @NotBlank
    @Pattern(regexp = "\\d{5}\\.\\d{5} \\d{5}\\.\\d{6} \\d{5}\\.\\d{6} \\d \\d{14}")
    private String codigoBarra;

    @NotBlank
    @Size(min = 4, max = 4)
    private String agencia;

    @NotBlank
    @DecimalMin("0.1")
    @DecimalMax("1000.0")
    private Double valor;

    @NotNull
    //@Past
    //@PastOrPresent
    //@FutureOrPresent
    private LocalDate dataVencimento;

    @NotBlank
    @Size(min = 3, max = 100)
    private String nomePagador;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @CPF
    //@TituloEleitoral
    //@CNPJ
    private String cpf;

    public BoletoBancario() {
    }

    public BoletoBancario(Integer id, String banco, String conta, String codigoBarra, String agencia, Double valor, LocalDate dataVencimento, String nomePagador, String email, String cpf) {
        this.id = id;
        this.banco = banco;
        this.conta = conta;
        this.codigoBarra = codigoBarra;
        this.agencia = agencia;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.nomePagador = nomePagador;
        this.email = email;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getNomePagador() {
        return nomePagador;
    }

    public void setNomePagador(String nomePagador) {
        this.nomePagador = nomePagador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
