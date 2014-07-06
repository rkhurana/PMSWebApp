/**
 * 
 */
package com.home.pms.common.utils;

import java.io.File;
import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * The Class ReconLogger.This class is responsible for creating the logs and helps in creating the logs of all
 * debbuging, errors fatal, warning messages
 * 
 * @author Rohit Khurana
 *
 */
public class PmsLogger {


	/** Assingning the null value to Logger initially. */
	private Logger					logger				= null;

	/** Declaring and initializing the isLoggerEnabled attribute. */
	private static boolean			isLoggerEnabled		= false;

	/** Assigning the null value to LoggerRepository initially. */
	private static LoggerRepository	loggerRepository	= null;

	/** The location. */
	private String					location;
	
	/**
	 * Helps to set the values through constructor.
	 * 
	 * @param loggableClass
	 *            the log-able class
	 */
	public PmsLogger(final Class<?> loggableClass) {
		if (loggerRepository == null) {
			defaultInitializer();
		}
		if (isLoggerEnabled) {
			logger = loggerRepository.getLogger(loggableClass.getName());
		}
	}
	
	private void defaultInitializer() {
		try {
			DOMConfigurator.configure(getClass().getResource("/pms-log-config.xml"));
			loggerRepository = LogManager.getLoggerRepository();
			isLoggerEnabled = loggerRepository.getLogger("com.home").getAdditivity();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Initialize.
	 * 
	 * @return true, if successful
	 */
	public void initialize() {
		try {
			final File file = ResourceLoaderUtility.searchAndLoadResource(location);
			URL logerConfigUrl = file.toURI().toURL();
			if (file.exists()) {
				DOMConfigurator.configure(logerConfigUrl);
			}
			loggerRepository = LogManager.getLoggerRepository();
			isLoggerEnabled = loggerRepository.getLogger("com.wipro.base").getAdditivity();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>
	 * This method helps in creating the logs and receives one parameter named as message. This will be done if
	 * isLoggerEnabled and isInfoEnabled evaluates to be true then it will pass the message into the info method
	 * </p>
	 * 
	 * @param message
	 *            the message
	 */
	public void logInfo(final String message) {
		if (isLoggerEnabled && logger.isInfoEnabled()) {
			logger.info(message);
		}
	}

	/**
	 * <p>
	 * This method helps in dealing with the debugging issues and receives one parameter named as message
	 * </p>
	 * .
	 * 
	 * @param message
	 *            the message
	 */
	public void logDebug(final String message) {
		if (isLoggerEnabled && logger.isDebugEnabled()) {
			logger.debug(message);
		}
	}

	/**
	 * <p>
	 * This method helps in dealing with the warning issues and receives one parameter named as message
	 * </p>
	 * .
	 * 
	 * @param message
	 *            the message
	 */
	public void logWarn(final String message) {
		if (isLoggerEnabled && logger.isEnabledFor(logger.getEffectiveLevel())) {
			logger.warn(message);
		}
	}

	/**
	 * <p>
	 * This method deals with all errors and receives two parameter named as message and throwable of Throwable class.
	 * This Throwable is the super classes of all errors and exceptions.
	 * 
	 * @param message
	 *            the message
	 * @param throwable
	 *            the throwable
	 */
	public void logError(final String message, final Throwable throwable) {
		if (isLoggerEnabled && logger.isEnabledFor(logger.getEffectiveLevel())) {
			logger.error(message, throwable);
		}
	}

	/**
	 * Log error.
	 * 
	 * @param message
	 *            the message
	 */
	public void logError(final String message) {
		if (isLoggerEnabled && logger.isEnabledFor(logger.getEffectiveLevel())) {
			logger.error(message);
		}
	}

	/**
	 * Sets the location.
	 * 
	 * @param location
	 *            the location to set
	 */
	public void setLocation(final String location) {
		this.location = location;
	}

	/**
	 * <p>
	 * This method helps in dealing with all fatal issues and it also receives one parameter named as message
	 * </p>
	 * .
	 * 
	 * @param message
	 *            the message
	 */
	@SuppressWarnings("deprecation")
	public void logFatal(final String message) {
		if (isLoggerEnabled && logger.isEnabledFor(Priority.FATAL)) {
			logger.fatal(message);
		}
	}
}
