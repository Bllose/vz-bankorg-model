package com.vz.model.mq.common.one;

public class BodyResponse implements Cloneable{

	private OrderUpdate orderUpdate;
	private OrderFlow orderFlow;
	private FeedbackInfo feedbackInfo;

	public OrderFlow getOrderFlow() {
		return orderFlow;
	}
	public void setOrderFlow(OrderFlow orderFlow) {
		this.orderFlow = orderFlow;
	}
	public OrderUpdate getOrderUpdate() {
		return orderUpdate;
	}
	public void setOrderUpdate(OrderUpdate orderUpdate) {
		this.orderUpdate = orderUpdate;
	}
	public FeedbackInfo getFeedbackInfo() {
		return feedbackInfo;
	}
	public void setFeedbackInfo(FeedbackInfo feedbackInfo) {
		this.feedbackInfo = feedbackInfo;
	}

	 public BodyResponse clone() {
		 BodyResponse body = null;
		 try {
			 body=(BodyResponse)super.clone();
		 }catch(CloneNotSupportedException e) {
	            e.printStackTrace();
	     }
		 body.orderFlow = orderFlow.clone();
		 body.orderUpdate = orderUpdate.clone();
		 body.feedbackInfo = feedbackInfo.clone();
		 return body;
	 }

}
