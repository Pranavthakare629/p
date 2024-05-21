package pdt.std.otp.controller;

import java.util.List;

public class SendSMSRequest {

	private String language;		
    private List<MobNO> mobileNo;		
	private List<String> typeOfMsg;		
    public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public List<MobNO> getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(List<MobNO> mobileNo) {
		this.mobileNo = mobileNo;
	}
	public List<String> getTypeOfMsg() {
		return typeOfMsg;
	}
	public void setTypeOfMsg(List<String> typeOfMsg) {
		this.typeOfMsg = typeOfMsg;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public SMSText getSmsText() {
		return smsText;
	}
	public void setSmsText(SMSText smsText) {
		this.smsText = smsText;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getPartID() {
		return partID;
	}
	public void setPartID(String partID) {
		this.partID = partID;
	}
	private String referenceId;		
    private SMSText smsText;		
    private String templateId;		
    private String partID;
	
}
