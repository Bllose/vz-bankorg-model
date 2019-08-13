package com.vz.model.bank.ningbo.push;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 最终发送给银行的实体
 * @author weisz
 *
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "tiripPackage")
public class TiripPackage implements Cloneable{
	
	private Transaction transaction;
	
	public TiripPackage clone(){
		try {
			TiripPackage tirip = (TiripPackage) super.clone();
			
			return tirip;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@XmlElement(name = "Transaction")
	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
}
	
