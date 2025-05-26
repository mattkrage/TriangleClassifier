package triangle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Console-based implementation of {@link ShapeOutput} that logs triangle information
 * and errors using SLF4J.
 * <p>
 * This implementation is intended for command-line applications and uses internationalized
 * messages provided by {@link I18nHelper}.
 */
public class ConsoleShapeOutput implements ShapeOutput {

    private static final Logger logger = LoggerFactory.getLogger(ConsoleShapeOutput.class);

    @Override
    public void printType(String bundleKey) {
        logger.info(I18nHelper.message(bundleKey));
    }

    @Override
    public void printError(String message) {
        logger.error("{} {}", I18nHelper.message("error"), message);
    }

}