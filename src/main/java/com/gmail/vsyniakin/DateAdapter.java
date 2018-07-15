package com.gmail.vsyniakin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/* Convert string in format "dd.MM.yyyy" to object LocalDate 
 * */

public interface DateAdapter {
	public final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	public static LocalDate stringToDate(String str) {
		return LocalDate.parse(str, FORMATTER);
	}
}
