/**
 * 
 */
package com.home.pms.common.exception;

import com.home.pms.common.utils.StringUtils;

/**
 * @author Rohit Khurana
 *
 */
public class PmsException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2987854370539961561L;

	/** The exception code. */
	private String				exceptionCode		= "Common Exception";

	/** The qualified class name. */
	private String				qualifiedClassName;

	/** The object id. */
	private Long				objectId;

	/** The values. */
	private String[]			values;
	
	/**
	 * Instantiates a new recon exception.
	 * 
	 * @param exceptionCode
	 *            the exception code
	 * @param qualifiedClassName
	 *            the qualified class name
	 * @param objectId
	 *            the object id
	 * @param exception
	 *            the exception
	 * @param values
	 *            the values
	 */
	public PmsException(final String exceptionCode, final String qualifiedClassName, final Long objectId,
			final Exception exception, final String[] values) {
		super(exception);
		if (!StringUtils.isEmptyString(exceptionCode)) {
			this.exceptionCode = exceptionCode;
		}
		this.qualifiedClassName = qualifiedClassName;
		this.objectId = objectId;
		this.values = values;
	}
	
	/**
	 * Instantiates a new recon exception.
	 * 
	 * @param exceptionCode
	 *            the exception code
	 * @param qualifiedClassName
	 *            the qualified class name
	 * @param objectId
	 *            the object id
	 * @param values
	 *            the values
	 */
	public PmsException(final String exceptionCode, final String qualifiedClassName, final Long objectId,
			final String[] values) {
		super();
		if (!StringUtils.isEmptyString(exceptionCode)) {
			this.exceptionCode = exceptionCode;
		}
		this.qualifiedClassName = qualifiedClassName;
		this.objectId = objectId;
		this.values = values;
	}
	
	/**
	 * Gets the exception code.
	 * 
	 * @return the exceptionCode
	 */
	public String getExceptionCode() {
		return this.exceptionCode;
	}
	
	/**
	 * Gets the decoded exception code.
	 * 
	 * @return the decoded exception code
	 */
	public String getDecodedExceptionCode() {
		return this.exceptionCode;
	}
	
	/**
	 * Gets the value for ReconException.java
	 * 
	 * @return the qualifiedClassName
	 */
	public final String getQualifiedClassName() {
		return this.qualifiedClassName;
	}
	
	/**
	 * Gets the value for ReconException.java
	 * 
	 * @return the objectId
	 */
	public final Long getObjectId() {
		return this.objectId;
	}
	
	/**
	 * Gets the values.
	 * 
	 * @return the values
	 */
	public String[] getValues() {
		return this.values;
	}
	
	/**
	 * @param exceptionCode
	 *            the exceptionCode to set
	 */
	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	/**
	 * @param qualifiedClassName
	 *            the qualifiedClassName to set
	 */
	public void setQualifiedClassName(String qualifiedClassName) {
		this.qualifiedClassName = qualifiedClassName;
	}

	/**
	 * @param objectId
	 *            the objectId to set
	 */
	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}
	
	/**
	 * @param values
	 *            the values to set
	 */
	public void setValues(String[] values) {
		this.values = values;
	}
}
