/**
 * 
 */
package com.home.pms.common.utils;

import java.util.Set;

/**
 * <p>
 *    This class is responsible for setting the utilities for the Set Collection.
 *  </p>
 * @author Rohit Khurana
 *
 */
public class SetUtils {

	/**
	 * Private constructor to prevent the instantiation because this class has
	 * all the static methods.
	 */
	private SetUtils() {
	}
	
	/**
	 * <p>
	 * This method checks whether the given Set is Empty or not. Set. This
	 * method checks whether the given Set is Empty or not.
	 * </p>
	 * 
	 * @param setRef
	 *            the set ref
	 * @return {@link Boolean } returns true if the Set is empty otherwise false
	 */
	public static boolean isEmptySet(final Set<?> setRef) {
		boolean isEmptySet = false;
		if ((setRef == null) || (setRef.size() == 0)) {
			isEmptySet = true;
		}
		return isEmptySet;
	}
}
