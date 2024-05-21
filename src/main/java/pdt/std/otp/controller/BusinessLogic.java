package pdt.std.otp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class BusinessLogic {
	
	
	@Autowired
	private HealthDO healthDO;
	
	@Autowired
	SMSTransformer sMSTransformer;
	
static Logger log=LoggerFactory.getLogger(BusinessLogic.class);

	public  CsOtpResponse getGenerateOtpDetails(EPolicyGenerateOtpRequest cGenerateOtpRequest,
			String businessCorelationId) throws JsonProcessingException, CustomException {
		
		log.debug("Entering getGenerateOtpDetails inside PolicyServicingBusinessLogic");
		
		CsOtpResponse csOtpResponse = null;

		healthDO.setBusinessCorelationId(businessCorelationId);
		// healthDO.setPolicyNumber(gPolicyGenerateOtpRequest.getPolicyNo());
		healthDO.setGenerateOTPRequest(cGenerateOtpRequest.getMobileno());
		
		
		GenerateOtpResponse generateOtpResponse = healthDO.getGenerateOtp();
		SendSMSRequest sendSMS = sMSTransformer.transformToSendOTPSMSRequest(cGenerateOtpRequest.getMobileno(),
				generateOtpResponse.getOtp());
		
		return csOtpResponse;
	}

}
