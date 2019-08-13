package com.vz.model;

import com.vz.model.mq.common.one.Response;
import com.vz.model.mq.common.two.MQMessage;

public class VzoomModelCloner {
	
	public static Response getResponseClone() {
		if(null == response) {
			response = VzoomModelIniter.getDeepInitialization(Response.class);
		}
		return response.clone();
	}
	
	public static MQMessage getMQMessageClone() {
		if(null == mqMessage) {
			mqMessage = VzoomModelIniter.getDeepInitialization(MQMessage.class);
		}
		return mqMessage.clone();
	}
	

	public static void main(String[] args) {
//		Response response = getResponseClone();
//		response.getBody();
		
//		Head head = getDuplication(Head.class);
//		System.out.println(head.getNsrsbh()+" done");
		
//		MQMessage message = getMQMessageClone();
//		message.getBody().getDatagram().getBaseInfo();
		
//		TiripPackage tirip = VzoomModelIniter.getDeepInitialization(TiripPackage.class);
//		tirip.getTransaction();
	}
	
	private static MQMessage mqMessage;
	private static Response response;
}


