package com.vz.model.exception.enums;

/**
 * <pre>
 * 2019-4-12 17:31:05
 * type 大体定义
 * 负数 - 保留
 * 0 - 保留
 * 1~9 严重到无法处理的异常
 * 10~19 轻微异常，不影响业务，警告即可的异常
 * 20~39 可以判断，且至少要收集，可追逆的异常
 * 40~99 较为严重，且很可能需要人工介入的异常
 * 100+ - 保留
 * </pre>
 * @author Bllose
 *
 */
public enum ErrorEnum {

	COULD_NOT_HANDLER(1, "无法处理的异常"),
	ILLEGAL_ACTIONNAME(40, "actionName非法"),
	COMMUNICATION_ERROR(41, "与银行交互异常"),
	ILLEGAL_PARAM(42, "关键参数非法");
	
	private int type = 1;
	private String typeName;
	
	ErrorEnum(int type, String typeName){
		this.type = type;
		this.typeName = typeName;
	}

	/**
	 * <pre>
	 * 负数 - 保留
	 * 0 - 保留
	 * 1~9 严重到无法处理的异常
	 * 10~19 轻微异常，不影响业务，警告即可的异常
	 * 20~39 可以判断，且至少要收集，可追逆的异常
	 * 40~99 较为严重，且很可能需要人工介入的异常
	 * 100+ - 保留
	 * </pre>
	 * @return
	 */
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
