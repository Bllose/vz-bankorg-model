package com.vz.model.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * 注意插入字段：
 * ID : 
 * CREATETIME : 创建时间
 * */
@TableName("ZX_ORDER_FEEDBACK")
public class OrderFeedbackDto {
    /**
     * ID
     */
    @TableField("ID")
    private String id;

    /**
     * 借款人姓名
     */
    @TableField("JKR_MC")
    private String jkrMc;

    /**
     * 借款人证件号码
     */
    @TableField("JKR_ZJHM")
    private String jkrZjhm;

    /**
     * 企业名称
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
    @TableField("ORDERNO")
    private String orderno;

    /**
     * 申请时间
     */
    @TableField("SQ_SJ")
    private String sqSj;

    /**
     * 审批时间
     */
    @TableField("SP_SJ")
    private String spSj;

    /**
     * 审批结果(通过，失败，审核中，准入失败，预审失败)
     */
    @TableField("SP_JG")
    private String spJg;

    /**
     * 授信金额
     */
    @TableField("SX_JE")
    private String sxJe;

    /**
     * 授信期限
     */
    @TableField("SX_QX")
    private String sxQx;

    /**
     * 上浮比例
     */
    @TableField("SFBL")
    private String sfbl;

    /**
     * 授信开始日期
     */
    @TableField("SX_KSSJ")
    private String sxKssj;

    /**
     * 授信结束日期
     */
    @TableField("SX_JSSJ")
    private String sxJssj;

    /**
     * 账户状态(正常，冻结，到期终止)；订单状态
     */
    @TableField("ZH_STATUS")
    private String zhStatus;

    /**
     * 来源
     */
    @TableField("SOURCE")
    private String source;

    /**
     * 创建时间
     */
    @TableField("CREATETIME")
    private Date createtime;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 申请人手机号码
     */
    @TableField("APPLY_MOBILE")
    private String applyMobile;

    /**
     * 所在省
     */
    @TableField("PROVINCE")
    private String province;

    /**
     * 所在市
     */
    @TableField("CITY")
    private String city;

    /**
     * 统一社会信用代码
     */
    @TableField("CRE_COMPANY_NO")
    private String creCompanyNo;

    /**
     * 判断是否是三证企业
     */
    @TableField("SFSJQY")
    private String sfsjqy;

    /**
     * 工商注册号
     */
    @TableField("COMPANY_LICENSE")
    private String companyLicense;

    /**
     * 组织机构代码
     */
    @TableField("COMPANY_ORG_NUM")
    private String companyOrgNum;

    /**
     * 产品代码
     */
    @TableField("PRODUCT_CODE")
    private String productCode;

    /**
     * 产品名称
     */
    @TableField("PRODUCT_NAME")
    private String productName;

    /**
     * 江苏银行额度占比
     */
    @TableField("APPROVE_AMOUNT_RATE_IN")
    private String approveAmountRateIn;

    /**
     * 申请金额（元）
     */
    @TableField("APPLY_AMOUNT")
    private String applyAmount;

    /**
     * 申请期限（月）
     */
    @TableField("APPLY_TERMS")
    private String applyTerms;

    /**
     * 审批失败原因
     */
    @TableField("SPSBYY")
    private String spsbyy;

    /**
     * 文件生成日期
     */
    @TableField("FILE_DATE")
    private String fileDate;

    /**
     * 审批通过利率
     */
    @TableField("APPROVE_RATE_BASE")
    private String approveRateBase;

    @TableField("SXBZ")
    private String sxbz;

    @TableField("YFKJE")
    private String yfkje;

    @TableField("INTERESTRATE")
    private String interestrate;

    /**
     * 年化率
     * */
    @TableField("RATE")
    private String rate;

    @TableField("UPDATETIME")
    private Date updatetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getJkrMc() {
        return jkrMc;
    }

    public void setJkrMc(String jkrMc) {
        this.jkrMc = jkrMc == null ? null : jkrMc.trim();
    }

    public String getJkrZjhm() {
        return jkrZjhm;
    }

