package com.sandeepkrjsr.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
	
	private static String MEETING_TIME_INPUT_FORMAT = "yyyyMMddHHmm";

	public static LocalDateTime getDateTime(String meetingTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(MEETING_TIME_INPUT_FORMAT);
		return LocalDateTime.parse(meetingTime, formatter);
	}

}
