package com.vz.model.enums;

/**
 * 数据等级
 *<pre>
 * <h1>银行前置需要主动处理的等级包括：&lt;A0&gt;</h1>
 *<hr>
 * <h4>A0：</h4>
 *当订单卡在数据质量时，会导致银行前置无法得知订单的存在。
 *而A0订单则作为订单提示信息优先推送至银行前置服务。
 *如果需要及时的订单重提或类似的功能，则可以以此作为依据。
 *</pre>
 */
public enum DataLevelEnum {

	/**
	 * 2019-3-20 11:11:26 添加
	 * <pre>
	 * 假设正常的业务流程：订单推送, 推送数据质量B的订单信息。
	 * 	这笔订单卡在数据质量，那么就会导致银行前置无法得知订单的存在。
	 * 	而A0订单则作为订单提示信息优先推送至银行前置服务。
	 * 	如果需要及时的订单重提或类似的功能，则可以以此作为依据。
	 * </pre>
	 * */
	A0("A0", "订单提示"),
	
	/**
	 * 2019-4-11 14:57:31 添加
	 * <pre>
	 * 某些情况下，需要制作反馈报告，但是数据等级却无从获取。
	 * 那么就使用X代替
	 * 典型的：
	 * 	银行主动拉取缓存的报告，失败了。因为压根没有缓存。这时候反馈订单流水时，就没有数据等级。
	 * 	授信订单反馈业务，执行完成后要反馈订单服务和订单流水。这时候也是没有数据等级的。
	 * </pre>
	 * */
	X("X", "未知");
	
	private String code;
	private String msg;
	
	DataLevelEnum(String code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getMsg() {
		return msg;
	}
}
