package com.vz.model.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 对账反馈表
 * @date 2019-4-2
 */
@TableName("ZX_BANK_DZ_FEEDBACK")
public class BankDzFeedbackDto {
    /**
     * ID
     */
    @TableField("ID")
    private String id;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private String createTime;

    /**
     * 产品ID
     */
    @TableField("PRODUCT_NAME")
    private String productName;

    /**
     * 银行名称
     */
    @TableField("BANK_NAME")
    private String bankName;

    /**
     * 公司名称
     */
    @TableField("QYMC")
    private String qymc;

    /**
     * 纳税识别号
     */
    @TableField("NSRSBH")
    private String nsrsbh;

    /**
     * 订单编号
     */
    @TableField("ORDER_NO")
    private String orderNo;

    /**
     * 状态
     */
    @TableField("ORDER_STATUS")
    private String orderStatus;

    /**
     * 逾期天数
     */
    @TableField("YQTS")
    private String yqts;

    /**
     * 合同编号
     */
    @TableField("HTBH")
    private String htbh;

    /**
     * 用款额度
     */
    @TableField("YKED")
    private String yked;

    /**
     * 用款日期
     */
    @TableField("YKRQ")
    private String ykrq;

    /**
     * 用款信息
     */
    @TableField("YKXX")
    private String ykxx;

    /**
     * 还款额度
     */
    @TableField("REPAYMENT_QUOTA")
    private String repaymentQuota;

    /**
     * 欠款额度
     */
    @TableField("ARREARS_QUOTA")
    private String arrearsQuota;

    /**
     * 还款状态
     */
    @TableField("REPAYMENT_STATUS")
    private String repaymentStatus;

    /**
     * 产品ID
     */
    @TableField("PRODUCT_ID")
    private String productId;

    /**
     * 对账反馈类型：”还款“，”用款“
     */
    @TableField("DZ_TYPE")
    private String dzType;

    /**
     * 还款本金
     */
    @TableField("HK_PRINCIPAL")
    private String hkPrincipal;

    /**
     * 还款利息
     */
    @TableField("HK_INTEREST")
    private String hkInterest;

    /**
     * 还款方式
     */
    @TableField("HK_MODE")
    private String hkMode;

    /**
     * 还款日期
     */
    @TableField("HK_DATE")
    private String hkDate;

    /**
     * 还款时间
     */
    @TableField("HK_TIME")
    private String hkTime;

    /**
     * 贷款账号
     */
    @TableField("HK_DKZH")
    private String hkDkzh;

    /**
     * 借据编号
     */
    @TableField("LOAN_ID")
    private String loanId;

    /**
     * 城市/一级分行
     */
    @TableField("CITY")
    private String city;

    /**
     * 借款人
     */
    @TableField("BORROWER")
    private String borrower;

    /**
     * 授信金额
     */
    @TableField("CREDIT_AMOUNT")
    private String creditAmount;

    /**
     * 借款日期
     */
    @TableField("LOAN_TIME")
    private String loanTime;

    /**
     * 当前借据金额
     */
    @TableField("LOAN_AMOUNT")
    private String loanAmount;

    /**
     * 借款利率
     */
    @TableField("LOAN_RATE")
    private String loanRate;

    /**
     * 累计实收利息
     */
    @TableField("INTEREST")
    private String interest;

    /**
     * 结清标志
     */
    @TableField("SETTLE_SIGN")
    private String settleSign;

    /**
     * 结清日期
     */
    @TableField("SETTLE_TIME")
    private String settleTime;

    /**
     * 本期季末不良率
     */
    @TableField("BAD_RATE")
    private String badRate;

    /**
     * 本期应还本金
     */
    @TableField("YHBJ")
    private String yhbj;

    /**
     * 贷款余额
     */
    @TableField("YHLX")
    private String yhlx;

    @TableField("SFYQ")
    private String sfyq;

    @TableField("JZRQ")
    private String jzrq;

    @TableField("SYED")
    private String syed;

    @TableField("DKYE")
    private String dkye;

