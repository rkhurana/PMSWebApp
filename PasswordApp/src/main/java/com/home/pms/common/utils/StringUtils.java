/**
 * 
 */
package com.home.pms.common.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

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
	
	/**
	 * <p>
	 * This is responsible to decide whether the provided String value is empty or not
	 * </p>
	 * .
	 * 
	 * @param value
	 *            the value
	 * @return {@link Boolean} true if value is empty else false. {@link Object} Vale need to check
	 */
	public static boolean isEmptyString(final Object value) {
		boolean isEmpty = true;
		String values = null;
		if (value != null) {
			values = value.toString().trim();
		}
		if ((values != null) && (values.length() != 0)) {
			isEmpty = false;
		}
		return isEmpty;
	}

	/**
	 * <p>
	 * This will convert a string into list separated by any separator
	 * </p>
	 * .
	 * 
	 * @param value
	 *            the value
	 * @param seperator
	 *            the seperator
	 * @return {@link List} list of separated values {@link String} value to be converted into list {@link String} separator like , ; etc
	 */
	public static List<String> toList(final String value, final String seperator) {
		List<String> tempL = null;
		if (!isEmptyString(value)) {
			tempL = new ArrayList<String>();
			StringTokenizer stringToken = new StringTokenizer(value, seperator);
			while (stringToken.hasMoreTokens()) {
				tempL.add(stringToken.nextToken());
			}
		}
		return tempL;
	}

	/**
	 * <p>
	 * This will convert a string into Array separated by any separator
	 * </p>
	 * .
	 * 
	 * @param value
	 *            the value
	 * @param seperator
	 *            the seperator
	 * @return {@link List} list of separated values
	 */
	public static String[] toArray(final String value, final String seperator) {
		List<String> tempL = null;
		if (!isEmptyString(value)) {
			tempL = new ArrayList<String>();
			StringTokenizer st = new StringTokenizer(value, seperator);
			while (st.hasMoreTokens()) {
				tempL.add(st.nextToken());
			}
			String[] temArray = new String[tempL.size()];
			int counter = 0;
			for (String str : tempL) {
				temArray[counter] = str;
				counter++;
			}
			return temArray;
		}
		return null;
	}

	/**
	 * Cast to string array.
	 * 
	 * @since 0.4
	 * @param array
	 *            the array
	 * @return the string[]
	 */
	public static String[] castToStringArray(Object[] array) {
		if ((array != null) && (array.length > 0)) {
			String[] strArray = new String[array.length];
			int index = 0;
			for (Object obj : array) {
				strArray[index] = toString(obj);
				index++;
			}

			return strArray;
		}
		return null;

	}

	/**
	 * <p>
	 * This helps to remove all the special characters from value
	 * </p>
	 * .
	 * 
	 * @param value
	 *            the value
	 * @return {@link String} {@link String}
	 */
	public static String removeAllSpecialCharacters(final String value) {
		String pattern = "[-!\"#$%&'()*+,./:;<=>?@\\[\\]_`{|}~\\+\\s]";
		return value.replaceAll(pattern, "");
	}

	/**
	 * <p>
	 * This helps to remove all the special character from value
	 * </p>
	 * .
	 * 
	 * @param value
	 *            the value
	 * @param spCharRegxPat
	 *            the special char regx pat
	 * @return {@link String} {@link String}
	 */
	public static String removeAllSpecialCharacters(final String value, final String spCharRegxPat) {
		return value.replaceAll(spCharRegxPat, "");
	}

	/**
	 * <p>
	 * Replace all the values from a string as expected by infoM map
	 * </p>
	 * .
	 * 
	 * @param str
	 *            the str
	 * @param infoM
	 *            the info m
	 * @return {@link String} {@link String} {@link Map}
	 */
	public static String replaceByKeyMap(String str, final Map<String, String> infoM) {
		Set<Map.Entry<String, String>> set = infoM.entrySet();
		for (Map.Entry<String, String> me : set) {
			str = str.replace(me.getKey(), me.getValue());
		}
		return str;
	}

	/**
	 * <p>
	 * This helps to check whether the passed 2 strings are equal or not ignoring the case
	 * </p>
	 * .
	 * 
	 * @param str1
	 *            the str1
	 * @param str2
	 *            the str2
	 * @return true if equal else false {@link String} String value 1 {@link String} String value 2
	 */
	public static boolean isEqualIgnoreCase(final String str1, final String str2) {
		boolean isEqual = false;
		if (!isEmptyString(str1) && !isEmptyString(str2)) {
			if (str1.equalsIgnoreCase(str2)) {
				isEqual = true;
			}
		}
		return isEqual;
	}

	/**
	 * <p>
	 * This helps to check whether the passed two strings are equal or not
	 * </p>
	 * .
	 * 
	 * @param str1
	 *            the str1
	 * @param str2
	 *            the str2
	 * @return true if equal else false {@link String} String value 1 {@link String} String value 2
	 */
	public static boolean isEqual(final String str1, final String str2) {
		boolean isEqual = false;
		if (!isEmptyString(str1) && !isEmptyString(str2)) {
			if (str1.equals(str2)) {
				isEqual = true;
			}
		} else if (isEmptyString(str1) && isEmptyString(str2)) {
			isEqual = true;
		}
		return isEqual;
	}

	/**
	 * Checks if is equal.
	 * 
	 * @param str1
	 *            the str1
	 * @param str2
	 *            the str2
	 * @return true, if is equal
	 */
	public static boolean isEqual(final Object str1, final Object str2) {
		boolean isEqual = false;
		if (!isEmptyString(str1) && !isEmptyString(str2)) {
			if (toString(str1).equals(toString(str2))) {
				isEqual = true;
			}
		}
		return isEqual;
	}

	/**
	 * <p>
	 * Responsible to trim the value as expected
	 * </p>
	 * .
	 * 
	 * @param value
	 *            the value
	 * @param startIndex
	 *            the start index
	 * @param endIndex
	 *            the end index
	 * @return {@link String } returns the substring reconing to the positions specified {@link String} value to be trimmed. {@link Integer} trim start
	 *         index {@link Integer} trim end index
	 */
	public static String trimTo(final String value, final int startIndex, final int endIndex) {
		String newValue = null;
		if (!isEmptyString(value) && (value.length() >= endIndex) && (startIndex < endIndex)) {
			newValue = value.substring(startIndex, endIndex);
		}
		return newValue;
	}

	/**
	 * Cast to long.
	 * 
	 * @param value
	 *            the value
	 * @return the long
	 */
	public static double castToDouble(final Object value) {
		double castVal = 0;
		if (!StringUtils.isEmptyString(value)) {
			castVal = Double.parseDouble(StringUtils.toString(value));
		}
		return castVal;
	}

	/**
	 * Cast to long.
	 * 
	 * @param value
	 *            s
	 * @return the long
	 */
	public static long castToLong(final Object value) {
		long castVal = 0;
		if (!StringUtils.isEmptyString(value)) {
			castVal = Long.parseLong(StringUtils.toString(value));
		}
		return castVal;
	}

	/**
	 * Cast to boolean.
	 * 
	 * @param value
	 *            the value
	 * @return the boolean
	 */
	public static boolean castToBoolean(final Object value) {
		boolean castVal = false;
		if (!StringUtils.isEmptyString(value)) {
			castVal = Boolean.parseBoolean(StringUtils.toString(value));
		}
		return castVal;
	}

	/**
	 * Cast to Integer.
	 * 
	 * @param value
	 *            the value
	 * @return the integer
	 */
	public static int castToInteger(final Object value) {
		int castVal = 0;
		if (!StringUtils.isEmptyString(value)) {
			castVal = Integer.parseInt(StringUtils.toString(value));
		}
		return castVal;
	}

	/**
	 * Cast to integer.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param value
	 *            the value
	 * @param castTo
	 *            the cast to
	 * @return the t
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> T castTo(final Object value, final T castTo) {
		if (!StringUtils.isEmptyString(value)) {
			return (T) value;
		}
		return null;
	}

	/**
	 * this will convert the object to String.
	 * 
	 * @param object
	 *            object to be converted into String
	 * @return {@link String}
	 */
	public static String toString(final Object object) {
		String str = "";
		if (object != null) {
			str = object.toString();
			if (isEmptyString(str)) {
				str = "";
			}
		}
		return str;
	}

	/**
	 * This method is used covert a string to title case.
	 * 
	 * @param str
	 *            String to check
	 * 
	 * @return String The changed string is returned
	 */
	public static String toTitleCase(final String str) {
		String strUpper = str.toUpperCase();
		return strUpper.charAt(0) + str.substring(1).toLowerCase();
	}

	/**
	 * Trim Class name.
	 * 
	 * @param name
	 *            the name
	 * @return the string
	 */
	public static String trimClassName(final String name) {
		String newName = name;
		if (newName.indexOf(".") > -1) {
			newName = newName.substring(name.lastIndexOf(".") + 1);
		}
		return newName;
	}

	/**
	 * <p>
	 * This method is used convert a string to Map.
	 * </p>
	 * 
	 * @param value
	 *            the value
	 * @param seperator
	 *            the seperator
	 * @return {@link Map} map {@link String} value to be converted into map {@link String} separator like , ; etc
	 */
	public static Map<String, String> toMap(final String value, final String seperator) {
		String newValue = null;
		Map<String, String> resultMap = new LinkedHashMap<String, String>();
		StringTokenizer tokenizer = new StringTokenizer(value, seperator);
		while (tokenizer.hasMoreTokens()) {
			newValue = tokenizer.nextToken();
			String key = newValue.replaceAll(" ", "");
			resultMap.put(key, newValue);
		}
		return resultMap;
	}

	/**
	 * Checks if is number.
	 * 
	 * @param value
	 *            the value
	 * @return true, if is number
	 */
	public static boolean isNumber(final String value) {
		boolean isNum = false;
		try {
			Double.parseDouble(value);
			isNum = true;
		} catch (NumberFormatException e) {

		}
		return isNum;
	}

	/**
	 * Converts a String to String list.
	 * 
	 * @param value
	 *            the string value
	 * @return the string list
	 */
	public static List<String> toStringList(String value) {
		List<String> stringValues = null;
		if (!StringUtils.isEmptyString(value)) {
			if (value.contains("[")) {
				value = value.substring(1, value.length() - 1);
			}
			stringValues = new ArrayList<String>();
			StringTokenizer stingTokens = new StringTokenizer(value, ",");
			while (stingTokens.hasMoreTokens()) {
				String token = stingTokens.nextToken();
				if (token.equals("")) {
					continue;
				} else {
					token = token.trim();
					stringValues.add(token);
				}
			}
		}
		if ((stringValues != null) && (stringValues.size() == 0)) {
			return null;
		} else {
			return stringValues;
		}
	}

}
