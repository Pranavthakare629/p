package pdt.std.otp.controller;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class GenerateOtpResponse {

	@JsonProperty("otp")
	private String otp;

	
	
	public String getOtp() {
		return otp;
	}



	public void setOtp(String otp) {
		this.otp = otp;
	}



	public ApplicationError getApplicationError() {
		return applicationError;
	}



	public void setApplicationError(ApplicationError applicationError) {
		this.applicationError = applicationError;
	}



	@JsonProperty("applicationError")
	private ApplicationError applicationError;
}
