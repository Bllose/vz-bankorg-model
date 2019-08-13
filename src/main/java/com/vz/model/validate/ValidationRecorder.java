package com.vz.model.validate;

/**
 * 用以记录校验结果
 * @param record
 */
public class ValidationRecorder {
	
	public static ValidationRecorder getInit() {
		ValidationRecorder vr = new ValidationRecorder();
		vr.init();
		return vr;
	}
	
	public void init(){
		this.record = "";
		this.result = true;
	}

	private boolean result;
	private String record;
	public boolean isResult() {
		return result;
	}
	/**
	 * 只要有任意一种不合法，则本次校验报文不合法
	 * @param result
	 */
	public void setResult(boolean result) {
		if(!this.result) return ;
		this.result = result;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record += ";"+record;
	}
}
