/**
 * 
 */
package com.home.pms.common.utils;

import java.util.List;

/**
 * <p>
 *       ListUtils provided required helper methods to deal with Java List.
 *  </p>
 *         
 * @author Rohit Khurana
 *
 */
public class ListUtils {

	/**
	 * Private constructor to prevent the instantiation because this class has all the static methods.
	 */
	private ListUtils() {
	}
	

	/**
	 * <p>
	 * Checks if given list is empty.
	 * </p>
	 * 
	 * @param refList
	 *            the ref list
	 * @return true, if is empty list
	 */
	public static boolean isEmptyList(final List<?> refList) {
		return (refList == null) || (refList.size() == 0) ? true : false;
	}
}
