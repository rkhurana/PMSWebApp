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
	 * @return innstace of the class
	 */
	public static ListUtils getInstance() {
		return new ListUtils();
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
		System.out.println(refList.get(0));
		return (refList == null) || (refList.size() == 0) ? true : false;
	}
	
	/**
	 * @param refList
	 * @return
	 */
	public Object getFirstElement(final List<?> refList) {
		if (refList != null || !refList.isEmpty()) {
			return refList.get(0);
		}
		return null;
	}
	
	/**
	 * @param refList
	 * @return
	 */
	public Object getLastElement(final List<?> refList) {
		if (refList != null || !refList.isEmpty()) {
			return refList.get(refList.size()-1);
		}
		return null;
	}
	/**
	 * @param refList
	 * @return
	 */
	public	String[] convertToStringArray(final List<?> refList){
		String[] strResult = null;
		if (refList != null || !refList.isEmpty()) {
			 strResult=new String[refList.size()];  
			strResult=	refList.toArray(strResult);
		}
		return strResult;
	}
}
