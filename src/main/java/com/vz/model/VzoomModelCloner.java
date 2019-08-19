package com.vz.model;

import com.vz.model.mq.common.one.Response;
import com.vz.model.mq.common.two.MQMessage;
import com.vz.model.mq.common.two.subcollect.SubColMqMessage;

public class VzoomModelCloner {

	/**银行前置用于反馈的消息对象
	 * <pre>
	 * </pre>
	 * @author Administrator
	 * @createTime 2019/8/19
	 * @description
	 * */
	public static Response getResponseClone() {
		if(null == response) {
			response = VzoomModelIniter.getDeepInitialization(Response.class);
		}
		return response.clone();
	}

	/**MQ消息通用对象
	 * <pre>
	 * </pre>
	 * @author Administrator
	 * @createTime 2019/8/19
	 * @description
	 * */
	public static MQMessage getMQMessageClone() {
		if(null == mqMessage) {
			mqMessage = VzoomModelIniter.getDeepInitialization(MQMessage.class);
		}
		return mqMessage.clone();
	}

	/**创建用于子采集发送MQ的消息对象
	 * <pre>
	 * </pre>
	 * @author Administrator
	 * @createTime 2019/8/19
	 * @description
	 * */
	public static SubColMqMessage getSubColMessageClone(){
		if(null == subColMqMessage){
			subColMqMessage = VzoomModelIniter.getDeepInitialization(SubColMqMessage.class);
		}
		return subColMqMessage.clone();
	}
	
	private static MQMessage mqMessage;
	private static Response response;
	private static SubColMqMessage subColMqMessage;
}


