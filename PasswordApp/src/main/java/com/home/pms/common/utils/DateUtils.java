/**
 * 
 */
package com.home.pms.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *         This class provide various utilities for date conversion format
 * </p>
 *         
 * @author Rohit Khurana
 *
 */
public class DateUtils {
	
	/**
	 * Private constructor to prevent the instantiation because this class has
	 * all the static methods.
	 */
	private DateUtils() {
	}

	/**
	 * <p>
	 * This will format the Date as expected
	 * </p>
	 * .
	 * 
	 * @param date
	 *            the date
	 * @param format
	 *            the format
	 * @return {@link String} formated date in String representation {@link Date} date to be formated {@link String}
	 *         required format
	 */
	public static String formatDate(final Date date, final String format) {
		String formatedDate = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		formatedDate = simpleDateFormat.format(date);
		return formatedDate;
	}
}
