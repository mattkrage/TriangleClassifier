package triangle;

/**
 * Entry point for the triangle classification command-line application.
 * <p>
 * This class parses command-line arguments, invokes the triangle classification logic
 * via {@link TriangleClassifier}, and handles formatted output using {@link ConsoleShapeOutput}.
 * It orchestrates input validation, shape creation, and result presentation.
 */
public class TriangleCliApp {

    /**
     * Launches the triangle classification application.
     * <p>
     * Delegates execution to {@link #run(String[], ShapeOutput)} with a {@link ConsoleShapeOutput}.
     *
     * @param args the side lengths of the triangle (must be exactly three numeric values)
     */
    public static void main(String... args) {
        ShapeOutput output = new ConsoleShapeOutput();
        new TriangleCliApp().run(args, output);
    }

    /**
     * Runs the application logic to classify a triangle based on the provided input.
     * <p>
     * This method validates the input, creates a {@link Triangle} using {@link TriangleClassifier},
     * obtains a description of the triangle type, and prints the result via the provided {@link ShapeOutput}.
     * If the input is invalid, it prints an error message and terminates the application with a non-zero exit code.
     *
     * @param args   the side lengths of the triangle as strings
     * @param output the output handler responsible for displaying results and errors
     */
    public void run(String[] args, ShapeOutput output) {
        try {
            ShapeClassifier<Triangle> classifier = new TriangleClassifier();
            Triangle triangle = classifier.createShape(args);

            output.printType(classifier.getShapeDescription(triangle));

        } catch (InvalidInputException e) {
            output.printError(e.getMessage());
            System.exit(1);
        }
    }
}
