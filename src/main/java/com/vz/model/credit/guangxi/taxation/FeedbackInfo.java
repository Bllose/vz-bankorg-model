package com.vz.model.credit.guangxi.taxation;

/**授信信息反馈信息对象
 * @ProjectName: vz-bankorg-model
 * @Package: com.vz.model.credit.guangxi.taxation
 * @ClassName: FeedbackInfo
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/21 10:54
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/21 10:54
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class FeedbackInfo {

    private String tbpName; // 银行名称
    private String tbpCode; // 银行代码
    private String businessType; // 线上产品代码
    private String indName; // 申请人姓名
    private String indCertType; // 申请人证件类型
    private String indCertID; // 申请人证件号码
    private String entName; // 申贷企业名称
    private String entCreditID; // 企业社会信用代码
    private String entTaxID; // 纳税人识别号
    // 由于广西税局方写错了该字段，故此字段跟着变动
    private String applyTimeStrat; // 贷款申请起日期
    private String applyTimeEnd; // 贷款申请止日期
    private String grantFindTimeStart; // 授权查询起日期
    private String grantFindTimeEnd; // 授权查询止日期
    private String loanGrantTime; // 贷款授信日期
    private String loanTerm; // 贷款期限
    private String loanTime; // 银行放款日期
    private String loanOverdue; // 申贷企业是否贷款逾期
    private String isExtension; // 银行是否同意展期
    private String extensionTime; // 银行展期截止时间
    private String loanAccount; // 申贷企业放款账户
    private String backups; // 申贷企业对公账户是否自动在税务机关备案
    private String businessid; // 业务流水编号
    private String grantCode; // 授权书编号
    private String bankaccount; // 银行账号:税局分配查询税务数据的账号
    private String bankpassword; // 银行密码:税局分配查询税务数据的密码

    private Integer loanApplyAmount; // 申请贷款金额
    private Integer loanAmount; // 贷款金额
    private Integer drawingBalance; // 企业提款余额
    private Integer loanBalance; // 贷款余额


    public String getApplyTimeStrat() {
        return applyTimeStrat;
    }

    public void setApplyTimeStrat(String applyTimeStrat) {
        this.applyTimeStrat = applyTimeStrat;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    public String getBankpassword() {
        return bankpassword;
    }

    public void setBankpassword(String bankpassword) {
        this.bankpassword = bankpassword;
    }

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

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getApplyTimeEnd() {
        return applyTimeEnd;
    }

    public void setApplyTimeEnd(String applyTimeEnd) {
        this.applyTimeEnd = applyTimeEnd;
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

    public String getLoanGrantTime() {
        return loanGrantTime;
    }

    public void setLoanGrantTime(String loanGrantTime) {
        this.loanGrantTime = loanGrantTime;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }


    public String getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(String loanTime) {
        this.loanTime = loanTime;
    }

    public String getLoanOverdue() {
        return loanOverdue;
    }

    public void setLoanOverdue(String loanOverdue) {
        this.loanOverdue = loanOverdue;
    }

    public String getIsExtension() {
        return isExtension;
    }

    public void setIsExtension(String isExtension) {
        this.isExtension = isExtension;
    }

    public String getExtensionTime() {
        return extensionTime;
    }

    public void setExtensionTime(String extensionTime) {
        this.extensionTime = extensionTime;
    }

    public String getLoanAccount() {
        return loanAccount;
    }

    public void setLoanAccount(String loanAccount) {
        this.loanAccount = loanAccount;
    }

    public String getBackups() {
        return backups;
    }

    public void setBackups(String backups) {
        this.backups = backups;
    }

    public String getBusinessid() {
        return businessid;
    }

    public void setBusinessid(String businessid) {
        this.businessid = businessid;
    }

    public String getGrantCode() {
        return grantCode;
    }

    public void setGrantCode(String grantCode) {
        this.grantCode = grantCode;
    }

    public String getIndCertID() {
        return indCertID;
    }

    public void setIndCertID(String indCertID) {
        this.indCertID = indCertID;
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

    public Integer getDrawingBalance() {
        return drawingBalance;
    }

    public void setDrawingBalance(Integer drawingBalance) {
        this.drawingBalance = drawingBalance;
    }

    public Integer getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(Integer loanBalance) {
        this.loanBalance = loanBalance;
    }
}
