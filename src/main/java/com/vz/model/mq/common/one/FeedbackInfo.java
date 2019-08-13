package com.vz.model.mq.common.one;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Administrator
 *	<pre>
 *2019-3-9 11:22:34 更新
 *必输字段：
 *nsrsbh
 *orderStatus
 *proId
 *product
 *productId
 *bankName
 *bankId
 *financeAmount
 *companyName
 *creditAmount
 *creditStartTime
 *creditEndTime
 *applyTime
 *</pre>
 */
public class FeedbackInfo implements Cloneable{
	
	@NotBlank(message = "nsrsbh 不能为空")
	private String nsrsbh; // 纳税人识别号 Y
	
	@NotBlank(message = "orderStatus 不能为空")
	@Pattern(regexp = "(0000|2000|9999)", message = "orderStatus 取值不正确，正确的取值范围：(0000|2000|9999)")
	private String orderStatus; // 订单状态（只接收(0000|2000|9999)） Y
	
	@NotBlank(message = "proId 不能为空")
	private String proId; // 产品ID Y
	
	@NotBlank(message = "orgName 银行名称 不能为空")
	private String orgName; // 银行名称/填写当前产品的银行名称 
	/*
	 * 必输字段
	 * */
	// 以下四个字段为反馈服务反馈给税局端时需要的四个字段
	private String product ; //填写当前产品的名称，如苏贸贷 Y
	private String productId ; //填写当前产品的proId Y
	private String bankName ; //填写当前产品的银行名称 Y
	private String bankId ; //填写当前产品的proId Y
	
	private String financeAmount ; //申请金额 Y
	private String companyName; // 公司名称 Y
	private String companyCreditNo; // 社会信用代码
	private String companyLicense; // 工商注册号
	private String companyOrgNo; // 组织机构代码
	
	private String bankProId; // 银行的产品编码
	private String bankProduct; // 银行的产品名称
	private String orderNo; // 订单号
	private String serialNo; // 业务受理号
	
	private String creditAmount; // 授信金额 Y
	private String creditRate; // 银行放款额度比例(江苏银行)
	private String currency; //币种
	private String advancePaymentAmount; // 预付款金额	
	private String accountStatus; // 账户状态
	private String annualizedRate; // 年化利率
	private String channelFrom; // 渠道来源	
	private String approveSuccessRate; // 审批通过率
	private String floatingRatio; // 审批通过上浮比例
	
	private String reasonForApf; // 审批失败原因
	private String serialNumber; // 序列号
	private String remark; // 具体说明
	private String province; // 省份名称/编码
	private String city;	// 城市名称/编码
	private String preCreditAmount ; //预授信金额 
	
	private String loaneeName; // 贷款人姓名;申请人姓名;借款人姓名
	private String loaneeIdentification;	// 贷款人证件号码;申请人证件号码
	private String loaneePhone; // 贷款人电话号码；申请人电话号码
	private String loanOrderNo;	// 贷款编号
	private String customerCharacteristic; // 客户特征/客户标识/客户类别


	/*
	 * 时间相关字段
	 * */
	private Date creditEndTime; // 授信终止日期（类型：string，格式：yyyy-MM-dd） Y
	private Date creditStartTime; // 授信开始日期（类型：string，格式：yyyy-MM-dd）Y
	private Date applyTime; // 申请时间（类型：string，格式：yyyy-MM-dd）Y
	private String applyDuration; // 申请期限
	private Date approveTime; // 审批时间/审核 时间（类型：string，格式：yyyy-MM-dd）
	private String creditDuration; // 授信期限
	private Date updateTime; // 反馈信息/文件生成时间
	
	
	public String getProduct() {
		return product;
	}



	public void setProduct(String product) {
		this.product = product;
	}
	

	public String getLoaneeName() {
		return loaneeName;
	}



	public void setLoaneeName(String loaneeName) {
		this.loaneeName = loaneeName;
	}



	public String getLoaneeIdentification() {
		return loaneeIdentification;
	}



	public void setLoaneeIdentification(String loaneeIdentification) {
		this.loaneeIdentification = loaneeIdentification;
	}



	public String getLoanOrderNo() {
		return loanOrderNo;
	}



	public void setLoanOrderNo(String loanOrderNo) {
		this.loanOrderNo = loanOrderNo;
	}



	public String getCustomerCharacteristic() {
		return customerCharacteristic;
	}



	public void setCustomerCharacteristic(String customerCharacteristic) {
		this.customerCharacteristic = customerCharacteristic;
	}





	public String getProductId() {
		return productId;
	}



	public void setProductId(String productId) {
		this.productId = productId;
	}



	public String getBankName() {
		return bankName;
	}



	public void setBankName(String bankName) {
		this.bankName = bankName;
	}



