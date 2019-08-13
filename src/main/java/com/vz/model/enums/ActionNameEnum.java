package com.vz.model.enums;

/**
 * 业务类型枚举类
 *
 *<pre>
 *<h1>针对解析MQ消息时，判断业务种类所使用的枚举类</h1>
 *
 *包含如下类型
 *<ul>
 *	<li>GLOBAL_INF(globalInfo)</li>
 *	<li>BASE_INF(baseInfo)</li>
 *	<li>RESEND(resend): 异常订单重发</li>
 *	<li>FEED_BACK(feedback): 授信订单/对账反馈</li>
 *	<li>LOAN_BACK(loanback): 对账反馈</li>
 *</ul>
 *</pre>
 */
public enum ActionNameEnum {

	/**globalInfo*/
	GLOBAL_INF("globalInfo", "全量数据报文"),
	/**baseInfo*/
	BASE_INF("baseInfo", "基础数据报文"),
	/**timer*/
	TIMER("timer", "定时平台调度"),
	/**resend 异常订单重发*/
	RESEND("resend", "异常订单重发"),
	/**feedback 授信订单反馈*/
	FEED_BACK("feedback", "授信订单/对账反馈"),
	/**loanback 对账反馈*/
	LOAN_BACK("loanback", "对账反馈"),
	/**upload 贷后打包上传*/
	UP_LOAD("upload", "贷后打包上传");
	
	
	
	private String code;
	private String msg;
	
	ActionNameEnum(String code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public String getCode() {
		return code;
	}
}
