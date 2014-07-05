/**
 * 
 */
package com.home.pms.common.utils;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * @author nandan
 *
 */
public class SetUtilsTest {
	
	SetUtils setUtils = SetUtils.getInstance();

	/**
	 * Test method for {@link com.home.pms.common.utils.SetUtils#isEmptySet(java.util.Set)}.
	 */
	@Test
	public void testIsEmptySet() {
		Set setRef = new HashSet();
		setRef.add("Objcet");
		System.out.println("testIsEmptySet "+setUtils.isEmptySet(setRef));
	}

	/**
	 * Test method for {@link com.home.pms.common.utils.SetUtils#size(java.util.Set)}.
	 */
	@Test
	public void testSize() {
		Set setRef = new HashSet();
		setRef.add("Rohit");
		setRef.add("Nandan");
		setRef.add("Mukhesh");
		System.out.println("testSize "+setUtils.size(setRef));
	}

	/**
	 * Test method for {@link com.home.pms.common.utils.SetUtils#getFirstElement(java.util.Set)}.
	 */
	@Test
	public void testGetFirstElement() {
		Set setRef = new HashSet();
		setRef.add("Rohit");
		setRef.add("Nandan");
		setRef.add("Mukhesh");
		System.out.println("testGetFirstElement "+setUtils.getFirstElement(setRef));
	}
	
	/**
	 * Test method for {@link com.home.pms.common.utils.SetUtils#testToList(java.util.List)}.
	 */
	@Test
	public void testToList() {
		Set setRef = new HashSet();
		setRef.add("Rohit");
		setRef.add("Nandan");
		setRef.add("Mukhesh");
		System.out.println("testToList "+setUtils.toList(setRef));
	}
	/**
	 * Test method for {@link com.home.pms.common.utils.SetUtils#testToString(java.lang.String)}.
	 */
	@Test
	public void testToString() {
		Set setRef = new HashSet();
		setRef.add("Rohit");
		setRef.add("Nandan");
		setRef.add("Mukhesh");
		System.out.println("testToString "+setUtils.toString(setRef));
	}
	
}
