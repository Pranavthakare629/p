package pdt.std.otp.controller;

public class CustomException  extends Exception
{
	private static final long serialVersionUID = -7016973971744099088L;
	private String errorCode;
	private String errorMessage;

	
	/* public CustomException(String message) { super(message); } */
	 
	public CustomException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}