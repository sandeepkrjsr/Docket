package com.sandeepkrjsr.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class InputValidationTest {
	
	@Test
	void validateDuration0() {
		boolean output = InputValidation.validateDuration(0);
		assertFalse(output);
	}
	
	@Test
	void validateDurationNegative() {
		boolean output = InputValidation.validateDuration(-1);
		assertFalse(output);
		output = InputValidation.validateDuration(-15);
		assertFalse(output);
	}
	
	@Test
	void validateDurationNotMultipleOf15() {
		boolean output = InputValidation.validateDuration(10);
		assertFalse(output);
		output = InputValidation.validateDuration(16);
		assertFalse(output);
	}
	
	@Test
	void validateDurationMultipleOf15() {
		boolean output = InputValidation.validateDuration(15);
		assertTrue(output);
		output = InputValidation.validateDuration(30);
		assertTrue(output);
	}
	
	@Test
	void validateDateTimeInPast() {
		LocalDateTime dateTime = DateTimeUtils.getDateTime("202007270900");
		boolean output = InputValidation.validateDateTime(dateTime);
		assertFalse(output);
	}
	
	@Test
	void validateDateTimeInFuture() {
		LocalDateTime dateTime = DateTimeUtils.getDateTime("202207270900");
		boolean output = InputValidation.validateDateTime(dateTime);
		assertTrue(output);
	}
	
	@Test
	void validateDateTimeNotMultipleOf15Min() {
		LocalDateTime dateTime = DateTimeUtils.getDateTime("202207270901");
		boolean output = InputValidation.validateDateTime(dateTime);
		assertFalse(output);
		dateTime = DateTimeUtils.getDateTime("202207270905");
		output = InputValidation.validateDateTime(dateTime);
		assertFalse(output);
	}
	
	@Test
	void validateDateTimeMultipleOf15Min() {
		LocalDateTime dateTime = DateTimeUtils.getDateTime("202207270900");
		boolean output = InputValidation.validateDateTime(dateTime);
		assertTrue(output);
		dateTime = DateTimeUtils.getDateTime("202207270915");
		output = InputValidation.validateDateTime(dateTime);
		assertTrue(output);
	}

}
