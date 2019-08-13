package com.vz.model.mq.common.one;

public class HeadResponse implements Cloneable{
	
	private String reqId;
	private String actionName;
	private String nsrsbh;
	private String source;
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public String getNsrsbh() {
		return nsrsbh;
	}
	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	 public HeadResponse clone() {
		 HeadResponse head = null;
		 try {
			 head=(HeadResponse)super.clone();
		 }catch(CloneNotSupportedException e) {  
	            e.printStackTrace();  
	     } 
		 return head;
	 }
	
}
