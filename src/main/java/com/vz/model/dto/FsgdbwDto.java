package com.vz.model.dto;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("ZX_FSGDBW")
public class FsgdbwDto {

	@TableField("ID_FSGDBW")
	private String id;
	
	@TableField("CREATE_TIME")
	private Date createTime;
	
	@TableField("XMLBW")
	private String xmlBw;
	
	@TableField("REMARK")
	private String remark;
	
	@TableField("TYPE")
	private String type;
	
	@TableField("NSRSBH")
	private String nsrsbh;
	
	@TableField("SERIAL_NO")
	private String serialNo;
	
	@TableField("ORDER_NO")
	private String orderNo;
	
	public boolean isEmpty() {
		if(serialNo == null || nsrsbh == null) return true;
		return false;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getXmlBw() {
		return xmlBw;
	}

	public void setXmlBw(String xmlBw) {
		this.xmlBw = xmlBw;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNsrsbh() {
		return nsrsbh;
	}

	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	
}
