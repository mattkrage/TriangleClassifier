package triangle;

import java.math.BigDecimal;

/**
 * {@code TriangleClassifier} is an implementation of {@link ShapeClassifier}
 * responsible for parsing input arguments, creating a {@link Triangle} instance,
 * and producing a human-readable description of the triangle type via a {@link ShapeOutput}.
 * <p>
 * This class separates shape classification logic from presentation logic, which
 * allows easy substitution of different output formats (e.g., console, GUI, web).
 */
public class TriangleClassifier implements ShapeClassifier<Triangle> {

    /**
     * Parses the input arguments into side lengths and constructs a {@link Triangle} instance.
     * <p>
     * This method validates that exactly three arguments are provided, and that each argument
     * is a valid numeric value. It then constructs a triangle using {@link BigDecimal} for precision.
     * If any of the arguments are invalid or if the triangle cannot be constructed, an exception is thrown.
     *
     * @param args an array of strings representing the three side lengths of the triangle
     * @return a valid {@link Triangle} instance
     * @throws InvalidInputException if the number of arguments is incorrect, the input cannot be parsed,
     *                               or the triangle violates geometric constraints
     */
     @Override
     public Triangle createShape(String[] args) throws InvalidInputException {

        validateArguments(args);
        try {
            BigDecimal a = new BigDecimal(args[0]);
            BigDecimal b = new BigDecimal(args[1]);
            BigDecimal c = new BigDecimal(args[2]);

            return new Triangle(a, b, c);

        } catch (NumberFormatException e) {
            throw new InvalidInputException(I18nHelper.message("error.validNumber"));
        } catch (IllegalArgumentException e) {
            throw new InvalidInputException(e.getMessage());
        }
    }

    @Override
    public String getShapeDescription(Triangle triangle) {
            return switch (triangle.getType()) {
                case EQUILATERAL -> I18nHelper.message("triangle.equilateral");
                case ISOSCELES -> I18nHelper.message("triangle.isosceles");
                case SCALENE -> I18nHelper.message("triangle.scalene");
                case OTHER -> I18nHelper.message("triangle.unknown");
            };
    }

    private void validateArguments(String[] args) throws InvalidInputException {
        if (args.length != 3) {
            throw new InvalidInputException(I18nHelper.message("error.parameters"));
        }
    }

}
