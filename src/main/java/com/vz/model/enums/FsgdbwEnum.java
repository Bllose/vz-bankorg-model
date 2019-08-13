package com.vz.model.enums;

/**
 * “发送光大报文”枚举类
 * @author Administrator
 *
 */
public enum FsgdbwEnum {
	MQ_RECEIVE_BASE("MQ_RECEIVE_BASE", "MQ消息baseInfo"),// baseInfo级别消息入库保存
	MQ_RECEIVE_GLOBAL("MQ_RECEIVE_GLOBAL", "MQ消息globalInfo"),// globalInfo级别消息入库保存
	MQ_RECEIVE_PRE("MQ_RECEIVE_PRE", "贷前MQ消息"),// 贷前MQ消息记录
	MQ_RECEIVE_POS("MQ_RECEIVE_POS", "贷后MQ消息"),// 贷后MQ消息记录
	PUSH_GLOBAL("PUSH_GLOBAL", "数据推送globalInfo"), // 推送给银行的消息记录
	QUERY_GLOBAL("QUERY_GLOBAL", "(银行)查询GlobalInfo"), // 银行主动查询报告记录
	PUSH_BASE("PUSH_BASE", "数据推送BaseInfo"), // 推送给银行的消息记录
	PDF("MQ_PDF_URL", "PDF下载地址"),
	POSTLOAN_REPORT("POSTLOAN_REPORT", "贷后/非首次报告文件内容"), 			// 如果需要保存报告内容，则使用此类型
	POSTLOAN_REPORT_UPLOAD("POSTLOAN_REPORT_UPLOAD", "贷后/非首次报告上传"), // 如果要记录上传操作，则使用此类型
	PRELOAN_REPORT("PRELOAN_REPORT", "贷前/首次报告文件内容"),				// 如果需要保存报告内容，则使用此类型
	PRELOAN_REPORT_UPLOAD("PRELOAN_REPORT_UPLOAD", "贷前/首次报告上传"),	// 如果要记录上传操作，则使用此类型
	PREPARE_PROCESS("PREPARE_PROCESS", "待执行"), // 比如T+1业务，T日到达，缓存后待执行
	ORDER_FEEDBACK("ORDER_FEEDBACK", "授信订单反馈内容"),
	CACHE_PRELOAN("CACHE_PRELOAN", "贷前报告缓存"),	// 比如订单推送时缓存报告，等待银行来查时使用
	XMLLOG("XMLLOG", "微众银行报告缓存"), // 兼容微众银行存量数据
	/**
	 * 与数据等级A0协同工作
	 * @see {@link com.vz.model.enums.DataLevelEnum}
	 * */
	ORDER_PIONEER("ORDER_PIONEER", "订单提示信息")
	;

	
	private String type;
	private String typeName;
	
	FsgdbwEnum(String type, String typeName){
		this.type = type;
		this.typeName = typeName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
