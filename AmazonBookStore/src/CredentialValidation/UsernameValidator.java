package CredentialValidation;
public class UsernameValidator {
    private static final int MAX_LENGTH = 25;
    private static final int MIN_LENGTH = 1;

    public static boolean isValid(String username) {
        return username != null && username.length() <= MAX_LENGTH
                && username.length() >= MIN_LENGTH && !username.contains(" ");
    }
}
