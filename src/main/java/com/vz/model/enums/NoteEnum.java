package com.vz.model.enums;

/**
 * 订单流水枚举类
 * @author Administrator
 *
 */
public enum NoteEnum {

	SUCCESS("success", "成功"),
	FAILED("failed", "失败");
	
	private String code;
	private String msg;
	
	NoteEnum(String code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getMsg() {
		return msg;
	}
}
