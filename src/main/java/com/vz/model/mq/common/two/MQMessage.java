package com.vz.model.mq.common.two;

/**微众税银使用的MQ消息对象，整体格式
 * <pre>
 * </pre>
 * @author Administrator
 * @createTime 2019/8/15
 * @description
 * */
public class MQMessage implements Cloneable{

	private HeadMessage head;
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
