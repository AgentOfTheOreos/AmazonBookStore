package DataModels.CredentialValidation;
import java.util.regex.Pattern;

public class EmailValidator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    );
    public static boolean isValid(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
}