    public void setJkrZjhm(String jkrZjhm) {
        this.jkrZjhm = jkrZjhm == null ? null : jkrZjhm.trim();
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

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getSqSj() {
        return sqSj;
    }

    public void setSqSj(String sqSj) {
        this.sqSj = sqSj == null ? null : sqSj.trim();
    }

    public String getSpSj() {
        return spSj;
    }

    public void setSpSj(String spSj) {
        this.spSj = spSj == null ? null : spSj.trim();
    }

    public String getSpJg() {
        return spJg;
    }

    public void setSpJg(String spJg) {
        this.spJg = spJg == null ? null : spJg.trim();
    }

    public String getSxJe() {
        return sxJe;
    }

    public void setSxJe(String sxJe) {
        this.sxJe = sxJe == null ? null : sxJe.trim();
    }

    public String getSxQx() {
        return sxQx;
    }

    public void setSxQx(String sxQx) {
        this.sxQx = sxQx == null ? null : sxQx.trim();
    }

    public String getSfbl() {
        return sfbl;
    }

    public void setSfbl(String sfbl) {
        this.sfbl = sfbl == null ? null : sfbl.trim();
    }

    public String getSxKssj() {
        return sxKssj;
    }

    public void setSxKssj(String sxKssj) {
        this.sxKssj = sxKssj == null ? null : sxKssj.trim();
    }

    public String getSxJssj() {
        return sxJssj;
    }

    public void setSxJssj(String sxJssj) {
        this.sxJssj = sxJssj == null ? null : sxJssj.trim();
    }

    public String getZhStatus() {
        return zhStatus;
    }

    public void setZhStatus(String zhStatus) {
        this.zhStatus = zhStatus == null ? null : zhStatus.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getApplyMobile() {
        return applyMobile;
    }

    public void setApplyMobile(String applyMobile) {
        this.applyMobile = applyMobile == null ? null : applyMobile.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCreCompanyNo() {
        return creCompanyNo;
    }

    public void setCreCompanyNo(String creCompanyNo) {
        this.creCompanyNo = creCompanyNo == null ? null : creCompanyNo.trim();
    }

    public String getSfsjqy() {
        return sfsjqy;
    }

    public void setSfsjqy(String sfsjqy) {
        this.sfsjqy = sfsjqy == null ? null : sfsjqy.trim();
    }

    public String getCompanyLicense() {
        return companyLicense;
    }

    public void setCompanyLicense(String companyLicense) {
        this.companyLicense = companyLicense == null ? null : companyLicense.trim();
    }

    public String getCompanyOrgNum() {
        return companyOrgNum;
    }

    public void setCompanyOrgNum(String companyOrgNum) {
        this.companyOrgNum = companyOrgNum == null ? null : companyOrgNum.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getApproveAmountRateIn() {
        return approveAmountRateIn;
    }

    public void setApproveAmountRateIn(String approveAmountRateIn) {
        this.approveAmountRateIn = approveAmountRateIn == null ? null : approveAmountRateIn.trim();
    }

    public String getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(String applyAmount) {
        this.applyAmount = applyAmount == null ? null : applyAmount.trim();
    }

    public String getApplyTerms() {
        return applyTerms;
    }

    public void setApplyTerms(String applyTerms) {
        this.applyTerms = applyTerms == null ? null : applyTerms.trim();
    }

    public String getSpsbyy() {
        return spsbyy;
    }

    public void setSpsbyy(String spsbyy) {
        this.spsbyy = spsbyy == null ? null : spsbyy.trim();
    }

    public String getFileDate() {
        return fileDate;
    }

    public void setFileDate(String fileDate) {
        this.fileDate = fileDate == null ? null : fileDate.trim();
    }

    public String getApproveRateBase() {
        return approveRateBase;
    }

    public void setApproveRateBase(String approveRateBase) {
        this.approveRateBase = approveRateBase == null ? null : approveRateBase.trim();
    }

    public String getSxbz() {
        return sxbz;
    }

    public void setSxbz(String sxbz) {
        this.sxbz = sxbz == null ? null : sxbz.trim();
    }

    public String getYfkje() {
        return yfkje;
    }

    public void setYfkje(String yfkje) {
        this.yfkje = yfkje == null ? null : yfkje.trim();
    }

    public String getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(String interestrate) {
        this.interestrate = interestrate == null ? null : interestrate.trim();
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}