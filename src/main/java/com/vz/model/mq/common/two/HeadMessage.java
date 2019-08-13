package com.vz.model.mq.common.two;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


/**
 * MQ消息报文头
 * 
 *<pre>
 *发起一个有效订单消息，至少包含如下信息
 *<hr>
 *<ul>
 *<li>actionName</li>
 *<li>nsrsbh</li>
 *</ul>
 *</pre>
 */
public class HeadMessage implements Cloneable{
	/**
	 * 如果服务拥有多个功能，那么就需要actionName来判断业务内容
	 * */
	@Size(min=1,max=999,message="actionName不存在，无法识别业务类型!")
	private String actionName;
	
	@NotBlank(message = "有效的订单请求，纳税人识别号不能为空!")
	private String nsrsbh;
	
	/**
	 * 当前请求的来源，即本服务（项目）的名称
	 * */
	private String source;
	private String reqId;
	
	public HeadMessage clone() {
		try {
			return (HeadMessage) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
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
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	

	
}
