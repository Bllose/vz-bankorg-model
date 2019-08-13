package com.vz.model.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 对账反馈数据表对象
 * @author Administrator
 *
 */
@TableName("ZX_LOAN_DETAIL")
public class LoanbackDto {

	@TableId(value="id", type= IdType.UUID) 
	private String id;//唯一ID

	@TableField("ORDER_NO") //订单编号
	private String orderNo;

	@TableField("COMPANY_NAME") //公司名称
	private String companyName;

	@TableField("NSRSBH") //纳税识别号
	private String nsrsbh;

	@TableField("APPLY_DATE") //贷款日期
	private String applyDate;

	@TableField("BALANCE_DUE") //贷款余额
	private String balanceDue;

	@TableField("UPDATE_TIME") //数据时间
	private String updateTime;

	@TableField("STATUS") //借据状态
	private String status;

	@TableField("CLEAR_DATE") //结清日期
	private String clearDate;

	@TableField("CREATE_TIME") //入库时间
	private String createTime;

	@TableField("REMARK") //备注
	private String remark;

	@TableField("SERIAL_NO") //借据编号
	private String serialNo;

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("LoanbackDto [");
		sb.append("ID:").append(id).append("| ");
		sb.append("NSRSBH:").append(nsrsbh).append("| ");
		sb.append("COMPANY_NAME:").append(companyName).append("| ");
		sb.append("ORDER_NO:").append(orderNo).append("| ");
		sb.append("SERIAL_NO:").append(serialNo);
		sb.append("]");
		return new String(sb);
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getNsrsbh() {
		return nsrsbh;
	}

	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getBalanceDue() {
		return balanceDue;
	}

	public void setBalanceDue(String balanceDue) {
		this.balanceDue = balanceDue;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getClearDate() {
		return clearDate;
	}

	public void setClearDate(String clearDate) {
		this.clearDate = clearDate;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	
}
