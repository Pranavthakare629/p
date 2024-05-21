package pdt.std.otp.controller;

public class CsOtpResponse {
	private String otp;
	private ApplicationError applicationError;
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

}
