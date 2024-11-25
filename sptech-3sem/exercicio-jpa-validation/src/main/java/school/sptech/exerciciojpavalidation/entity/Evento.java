package school.sptech.exerciciojpavalidation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 5, max = 100)
    private String nome;

    @NotBlank
    @Size(min = 5, max = 150)
    private String local;

    @NotNull
    @FutureOrPresent
    private LocalDate dataEvento;

    private LocalDate dataPublicacao = LocalDate.now();

    private Boolean gratuito;

    private Boolean cancelado;

    public Evento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotBlank String getLocal() {
        return local;
    }

    public void setLocal(@NotBlank String local) {
        this.local = local;
    }

    public @Future LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(@Future LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public @Future LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(@Future LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Boolean getGratuito() {
        return gratuito;
    }

    public void setGratuito(Boolean gratuito) {
        this.gratuito = gratuito;
    }

    public @AssertFalse Boolean getCancelado() {
        return cancelado;
    }

    public void setCancelado(@AssertFalse Boolean cancelado) {
        this.cancelado = cancelado;
    }

    public String getStatus() {
        if (this.cancelado) {
            return "CANCELADO";
        } else if (this.dataEvento.isBefore(LocalDate.now())) {
            return "FINALIZADO";
        }
        return "ABERTO";
    }
}
