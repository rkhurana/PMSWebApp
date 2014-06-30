/**
 * 
 */
package com.home.pms.common.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
	 * @param oRef
	 * @return
	 */
	public int size(final Set oRef){
		
		if ((oRef != null) || (oRef.size() != 0)) {
		return oRef.size();
		}
		return 0;
	}
	/**
	 * @param setRef
	 * @return
	 */
	public	Object getFirstElement(final Set<?> setRef){
		if ((setRef == null) || (setRef.size() != 0)) {
		Iterator it=  setRef.iterator();
		while(it.hasNext()){
			return it.next();
		  }
		}
		return null;
		
	}
	public	List<Object> toList(final Set<?> setRef){
		List list =new ArrayList();
		if ((setRef == null) || (setRef.size() != 0)) {
			list.addAll(setRef);
			return list;
		}
		return null;
		
	}
	public	String toString(final Set<?> setRef){
		if ((setRef == null) || (setRef.size() != 0)) {
			return setRef.toString();
		}
		return null;
		
	}
	
}
