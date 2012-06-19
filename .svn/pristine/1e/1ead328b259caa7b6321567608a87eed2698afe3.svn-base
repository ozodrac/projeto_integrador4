package br.com.shark.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This class handles the process of finding and getting the resource br.com.shark.bundle files of each class.
 * 
 * @author Luciano Sampaio
 * @version 1.0
 * 
 */
public class I18N {

	/**
	 * The location where all the resource br.com.shark.bundle file are stored.
	 */
	private static final String RESOURCE_BUNDLE_LOCATION = "br.com.shark.bundle/";

	/**
	 * @param className
	 * @param locale
	 * @return
	 */
	public static ResourceBundle getBundle(String className, Locale locale) {
		return ResourceBundle.getBundle(RESOURCE_BUNDLE_LOCATION + className, locale);
	}
}