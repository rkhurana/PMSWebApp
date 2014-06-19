/**
 * 
 */
package com.home.pms.common.utils;

import java.text.DecimalFormat;

/**
 *  <p>
 *     StringUtils class provides all the expected supporting methods required to deal with Primitive Type "String" in Java.
 *  </p>
 *  
 * @author Rohit Khurana
 *
 */
public class NumberFormater {

	/**
	 * Private constructor to prevent the instantiation because this class has all the static methods.
	 */
	private NumberFormater() {
	}
	
	/**
	 * Gets the formated number.
	 * 
	 * @param num
	 *            the num
	 * @param format
	 *            the format
	 * @return the double
	 */
	public static Double getFormatedNumber(final Double num, final String format) {
		Double newNum = null;
		if (!StringUtils.isEmptyString(format)) {
			newNum = Double.parseDouble(new DecimalFormat(format).format(num));
		}
		return newNum;
	}
}
