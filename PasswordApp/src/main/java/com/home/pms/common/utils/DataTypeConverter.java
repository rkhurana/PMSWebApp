/**
 * 
 */
package com.home.pms.common.utils;

/**
 * <p>
 *      This class is responsible for conversion of different Data types
 * </p>
 * @author Rohit Khurana
 *
 */
public class DataTypeConverter {

	/**
	 * Private constructor to prevent the instantiation because this class has all the static methods.
	 */
	private DataTypeConverter() {
	}

	/**
	 * <p>
	 * This is the static method that receives three parameters of type string and throws the Exception. The nature of
	 * the parameters are:- 1. Data that needs to be converted 2. To which Type it is to be converted 3. In which Format
	 * it is to be converted
	 * </p>
	 * 
	 * @param convertableData
	 * @param convertionType
	 * @param conversionFormat
	 * @return
	 * @throws Exception
	 */
	public static Object convertDataType(final String convertableData, final String convertionType,
			final String conversionFormat) throws Exception {
		Object convertedData = null;
		final String contbleDataStr = StringUtils.toString(convertableData);
		final String conversionType = convertionType.toLowerCase();
		/**
		 * <p>
		 * Here it is checking whether the convertableData is empty or not. If it is not empty it converts that data
		 * into the corresponding data type.
		 * </p>
		 */

		if (!StringUtils.isEmptyString(contbleDataStr)) {
			/**
			 * This converts all the strings to lower case format
			 */
			/**
			 * <p>
			 * If the convertionType ends with "int" then it is automatically converted to integer data type
			 * </p>
			 */
			if (conversionType.endsWith("int") || conversionType.endsWith("integer")) {
				try {
					convertedData = Integer.valueOf(contbleDataStr);
				}
				catch (Exception e) {
					convertedData = Long.valueOf(new Double(Double.parseDouble(contbleDataStr)).longValue()).intValue();
				}
			}
			/**
			 * <p>
			 * If the convertionType ends with "long" then it is automatically converted to long data type
			 * </p>
			 */
			else if (conversionType.endsWith("long")) {
				try {
					convertedData = Long.valueOf(contbleDataStr);
				}
				catch (Exception e) {
					convertedData = Long.valueOf(new Double(Double.parseDouble(contbleDataStr)).longValue());
				}
			}
			/**
			 * <p>
			 * If the convertionType ends with "float" then it is automatically converted to float data type
			 * </p>
			 */
			else if (conversionType.endsWith("float")) {
				convertedData = new Float(Float.parseFloat(contbleDataStr));
			}
			/**
			 * <p>
			 * If the convertionType ends with "double" then it is automatically converted to double data type
			 * </p>
			 */
			else if (conversionType.endsWith("double")) {
				convertedData = new Double(Double.parseDouble(contbleDataStr));
			}
			/**
			 * <p>
			 * If the convertionType ends with "big decimal" then it is automatically converted to big decimal data type
			 * </p>
			 */
			else if (conversionType.endsWith("bigdecimal")) {
				convertedData = Long.valueOf(contbleDataStr);
			}
			/**
			 * <p>
			 * If the convertionType ends with "boolean" then it is automatically converted to boolean data type
			 * </p>
			 */
			else if (conversionType.endsWith("boolean")) {
				convertedData = Boolean.valueOf(contbleDataStr);
			}
			/**
			 * <p>
			 * If the convertionType ends with "char" then it is automatically converted to char data type
			 * </p>
			 */
			else if (conversionType.endsWith("char") || conversionType.endsWith("character")) {
				convertedData = new Character(contbleDataStr.toCharArray()[0]);
			}
			/**
			 * <p>
			 * If the convertionType ends with "date" then first it checks whether the conversionFormat is empty or not.
			 * If it is not empty then it takes the default date and time format as mentioned above
			 * </p>
			 */
			else if (conversionType.endsWith("date")) {
				convertedData = DateUtils.formatDate(contbleDataStr, conversionFormat);
			}
			/**
			 * <p>
			 * If the convertionType ends with "string" then it is automatically converted to String data type
			 * </p>
			 */
			else if (conversionType.endsWith("string")) {
				convertedData = contbleDataStr;
			}
			/**
			 * <p>
			 * If the above conditions don't evaluate to true then it will throw an exception showing that the
			 * respective conversion type is not supported
			 * </p>
			 */
			else {
				throw new Exception(convertionType + " not supported.");
			}
		}
		return convertedData;
	}
}
