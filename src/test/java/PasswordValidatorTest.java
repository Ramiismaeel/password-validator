import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {

    //isNotEmpty
    @Test
    void isNotEmpty_shouldReturnTrue_by123() {
        assertTrue(PasswordValidator.isNotEmpty("123"));
    }
    @Test
    void isNotEmpty_shouldReturnFalse_byNull() {
        assertFalse(PasswordValidator.isNotEmpty(null));
    }
    @Test
    void isNotEmpty_shouldReturnFalse_byEmpty() {
        assertFalse(PasswordValidator.isNotEmpty(""));
    }
}

