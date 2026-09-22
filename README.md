# Password validator

![Java](https://img.shields.io/badge/Java-25-ED8B00?logo=java&logoColor=white)
![JUnit 5](https://img.shields.io/badge/JUnit-5-25A162?logo=junit5&logoColor=white)


## Getting Started

A lightweight utility to evaluate passwords against essential security baselines.

## Validation Criteria

To pass validation, a password **must** meet all of the following rules:

- **Minimum Length:** At least 8 characters long.
- **Numerics:** Contains at least one digit (`0-9`).
- **Casing:** Includes both uppercase and lowercase letters (`a-z`, `A-Z`).
- **Blacklist:** Is not present in the internal list of common, weak, or compromised passwords.
- **Special Characters**: At least include one special character e.g. (`@#$()_+-=[]{}|;:,.<>?/~!%^&*`)

## Example Usage

```java
import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a password to validate: ");
        String inputPassword = scanner.nextLine();
        
        // Assuming your validation logic is in a class named PasswordValidator
        boolean isValid = PasswordValidator.isValid(inputPassword);
        
        if (isValid) {
            System.out.println("Success: Password meets all security criteria.");
        } else {
            System.out.println("Error: Password is too weak. Please try again.");
        }
        
        scanner.close();
    }
}