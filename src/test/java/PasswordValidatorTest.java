import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    //hasMinLength
    @ParameterizedTest
    @CsvSource({
            "12345678, true",
            "1234567, false",
            " 1234567 , false",
            " 123 4567 , true"

    })
    void hasMinLength_shouldReturnExpected_byInput(String input, boolean expected) {
        assertEquals(expected, PasswordValidator.hasMinLength(input, 8));
    }

    //containsDigit
    @ParameterizedTest
    @CsvSource({
            "12345678, true",
            "wqerrwr, false",
            " aew3sdf , true",
            "ssdf@3sew , true",
            "ssdf@0sew , true"

    })
    void containsDigit_shouldReturnExpected_byInput(String input, boolean expected) {
        assertEquals(expected, PasswordValidator.containsDigit(input));
    }

    //containsUpperAndLower
    @ParameterizedTest
    @CsvSource({
            "12345678, false",
            "wqerrwr, false",
            " HELLO , false",
            "TdTr@123, true",
            "R rr  , true"

    })
    void containsUpperAndLower_shouldReturnExpected_byInput(String input, boolean expected) {
        assertEquals(expected, PasswordValidator.containsUpperAndLower(input));
    }
}

