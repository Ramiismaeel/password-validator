
public class PasswordValidator {
    static void main() {

    }

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
    public static boolean isCommonPassword(String password){ return  false;}
}
