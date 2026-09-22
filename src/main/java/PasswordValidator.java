import java.security.SecureRandom;
import java.util.*;

public class PasswordValidator {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        boolean validPassword = false;

        while (!validPassword) {
            System.out.println("Enter your password!");
            String passwordInput = scanner.nextLine();

            validPassword = isValid(passwordInput);

            if (!ValidationResult.isEmpty()) {
                System.out.println(ValidationResult);
                ValidationResult.clear();
            }

            if (validPassword) {
                System.out.println("Your password is valid.");
            } else {
                System.out.println("Your password is not valid.");
            }
        }

        scanner.close();

    }

    private static final Set<String> COMMON_PASSWORDS = Set.of("12345678", "password", "passwort", "adminadmin", "abc123456", "aa123456", "qwerty123", "password1", "password12", "password123", "passwort1");
    private static final int MIN_LENGTH = 8;
    private static final String ALLOWED_SPECIAL_CHARS = "@#$()_+-=[]{}|;:,.<>?/~!%^&*";

    private static final List<String> ValidationResult = new ArrayList<>();
    private static final String MIN_LENGTH_ISSUE = "Your password is less than "+MIN_LENGTH+" characters";
    private static final String DIGIT_ISSUE  = "Your password has no digits";
    private static final String UPPER_LOWER_ISSUE  = "Your password hasn't both Uppercase & lowercase letters";
    private static final String COMMON_ISSUE  = "Your password is weak (common)";
    private static final String SPECIAL_CHAR_ISSUE = "Your password has no special character";

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
        return COMMON_PASSWORDS.contains(password.trim().toLowerCase(Locale.ROOT));

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
        ValidationResult.clear();
        boolean valid = true;
        if(isEmpty(password)) {
            valid =  false;
        } else {
            if(!hasMinLength(password, MIN_LENGTH)) {
                ValidationResult.add(MIN_LENGTH_ISSUE);
                valid =  false;
            }  if(!containsDigit(password)) {
                ValidationResult.add(DIGIT_ISSUE);
                valid =  false;
            }  if(!containsUpperAndLower(password)) {
                ValidationResult.add(UPPER_LOWER_ISSUE);
                valid =  false;
            }  if(!containsSpecialChar(password)) {
                ValidationResult.add(SPECIAL_CHAR_ISSUE);
                valid =  false;
            }
             if(isCommonPassword(password)) {
                ValidationResult.add(COMMON_ISSUE);
                valid =  false;
            }
        }
        return valid;
    }


    public static String generatePassword(int length, String allowedSpecial) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz"
                + "0123456789"
                + allowedSpecial;
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);
        for(int i=0; i< length; i++) {
            int index = random.nextInt(chars.length());
            password.append(chars.charAt(index));
        };
        return password.toString();
    }
}
