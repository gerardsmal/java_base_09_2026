package com.betacom.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Utilities {

	private static final String PATTERN_DATE = "d/M/yyyy HH:mm:ss";
	/*
	 * transform date in format string
	 */
	public static String dataToString(LocalDateTime myDate) {
		return dataToString(PATTERN_DATE, myDate);
	}	
	
	public static String dataToString(String pattern,LocalDateTime myDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ITALIAN);
		return myDate.format(formatter);
	}
	
}
