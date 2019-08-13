package com.vz.model.mq.common.two.body.datagram;

import java.util.HashMap;

public class BaseInfo implements Cloneable{

	private Object taxDetail;

	public Object getTaxDetail() {
		return taxDetail;
	}

	public void setTaxDetail(Object taxDetail) {
		this.taxDetail = taxDetail;
	}
	
	public BaseInfo clone() {
		try {
			return (BaseInfo) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
