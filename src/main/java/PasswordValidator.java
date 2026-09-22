import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class PasswordValidator {
    static void main() {
        System.out.println("Enter your password!");
        Scanner scanner = new Scanner(System.in);
        String passwordInput = scanner.nextLine();
        boolean validPassword = isValid(passwordInput);
        System.out.println(validPassword ? "Your password is valid.": "Your password is not valid.");
        scanner.close();

    }

    private static final Set<String> COMMON_PASSWORDS = Set.of("12345678", "password", "passwort", "adminadmin", "abc123456", "aa123456", "qwerty123", "password1", "password12", "password123", "passwort1");
    private static final int MIN_LENGTH = 8;
    private static final String ALLOWED_SPECIAL_CHARS = "@#$()_+-=[]{}|;:,.<>?/~!%^&*`";

    public static boolean isEmpty(String password) {
        return password == null || password.isEmpty();
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

    public static boolean containsSpecialChar(String password) {
        char[] passwordsChars = password.toCharArray();

        for(char c: passwordsChars) {
            if (ALLOWED_SPECIAL_CHARS.indexOf(c) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValid(String password) {

        if(isEmpty(password)) {
            return false;
        } else {
            if(!hasMinLength(password, MIN_LENGTH)) {
                return false;
            } else if(!containsDigit(password)) {
                return false;
            } else if(!containsUpperAndLower(password)) {
                return false;
            } else if(!containsSpecialChar(password)) {
                return false;
            }
            else return !isCommonPassword(password);
        }
    }
}
