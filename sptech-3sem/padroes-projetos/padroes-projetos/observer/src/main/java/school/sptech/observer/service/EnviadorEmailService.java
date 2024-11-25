package school.sptech.observer.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EnviadorEmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TaskExecutor taskExecutor;

    private static Log log = LogFactory.getLog(EnviadorEmailService.class);

    public void sendEmail(final String remetente, final String destinatario, final String titulo, final String conteudo){
        taskExecutor.execute(() -> sendMailSimple(remetente, destinatario, titulo, conteudo));
    }

    private void sendMailSimple(
            final String remetente,
            final String destinatario,
            final String titulo,
            final String conteudo
    ) {

        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(remetente);
            helper.setTo(destinatario);
            helper.setSubject(titulo);
            helper.setText(conteudo);
        } catch (MessagingException e) {
            throw new MailParseException(e);
        }

        mailSender.send(message);

        if (log.isDebugEnabled()) {
            log.debug(String.format("Email enviado corretamente para: %s", destinatario));
        }
    }
}
