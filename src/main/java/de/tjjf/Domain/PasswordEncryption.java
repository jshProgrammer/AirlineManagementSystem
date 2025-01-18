package de.tjjf.Domain;

import javax.crypto.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordEncryption {

    public static void encryptAndSavePassword(String password, String filePath, String keyPath) throws NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, IOException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256, new SecureRandom());
        SecretKey secretKey = keyGen.generateKey();

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedPassword = cipher.doFinal(password.getBytes());

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(encryptedPassword);
        }

        try (FileOutputStream keyFos = new FileOutputStream(keyPath)) {
            keyFos.write(secretKey.getEncoded());
        }
    }
}
