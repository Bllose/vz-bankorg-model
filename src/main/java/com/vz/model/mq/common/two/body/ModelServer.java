package com.vz.model.mq.common.two.body;

public class ModelServer implements Cloneable{

	private String preAccessDesc;// 模型结果内容
	private String preAccess; // 模型结果编码，00000000 成功
	private String originOutData;// 模型的原始输出数据
	private String preCreditAmount;// 预授信金额
	private String creditAmount;// 授信额度
	private String preCreditAmountRange; // 预授信金额（区间）

	public ModelServer clone() {
		try {
			return (ModelServer) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getPreCreditAmount() {
		return preCreditAmount;
	}

	public void setPreCreditAmount(String preCreditAmount) {
		this.preCreditAmount = preCreditAmount;
	}

	public String getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(String creditAmount) {
		this.creditAmount = creditAmount;
	}
	
	/**
	 * 模型结果内容
	 * */
	public String getPreAccessDesc() {
		return preAccessDesc;
	}
	public void setPreAccessDesc(String preAccessDesc) {
		this.preAccessDesc = preAccessDesc;
	}
	
	/**
	 * 模型结果编码
	 * */
	public String getPreAccess() {
		return preAccess;
	}
	public void setPreAccess(String preAccess) {
		this.preAccess = preAccess;
	}

	/**
	 * 模型输出的原始结果
	 * @return
	 */
	public String getOriginOutData() {
		return originOutData;
	}

	public void setOriginOutData(String originOutData) {
		this.originOutData = originOutData;
	}

	public String getPreCreditAmountRange() {
		return preCreditAmountRange;
	}

	public void setPreCreditAmountRange(String preCreditAmountRange) {
		this.preCreditAmountRange = preCreditAmountRange;
	}
	
	
}
