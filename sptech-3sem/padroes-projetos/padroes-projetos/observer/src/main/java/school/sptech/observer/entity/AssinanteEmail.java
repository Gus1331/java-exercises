package school.sptech.observer.entity;

import school.sptech.observer.entity.observer.Assinante;
import school.sptech.observer.service.EnviadorEmailService;

import java.util.UUID;

public class AssinanteEmail implements Assinante {

  private UUID id = UUID.randomUUID();
  private String nome;
  private String email;
  private static final String EMAIL_EMPRESA = "javamasters@onionstack.io";

  @Override
  public void receberNewsletter(EnviadorEmailService enviadorEmailService, Newsletter newsletter) {
    enviadorEmailService.sendEmail(EMAIL_EMPRESA, this.email, newsletter.getTitulo(), newsletter.getConteudo());
  }

  public UUID getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
