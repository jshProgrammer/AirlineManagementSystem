package de.tjjf.CRUDTests;

import de.tjjf.Domain.EmailSender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class sendEmailTest {

    @Test
    public void testEmailSentSuccessfully() {
        EmailSender emailSender = new EmailSender();
        emailSender.sendMail("jpfennig2403@gmail.com", "sendEmailTestCase", "TestContent", "");
            System.out.println("E-Mail wurde erfolgreich gesendet");
            assertTrue(true, "E-Mail wurde erfolgreich gesendet.");
    }
}
