package net.PognaliApp.services;

import net.PognaliApp.models.User;
import org.apache.commons.dbcp.ConnectionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of {@link CheckMailService} interface.
 *
 * @author Ruslan Zosimov
 * @version 1.0
 */
@Service
@Scope(value = "prototype")
public class CheckMailServiceImpl implements CheckMailService {
    private static final String subject = "Checking your mail address";
    private static final String messagebody = "Code for entering in the page:";
    private Random rand = new Random();
    private String gencode= String.valueOf(rand.nextInt(9999));
    private String mailRecipient;
    private Properties props;


    public CheckMailServiceImpl() {
    }

    @Override
    public void sendCheckMessage(User user) {
        this.mailRecipient = user.getEmail();
        user.setGencode(gencode);
        try {
            String SMTP_AUTH_USER = "apppognali@gmail.com";
            String SMTP_AUTH_PWD = "pognaliapppassword";

            props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(SMTP_AUTH_USER, SMTP_AUTH_PWD);
                }
            });

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(SMTP_AUTH_USER));

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailRecipient));

            message.setSubject(subject);

            message.setText(messagebody + gencode);

            Transport.send(message);

        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static String getSubject() {
        return subject;
    }

    public static String getMessage() {
        return messagebody;
    }

    public String getGencode() {
        return gencode;
    }

    public void setGencode(String gencode) {
        this.gencode = gencode;
    }

    public String getMailRecipient() {
        return mailRecipient;
    }

    public void setMailRecipient(String mailRecipient) {
        this.mailRecipient = mailRecipient;
    }


}
