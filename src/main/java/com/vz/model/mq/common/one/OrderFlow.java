package com.vz.model.mq.common.one;

public class OrderFlow implements Cloneable{

	private String orderNo;
	private String orderNode;
	private String nodeDealResult;
	private String nodeStatus;
	private String dataLevel;//数据等级
	private String serialNo;
	
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
	public String getOrderNode() {
		return orderNode;
	}
	public void setOrderNode(String orderNode) {
		this.orderNode = orderNode;
	}
	public String getNodeDealResult() {
		return nodeDealResult;
	}
	public void setNodeDealResult(String nodeDealResult) {
		this.nodeDealResult = nodeDealResult;
	}
	public String getNodeStatus() {
		return nodeStatus;
	}
	public void setNodeStatus(String nodeStatus) {
		this.nodeStatus = nodeStatus;
	}
	public String getDataLevel() {
		return dataLevel;
	}
	public void setDataLevel(String dataLevel) {
		this.dataLevel = dataLevel;
	}

	 public OrderFlow clone() {
		 OrderFlow flow = null;
		 try {
			 flow=(OrderFlow)super.clone();
		 }catch(CloneNotSupportedException e) {  
	            e.printStackTrace();  
	     } 
		 return flow;
	 }

	
}
