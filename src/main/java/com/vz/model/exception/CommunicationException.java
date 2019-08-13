package com.vz.model.exception;

import com.vz.model.exception.enums.ErrorEnum;

/**
 * 当与银行交互式出现异常时，使用此异常进行处理
 * @author Administrator
 *
 */
public class CommunicationException extends FrontBankDefualException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6354643089827929691L;

	public CommunicationException(ErrorEnum error, String message) {
		super(error, message);
	}

}
