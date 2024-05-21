package pdt.std.otp.controller;

import java.util.ArrayList;
import java.util.List;

public class SMSTransformer {
	public SendSMSRequest transformToSendOTPSMSRequest(String mobileNo,String otp) {
		
		SendSMSRequest sendSMSRequest = new SendSMSRequest();
		List<MobNO> mobNos = new ArrayList<MobNO>();
		MobNO mobNO = new MobNO();
		mobNO.setMobileNo(mobileNo);
		mobNos.add(mobNO);
		sendSMSRequest.setMobileNo(mobNos);
		sendSMSRequest.setLanguage("English");
		sendSMSRequest.setPartID("");
		sendSMSRequest.setReferenceId(mobileNo);

		SMSText smsText = new SMSText();
		List<SmsValues> smsValues = new ArrayList<SmsValues>();
		
		SmsValues sms = new SmsValues();
		sms.setName("$OTP");
		sms.setValue(otp);
		smsValues.add(sms);
		
		SmsValues sms1 = new SmsValues();
		sms1.setName("$VAL_MIN");
		sms1.setValue("5");
		smsValues.add(sms1);
		
		
		/*
		 * SmsValues sms2 = new SmsValues();
		 * sms2.setName(BagicPolicyServicingConstants.getString("SMS_PARAM_1_NAME"));
		 * sms2.setValue(name); smsValues.add(sms2);
		 */
		
		
		smsText.setSmsValues(smsValues);
		sendSMSRequest.setSmsText(smsText);
		
		List<String> messageType = new ArrayList<String>();
		messageType.add("SMS");
		sendSMSRequest.setTypeOfMsg(messageType);
		//sendSMSRequest.setTemplateId(BagicPolicyServicingConstants.getString("SMS_TEMPLATE_ID_25")); //old code by anand for reference
		sendSMSRequest.setTemplateId("188");
		
		
		return sendSMSRequest;
	}
	
	
}
