package com.vz.model.bank.ningbo.push;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 最终发送给银行的实体
 * @author weisz
 * <pre>
 *	报文服务组装报文至Transaction层
 *  故本层不需要内容	
 * </pre>
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "Transaction")
public class Transaction implements Cloneable{
	
//	private BusinessContent businessContent;
	
//	public Transaction clone() {
//		try {
//			Transaction transaction = (Transaction) super.clone();
//			transaction.businessContent = businessContent.clone();
//			return transaction;
//		} catch (CloneNotSupportedException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	

//	@XmlElement(name = "businessContent")
//	public BusinessContent getBusinessContent() {
//		return businessContent;
//	}
//
//	public void setBusinessContent(BusinessContent businessContent) {
//		this.businessContent = businessContent;
//	}
	
}
	
