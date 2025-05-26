package triangle;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class I18nTest {

    private static final String SIDES_MUST_BE_VALID = "Invalid triangle: violates triangle inequality";
    private static final String SIDES_MUST_BE_VALID_FR = "Les côtés ne forment pas un triangle valide";

    @Test
    void testInternationalization() {
        Locale.setDefault(Locale.FRENCH);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Triangle(new BigDecimal("1"), new BigDecimal("0.1"), new BigDecimal("7.5"))
        );
        assertEquals(SIDES_MUST_BE_VALID_FR, exception.getMessage());
    }

    @Test
    void testInternationalizationFallbackWhenTranslationMissing() {
        Locale.setDefault(Locale.forLanguageTag("da-DK"));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Triangle(new BigDecimal("1"), new BigDecimal("0.1"), new BigDecimal("7.5"))
        );
        assertEquals(SIDES_MUST_BE_VALID, exception.getMessage());
    }
}
