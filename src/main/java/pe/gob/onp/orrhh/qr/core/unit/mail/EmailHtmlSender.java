package pe.gob.onp.orrhh.qr.core.unit.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
 
@Component
public class EmailHtmlSender {
 
    @Autowired
    private EmailSender emailSender;
 
    @Autowired
    private TemplateEngine templateEngine;
 
    public EmailStatus send(String to, String subject, String templateName, Context context, byte[] value, String type) {
        String body = templateEngine.process(templateName, context);
        return emailSender.sendHtml(to, subject, body, value, type);
    }
}