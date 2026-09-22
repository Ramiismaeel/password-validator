public class PasswordValidator {
    static void main() {

    }

    public static boolean isNotEmpty(String password) {
        return password != null && !password.isEmpty();
    }
    public static boolean hasMinLength(String password, int min) { return  false;}
    public static boolean containsDigit(String password){ return  false;}
    public static boolean containsUpperAndLower(String password){ return  false;}
    public static boolean isCommonPassword(String password){ return  false;}
}