    /**
     * 本期应还利息
     */
    @TableField("BQYHLX")
    private String bqyhlx;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc == null ? null : qymc.trim();
    }

    public String getNsrsbh() {
        return nsrsbh;
    }

    public void setNsrsbh(String nsrsbh) {
        this.nsrsbh = nsrsbh == null ? null : nsrsbh.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getYqts() {
        return yqts;
    }

    public void setYqts(String yqts) {
        this.yqts = yqts == null ? null : yqts.trim();
    }

    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh == null ? null : htbh.trim();
    }

    public String getYked() {
        return yked;
    }

    public void setYked(String yked) {
        this.yked = yked == null ? null : yked.trim();
    }

    public String getYkrq() {
        return ykrq;
    }

    public void setYkrq(String ykrq) {
        this.ykrq = ykrq == null ? null : ykrq.trim();
    }

    public String getYkxx() {
        return ykxx;
    }

    public void setYkxx(String ykxx) {
        this.ykxx = ykxx == null ? null : ykxx.trim();
    }

    public String getRepaymentQuota() {
        return repaymentQuota;
    }

    public void setRepaymentQuota(String repaymentQuota) {
        this.repaymentQuota = repaymentQuota == null ? null : repaymentQuota.trim();
    }

    public String getArrearsQuota() {
        return arrearsQuota;
    }

    public void setArrearsQuota(String arrearsQuota) {
        this.arrearsQuota = arrearsQuota == null ? null : arrearsQuota.trim();
    }

    public String getRepaymentStatus() {
        return repaymentStatus;
    }

    public void setRepaymentStatus(String repaymentStatus) {
        this.repaymentStatus = repaymentStatus == null ? null : repaymentStatus.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getDzType() {
        return dzType;
    }

    public void setDzType(String dzType) {
        this.dzType = dzType == null ? null : dzType.trim();
    }

    public String getHkPrincipal() {
        return hkPrincipal;
    }

    public void setHkPrincipal(String hkPrincipal) {
        this.hkPrincipal = hkPrincipal == null ? null : hkPrincipal.trim();
    }

    public String getHkInterest() {
        return hkInterest;
    }

    public void setHkInterest(String hkInterest) {
        this.hkInterest = hkInterest == null ? null : hkInterest.trim();
    }

    public String getHkMode() {
        return hkMode;
    }

    public void setHkMode(String hkMode) {
        this.hkMode = hkMode == null ? null : hkMode.trim();
    }

    public String getHkDate() {
        return hkDate;
    }

    public void setHkDate(String hkDate) {
        this.hkDate = hkDate == null ? null : hkDate.trim();
    }

    public String getHkTime() {
        return hkTime;
    }

    public void setHkTime(String hkTime) {
        this.hkTime = hkTime == null ? null : hkTime.trim();
    }

    public String getHkDkzh() {
        return hkDkzh;
    }

    public void setHkDkzh(String hkDkzh) {
        this.hkDkzh = hkDkzh == null ? null : hkDkzh.trim();
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId == null ? null : loanId.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower == null ? null : borrower.trim();
    }

    public String getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount == null ? null : creditAmount.trim();
    }

    public String getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(String loanTime) {
        this.loanTime = loanTime == null ? null : loanTime.trim();
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount == null ? null : loanAmount.trim();
    }

    public String getLoanRate() {
        return loanRate;
    }

    public void setLoanRate(String loanRate) {
        this.loanRate = loanRate == null ? null : loanRate.trim();
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest == null ? null : interest.trim();
    }

    public String getSettleSign() {
        return settleSign;
    }

    public void setSettleSign(String settleSign) {
        this.settleSign = settleSign == null ? null : settleSign.trim();
    }

    public String getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(String settleTime) {
        this.settleTime = settleTime == null ? null : settleTime.trim();
    }

    public String getBadRate() {
        return badRate;
    }

    public void setBadRate(String badRate) {
        this.badRate = badRate == null ? null : badRate.trim();
    }

    public String getYhbj() {
        return yhbj;
    }

    public void setYhbj(String yhbj) {
        this.yhbj = yhbj == null ? null : yhbj.trim();
    }

    public String getYhlx() {
        return yhlx;
    }

    public void setYhlx(String yhlx) {
        this.yhlx = yhlx == null ? null : yhlx.trim();
    }

    public String getSfyq() {
        return sfyq;
    }

    public void setSfyq(String sfyq) {
        this.sfyq = sfyq == null ? null : sfyq.trim();
    }

    public String getJzrq() {
        return jzrq;
    }

    public void setJzrq(String jzrq) {
        this.jzrq = jzrq == null ? null : jzrq.trim();
    }

    public String getSyed() {
        return syed;
    }

    public void setSyed(String syed) {
        this.syed = syed == null ? null : syed.trim();
    }

    public String getDkye() {
        return dkye;
    }

    public void setDkye(String dkye) {
        this.dkye = dkye == null ? null : dkye.trim();
    }

    public String getBqyhlx() {
        return bqyhlx;
    }

    public void setBqyhlx(String bqyhlx) {
        this.bqyhlx = bqyhlx == null ? null : bqyhlx.trim();
    }
}