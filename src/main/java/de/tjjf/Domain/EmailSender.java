package de.tjjf.Domain;

import de.tjjf.Domain.models.MFlight;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailSender {

    public static void sendMail(String recipient) {

        // Absender E-Mail und Passwort
        final String username = "airlinemanagementtestmail@gmail.com";
        final String password = "fkgk rdof hhkj arwc";

        // Empfängeradresse und SMTP-Server-Einstellungen

        String host = "smtp.gmail.com";
        int port = 587;

        // SMTP-Server-Konfiguration
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", String.valueOf(port));

        // Session erstellen
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Nachricht erstellen
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject("Cancelation of Flight ");
            message.setText("Testmail");

            // E-Mail senden
            Transport.send(message);

            System.out.println("E-Mail erfolgreich gesendet!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        sendMail("jpfennig2403@gmail.com");
    }

}
