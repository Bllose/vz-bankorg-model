package com.vz.model.enums;

/**
 * 订单来源字段枚举类
 * @author Administrator
 *
 */
public enum OrderFromEnum {

	BANK("002", "银行-认证"),
	VZ_WEB("003", "微众-网站");
	
	private String code;
	private String msg;
	
	OrderFromEnum(String code, String msg){
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
