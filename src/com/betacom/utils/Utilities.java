package com.betacom.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import com.betacom.exception.AcademyException;

public class Utilities {

	private static final String PATTERN_DATE = "d/M/yyyy";
	private static final String PATTERN_DATE_TIME = "d/M/yyyy HH:mm:ss";
	/*
	 * transform date in format string
	 */
	public static String dataToString(LocalDateTime myDate) {
		return dataToString(PATTERN_DATE_TIME, myDate);
	}	
	
	public static String dataToString(String pattern,LocalDateTime myDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ITALIAN);
		return myDate.format(formatter);
	}

	public static String dataToString(LocalDate myDate) {
		return dataToString(PATTERN_DATE, myDate);
	}	
	
	public static String dataToString(String pattern,LocalDate myDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ITALIAN);
		return myDate.format(formatter);
	}

	
	public static LocalDate stringToDate(String myDate) {
		return stringToDate(PATTERN_DATE, myDate);
	}
	
	public static LocalDate stringToDate(String pattern,String myDate) {
		LocalDate r = null;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ITALIAN);
			r = LocalDate.parse(myDate, formatter);
		} catch (DateTimeParseException e) {
			throw new AcademyException("Formato della data invalida " + myDate + " formato previsto " + pattern);
		}
		return r;
	}
	
	
}
