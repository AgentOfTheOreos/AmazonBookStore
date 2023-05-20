package CredentialValidation;

public class ISBNValidator {
    private static final int ISBN_LENGTH = 13;

    public static boolean isValid(String isbn) {
        return isbn != null && isbn.length() == ISBN_LENGTH && isbn.matches("\\d+");
    }
}
