package com.vz.model.mq.common.one;

import java.util.Date;

public class OrderUpdate implements Cloneable{
	
	private String orderNo;		// 订单号;由网站、认证推送，透传至此
	private String orderNode;	// 信息节点;用来表明是哪个系统制作的报告
	private Date updateTime;	
	private String orderStatus;	// 订单状态
	private String proId;		// 产品ID（业务ID，比如贷后时使用的是贷后ID）
	private String serialNo;	// 业务流水号（订单服务生成）
	private String postloanListId;//贷后ID;返回给贷后服务系统，用以更新贷后状态
	
	/*
	 * 非公共必要字段
	 * */
	private String message;
	
	/*
	 * 民生银行反馈给网站时必送字段
	 * */
	private String ysxmax;	// 预授信最大值
	private String ysxmin;	// 预授信最小值
	private String note;	// 预授信结果信息
	private String ispass;	// 预授信结果编码
	private String nsrsbh;	// 纳税人识别号
	
	/*
	 * 江苏中行税易贷。由于需要将银行反馈的“银行订单号”反馈给网站，网站才能跳转至银行。
	 * */
	private String bankSerialNo;
	// tokenId 作为银行返回的标示符，网站公用方法中都有使用；为了减少开发量，暂使用tokenId传“银行订单号”
	private String tokenId;
	// 更新订单的remark；天津中行首次使用，目的是将准入结果反馈给订单服务，用以展示在后台管理系统
	private String remark;
	
	
	public String getYsxmax() {
		return ysxmax;
	}
	public void setYsxmax(String ysxmax) {
		this.ysxmax = ysxmax;
	}
	public String getYsxmin() {
		return ysxmin;
	}
	public void setYsxmin(String ysxmin) {
		this.ysxmin = ysxmin;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getIspass() {
		return ispass;
	}
	public void setIspass(String ispass) {
		this.ispass = ispass;
	}
	public String getNsrsbh() {
		return nsrsbh;
	}
	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}
	public String getOrderNode() {
		return orderNode;
	}
	public void setOrderNode(String orderNode) {
		this.orderNode = orderNode;
	}
	public String getPostloanListId() {
		return postloanListId;
	}
	public void setPostloanListId(String postloanListId) {
		this.postloanListId = postloanListId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	
	public OrderUpdate clone() {
		 OrderUpdate update = null;
		 try {
			 update=(OrderUpdate)super.clone();
		 }catch(CloneNotSupportedException e) {  
	            e.printStackTrace();  
	     } 
		 return update;
	 }
	public String getBankSerialNo() {
		return bankSerialNo;
	}
	public void setBankSerialNo(String bankSerialNo) {
		this.bankSerialNo = bankSerialNo;
	}
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
