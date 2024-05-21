package pdt.std.otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Controller {

	@Autowired
	private BusinessLogic businessLogic;
	
	@Autowired
	private HWebsales hWebsales;
	
	
	
	 @RequestMapping(value = "/generateOTP", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
		public CsOtpResponse generateOTP(@RequestBody EPolicyGenerateOtpRequest cGenerateOtpRequest,
				HttpServletRequest request) throws Exception {

			long startTime = System.currentTimeMillis();
			StringBuilder errorDetails = null;
			StringBuilder bcId = new StringBuilder();
			bcId.append(cGenerateOtpRequest.getMobileno());
			String businessCorelationId = bcId.toString();
			
			ApplicationError applicationError = new ApplicationError();
			CsOtpResponse csOtpResponse = new CsOtpResponse();
			try {
				csOtpResponse = businessLogic.getGenerateOtpDetails(cGenerateOtpRequest,businessCorelationId);
			} catch (CustomException ce) {
				errorDetails = new StringBuilder();
				errorDetails.append(ce.getMessage());
				applicationError.setErrordescription(errorDetails.toString());
				applicationError.setErrorcode(ce.getErrorCode());
				csOtpResponse.setApplicationError(applicationError);
			} catch (Exception e) {
				applicationError.setErrorcode("WSH100");
				applicationError.setErrordescription("Oops! Something went wrong. Kindly try after sometime.");
				csOtpResponse.setApplicationError(applicationError);
			} finally {
				long endTime = System.currentTimeMillis();
				
			}
			return csOtpResponse;

		}
	
	
	
	
	
}
