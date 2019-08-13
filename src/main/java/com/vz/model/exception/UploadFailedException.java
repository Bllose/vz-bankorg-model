package com.vz.model.exception;

import com.vz.model.exception.enums.ErrorEnum;

/**
 * 用以标记上传过程中出现的任意异常
 * @author Administrator
 *
 */
public class UploadFailedException extends FrontBankDefualException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	

	public String getMessage() {
		return message;
	}
	
//	public UploadFailedException()	{};

	public UploadFailedException (String message) {
		this.message = message;
		errorType = ErrorEnum.COMMUNICATION_ERROR;
	}
	
}
