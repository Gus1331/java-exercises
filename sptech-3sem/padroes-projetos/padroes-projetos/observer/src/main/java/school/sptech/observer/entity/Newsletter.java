package school.sptech.observer.entity;

import school.sptech.observer.entity.observer.Assinante;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Newsletter {

  private UUID id = UUID.randomUUID();
  private String titulo;
  private String conteudo;

  private List<Assinante> assinantes = new ArrayList<>();

  public void inscrever(Assinante assinante) {
    this.assinantes.add(assinante);
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getConteudo() {
    return conteudo;
  }

  public void setConteudo(String conteudo) {
    this.conteudo = conteudo;
  }

  public UUID getId() {
    return id;
  }

  public List<Assinante> getAssinantes() {
    return assinantes;
  }
}
