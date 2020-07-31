package com.business.customermanagement.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents an error response dto.
 */
@Getter
@AllArgsConstructor
public class ErrorResponse {
	
	  private LocalDateTime timestamp;
	  private String errorCode;
	  private String errorMessage;

}
