package pdt.std.otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
@Component
public class HealthDO {
	
	@Autowired
	HealthDTO healthDTO;
	
	@Autowired
	HWebsales hWebsales;
	
	public String getBusinessCorelationId() {
		return BusinessCorelationId;
	}

	public void setBusinessCorelationId(String businessCorelationId) {
		BusinessCorelationId = businessCorelationId;
	}

	private String  BusinessCorelationId;

	public void setGenerateOTPRequest(String mobileNo) {
		;
		GenerateOtp generateOtp = new GenerateOtp();
		generateOtp.setMobileNo(mobileNo);
		healthDTO.setGenerateOtp(generateOtp);
		
	}

	public GenerateOtpResponse getGenerateOtp() throws CustomException, JsonProcessingException {
 /////////////////////////////////////////////////
		GenerateOtpResponse generateOtpResponse = new GenerateOtpResponse();
		healthDTO = hWebsales.getgenerateOTP(healthDTO);
		generateOtpResponse = healthDTO.getGenerateOtpResponse();
		healthDTO.setGenerateOtpResponse(null);
		return generateOtpResponse;
	}

}
