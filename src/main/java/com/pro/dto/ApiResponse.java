package com.pro.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
	private String Message;
	private LocalDateTime timestamp;
	
	public ApiResponse(String message) {
		super();
		Message = message;
		timestamp=LocalDateTime.now();
	}
}
