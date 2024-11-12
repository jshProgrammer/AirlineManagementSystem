package de.tjjf.Domain;

import de.tjjf.Domain.models.MFlight;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailSender {

    public static void sendMail(String recipient, String subject, String text) {

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
            message.setSubject(subject);
            message.setText(text);

            // E-Mail senden
            Transport.send(message);

            System.out.println("E-Mail erfolgreich gesendet!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void sendCancelationMail(MFlight mFlight){
        for (MTicket ticket : mFlight.getTickets()){
            MPerson person = ticket.getPerson();
            String mailPerson = person.getEmail();
            String subject = "Cancelation of flight " + mFlight.getFlightNum();
            //TODO: evtl give the customer other flights as an alternative
            String message = "Dear "+person.getFirstName()+"\n" +
                    "unfortunately we have to inform you that your flight "+mFlight.getFlightNum()+" from "+mFlight.getDepartureAirport()+" to "+mFlight.getArrivalAirport()+ " got canceled\n" +
                    "";
            sendMail(mailPerson, subject, message);
        }
    }
    public static void sendCancelationMailCustomer(MFlight mFlight){
        for (MTicket ticket : mFlight.getTickets()){
            MPerson person = ticket.getPerson();
            String mailPerson = person.getEmail();
            String subject = "Cancelation of flight " + mFlight.getFlightNum();
            //TODO: evtl schöne Grußfromel zum abschluss
            String message = "Dear "+person.getFirstName()+"\n" +
                    "here is your validation for your cancelation of flight "+mFlight.getFlightNum()+" from "+mFlight.getDepartureAirport()+" to "+mFlight.getArrivalAirport() + "\n";
            sendMail(mailPerson, subject, message);
        }
    }
}
