package com.bytebybyte.gwt.jsni.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayBoolean;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;

public class JsArrayUtil {

	private JsArrayUtil() {
	}

	public static JsArrayString wrapArray(String[] srcArray) {
		JsArrayString result = JavaScriptObject.createArray().cast();
		for (int i = 0; i < srcArray.length; i++) {
			result.set(i, srcArray[i]);
		}
		return result;
	}

	public static String[] unwrapArray(JsArrayString jsArrayString) {
		String[] result = new String[jsArrayString.length()];
		for (int i = 0; i < jsArrayString.length(); i++) {
			result[i] = jsArrayString.get(i);
		}
		return result;
	}

	public static JsArrayNumber wrapArray(float[] srcArray) {
		JsArrayNumber result = JavaScriptObject.createArray().cast();
		for (int i = 0; i < srcArray.length; i++) {
			result.set(i, srcArray[i]);
		}
		return result;
	}

	public static JsArrayNumber wrapArray(double[] srcArray) {
		JsArrayNumber result = JavaScriptObject.createArray().cast();
		for (int i = 0; i < srcArray.length; i++) {
			result.set(i, srcArray[i]);
		}
		return result;
	}

	public static JsArrayInteger wrapArray(int[] srcArray) {
		JsArrayInteger result = JavaScriptObject.createArray().cast();
		for (int i = 0; i < srcArray.length; i++) {
			result.set(i, srcArray[i]);
		}
		return result;
	}

	public static JsArrayInteger wrapArray(byte[] srcArray) {
		JsArrayInteger result = JavaScriptObject.createArray().cast();
		for (int i = 0; i < srcArray.length; i++) {
			result.set(i, srcArray[i]);
		}
		return result;
	}

	public static JsArrayBoolean wrapArray(boolean[] srcArray) {
		JsArrayBoolean result = JavaScriptObject.createArray().cast();
		for (int i = 0; i < srcArray.length; i++) {
			result.set(i, srcArray[i]);
		}
		return result;
	}

}