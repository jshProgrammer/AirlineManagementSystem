package de.tjjf.Domain;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PasswordDecryption {

    // Entschlüsselt das Passwort aus einer verschlüsselten Datei
    public static String decryptPassword(String encryptedFilePath, String keyFilePath) throws Exception {
        // Schlüssel aus Datei lesen
        byte[] keyBytes = Files.readAllBytes(Paths.get(keyFilePath));
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

        // Verschlüsseltes Passwort aus Datei lesen
        byte[] encryptedPassword = Files.readAllBytes(Paths.get(encryptedFilePath));

        // Passwort entschlüsseln
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedPassword = cipher.doFinal(encryptedPassword);

        return new String(decryptedPassword);
    }

    /*public static String main(String[] args) {
        try {
            // Entschlüsseltes Passwort abrufen
            String smtpPassword = decryptPassword("src/main/java/de/tjjf/Domain/smtp_password.enc", "src/main/java/de/tjjf/Domain/aes_key.key");
            System.out.println("Entschlüsseltes Passwort: " + smtpPassword);

            // Hier kannst du smtpPassword verwenden, um den EmailSender zu konfigurieren
            // Beispiel: smtpClient.connect("smtp.gmail.com", username, smtpPassword);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
