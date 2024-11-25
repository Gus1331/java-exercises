package school.sptech.observer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.sptech.observer.entity.Newsletter;
import school.sptech.observer.entity.observer.Assinante;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class NewsletterService {

    @Autowired
    private EnviadorEmailService enviadorEmailService;

    private List<Newsletter> newsletters = new ArrayList<>();

    public void publicarNewsletter(UUID id) {
        Newsletter newsletter = this.buscarPorId(id);
        newsletter.getAssinantes()
                .forEach(assinante -> assinante.receberNewsletter(enviadorEmailService, newsletter));
    }

    public void adicionarAssinante(UUID idNewsletter, Assinante assinante) {
        Newsletter newsletter = this.buscarPorIndice(idNewsletter);
        newsletter.inscrever(assinante);
    }

    public void criar(Newsletter newsletter) {
        this.newsletters.add(newsletter);
    }

    public List<Newsletter> listar() {
        return newsletters;
    }

    public Newsletter buscarPorId(UUID idNewsletter) {
        return buscarPorIndice(idNewsletter);
    }

    private Newsletter buscarPorIndice(UUID id) {
        return this.newsletters.stream()
                .filter(newsletter -> newsletter.getId().equals(id))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("Newsletter não encontrado!")
                );
    }
}
