package DataModels.Managers;

import java.io.*;
import java.io.IOException;
import java.util.List;

import DataModels.Book;
import DataModels.Security.EncryptionUtils;
import DataModels.User;

public class FileHandler {
    private static final String KEY_FILE_EXTENSION = ".key";
    private static final String ENCRYPTED_FILE_EXTENSION = ".enc";
    // Save an encrypted object to a file
    public static void saveEncryptedObject(String filePath, Object object) {
        // This method's objective is to encrypt the object, and save it to a given directory along with the key to decrypt it
        try {
            File directory = getDirectory(object);
            createDirectoryIfNotExists(directory);

            String encryptedFilePath = getFilePath(directory, filePath, ENCRYPTED_FILE_EXTENSION);
            String keyFilePath = getFilePath(directory, filePath, KEY_FILE_EXTENSION);

            byte[] serializedData = serializeObject(object);
            String key = EncryptionUtils.generateRandomKey();
            byte[] encryptedData = encryptData(serializedData, key);

            saveDataToFile(encryptedFilePath, encryptedData);
            saveKeyToFile(keyFilePath, key);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    // Get the appropriate directory for the object
    private static File getDirectory(Object object) {
        if (object instanceof List<?> list) {
            if (!list.isEmpty()) {
                Object firstItem = list.get(0);
                return switch (firstItem.getClass().getSimpleName()) {
                    case "User" -> new File("ObjectFiles/UserLists");
                    case "Book" -> new File("ObjectFiles/BookLists");
                    default -> new File("ObjectFiles");
                };
            }
        } else if (object instanceof User) {
            return new File("ObjectFiles/Users");
        } else if (object instanceof Book) {
            return new File("ObjectFiles/Books");
        }
        return new File("ObjectFiles");
    }
    // Create the directory if it doesn't exist
    private static void createDirectoryIfNotExists(File directory) throws IOException {
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                throw new IOException("Failed to create the directory: " + directory.getAbsolutePath());
            }
        }
    }
    // Get the file path within the directory
    private static String getFilePath(File directory, String filePath, String fileExtension) {
        return directory.getPath() + "/" + filePath + fileExtension;
    }
    // Serialize the object to a byte array
    private static byte[] serializeObject(Object object) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(object);
        }
        return bos.toByteArray();
    }
    // Encrypt the data using the encryption key
    private static byte[] encryptData(byte[] data, String key) throws Exception {
        return EncryptionUtils.encrypt(data, key);
    }
    // Save the encrypted data to a file
    private static void saveDataToFile(String filePath, byte[] data) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(data);
        }
    }
    // Save the encryption key to a file
    private static void saveKeyToFile(String filePath, String key) throws IOException {
        try (FileOutputStream keyFos = new FileOutputStream(filePath)) {
            keyFos.write(key.getBytes());
        }
    }
    public static Object loadDecryptedObject(String fileName) {
        // This method's objective is to load the encrypted object using the key stored with it and retrieve the object
        try {
            String encryptedFilePath = getFilePath(fileName, ENCRYPTED_FILE_EXTENSION);
            String keyFilePath = getFilePath(fileName, KEY_FILE_EXTENSION);

            byte[] encryptedData = loadDataFromFile(encryptedFilePath);
            byte[] keyBytes = loadDataFromFile(keyFilePath);
            String key = new String(keyBytes);

            byte[] decryptedData = decryptData(encryptedData, key);

            return deserializeObject(decryptedData);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle or throw custom exception
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return null;
    }
    // Get the file path
    private static String getFilePath(String fileName, String fileExtension) {
        return "ObjectFiles/" + fileName + fileExtension;
    }
    // Load data from a file
    private static byte[] loadDataFromFile(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }
    // Decrypt the data
    private static byte[] decryptData(byte[] encryptedData, String key) throws Exception {
        return EncryptionUtils.decrypt(encryptedData, key);
    }
    // Deserialize the object
    private static Object deserializeObject(byte[] decryptedData) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(decryptedData);
        try (ObjectInputStream ois = new ObjectInputStream(bis)) {
            return ois.readObject();
        }
    }
}

