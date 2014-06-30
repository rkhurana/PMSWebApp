package com.home.pms.common.utils;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListUtilsTest {

		ListUtils listUtils = ListUtils.getInstance();
	@Test
	public void testIsEmptyList() {
		List<String> refList= new ArrayList();
		refList.add("A");
		listUtils.isEmptyList(refList);
		System.out.println(listUtils.isEmptyList(refList));
	}

	@Test
	public void testGetFirstElement() {
		List<String> refList= new ArrayList();
		refList.add("Rohit");
		refList.add("nandu");
		refList.add("mukesh");
		System.out.println(listUtils.getFirstElement(refList));
		fail("Not yet implemented");
	}

	@Test
	public void testGetLastElement() {
		List<String> refList= new ArrayList();
		refList.add("Rohit");
		refList.add("nandu");
		refList.add("mukesh");
		System.out.println(listUtils.getLastElement(refList));
		fail("Not yet implemented");
	}

	@Test
	public void testConvertToStringArray() {
		List<String> refList= new ArrayList();
		refList.add("Rohit");
		refList.add("nandu");
		refList.add("mukesh");
		System.out.println(listUtils.convertToStringArray(refList));
		fail("Not yet implemented");
	}

}