	public String getBankId() {
		return bankId;
	}



	public void setBankId(String bankId) {
		this.bankId = bankId;
	}



	public String getFinanceAmount() {
		return financeAmount;
	}



	public void setFinanceAmount(String financeAmount) {
		this.financeAmount = financeAmount;
	}



	public String getPreCreditAmount() {
		return preCreditAmount;
	}



	public void setPreCreditAmount(String preCreditAmount) {
		this.preCreditAmount = preCreditAmount;
	}

	 public String getProvince() {
		return province;
	}



	public void setProvince(String province) {
		this.province = province;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public FeedbackInfo clone() {
		 FeedbackInfo feedbackInfo = null;
		 try {
			 feedbackInfo=(FeedbackInfo)super.clone();
		 }catch(CloneNotSupportedException e) {  
	            e.printStackTrace();  
	     } 
		 return feedbackInfo;
	 }
	 
	 
	 
	public Date getCreditEndTime() {
		return creditEndTime;
	}
	
	
	public void setCreditEndTime(Date creditEndTime) {
		this.creditEndTime = creditEndTime;
	}
	
	
	public Date getCreditStartTime() {
		return creditStartTime;
	}
	
	
	public void setCreditStartTime(Date creditStartTime) {
		this.creditStartTime = creditStartTime;
	}

	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getCreditAmount() {
		return creditAmount;
	}

	/**授信金额*/
	public void setCreditAmount(String creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getNsrsbh() {
		return nsrsbh;
	}


	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public String getAccountStatus() {
		return accountStatus;
	}

	/**账户状态*/
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}


	public String getAnnualizedRate() {
		return annualizedRate;
	}


	public void setAnnualizedRate(String annualizedRate) {
		this.annualizedRate = annualizedRate;
	}


	public Date getApplyTime() {
		return applyTime;
	}

	/**申请时间*/
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}


	public Date getApproveTime() { 
		return approveTime;
	}


	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}


	public String getChannelFrom() {
		return channelFrom;
	}


	public void setChannelFrom(String channelFrom) {
		this.channelFrom = channelFrom;
	}


	public String getCreditDuration() {
		return creditDuration;
	}

	/**授信期限*/
	public void setCreditDuration(String creditDuration) {
		this.creditDuration = creditDuration;
	}


	public String getFloatingRatio() {
		return floatingRatio;
	}

	/**审批通过上浮比率*/
	public void setFloatingRatio(String floatingRatio) {
		this.floatingRatio = floatingRatio;
	}


	public String getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}


	public String getOrgName() {
		return orgName;
	}


	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	public String getProId() {
		return proId;
	}


	public void setProId(String proId) {
		this.proId = proId;
	}


	public String getReasonForApf() {
		return reasonForApf;
	}


	public void setReasonForApf(String reasonForApf) {
		this.reasonForApf = reasonForApf;
	}


	public String getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getAdvancePaymentAmount() {
		return advancePaymentAmount;
	}


	public void setAdvancePaymentAmount(String advancePaymentAmount) {
		this.advancePaymentAmount = advancePaymentAmount;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public String getLoaneePhone() {
		return loaneePhone;
	}



	public void setLoaneePhone(String loaneePhone) {
		this.loaneePhone = loaneePhone;
	}



	public String getCompanyCreditNo() {
		return companyCreditNo;
	}



	public void setCompanyCreditNo(String companyCreditNo) {
		this.companyCreditNo = companyCreditNo;
	}

	public String getCompanyLicense() {
		return companyLicense;
	}



	public void setCompanyLicense(String companyLicense) {
		this.companyLicense = companyLicense;
	}



	public String getCompanyOrgNo() {
		return companyOrgNo;
	}



	public void setCompanyOrgNo(String companyOrgNo) {
		this.companyOrgNo = companyOrgNo;
	}



	public String getBankProId() {
		return bankProId;
	}



	public void setBankProId(String bankProId) {
		this.bankProId = bankProId;
	}



	public String getBankProduct() {
		return bankProduct;
	}



	public void setBankProduct(String bankProduct) {
		this.bankProduct = bankProduct;
	}



	public String getApplyDuration() {
		return applyDuration;
	}



	public void setApplyDuration(String applyDuration) {
		this.applyDuration = applyDuration;
	}



	public String getApproveSuccessRate() {
		return approveSuccessRate;
	}



	public void setApproveSuccessRate(String approveSuccessRate) {
		this.approveSuccessRate = approveSuccessRate;
	}



	public String getCreditRate() {
		return creditRate;
	}



	public void setCreditRate(String creditRate) {
		this.creditRate = creditRate;
	}



	public Date getUpdateTime() {
		return updateTime;
	}



	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}



	public String getSerialNo() {
		return serialNo;
	}



	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

}
