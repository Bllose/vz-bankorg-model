package com.vz.model.credit.guangxi.taxation;

/**贷款申请反馈信息对象
 * @ProjectName: vz-bankorg-model
 * @Package: com.vz.model.credit.guangxi.taxation
 * @ClassName: LoanApplicationInfo
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/21 10:52
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/21 10:52
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LoanApplicationInfo {

    private String tbpName; // 银行名称
    private String tbpCode; // 银行代码
    private String businessType; // 线上产品名称
    private String indName; // 申请人姓名
    private String indCertType; // 申请人证件类型
    private String indCertID; // 申请人证件号码
    private String entName; // 申贷企业名称
    private String entCreditID; // 企业社会信用代码
    private String entTaxID; // 纳税人识别号
    private String applyTime; // 贷款申请日期
    private Integer loanApplyAmount; // 申请贷款金额
    private Integer loanAmount; // 授信金额
    private String loanTerm; // 贷款期限
    private String admittance; // 综合准入结果
    private String businessid; // 业务流水编号
    private String grantFindTimeStart; // 授权查询期限起
    private String grantFindTimeEnd; // 授权查询期限止
    private String grantCode; // 授权书编号

    public String getTbpName() {
        return tbpName;
    }

    public void setTbpName(String tbpName) {
        this.tbpName = tbpName;
    }

    public String getTbpCode() {
        return tbpCode;
    }

    public void setTbpCode(String tbpCode) {
        this.tbpCode = tbpCode;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getIndName() {
        return indName;
    }

    public void setIndName(String indName) {
        this.indName = indName;
    }

    public String getIndCertType() {
        return indCertType;
    }

    public void setIndCertType(String indCertType) {
        this.indCertType = indCertType;
    }

    public String getIndCertID() {
        return indCertID;
    }

    public void setIndCertID(String indCertID) {
        this.indCertID = indCertID;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getEntCreditID() {
        return entCreditID;
    }

    public void setEntCreditID(String entCreditID) {
        this.entCreditID = entCreditID;
    }

    public String getEntTaxID() {
        return entTaxID;
    }

    public void setEntTaxID(String entTaxID) {
        this.entTaxID = entTaxID;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getAdmittance() {
        return admittance;
    }

    public void setAdmittance(String admittance) {
        this.admittance = admittance;
    }

    public String getBusinessid() {
        return businessid;
    }

    public void setBusinessid(String businessid) {
        this.businessid = businessid;
    }

    public String getGrantFindTimeStart() {
        return grantFindTimeStart;
    }

    public void setGrantFindTimeStart(String grantFindTimeStart) {
        this.grantFindTimeStart = grantFindTimeStart;
    }

    public String getGrantFindTimeEnd() {
        return grantFindTimeEnd;
    }

    public void setGrantFindTimeEnd(String grantFindTimeEnd) {
        this.grantFindTimeEnd = grantFindTimeEnd;
    }

    public String getGrantCode() {
        return grantCode;
    }

    public void setGrantCode(String grantCode) {
        this.grantCode = grantCode;
    }

    public Integer getLoanApplyAmount() {
        return loanApplyAmount;
    }

    public void setLoanApplyAmount(Integer loanApplyAmount) {
        this.loanApplyAmount = loanApplyAmount;
    }

    public Integer getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Integer loanAmount) {
        this.loanAmount = loanAmount;
    }
}
