package DataModels.Security;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;

public class EncryptionUtils {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    // Encrypts the given byte array using AES encryption
    public static byte[] encrypt(byte[] data, String key) throws Exception {
        Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }
    // Decrypts the given byte array using AES decryption
    public static byte[] decrypt(byte[] encryptedData, String key) throws Exception {
        Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(encryptedData);
    }
    public static String generateRandomKey() {
        byte[] keyBytes = new byte[128 / 8];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(keyBytes);
        return bytesToHex(keyBytes);
    }
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

