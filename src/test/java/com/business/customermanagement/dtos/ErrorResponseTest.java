package com.business.customermanagement.dtos;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ErrorResponseTest {
	ErrorResponse errorResponse;
	LocalDateTime timestamp;

	@BeforeEach
	public void setUp() {
		timestamp = LocalDateTime.of(2020, 12, 12, 12, 12);
		errorResponse = new ErrorResponse(timestamp, "ERROR_CODE", "ERROR_MESSAGE");
	}

	@Test
	public void testGetTimestamp() {
      assertThat(timestamp).isEqualTo(errorResponse.getTimestamp());
	}
	@Test
	public void testGetErrorCode() {
		assertThat("ERROR_CODE").isEqualTo(errorResponse.getErrorCode());
	}
	@Test
	public void testGetErrorMessage() {
		assertThat("ERROR_MESSAGE").isEqualTo(errorResponse.getErrorMessage());
	}

}
