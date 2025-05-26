package triangle;

import java.math.BigDecimal;

/**
 * Immutable representation of a triangle defined by three side lengths.
 * <p>
 * This record enforces triangle validity on construction:
 * all sides must be positive and satisfy the triangle inequality.
 * </p>
 * <p>
 * Provides methods to determine the triangle type (equilateral, isosceles, scalene),
 * as well as an enum {@link TriangleType} to classify the triangle.
 * </p>
 *
 * @param a length of the first side
 * @param b length of the second side
 * @param c length of the third side
 */
public record Triangle(BigDecimal a, BigDecimal b, BigDecimal c) implements Shape {

    public enum TriangleType {
        EQUILATERAL,
        ISOSCELES,
        SCALENE,
        OTHER
    }

    public Triangle {
        if (a.compareTo(BigDecimal.ZERO) <= 0 || b.compareTo(BigDecimal.ZERO) <= 0 || c.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(I18nHelper.message("error.positiveSides"));
        }
        if (a.add(b).compareTo(c) <= 0 || a.add(c).compareTo(b) <= 0 ||b.add(c).compareTo(a) <= 0) {
            throw new IllegalArgumentException(I18nHelper.message("error.invalidTriangle"));
        }
    }

    public boolean equilateral() {
        return a.compareTo(b) == 0 && b.compareTo(c) == 0;
    }

    public boolean isosceles() {
        return a.compareTo(b) == 0 || b.compareTo(c) == 0 || a.compareTo(c) == 0;
    }

    public boolean scalene() {
        return !isosceles();
    }

    public TriangleType getType() {
        if (equilateral()) return TriangleType.EQUILATERAL;
        if (isosceles()) return TriangleType.ISOSCELES;
        if (scalene()) return TriangleType.SCALENE;
        return TriangleType.OTHER;
    }

}
