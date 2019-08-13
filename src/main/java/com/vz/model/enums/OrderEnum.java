package com.vz.model.enums;

/**
 * 传统的订单状态枚举类
 * @author Administrator
 *
 */
public enum OrderEnum {

	DONE("0000","订单完成"),INIT("1000","初始化"),SUCCESS("2000","业务成功"),FAILED("9999","业务失败"),ERROR("9000","业务异常");
	
	
	OrderEnum(String code, String message){
		this.code = code;
		this.message = message;
	}
	private String code;
	private String message;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
