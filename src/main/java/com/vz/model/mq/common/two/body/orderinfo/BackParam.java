package com.vz.model.mq.common.two.body.orderinfo;

/**
 * 认证系统，回调数据透传节点
 * @author Administrator
 *
 */
public class BackParam {

	private String cityNo;
	private String token_id;
	private String fromChannel;
	public String getCityNo() {
		return cityNo;
	}
	public void setCityNo(String cityNo) {
		this.cityNo = cityNo;
	}
	public String getToken_id() {
		return token_id;
	}
	public void setToken_id(String token_id) {
		this.token_id = token_id;
	}
	public String getFromChannel() {
		return fromChannel;
	}
	public void setFromChannel(String fromChannel) {
		this.fromChannel = fromChannel;
	}
	
	
}
