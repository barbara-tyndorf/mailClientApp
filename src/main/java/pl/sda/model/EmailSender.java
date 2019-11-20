package pl.sda.model;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import pl.sda.presenter.EmailData;


public class EmailSender {

    private static final String HOST = "smtp.gmail.com";
    private static final int PORT = 465;
    private static final String USER = "sdaszczecin12@gmail.com";
    private static final String PASSWORD = "Grupa12!";
    private static final boolean SSL_FLAG = true;


    public boolean sendEmail(EmailData emailData) {
        Email email = new SimpleEmail();
        email.setHostName(HOST);
        email.setSmtpPort(PORT);
        email.setAuthentication(USER, PASSWORD);
        email.setSSLOnConnect(SSL_FLAG);

        email.setSubject(emailData.getSubject());
        try {
            email.setFrom(emailData.getSender());
            email.addTo(emailData.getReceiver());
            email.setMsg(emailData.getContent());
            email.send();

            return true;

        } catch (EmailException e) {
            e.printStackTrace();
            return false;
        }

    }

}
