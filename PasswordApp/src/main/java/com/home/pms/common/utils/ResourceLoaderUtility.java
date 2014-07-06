/**
 * 
 */
package com.home.pms.common.utils;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.filechooser.FileSystemView;

import com.home.pms.common.exception.PmsException;

/**
 * @author Rohit Khurana
 *
 */
public class ResourceLoaderUtility {

	/**
	 * <p>
	 * loadClassPathResource loads the referenceResource in the referenceClass.
	 * </p>
	 * 
	 * @param refResource
	 *            the ref resource
	 * @param refClass
	 *            the ref class
	 * @return resultObj File
	 * @throws ReconException
	 *             the base exception
	 */
	public static File loadClassPathResource(final String refResource, final Class<?> refClass) throws PmsException {
		File resultObj = null;
		try {
			resultObj = new File(refClass.getClassLoader().getResource(refResource).toURI());
		} catch (Exception ext) {
			throw new PmsException("", null, null, ext, null);
		}
		return resultObj;

	}

	/**
	 * <p>
	 * loadFilePathResource this function returns the file present in the given path.
	 * </p>
	 * 
	 * @param refResourcePath
	 *            the ref resource path
	 * @return resultObj File
	 */
	public static File loadFilePathResource(final String refResourcePath) {
		return new File(refResourcePath);
	}

	/**
	 * <p>
	 * loadFilePathResources this function returns all the files present in the given path.
	 * </p>
	 * 
	 * @param refResourcePath
	 *            the ref resource path
	 * @return resultObj File
	 */
	public static File[] loadFilePathResources(final String refResourcePath) {
		return new File(refResourcePath).listFiles();
	}

	/**
	 * <p>
	 * loadResource load the given class it takes the class path as an argument of type String.
	 * </p>
	 * 
	 * @param refResource
	 *            the ref resource
	 * @return resultObj File
	 * @throws ReconException
	 *             the base exception
	 */
	public static File loadResource(final String refResource) throws PmsException {
		File resultObj = null;
		try {
			resultObj = new File(ResourceLoaderUtility.class.getResource(refResource).toURI());
		} catch (Exception ext) {
			throw new PmsException("", null, null, ext, null);
		}

		return resultObj;

	}

	/**
	 * <p>
	 * Search recursively the specified inside given directory.
	 * </p>
	 * 
	 * @param fileName
	 *            the file name
	 * @param directory
	 *            the directory
	 * @return the file
	 */
	private static File search(final String fileName, final File directory) {
		File[] refFileArray = directory.listFiles();
		File refFile = null;
		if (refFileArray == null) {
			return refFile;
		}
		for (File refArrayFile : refFileArray) {
			if (refArrayFile.isDirectory()) {
				refArrayFile = search(fileName, refArrayFile);
			}

			if ((refArrayFile != null) && refArrayFile.getName().equalsIgnoreCase(fileName)) {
				refFile = refArrayFile;
				break;
			} else {
				refFile = null;
			}
		}
		return refFile;
	}

	/**
	 * <p>
	 * Search and load resource from current user directory.
	 * </p>
	 * 
	 * @param refResourceName
	 *            the ref resource name
	 * @return the file object
	 * @throws ReconException
	 *             the base exception
	 */
	public static File searchAndLoadResource(final String refResourceName) throws PmsException {
		File refObject = null;
		if (StringUtils.isEmptyString(refResourceName)) {
			throw new PmsException(null, null, null, new NullPointerException("Resource name is empty"), null);
		} else {
			File refFile = new File(refResourceName);
			if (refFile.exists()) {
				refObject = loadFilePathResource(refResourceName);
			} else {
				refObject = search(refResourceName,
						FileSystemView.getFileSystemView().getParentDirectory(new File(System.getProperty("user.dir"))));
			}
		}
		if (refObject == null) {
			throw new PmsException("", null, null, new FileNotFoundException(), null);
		}
		return refObject;
	}

	/**
	 * <p>
	 * private constructor added to prevent creating object for this class.
	 * </p>
	 */
	private ResourceLoaderUtility() {
	}
}
