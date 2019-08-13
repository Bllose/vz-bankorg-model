package com.vz.model.mq.common.two.body.datagram;

/**
 * GlobalInfo 中所有提供的报文
 * @author Administrator
 *
 */
public class GlobalInfo implements Cloneable{

	private String taxDetail;

	private Object indexes;
	
	private String orderDetail;

	/**
	 * 税务报告之类的报文
	 * */
	public String getTaxDetail() {
		return taxDetail;
	}

	public void setTaxDetail(String taxDetail) {
		this.taxDetail = taxDetail;
	}

    public Object getIndexes() {
        return indexes;
    }

    public void setIndexes(Object indexes) {
        this.indexes = indexes;
    }

    public GlobalInfo clone() {
		try {
			return (GlobalInfo) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 订单信息之类的报文
	 * @return
	 */
	public String getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(String orderXml) {
		this.orderDetail = orderXml;
	}
}
