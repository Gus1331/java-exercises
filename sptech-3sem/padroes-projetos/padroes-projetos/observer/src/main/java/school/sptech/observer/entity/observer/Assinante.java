package school.sptech.observer.entity.observer;

import school.sptech.observer.entity.Newsletter;
import school.sptech.observer.service.EnviadorEmailService;

public interface Assinante {

    void receberNewsletter(EnviadorEmailService enviadorEmailService, Newsletter newsletter);
}
