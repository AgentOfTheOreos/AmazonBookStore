package DataModels.CredentialValidation;
import java.util.regex.Pattern;

public class PasswordValidator {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 100;
    private static final String SPECIAL_CHARACTERS_REGEX = "[!@#$%^&*()-+=]";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*" + SPECIAL_CHARACTERS_REGEX + ").{" + MIN_LENGTH + "," + MAX_LENGTH + "}$"
    );
    public static boolean isValid(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}
