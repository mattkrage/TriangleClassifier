package triangle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Triangle.
 */
public class TriangleTest {

    private static final String SIDES_MUST_BE_POSITIVE = "Sides must be positive";
    private static final String SIDES_MUST_BE_VALID = "Invalid triangle: violates triangle inequality";
    private Locale originalLocale;

    @BeforeEach
    void initLocale() {
        originalLocale = Locale.getDefault();
        Locale.setDefault(Locale.ENGLISH);
    }

    @AfterEach
    void cleanup() {
        Locale.setDefault(originalLocale);
    }

    @ParameterizedTest(name = "Triangle({0}, {1}, {2}) should throw IllegalArgumentException")
    @CsvSource({
            "0, 2, 3",
            "1, -2, 3",
            "1, 2, 0"})
    void throwsExceptionWhenSideIsZeroOrNegative(double aStr, double bStr, double cStr) {
        BigDecimal a = new BigDecimal(aStr);
        BigDecimal b = new BigDecimal(bStr);
        BigDecimal c = new BigDecimal(cStr);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Triangle(a, b, c)
        );
        assertEquals(SIDES_MUST_BE_POSITIVE, exception.getMessage());
    }

    @Test
    void throwsWhenInequalityViolated() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Triangle(new BigDecimal("1"), new BigDecimal("0.1"), new BigDecimal("7.5"))
        );
        assertEquals(SIDES_MUST_BE_VALID, exception.getMessage());
    }

    @Test
    void createsValidTriangle() {
        Triangle triangle = new Triangle(new BigDecimal("3.1"), new BigDecimal("4"), new BigDecimal("5"));
        assertTrue(new BigDecimal("3.1").compareTo(triangle.a()) == 0);
        assertTrue(new BigDecimal("4").compareTo(triangle.b()) == 0);
        assertTrue(new BigDecimal("5").compareTo(triangle.c()) == 0);
    }

    @ParameterizedTest(name = "Triangle({0}, {1}, {2}) => isosceles={3}, scalene={4}, equilateral={5}")
    @CsvSource({
            "3.1, 3.1, 3.1, true, false, true, EQUILATERAL",  // test equilateral triangle
            "3.1, 3.1, 5.0, true, false, false, ISOSCELES", // test isosceles triangle
            "3, 2.1, 5, false, true, false, SCALENE"  // test scalene triangle
    })
    void testTriangleTypes(double aStr, double bStr, double cStr, boolean isosceles, boolean scalene, boolean equilateral, String expectedTypeStr) {
        BigDecimal a = new BigDecimal(aStr);
        BigDecimal b = new BigDecimal(bStr);
        BigDecimal c = new BigDecimal(cStr);

        Triangle t = new Triangle(a, b, c);
        assertEquals(isosceles, t.isosceles());
        assertEquals(scalene, t.scalene());
        assertEquals(equilateral, t.equilateral());

        Triangle.TriangleType expectedType = Triangle.TriangleType.valueOf(expectedTypeStr);
        assertEquals(expectedType, t.getType());
    }


}
