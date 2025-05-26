package triangle;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nHelper {
    private static final String BUNDLE_NAME = "messages";

    public static String message(String key) {
        return ResourceBundle.getBundle(BUNDLE_NAME, Locale.getDefault()).getString(key);
    }
}
