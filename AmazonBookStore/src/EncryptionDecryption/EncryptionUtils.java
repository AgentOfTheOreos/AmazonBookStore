package EncryptionDecryption;
import javax.crypto.*;
import java.security.*;

public class EncryptionUtils {
    public static byte[] encryptData(byte[] data) throws NoSuchAlgorithmException, NoSuchProviderException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = getCipherInstance();
        cipher.init(Cipher.ENCRYPT_MODE, getEncryptionKey());
        return cipher.doFinal(data);
    }

    public static byte[] decryptData(byte[] encryptedData) throws NoSuchAlgorithmException, NoSuchProviderException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = getCipherInstance();
        cipher.init(Cipher.DECRYPT_MODE, getEncryptionKey());
        return cipher.doFinal(encryptedData);
    }

    private static Cipher getCipherInstance() {
        try {
            return Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static SecretKey getEncryptionKey() throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstanceStrong();
        keyGenerator.init(128, secureRandom);
        return keyGenerator.generateKey();
    }
}

