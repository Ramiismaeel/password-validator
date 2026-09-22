import java.util.Locale;
import java.util.Set;

public class PasswordValidator {
    static void main() {

    }

    private static final Set<String> COMMON_PASSWORDS = Set.of("12345678", "password", "passwort", "adminadmin", "abc123456", "aa123456", "qwerty123", "password1", "password12", "password123", "passwort1");

    public static boolean isNotEmpty(String password) {
        return password != null && !password.isEmpty();
    }

    public static boolean hasMinLength(String password, int min) {
        return password.trim().length() >= min;
    }

    public static boolean containsDigit(String password){
        char[] chars = password.toCharArray();
        boolean hasDigit = false;
        for(char c :chars) {
            if(Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        return hasDigit;
    }
    public static boolean containsUpperAndLower(String password){
        char[] chars = password.toCharArray();
        boolean hasUpper = false;
        boolean hasLower = false;
        for(char c :chars) {
            if(Character.isLowerCase(c)) {
                hasLower = true;
            }
            if(Character.isUpperCase(c)) {
                hasUpper = true;
            }
        }
        return hasUpper && hasLower;
    }

    public static boolean isCommonPassword(String password){
        if(COMMON_PASSWORDS.contains(password.trim().toLowerCase(Locale.ROOT))) {
            return true;
        }
        return false;


    }
}
