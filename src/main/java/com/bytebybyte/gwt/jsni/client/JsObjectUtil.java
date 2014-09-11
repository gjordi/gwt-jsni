package com.bytebybyte.gwt.jsni.client;

import java.util.Date;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.client.JsDate;

public class JsObjectUtil {

	protected JsObjectUtil() {
	}

	public static native Boolean getBooleanProperty(JavaScriptObject object, String name)
	/*-{
		return object[name] != null ? @java.lang.Boolean::valueOf(Z)(object[name]) : null;
	}-*/;

	public static void setBooleanProperty(JavaScriptObject object, String name, Boolean value) {
		if (value != null)
			JsObjectUtil.setBooleanProperty(object, name, value.booleanValue());
		else
			JsObjectUtil.clearProperty(object, name);
	}

	public static native void setBooleanProperty(JavaScriptObject object, String name, boolean value)
	/*-{
		object[name] = value;
	}-*/;

	@SuppressWarnings("deprecation")
	public static Date getDateProperty(JavaScriptObject object, String name) {
		JsDate date = getObjectProperty(object, name).cast();

		if (date == null)
			return null;

		return new Date(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds());
	}

	public static native Double getDoubleProperty(JavaScriptObject object, String name)
	/*-{
		return object[name] != null ? @java.lang.Double::valueOf(D)(object[name]) : null;
	}-*/;

	public static void setDoubleProperty(JavaScriptObject object, String name, Double value) {
		if (value != null)
			JsObjectUtil.setDoubleProperty(object, name, value.doubleValue());
		else
			JsObjectUtil.clearProperty(object, name);
	}

	public static native void setDoubleProperty(JavaScriptObject object, String name, double value)
	/*-{
		object[name] = value;
	}-*/;

	public static native Integer getIntegerProperty(JavaScriptObject object, String name)
	/*-{
		return object[name] != null ? @java.lang.Integer::valueOf(I)(object[name]) : null;
	}-*/;

	public static void setIntegerProperty(JavaScriptObject object, String name, Integer value) {
		if (value != null)
			JsObjectUtil.setIntegerProperty(object, name, value.intValue());
		else
			JsObjectUtil.clearProperty(object, name);
	}

	public static native void setIntegerProperty(JavaScriptObject object, String name, int value)
	/*-{
		object[name] = value;
	}-*/;

	/**
	 * Javascript does not support Long values, so this actually converts from an Integer value.
	 * 
	 * @param object
	 * @param name
	 * @return Long
	 */
	public static Long getLongProperty(JavaScriptObject object, String name) {
		Integer value = getIntegerProperty(object, name);

		return value != null ? value.longValue() : null;
	}

	/**
	 * Javascript does not support Long values, so this actually converts to an Integer value.
	 * 
	 * @param object
	 * @param name
	 * @param value
	 */
	public static void setLongProperty(JavaScriptObject object, String name, Long value) {
		if (value != null)
			JsObjectUtil.setIntegerProperty(object, name, value.intValue());
		else
			JsObjectUtil.clearProperty(object, name);
	}

	public static native JavaScriptObject getObjectProperty(JavaScriptObject object, String name)
	/*-{
		return object[name];
	}-*/;

	public static native void setObjectProperty(JavaScriptObject object, String name, JavaScriptObject value)
	/*-{
		if(value != null)
			object[name] = value;
		else
			delete object[name];
	}-*/;

	public static native String getStringProperty(JavaScriptObject object, String name)
	/*-{
		return object[name];
	}-*/;

	public static native void setStringProperty(JavaScriptObject object, String name, String value)
	/*-{
	 	if(value != null)
			object[name] = value;
		else
			delete object[name];
	}-*/;

	public static String[] getStringArrayProperty(JavaScriptObject object, String name) {
		return JsArrayUtil.unwrapArray(getStringArrayPropertyOverlay(object, name));
	}

	public static native JsArrayString getStringArrayPropertyOverlay(JavaScriptObject object, String name)
	/*-{
		return object[name];
	}-*/;

	public static void setStringArrayProperty(JavaScriptObject object, String name, String[] value) {
		setStringArrayPropertyOverlay(object, name, JsArrayUtil.wrapArray(value));
	}

	public static native void setStringArrayPropertyOverlay(JavaScriptObject object, String name, JsArrayString value)
	/*-{
	 	if(value != null)
			object[name] = value;
		else
			delete object[name];	
	}-*/;

	public static native JsProperties getPropertiesProperty(JavaScriptObject object, String name)
	/*-{
		return object[name];
	}-*/;

	public static native void setPropertiesProperty(JavaScriptObject object, String name, JsProperties value)
	/*-{
	 	if(value != null)
			object[name] = value;
		else
			delete object[name];	
	}-*/;

	public static void setMapProperty(JavaScriptObject object, String name, Map<String, String> value) {
		JsProperties properties = JsProperties.create();
		for (String key : value.keySet())
			properties.setStringProperty(key, value.get(key));
		setPropertiesProperty(object, name, properties);
	}

	public static void setMapArrayProperty(JavaScriptObject object, String name, Map<String, String[]> value) {
		JsProperties properties = JsProperties.create();
		for (String key : value.keySet())
			properties.setStringArrayProperty(key, value.get(key));
		setPropertiesProperty(object, name, properties);
	}

	public static native void clearProperty(JavaScriptObject object, String name)
	/*-{
		delete object[name];
	}-*/;

	public static JavaScriptObject createObject() {
		return JavaScriptObject.createObject();
	}
}
