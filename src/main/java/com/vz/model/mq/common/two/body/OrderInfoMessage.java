package com.vz.model.mq.common.two.body;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.validation.constraints.NotNull;

import com.vz.model.mq.common.two.body.orderinfo.BackParam;

/**
 * MQ推送的orderInfo JSON 对象
 * */
public class OrderInfoMessage extends HashMap<String,Object> implements Cloneable{
	
	/*
	 * 基本字段
	 * */
	private String serialNo;//流水号
	private Date submitTime; // 订单系统生成的订单提交时间
	private String orderType;// 订单类型
	private String orderNo;	// 订单号
	private String companyName;	//纳税人名称；企业名称
	private String proId;	//业务ID 比如贷后时就与productId不一样
	private String productId; //产品ID
	
	@NotNull(message = "纳税人识别号不能为空!")
	private String nsrsbh; 	// 纳税人识别号
	
	private String orderFrom; // 订单来源, 报文服务有时候是必输字段
	
	private String applyer;	//申请人名字
	private String financeAmount;	//融资金额(万元)
	
	
	/**贷后名单表中yf这个字段
	 * 由贷后服务转化为pch字段，向后透传*/
	private String pch;//批次号，贷后使用
	private String postloanListId;//贷后清单ID，由贷后服务查询、发送并用于更新。只透传不保存
	
	
	public OrderInfoMessage clone() {
		return (OrderInfoMessage) super.clone();
	}
	
	public String getNsrsbh() {
		return this.get("nsrsbh")==null?null:String.valueOf(this.get("nsrsbh"));
	}
	public void setNsrsbh(String nsrsbh) {
		this.put("nsrsbh", nsrsbh);
		this.nsrsbh = nsrsbh;
	}
	
	/**
	 * 订单提交时间，由订单服务接收。订单服务有非空校验
	 * @param submitTime
	 */
	public void setSubmitTime(Date submitTime) {
		this.put("submitTime", submitTime);
		this.submitTime = submitTime;
	}
	public Date getSubmitTime() {
		try {
			if(submitTime == null) {
				Object subTime = this.get("submitTime");
				if(null == subTime) return null;
				
				if(subTime instanceof Date) {
					submitTime = (Date) subTime;
				}else if(subTime instanceof String) {
					submitTime = analyString2Time(String.valueOf(subTime));
				}else if(subTime instanceof Long) {
					submitTime = new Date((long) subTime);
				}
				
				return submitTime;
			}
		}catch(Exception e) {
			System.err.println("尝试获取认证时间失败,使用默认时间");
		}
		return submitTime;
		
	}
	
	private Date analyString2Time(String timeString) {
		Date result = new Date();
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 0);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			result = sdf.parse(timeString);
		} catch (ParseException e) {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
			try {
				result = sdf1.parse(timeString);
			} catch (ParseException e1) {
				System.err.println("请检查传入日期格式是否正确，传入的日期为：" + timeString);
			}
		}
		return result;

	}

	/**
	 * 订单号
	 * <pre>
	 * 由前置系统提供
	 * 所有新发起的订单，都应该提供一个唯一ID
	 * </pre>
	 * @param orderNo
	 */
	public void setOrderNo(String orderNo) {
		this.put("orderNo", orderNo);
		this.orderNo = orderNo;
	}
	public String getOrderNo() {
		return this.get("orderNo")==null?null:String.valueOf(this.get("orderNo"));
	}
	
	
	public String getOrderType() {
		return this.get("orderType")==null?null:String.valueOf(this.get("orderType"));
	}
	/**
	 * 订单类型，订单服务有非空校验和枚举校验
	 * <pre>
	 * 枚举值：PRELOAN | POSTLOAN
	 * </pre>
	 * @param orderType
	 */
	public void setOrderType(String orderType) {
		this.put("orderType", orderType);
		this.orderType = orderType;
	}
	
	public String getPch() {
		return this.get("pch")==null?null:String.valueOf(this.get("pch"));
	}
	public void setPch(String pch) {
		this.put("pch", pch);
		this.pch = pch;
	}
	
	public String getSerialNo() {
		return this.get("serialNo")==null?null:String.valueOf(this.get("serialNo"));
	}
	public void setSerialNo(String serialNo) {
		this.put("serialNo", serialNo);
		this.serialNo = serialNo;
	}
	
	
	public String getApplyer() {
		return this.get("applyer")==null?null:String.valueOf(this.get("applyer"));
	}
	public void setApplyer(String applyer) {
		this.put("applyer", applyer);
		this.applyer = applyer;
	}
	
	
	public String getCompanyName() {
		return this.get("companyName")==null?null:String.valueOf(this.get("companyName"));
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getFinanceAmount() {
		
		return this.get("financeAmount")==null?null:String.valueOf(this.get("financeAmount"));
	}
	public void setFinanceAmount(String financeAmount) {
		this.financeAmount = financeAmount;
	}

	public String getProId() {
		return this.get("proId")==null?null:String.valueOf(this.get("proId"));
	}
	public void setProId(String proId) {
		this.put("proId", proId);
		this.proId = proId;
	}
	
	public String getProductId() {
		return this.get("productId")==null?null:String.valueOf(this.get("productId"));
	}
	public void setProductId(String productId) {
		this.put("productId", productId);
		this.productId = productId;
	}

	public String getPostloanListId() {
		return this.get("postloanListId")==null?null:String.valueOf(this.get("postloanListId"));
	}
	public void setPostloanListId(String postloanListId) {
		this.put("postloanListId", postloanListId);
		this.postloanListId = postloanListId;
	}
	
	
}
