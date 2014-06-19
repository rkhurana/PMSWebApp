/**
 * 
 */
package com.home.pms.common.utils;

/**
 *  <p>
 *         StringUtils class provides all the expected supporting methods required to deal with Primitive Type "String" in Java.
 *  </p>
 * @author Rohit Khurana
 *
 */
public class StringUtils {

	/**
	 * Private constructor to prevent the instantiation because this class has all the static methods.
	 */
	private StringUtils(){
		
	}
	
	/**
	 * <p>
	 * This is responsible to decide whether the provided String value is empty or not
	 * </p>
	 * .
	 * 
	 * @param value
	 *            the value
	 * @return {@link Boolean} true if value is empty else false. {@link String} Vale need to check
	 */
	public static boolean isEmptyString(final String value) {
		String values = value == null ? null : value.trim();
		return (values == null) || (values.length() == 0) ? true : false;
	}
}
