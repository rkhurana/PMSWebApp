/**
 * 
 */
package com.home.pms.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class ReflectionTool helps to access the properties and methods dynamically.
 * 
 * @author Rohit Khurana
 *
 */
public class ReflectionTool {

	/**
	 * Private constructor to prevent the instantiation because this class has all the static methods.
	 */
	private ReflectionTool(){
		
	}
	
	/**
	 * List getter methods.
	 * 
	 * @param refObject
	 *            the ref object
	 * @return the map
	 */
	public static Map<String, Method> listGetterMethods(Object refObject){
		Map<String, Method> getterMethodsM = new HashMap<String, Method>();
		Class<?> refClassName = refObject.getClass();
		Method[] methods = refClassName.getMethods();
		String getterMehtod;
		for(Method methodRef : methods){
			if((methodRef.getReturnType() != null) && (methodRef.getName().startsWith("get"))){
				getterMehtod = StringUtils.removeAllSpecialCharacters(methodRef.getName().substring(3).toLowerCase());
				getterMethodsM.put(getterMehtod, methodRef);
			}else if((methodRef.getReturnType() != null) && methodRef.getName().startsWith("is")){
				getterMehtod = StringUtils.removeAllSpecialCharacters(methodRef.getName().substring(2).toLowerCase());
				getterMethodsM.put(getterMehtod, methodRef);
			}
		}
		return getterMethodsM;
	}
	
	/**
	 * List getter methods.
	 * 
	 * @param refClass
	 *            the ref class
	 * @return the map
	 */
	public static Map<String, Method> listGetterMethods(final Class<?> refClass) {
		Map<String, Method> methods = new HashMap<String, Method>();
		Method[] method = refClass.getMethods();
		String getterNames;
		for (Method m : method) {
			if (m.getName().startsWith("get")) {
				getterNames = StringUtils.removeAllSpecialCharacters(m.getName().substring(3)).toLowerCase();
				methods.put(getterNames, m);
			} else if (m.getName().startsWith("is")) {
				getterNames = StringUtils.removeAllSpecialCharacters(m.getName().substring(2)).toLowerCase();
				methods.put(getterNames, m);
			}
		}
		return methods;
	}
	
