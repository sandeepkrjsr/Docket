package com.sandeepkrjsr.utils;

import java.time.LocalDateTime;

public class InputValidation {
	
	private static int DURATION_INTERVAL_IN_MINUTE = 15;

	public static boolean validateDuration(int duration) {
		return duration > 0 
				&& duration % DURATION_INTERVAL_IN_MINUTE == 0;
	}

	public static boolean validateDateTime(LocalDateTime dateTime) {
		return dateTime.isAfter(LocalDateTime.now()) 
				&& dateTime.getMinute() % DURATION_INTERVAL_IN_MINUTE == 0;
	}

}
