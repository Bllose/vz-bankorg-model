package com.vz.model.exception;

import com.vz.model.exception.enums.ErrorEnum;

/**
 * 银行前置默认异常信息点
 * <pre>
 * 所有希望我们自己捕获的异常均使用它
 * </pre>
 * @author Administrator
 */
public class FrontBankDefualException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5269552342480157695L;
	
	private String message;
	
	protected ErrorEnum errorType;

	public String getMessage() {
		return message;
	}
	
	public ErrorEnum getErrorType() {
		return errorType;
	}

	/**
	 * 银行前置默认异常信息点
	 * <pre>
	 * 所有希望我们自己捕获，不受其他异常信息干扰的异常均使用它
	 * </pre>
	 * @author Administrator
	 */
	public FrontBankDefualException (String message) {
		this.message = message;
	}
	
	/**
	 * 银行前置需要捕获处理的异常
	 * @param errorType 异常类型
	 * @param message 异常信息
	 */
	public FrontBankDefualException(ErrorEnum error, String message) {
		this.errorType = error;
		this.message = message;
	}
	
	public FrontBankDefualException() {
		
	}
}