	/**
	 * Invoke method.
	 * 
	 * @param refMethod
	 *            the ref method
	 * @param refArguments
	 *            the ref arguments
	 * @param refObject
	 *            the ref object
	 * @return the object
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 * @throws InvocationTargetException
	 *             the invocation target exception
	 */
	public static Object invokeMethod(final Method refMethod, final Object[] refArguments, final Object refObject) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		return refMethod.invoke(refObject, refArguments);
	}
	
	/**
	 * Extract getter values.
	 * 
	 * @param methods
	 *            the methods
	 * @param refObject
	 *            the ref object
	 * @return the map
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 * @throws InvocationTargetException
	 *             the invocation target exception
	 */
	public static Map<String, Object> extractGetterValues(final Map<String, Method> methods, final Object refObject) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Map<String, Object> extractedValueM = new HashMap<String, Object>();
		Object extractedVal = null;
		for (Map.Entry<String, Method> me : methods.entrySet()) {
			extractedVal = invokeMethod(me.getValue(), new Object[] {}, refObject);
			if (!StringUtils.isEmptyString(extractedVal)) {
				extractedValueM.put(me.getKey(), extractedVal);
			}
		}
		return extractedValueM;
	}
	
	/**
	 * List setter methods.
	 * 
	 * @param refObject
	 *            the ref object
	 * @return the map
	 */
	public static Map<String, Method> listSetterMethods(final Object refObject) {
		Map<String, Method> methods = new HashMap<String, Method>();
		Class<?> refClassName = refObject.getClass();
		Method[] method = refClassName.getMethods();
		String setterNames;
		for (Method m : method) {
			if (m.getName().startsWith("set")) {
				setterNames = StringUtils.removeAllSpecialCharacters(m.getName().substring(3)).toLowerCase();
				methods.put(setterNames, m);
			}
		}
		return methods;
	}
	
	/**
	 * List all fields.
	 * 
	 * @param refObject
	 *            the ref object
	 * @return the map
	 */
	public static Map<String, Field> listAllFields(final Object refObject) {
		Map<String, Field> fields = new HashMap<String, Field>();
		Field[] field = refObject.getClass().getDeclaredFields();
		if (field != null) {
			for (Field f : field) {
				fields.put(f.getName(), f);
			}
		}
		return fields;
	}
	
	/**
	 * List all fields.
	 * 
	 * @param refObject
	 *            the ref object
	 * @return the map
	 */
	public static Map<String, Field> listAllFields(final Class<?> refObject) {
		Map<String, Field> fields = new HashMap<String, Field>();
		Field[] field = refObject.getDeclaredFields();
		if (field != null) {
			for (Field f : field) {
				fields.put(f.getName(), f);
			}
		}
		return fields;
	}
	
	/**
	 * List setter methods.
	 * 
	 * @param refClass
	 *            the ref class
	 * @return the map
	 */
	public static Map<String, Method> listSetterMethods(final Class<?> refClass) {
		Map<String, Method> methods = new HashMap<String, Method>();
		Method[] method = refClass.getDeclaredMethods();
		String setterNames;
		for (Method m : method) {
			if (m.getName().startsWith("set")) {
				setterNames = StringUtils.removeAllSpecialCharacters(m.getName().substring(3)).toLowerCase();
				methods.put(setterNames, m);
			}
		}
		return methods;
	}
	
	/**
	 * Locate getter method.
	 * 
	 * @param refObject
	 *            the ref object
	 * @param methodName
	 *            the method name
	 * @return the method
	 * @throws Exception
	 *             the exception
	 */
	public static Method locateGetterMethod(final Object refObject, final String methodName) throws Exception {
		Map<String, Method> methods = listGetterMethods(refObject);
		if (isMapContainsKey(StringUtils.removeAllSpecialCharacters(methodName).toLowerCase(), methods)) {
			return methods.get(StringUtils.removeAllSpecialCharacters(methodName).toLowerCase());
		} else {
			throw new Exception("No getter method found for property " + methodName + " inside " + refObject.getClass().getName());
		}
	}
	
	/**
	 * Locate getter method.
	 * 
	 * @param refClass
	 *            the ref class
	 * @param methodName
	 *            the method name
	 * @return the method
	 * @throws Exception
	 *             the exception
	 */
	public static Method locateGetterMethod(final Class<?> refClass, final String methodName) throws Exception {
		Map<String, Method> methods = listGetterMethods(refClass);
		if (isMapContainsKey(StringUtils.removeAllSpecialCharacters(methodName).toLowerCase(), methods)) {
			return methods.get(StringUtils.removeAllSpecialCharacters(methodName).toLowerCase());
		} else {
			throw new Exception("No getter method found for property " + methodName + " inside " + refClass.getName());
		}
	}
	
	/**
	 * Checks if is map contains key.
	 * 
	 * @param key
	 *            the key
	 * @param refMap
	 *            the ref map
	 * @return true, if is map contains key
	 */
	public static boolean isMapContainsKey(final String key, final Map<?, ?> refMap) {
		boolean result = true;
		if (refMap.get(key) == null) {
			result = false;
		}
		return result;
	}
	
	/**
	 * Invoke setter.
	 * 
	 * @param objRef
	 *            the obj ref
	 * @param param
	 *            the param
	 * @param paramType
	 *            the param type
	 * @param value
	 *            the value
	 * @throws Exception
	 *             the exception
	 */
	public static void invokeSetter(final Object objRef, final String param, final Class<?> paramType, final Object[] value) throws Exception {
		Method method = objRef.getClass().getDeclaredMethod("set" + param, new Class[] { paramType });
		method.invoke(objRef, value);
	}
	
	/**
	 * Invoke getter.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param objRef
	 *            the obj ref
	 * @param param
	 *            the param
	 * @param castType
	 *            the cast type
	 * @return the t
	 * @throws Exception
	 *             the exception
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> T invokeGetter(final Object objRef, final String param, final T castType) throws Exception {
		Method method = objRef.getClass().getDeclaredMethod("get" + param, new Class[] {});
		return (T) method.invoke(objRef, new Object[] {});
	}
	
	/**
	 * Invoke getter.
	 * 
	 * @param objRef
	 *            the obj ref
	 * @param param
	 *            the param
	 * @return the object
	 * @throws Exception
	 *             the exception
	 */
	public static Object invokeGetter(final Object objRef, final String param) throws Exception {
		Method method = objRef.getClass().getDeclaredMethod("get" + param, new Class[] {});
		return method.invoke(objRef, new Object[] {});
	}
}
