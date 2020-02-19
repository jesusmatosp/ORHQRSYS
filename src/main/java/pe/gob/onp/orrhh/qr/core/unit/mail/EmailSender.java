package pe.gob.onp.orrhh.qr.core.unit.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.util.Base64;

import javax.mail.internet.MimeMessage;
 
@Component
public class EmailSender {
 
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSender.class);
 
    @Autowired
    private JavaMailSender javaMailSender;
 
    public EmailStatus sendPlainText(String to, String subject, String text, byte[] value, String type) {
        return sendM(to, subject, text, false, value, type);
    }
 
    public EmailStatus sendHtml(String to, String subject, String htmlBody, byte[] value, String type) {
        return sendM(to, subject, htmlBody, true, value, type);
    }
 
    private EmailStatus sendM(String to, 
    							String subject, 
    							String text, 
    							Boolean isHtml, 
    							byte[] value, String type) {
        try {
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, isHtml);
            if(type.equalsIgnoreCase("0202")) {
            	// bienestar:
                helper.addInline("logo", new ClassPathResource("static/bienestar/logo_bienestar.png"), "image/png");
                helper.addInline("ic_background", new ClassPathResource("static/bienestar/background_bienestar_2_.png"), "image/png");
                helper.addInline("ic_calendario", new ClassPathResource("static/bienestar/icono_calendario.png"), "image/png");
                helper.addInline("ic_lugar", new ClassPathResource("static/bienestar/icono_lugar.png"), "image/png");
                helper.addInline("ic_reloj", new ClassPathResource("static/bienestar/icono_reloj.png"), "image/png");
            } else {
            	// capacitacion:
                helper.addInline("logo", new ClassPathResource("static/capacitacion/logo_capacitacion.png"), "image/png");
                helper.addInline("ic_background", new ClassPathResource("static/capacitacion/background_1.png"), "image/png");
                helper.addInline("ic_calendario", new ClassPathResource("static/capacitacion/calendario_icono.png"), "image/png");
                helper.addInline("ic_lugar", new ClassPathResource("static/capacitacion/lugar_icono.png"), "image/png");
                helper.addInline("ic_reloj", new ClassPathResource("static/capacitacion/reloj_icono.png"), "image/png");
            }
            // helper.addInline("qr", new ByteArrayResource(value));
            helper.addAttachment("MyQRCode.jpg", new ByteArrayResource(value));

            // capacitacion:
            javaMailSender.send(mail);
            LOGGER.info("Send email '{}' to: {}", subject, to);
            return new EmailStatus(to, subject, text).success();
        } catch (Exception e) {
            LOGGER.error(String.format("Problem with sending email to: {}, error message: {}", to, e.getMessage()));
            e.printStackTrace();
            return new EmailStatus(to, subject, text).error(e.getMessage());
        }
    }
}