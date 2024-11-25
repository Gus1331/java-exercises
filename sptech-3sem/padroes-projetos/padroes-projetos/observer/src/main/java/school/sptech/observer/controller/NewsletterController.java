package school.sptech.observer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.observer.entity.AssinanteEmail;
import school.sptech.observer.entity.Newsletter;
import school.sptech.observer.service.NewsletterService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/newsletter")
public class NewsletterController {

  @Autowired
  private NewsletterService newsletterService;


  @GetMapping
  public ResponseEntity<List<Newsletter>> listar() {
    List<Newsletter> conteudos = this.newsletterService.listar();

    if (conteudos.isEmpty()) {
      return ResponseEntity.status(204).build();
    }

    return ResponseEntity.status(200).body(conteudos);
  }

  @GetMapping("/{idNewsletter}")
  public ResponseEntity<Newsletter> buscarPorId(@PathVariable UUID idNewsletter) {
    return ResponseEntity.status(200).body(this.newsletterService.buscarPorId(idNewsletter));
  }

  @PostMapping
  public ResponseEntity<Newsletter> criar(@RequestBody Newsletter newsletter) {
    this.newsletterService.criar(newsletter);
    return ResponseEntity.status(201).body(newsletter);
  }

  @PostMapping("/{idNewsletter}/assinantes")
  public ResponseEntity<Void> inscrever(
          @PathVariable UUID idNewsletter,
          @RequestBody AssinanteEmail assinanteEmail
  ) {
    this.newsletterService.adicionarAssinante(idNewsletter, assinanteEmail);
    return ResponseEntity.status(201).build();
  }

  @PostMapping("/{idNewsletter}/publicacao")
  public ResponseEntity<Void> publicar(@PathVariable UUID idNewsletter) {
    this.newsletterService.publicarNewsletter(idNewsletter);
    return ResponseEntity.status(200).build();
  }
}
