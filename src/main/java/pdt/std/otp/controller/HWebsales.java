package pdt.std.otp.controller;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public interface HWebsales {

	
	HealthDTO getgenerateOTP(HealthDTO getgenerateOTP) throws JsonProcessingException, CustomException;
}
 