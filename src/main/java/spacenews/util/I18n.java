package spacenews.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Class to internationalize
 */
public class I18n {
	private static final String BASE_NAME = "labels";
	private static ResourceBundle bundle;

	/**
	 * constructor
	 * @param locale: variable to set the language
	 * @return the specific bundle for the wished language
	 */
	public static ResourceBundle getResourceBundle(Locale locale) {
		bundle = ResourceBundle.getBundle(BASE_NAME, locale);
		return bundle;
	}

	/**
	 * method to get a specific bundle
	 * @param key: key word for the language
	 * @return the name of the bundle
	 */
	public static String getString(String key) {
		try {
			return bundle.getString(key);
		} catch (MissingResourceException e) {
			return " ! " + key + " ! ";
		}
	}

	/**
	 * method to return the wished bundle
	 * @param key: key word for the language
	 * @param params: language specification
	 * @return a pair of language and region
	 */
	public static String getString(String key, Object... params) {
		try {
			return MessageFormat.format(bundle.getString(key), params);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
