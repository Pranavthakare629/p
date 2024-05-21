package pdt.std.otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
@Component
public class HealthImpl implements HWebsales {

	
	@Autowired
	private HealthDTO dto;
	
	
	@Value("${ms.host}" + ":" + "${ms.port}" + "${ms.generateOtp.endpoint}")
	private String msGenerateOTPUrl;
	
	@Autowired
	private MSTokenGeneration  tokenGeneration;
	
	@Override
	public HealthDTO getgenerateOTP(HealthDTO getgenerateOTP) throws JsonProcessingException, CustomException {
		;
		long startTime = System.currentTimeMillis();
		String corelationId="cvbnm" ;
		 
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.set("BusinessCorelationId", dto.getBcid());
		headers.set("CorelationId", corelationId);
		headers.set("Authorization", tokenGeneration.getAccessToken());

		GenerateOtpResponse generateOtpResponse = null;
		EPolicyGenerateOtpRequest reqOTp = new EPolicyGenerateOtpRequest();

		try {

			// HttpEntity<EPolicyGenerateOtpRequest> request = new
			// HttpEntity<EPolicyGenerateOtpRequest>(getgenerateOTP,headers);
			HttpEntity<GenerateOtp> entity = new HttpEntity<GenerateOtp>(getgenerateOTP.getGenerateOtp(), headers);

			RestTemplate restTemplate=new RestTemplate();
			generateOtpResponse = restTemplate.postForObject(msGenerateOTPUrl, entity, GenerateOtpResponse.class);
			
		} finally {
			System.out.println("hello");
		}

		

		getgenerateOTP.setGenerateOtpResponse(generateOtpResponse);
		
		return getgenerateOTP;

	}
}
