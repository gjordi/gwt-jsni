package com.bytebybyte.gwt.jsni.client;

import com.google.gwt.core.client.JavaScriptObject;

public final class JsProperties extends JavaScriptObject {

	protected JsProperties() {
	}

	public Boolean getBooleanProperty(String name) {
		return JsObjectUtil.getBooleanProperty(this, name);
	}

	public void setBooleanProperty(String name, Boolean value) {
		JsObjectUtil.setBooleanProperty(this, name, value);
	}

	public Double getDoubleProperty(String name) {
		return JsObjectUtil.getDoubleProperty(this, name);
	}

	public void setDoubleProperty(String name, Double value) {
		JsObjectUtil.setDoubleProperty(this, name, value);
	}

	public Integer getIntegerProperty(String name) {
		return JsObjectUtil.getIntegerProperty(this, name);
	}

	public void setIntegerProperty(String name, Integer value) {
		JsObjectUtil.setIntegerProperty(this, name, value);
	}

	public String getStringProperty(String name) {
		return JsObjectUtil.getStringProperty(this, name);
	}

	public void setStringProperty(String name, String value) {
		JsObjectUtil.setStringProperty(this, name, value);
	}

	public String[] getStringArrayProperty(String name) {
		return JsObjectUtil.getStringArrayProperty(this, name);
	}

	public void setStringArrayProperty(String name, String[] values) {
		JsObjectUtil.setStringArrayProperty(this, name, values);
	}

	public static JsProperties create() {
		return JavaScriptObject.createObject().cast();
	}
}
