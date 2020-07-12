package com.callor.score.config;

public class Lines {

	public static String dLine = "";
	public static String sLine = "";
	
	static {
		for (int i = 0 ; i < 90 ; i ++) {
			dLine += "=";
			sLine += "-";
		}
	}
}
