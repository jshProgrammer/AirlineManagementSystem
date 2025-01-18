package de.tjjf.Domain;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PasswordDecryption {

    public static String decryptPassword(String encryptedFilePath, String keyFilePath) throws Exception {

        byte[] keyBytes = Files.readAllBytes(Paths.get(keyFilePath));
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

        byte[] encryptedPassword = Files.readAllBytes(Paths.get(encryptedFilePath));

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedPassword = cipher.doFinal(encryptedPassword);

        return new String(decryptedPassword);
    }
}
