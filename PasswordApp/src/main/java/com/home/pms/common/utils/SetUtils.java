/**
 * 
 */
package com.home.pms.common.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
	 * @return innstace of the class
	 */
	public static SetUtils getInstance() {
		return new SetUtils();
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

	/**
	 * Size.
	 * 
	 * @param oRef
	 *            the o ref
	 * @return the int
	 */
	@SuppressWarnings("unchecked")
	public static int size(final Object oRef) {
		if (oRef instanceof Set<?>) {
			if (!isEmptySet((Set<?>) oRef)) {
				Set<Object> sRef = (Set<Object>) oRef;
				return sRef.size();
			}
		}
		return 0;
	}

	/**
	 * <p>
	 * This method will return the First Element based on whether the given Set
	 * is empty or not
	 * </p>
	 * .
	 * 
	 * @param setRef
	 *            the set ref
	 * @return {@link Object } returns the first value of the Set
	 */
	public static Object getFirstElement(final Set<?> setRef) {
		Object firstElement = null;
		if (!isEmptySet(setRef)) {
			Iterator<?> itrRef = setRef.iterator();
			while (itrRef.hasNext()) {
				firstElement = itrRef.next();
				break;
			}
		}
		return firstElement;
	}

	/**
	 * <p>
	 * Helps to identify the named parameter from a set
	 * </p>
	 * .
	 * 
	 * @param setRef
	 *            the set ref
	 * @param namedElement
	 *            the named element
	 * @return null if element if not identified from set else identified object
	 *         {@link Set} Reference of Original set {@link String} Name of the
	 *         element to identify from set
	 */
	@SuppressWarnings("unchecked")
	public static Object getNamedElement(final Set<?> setRef, final Object namedElement) {
		Object element = null;
		if (!isEmptySet(setRef)) {
			Set<Map.Entry<?, ?>> newSetRef = (Set<Map.Entry<?, ?>>) setRef;
			for (Map.Entry<?, ?> me : newSetRef) {
				if (StringUtils
						.isEqualIgnoreCase(StringUtils.toString(me.getKey()), StringUtils.toString(namedElement))) {
					element = me.getValue();
					break;
				}
			}
		}
		return element;
	}

	/**
	 * To list.
	 * 
	 * @param setRef
	 *            the set ref
	 * @return the list
	 */
	public static List<Object> toList(final Set<?> setRef) {
		List<Object> toL = new ArrayList<Object>();
		if (!isEmptySet(setRef)) {
			Iterator<?> refIterator = setRef.iterator();
			while (refIterator.hasNext()) {
				toL.add(refIterator.next());
			}
		}
		return toL;
	}

	/**
	 * To specfic type list.
	 * 
	 * @param <E>
	 *            the element type
	 * @param setRef
	 *            the set ref
	 * @param castType
	 *            the cast type
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public static <E extends Object> List<E> toSpecficTypeList(final Set<?> setRef, final E castType) {
		List<E> toL = new ArrayList<E>();
		if (!isEmptySet(setRef)) {
			Iterator<?> refIterator = setRef.iterator();
			while (refIterator.hasNext()) {
				toL.add((E) refIterator.next());
			}
		}
		return toL;
	}

	/**
	 * To string.
	 * 
	 * @param setRef
	 *            the set ref
	 * @return the string
	 */
	public static String toString(final Set<?> setRef) {
		String str = "";
		if (!isEmptySet(setRef)) {
			Iterator<?> refIterator = setRef.iterator();
			Object obj;
			while (refIterator.hasNext()) {
				obj = refIterator.next();
				if (!StringUtils.isEmptyString(obj)) {
					str += StringUtils.toString(obj) + ",";
				}
			}
		}
		return str.length() > 1 ? str.substring(0, str.length()) : str;
	}
}
