package triangle;

/**
 * Generic interface for classifying geometric shapes.
 * <p>
 * Implementations are responsible for creating a specific type of {@link Shape}
 * from raw input (such as command-line arguments) and for providing a description
 * or classification of the shape (e.g., triangle type).
 *
 * @param <T> the type of shape this classifier handles
 */
public interface ShapeClassifier<T extends Shape> {

    T createShape(String[] args) throws InvalidInputException;

    String getShapeDescription(T shape);
}
