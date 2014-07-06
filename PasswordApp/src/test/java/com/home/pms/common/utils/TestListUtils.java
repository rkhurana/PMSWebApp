package com.home.pms.common.utils;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestListUtils {

		ListUtils listUtils = ListUtils.getInstance();
	/**
	 * Test method for {@link com.home.pms.common.utils.ListUtils#isEmptySet(java.util.List)}.
	 */
	@Test
	public void testIsEmptyList() {
		List<String> refList= new ArrayList();
		refList.add("A");
		listUtils.isEmptyList(refList);
		System.out.println("testIsEmptyList  "+listUtils.isEmptyList(refList));
	}
	/**
	 * Test method for {@link com.home.pms.common.utils.ListUtils#GetFirstElement(java.util.List)}.
	 */

	@Test
	public void testGetFirstElement() {
		List<String> refList= new ArrayList();
		refList.add("Rohit");
		refList.add("nandu");
		refList.add("mukesh");
		System.out.println("testGetFirstElement  "+listUtils.getFirstElement(refList));
	}

	/**
	 * 
	 * Test method for {@link com.home.pms.common.utils.ListUtils#GetLastElement(java.util.List)}.
	 */
	 
	@Test
	public void testGetLastElement() {
		List<String> refList= new ArrayList();
		refList.add("Rohit");
		refList.add("nandu");
		refList.add("mukesh");
		System.out.println("testGetLastElement  "+listUtils.getLastElement(refList));
	}
	/**
	 * 
	 * Test method for {@link com.home.pms.common.utils.ListUtils#ConvertToStringArray(java.util.List)}.
	 */

	@Test
	public void testConvertToStringArray() {
		List<String> refList= new ArrayList();
		refList.add("Rohit");
		refList.add("nandu");
		refList.add("mukesh");
		System.out.println("testConvertToStringArray "+listUtils.convertToStringArray(refList));
	}

}
