package com.vz.model.mq.common.two;

import javax.validation.constraints.NotNull;

public class MQMessage implements Cloneable{
	
	@NotNull(message = "消息HEAD不能为null")
	private HeadMessage head;
	
	@NotNull(message = "消息BODY不能为null")
	private BodyMessage body;
	
	public MQMessage clone() {
		try {
			MQMessage message = (MQMessage) super.clone();
			message.head = head.clone();
			message.body = body.clone();
			return message;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public HeadMessage getHead() {
		return head;
	}
	public void setHead(HeadMessage head) {
		this.head = head;
	}
	public BodyMessage getBody() {
		return body;
	}
	public void setBody(BodyMessage body) {
		this.body = body;
	}

}
