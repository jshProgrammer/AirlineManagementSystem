package de.tjjf.Domain;

import de.tjjf.Domain.models.MFlight;
import de.tjjf.Domain.models.MPerson;
import de.tjjf.Domain.models.MTicket;

import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;

import static de.tjjf.Domain.InvoicePDF.createPDF;

public class EmailSender {
    public static void main(String[] args) {
        sendMail("tomknoblach@t-online.de", "TEST", "<p>Dear "  + ",</p>" +
                "<p>Unfortunately, we have to inform you that your flight "  +
                " from " +  " to "+
                " has been canceled.</p>" +
                "<p>We apologize for the inconvenience.</p>" +
                "<p><img src='cid:logoImage'></p>","");
    }

    public static void sendMail(String recipient, String subject, String htmlContent, String file) {


        // Absender E-Mail und Passwort
        final String username = "airlinemanagementtestmail@gmail.com";
        final String password;
        //TODO: eig dürfte man nicht key und enc hochladen, aber wie sollen wir es sonst hier entschlüsseln?
        try {
            password = PasswordDecryption.decryptPassword("src/main/java/de/tjjf/Domain/smtp_password.enc", "src/main/java/de/tjjf/Domain/aes_key.key");
        } catch(Exception e) {
            throw new RuntimeException("Password could not be decrypted");
        }
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
            //message.setText(text);
            //Nur Test Code
            MimeMultipart multipart = new MimeMultipart("related");

            // HTML-Teil hinzufügen
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(htmlContent, "text/html");
            multipart.addBodyPart(htmlPart);

            // Bildteil hinzufügen
            MimeBodyPart imagePart = new MimeBodyPart();
            imagePart.attachFile(new File("src/main/resources/AirlineLogo.jpeg")); // Pfad zum Bild
            imagePart.setContentID("<logoImage>");
            imagePart.setDisposition(MimeBodyPart.INLINE);
            multipart.addBodyPart(imagePart);
            message.setContent(multipart);

            //PDF Anhängen
            //TODO: nochmal überprüfen, irgendwo hier bei der PDF noch ein Fehler
            if(file != "") {
                try{
                    MimeBodyPart attachPart = new MimeBodyPart();
                    FileDataSource source = new FileDataSource(file);
                    attachPart.setDataHandler(new DataHandler (source));
                    attachPart.setFileName(new File(file).getName());
                    multipart.addBodyPart(attachPart); //
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            message.setContent(multipart);

            // E-Mail senden
            Transport.send(message);

            System.out.println("E-Mail erfolgreich gesendet!");

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void sendCancelationMail(MFlight mFlight) {
        for (MTicket ticket : mFlight.getTickets()) {
            ticket.setTicketStatus(MTicket.TicketStatus.canceled);
            MPerson person = ticket.getPerson();
            String mailPerson = person.getEmail();
            String subject = "Cancelation of flight " + mFlight.getFlightNum();

            String htmlMessage = "<p>Dear " + person.getFirstName() + ",</p>" +
                    "<p>Unfortunately, we have to inform you that your flight " + mFlight.getFlightNum() +
                    " from " + mFlight.getDepartureAirport() + " to " + mFlight.getArrivalAirport() +
                    " has been canceled.</p>" +
                    "<p>We apologize for the inconvenience.</p>" +
                    "<p><img src='cid:logoImage'></p>";
            String file = "";
            sendMail(mailPerson, subject, htmlMessage, file);
        }
    }

    public static void sendInvoice(MTicket ticket){
        String recipient = ticket.getPerson().getEmail();
        String subject = "Rechnung zu Ticket: "+ticket.getTicketId();
        String content = "<h1>Vielen Dank für Ihren Einkauf!</h1>"
                + "<p>Sehr geehrter Kunde, anbei finden Sie Ihre Rechnung als PDF.</p>";
        String PDFPath = createPDF(ticket);
        sendMail(recipient,subject,content,PDFPath);
    }

    public static void sendCancelationMailCustomer(MFlight mFlight){
        for (MTicket ticket : mFlight.getTickets()){
            MPerson person = ticket.getPerson();
            String mailPerson = person.getEmail();
            String subject = "Cancelation of flight " + mFlight.getFlightNum();
            //TODO: evtl schöne Grußfromel zum abschluss Name noch ändern
            String htmlmessage = "<p>Dear " + person.getFirstName() + ",</p>" +
                    "<p>here is your validation for your cancelation of flight " + mFlight.getFlightNum() +
                    " from " + mFlight.getDepartureAirport() + " to " + mFlight.getArrivalAirport() +
                    " .</p>" +
                    "<p>Kind regards THE AIRLINE</p>" +
                    "<p><img src='cid:logoImage'></p>";
            String file = "";
            sendMail(mailPerson, subject, htmlmessage, file);
        }
    }

    /*public static void sendCancelationMail(MFlight mFlight){
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
    }*/
    /*public static void sendCancelationMailCustomer(MFlight mFlight){
        for (MTicket ticket : mFlight.getTickets()){
            MPerson person = ticket.getPerson();
            String mailPerson = person.getEmail();
            String subject = "Cancelation of flight " + mFlight.getFlightNum();
            //TODO: evtl schöne Grußfromel zum abschluss
            String message = "Dear "+person.getFirstName()+"\n" +
                    "here is your validation for your cancelation of flight "+mFlight.getFlightNum()+" from "+mFlight.getDepartureAirport()+" to "+mFlight.getArrivalAirport() + "\n";
            sendMail(mailPerson, subject, message);
        }
    }*/
}
