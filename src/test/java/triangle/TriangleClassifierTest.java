package triangle;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleClassifierTest {

    @Test
    void createsTriangleFromValidInput() throws Exception {
        String[] args = {"3.1", "4", "5"};
        TriangleClassifier classifier = new TriangleClassifier();
        Triangle triangle = classifier.createShape(args);
        assertTrue(new BigDecimal("3.1").compareTo(triangle.a()) == 0);
        assertTrue(new BigDecimal("4").compareTo(triangle.b()) == 0);
        assertTrue(new BigDecimal("5").compareTo(triangle.c()) == 0);
    }

    @Test
    void throwsIfNotEnoughArguments() {
        String[] args = {"3.01", "4"};
        TriangleClassifier classifier = new TriangleClassifier();
        Exception exception = assertThrows(
                InvalidInputException.class,
                () -> classifier.createShape(args)
        );
        assertEquals(I18nHelper.message("error.parameters"), exception.getMessage());
    }

    @Test
    void throwsIfArgumentIsNotANumber() {
        String[] args = {"3", "x", "5"};
        TriangleClassifier classifier = new TriangleClassifier();
        Exception exception = assertThrows(
                InvalidInputException.class,
                () -> classifier.createShape(args)
        );
        assertEquals(I18nHelper.message("error.validNumber"), exception.getMessage());
    }

    @Test
    void throwsIfInvalidTriangle() {
        String[] args = {"1", "2.2", "8"};
        TriangleClassifier classifier = new TriangleClassifier();
        Exception exception = assertThrows(
                InvalidInputException.class,
                () -> classifier.createShape(args)
        );
        assertEquals(I18nHelper.message("error.invalidTriangle"), exception.getMessage());
    }
}
