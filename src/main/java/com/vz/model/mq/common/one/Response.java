package com.vz.model.mq.common.one;

public class Response implements Cloneable{

	private HeadResponse head;
	private BodyResponse body;
	
	public HeadResponse getHead() {
		return head;
	}
	public void setHead(HeadResponse head) {
		this.head = head;
	}
	public BodyResponse getBody() {
		return body;
	}
	public void setBody(BodyResponse body) {
		this.body = body;
	}
	
	 public Response clone() {
		 Response response = null;
		 try {
			 response=(Response)super.clone();
		 }catch(CloneNotSupportedException e) {  
	            e.printStackTrace();  
	     } 
		 response.head = head.clone();
		 response.body = body.clone();
		 return response;
	 }
}
