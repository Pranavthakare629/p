package pdt.std.otp.controller;

import org.springframework.stereotype.Component;

@Component
public class HealthDTO {

	
	private GenerateOtpResponse generateOtpResponse;
	private GenerateOtp generateOtp;
	private String bcid;
	public String getBcid() {
		return bcid;
	}
	public void setBcid(String bcid) {
		this.bcid = bcid;
	}
	public GenerateOtpResponse getGenerateOtpResponse() {
		return generateOtpResponse;
	}
	public void setGenerateOtpResponse(GenerateOtpResponse generateOtpResponse) {
		this.generateOtpResponse = generateOtpResponse;
	}
	public GenerateOtp getGenerateOtp() {
		return generateOtp;
	}
	public void setGenerateOtp(GenerateOtp generateOtp) {
		this.generateOtp = generateOtp;
	}
}
