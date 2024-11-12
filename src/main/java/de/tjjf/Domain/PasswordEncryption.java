package de.tjjf.Domain;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;

public class PasswordEncryption {

    // Verschlüsselt das Passwort und speichert es in einer Datei
    public static void encryptAndSavePassword(String password, String filePath, String keyPath) throws Exception {
        // AES-Schlüssel erzeugen
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256, new SecureRandom()); // 256-Bit AES-Schlüssel
        SecretKey secretKey = keyGen.generateKey();

        // Passwort verschlüsseln
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedPassword = cipher.doFinal(password.getBytes());

        // Verschlüsseltes Passwort speichern
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(encryptedPassword);
        }

        // AES-Schlüssel speichern
        try (FileOutputStream keyFos = new FileOutputStream(keyPath)) {
            keyFos.write(secretKey.getEncoded());
        }
    }

    public static void main(String[] args) {
        /*try {
            String password = ""; // App-Passwort hier eingeben
            encryptAndSavePassword(password, "src/main/java/de/tjjf/Domain/smtp_password.enc", "src/main/java/de/tjjf/Domain/aes_key.key");
            System.out.println("Passwort erfolgreich verschlüsselt und gespeichert.");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
