package com.vz.model.mq.common.two.body;

/**
 * 订单服务组装的订单报文
 * @author Administrator
 *
 */
public class OrderXml implements Cloneable{

	private String orderXmlDetail;

	public String getOrderXmlDetail() {
		return orderXmlDetail;
	}

	public void setOrderXmlDetail(String orderXmlDetail) {
		this.orderXmlDetail = orderXmlDetail;
	}
	
	public OrderXml clone() {
		try {
			return (OrderXml) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
}
