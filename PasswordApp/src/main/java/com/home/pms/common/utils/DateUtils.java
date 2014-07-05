/**
 * 
 */
package com.home.pms.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
	
	/**
	 * <p>
	 * This will format the Date as expected
	 * </p>
	 * .
	 * 
	 * @param date
	 *            the date
	 * @param locale
	 *            the locale
	 * @return {@link String} formated date in String representation {@link Date} date to be formated {@link Locale}
	 *         Expected Locale on which date will be formated
	 */
	public static String formatDate(final Date date, final Locale locale) {
		return DateFormat.getInstance().format(date).toUpperCase();
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
	 * @return {@link String} formated date in String representation
	 * @throws Exception
	 *             the exception {@link String} date to be formated {@link String} required format
	 */
	public static Date formatDate(final String date, final String format) throws Exception {
		assertValidation(date, format);
		try {
			return org.apache.commons.lang.time.DateUtils.parseDate(date, new String[] { format });
		} catch (Exception e) {
			SimpleDateFormat sdf = new SimpleDateFormat(StringUtils.removeAllSpecialCharacters(format));
			sdf.setLenient(false);
			return sdf.parse(StringUtils.removeAllSpecialCharacters(date));
		}
	}

	/**
	 * Format date.
	 * 
	 * @param fromFormat
	 *            the from format
	 * @param toFormat
	 *            the to format
	 * @param date
	 *            the date
	 * @return the date
	 * @throws ParseException
	 *             the parse exception
	 * @throws Exception
	 *             the exception
	 */
	public static Date formatAsDate(final String fromFormat, final String toFormat, final String date)
			throws ParseException, Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(toFormat);
		return sdf.parse(sdf.format(formatDate(date, fromFormat)));
	}

	/**
	 * Format as string date.
	 * 
	 * @param fromFormat
	 *            the from format
	 * @param toFormat
	 *            the to format
	 * @param date
	 *            the date
	 * @return the string
	 * @throws ParseException
	 *             the parse exception
	 * @throws Exception
	 *             the exception
	 */
	public static String formatAsStringDate(final String fromFormat, final String toFormat, final String date)
			throws ParseException, Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(toFormat);
		return sdf.format(formatDate(date, fromFormat));
	}

	/**
	 * Assert validation.
	 * 
	 * @param date
	 *            the date
	 * @param format
	 *            the format
	 * @throws Exception
	 *             the exception
	 */
	private static void assertValidation(String date, String format) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setLenient(false);
		sdf.parse(date);
	}

	/**
	 * <p>
	 * This will format the date with special characters
	 * </p>
	 * .
	 * 
	 * @param date
	 *            the date
	 * @param format
	 *            the format
	 * @return {@link String} formated date will be returned
	 * @throws Exception
	 *             the exception {@link String} date to be formated {@link String} in which format it is to be converted
	 */
	public static Date formatDateWithoutSpecialCharRemove(final String date, final String format) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setLenient(false);
		return sdf.parse(date);
	}

	/**
	 * <p>
	 * This will calculate the no of working days between given 2 dates excluding the weekends
	 * </p>
	 * .
	 * 
	 * @param date1
	 *            the date1
	 * @param date2
	 *            the date2
	 * @return {@link Integer} no of days between 2 dates excluding weekends {@link Date} start date {@link Date} end
	 *         date
	 */

	public static int getNumOfWorkingDaysExcludingWeekends(final Date date1, final Date date2) {
		Calendar startCal, endCal;
		startCal = Calendar.getInstance();
		startCal.setTime(date1);
		endCal = Calendar.getInstance();
		endCal.setTime(date2);
		int workDays = 0;
		/**
		 * it returns 0 if start and end are the same
		 */
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}
		/**
		 * <p>
		 * Just in case the dates were transposed this prevents infinite loop if the startCal date is greater than the
		 * endCal date then the dates will be swapped
		 * </p>
		 */
		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(date2);
			endCal.setTime(date1);
		}
		do {
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if ((startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY)
					&& (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)) {
				++workDays;
			}
		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis());

		return workDays;
	}

	/**
	 * <p>
	 * This will calculate the no of working days between given 2 dates excluding the weekends
	 * </p>
	 * .
	 * 
	 * @param date1
	 *            the date1
	 * @param date1Pattern
	 *            the date1 pattern
	 * @param date2
	 *            the date2
	 * @param date2Pattern
	 *            the date2 pattern
	 * @return {@link Integer} no of days between 2 dates excluding weekends
	 * @throws Exception
	 *             the exception {@link String} start date {@link String} format of date1 {@link String} end date
	 *             {@link String} format of date2
	 */
	public static int getNumOfWorkingDaysExcludingWeekends(final String date1, final String date1Pattern,
			final String date2, final String date2Pattern) throws Exception {
		return getNumOfWorkingDaysExcludingWeekends(formatDate(date1, date1Pattern), formatDate(date2, date2Pattern));
	}

	/**
	 * <p>
	 * This helps to calculate the next date from given date
	 * </p>
	 * .
	 * 
	 * @param startDate
	 *            the start date
	 * @param addNoOfDays
	 *            the add no of days
	 * @return {@link Date} returns the next date {@link Date} this is the start date {@link Integer} number of days to
	 *         be added
	 */
	public static Date calculateNextDate(final Date startDate, final int addNoOfDays) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.DATE, addNoOfDays);
		return cal.getTime();
	}

	/**
	 * <p>
	 * This helps to calculate the next date from given date
	 * </p>
	 * .
	 * 
	 * @param startDate
	 *            the start date
	 * @param startDateFormat
	 *            the start date format
	 * @param addNoOfDays
	 *            the add no of days
	 * @return {@link Date} returns the next date {@link Integer} number of days to be added
	 */
	public static Date calculateNextDate(final String startDate, final String startDateFormat, final int addNoOfDays) {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(formatDate(startDate, startDateFormat));
		} catch (Exception e) {

		}
		cal.add(Calendar.DATE, addNoOfDays);
		return cal.getTime();
	}

	/**
	 * Format date.
	 * 
	 * @param inputDate
	 *            the input date
	 * @param formatOne
	 *            the format one
	 * @param formatTwo
	 *            the format two
	 * @return {@link String} returns the formatted date
	 * @throws Exception
	 *             the exception {@link String} the date that will be provided at input time {@link String}
	 *             {@link String}
	 */
	public static String formatDate(final String inputDate, final String formatOne, final String formatTwo)
			throws Exception {
		SimpleDateFormat oneFormat = new SimpleDateFormat(formatOne);
		Date date = oneFormat.parse(inputDate);
		SimpleDateFormat otherFormat = new SimpleDateFormat(formatTwo);
		return otherFormat.format(date);
	}

	/**
	 * Difference.
	 * 
	 * @param startDate
	 *            the start date
	 * @param endDate
	 *            the end date
	 * @return dif difference between the two dates {@link Date} the start date {@link Date} the end date
	 */
	public static long difference(final Date startDate, final Date endDate) {
		long difference = endDate.getTime() - startDate.getTime();
		return difference;
	}
}
