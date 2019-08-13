package com.vz.model.bank.ningbo.push;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "businessContent")
public class BusinessContent implements Cloneable{
	
	private String taxDetail;
	
	@XmlElement(name = "taxDetail")
	public String getTaxDetail() {
		return taxDetail;
	}

	public void setTaxDetail(String taxDetail) {
		this.taxDetail = taxDetail;
	}


	public BusinessContent clone() {
		
		try {
			return (BusinessContent) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
