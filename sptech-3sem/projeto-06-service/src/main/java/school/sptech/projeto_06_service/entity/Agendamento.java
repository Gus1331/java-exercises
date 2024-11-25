package school.sptech.projeto_06_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String titulo;

    @NotBlank
    @Size(min = 3, max = 150)
    private String local;

    @NotNull
    @Future
    private LocalDate data;

    @AssertFalse
    private boolean finalizado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank @Size(min = 3, max = 100) String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotBlank @Size(min = 3, max = 100) String titulo) {
        this.titulo = titulo;
    }

    public @NotBlank @Size(min = 3, max = 150) String getLocal() {
        return local;
    }

    public void setLocal(@NotBlank @Size(min = 3, max = 150) String local) {
        this.local = local;
    }

    public @NotNull @Future LocalDate getData() {
        return data;
    }

    public void setData(@NotNull @Future LocalDate data) {
        this.data = data;
    }

    @AssertFalse
    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(@AssertFalse boolean finalizado) {
        this.finalizado = finalizado;
    }
}
