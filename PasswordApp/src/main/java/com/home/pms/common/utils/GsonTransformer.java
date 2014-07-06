/**
 * 
 */
package com.home.pms.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Rohit Khurana
 *
 */
public class GsonTransformer {

	/** The gson ref. */
	private Gson	gsonRef;

	/**
	 * Instantiates a new gson transformer.
	 * 
	 */
	private GsonTransformer() {
		this.gsonRef = new GsonBuilder().create();
	}

	/**
	 * Gets the single instance of GsonTransformer.
	 * 
	 * @return single instance of GsonTransformer
	 */
	public static final GsonTransformer getInstance() {
		return new GsonTransformer();
	}

	/**
	 * To object.
	 * 
	 * @param gsonData
	 *            the gson data
	 * @param classType
	 *            the class type
	 * @return the object
	 */
	public <T extends Object> T fromGsonToObject(final String gsonData, final Class<T> classType) {
		return this.gsonRef.fromJson(gsonData, classType);
	}

	/**
	 * From object to gson.
	 * 
	 * @param objRef
	 *            the obj ref
	 * @return the string
	 */
	public String fromObjectToGson(final Object objRef) {
		return this.gsonRef.toJson(objRef);
	}
}
