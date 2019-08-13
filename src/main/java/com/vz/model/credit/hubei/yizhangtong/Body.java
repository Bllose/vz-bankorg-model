package com.vz.model.credit.hubei.yizhangtong;

import com.vz.model.credit.hubei.yizhangtong.body.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * @ProjectName: bllose-utils
 * @Package: com.vz.model.credit.hubei.yizhangtong
 * @ClassName: Body
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/5 14:52
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/5 14:52
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Body {

    // 查询授权信息时输入
    private String cxyf; // 查询月份

    // 查询企业信息时推送
    private String nsrlx; // 纳税人类型
    private String pch; // 批次号
    private String nsrsbh; //
    private String nsrmc; // 纳税人名称
    // 查询贷款审批结果时推送如上三个字段和如下四个字段
    private String spjg; // 审批结果
    private String dkje; // 贷款金额
    private String spnr; // 审批内容
    private String sprq; // 审批日期

    private List<Sqxx> sqxxs; // 查询申请信息时返回的申请信息

    /*
    * 查询企业信息时 - 返回如下信息
    * */
    private String rtncode;
    private String rtnmsg;
    private Jcxx jcxx;
    private List<Sbxx> sbxxs; // TODO - 接口文档不一致
    private List<Zsxx> zsxxs;
    private Cwxx cwxxs; // TODO - 接口文档找不到
    private List<Wfwz> wfwzs;
    /*
     * 查询企业信息时 - 返回如上信息
     * */

    public String getRtncode() {
        return rtncode;
    }

    public void setRtncode(String rtncode) {
        this.rtncode = rtncode;
    }

    public String getRtnmsg() {
        return rtnmsg;
    }

    public void setRtnmsg(String rtnmsg) {
        this.rtnmsg = rtnmsg;
    }

    public Jcxx getJcxx() {
        return jcxx;
    }

    public void setJcxx(Jcxx jcxx) {
        this.jcxx = jcxx;
    }

    @XmlElementWrapper(name = "sbxxs")
    @XmlElement(name = "sbxx")
    public List<Sbxx> getSbxxs() {
        return sbxxs;
    }

    public void setSbxxs(List<Sbxx> sbxxs) {
        this.sbxxs = sbxxs;
    }

    @XmlElementWrapper(name = "zsxxs")
    @XmlElement(name = "zsxx")
    public List<Zsxx> getZsxxs() {
        return zsxxs;
    }

    public void setZsxxs(List<Zsxx> zsxxs) {
        this.zsxxs = zsxxs;
    }

    public Cwxx getCwxxs() {
        return cwxxs;
    }

    public void setCwxxs(Cwxx cwxxs) {
        this.cwxxs = cwxxs;
    }

    @XmlElementWrapper(name = "wfwzs")
    @XmlElement(name = "wfwz")
    public List<Wfwz> getWfwzs() {
        return wfwzs;
    }

    public void setWfwzs(List<Wfwz> wfwzs) {
        this.wfwzs = wfwzs;
    }

    @XmlElementWrapper(name = "sqxxs")
    @XmlElement(name = "sqxx")
    public List<Sqxx> getSqxxs() {
        return sqxxs;
    }

    public void setSqxxs(List<Sqxx> sqxxs) {
        this.sqxxs = sqxxs;
    }

    public String getSpjg() {
        return spjg;
    }

    public void setSpjg(String spjg) {
        this.spjg = spjg;
    }

    public String getDkje() {
        return dkje;
    }

    public void setDkje(String dkje) {
        this.dkje = dkje;
    }

    public String getSpnr() {
        return spnr;
    }

    public void setSpnr(String spnr) {
        this.spnr = spnr;
    }

    public String getSprq() {
        return sprq;
    }

    public void setSprq(String sprq) {
        this.sprq = sprq;
    }

    public String getPch() {
        return pch;
    }

    public void setPch(String pch) {
        this.pch = pch;
    }

    public String getNsrsbh() {
        return nsrsbh;
    }

    public void setNsrsbh(String nsrsbh) {
        this.nsrsbh = nsrsbh;
    }

    public String getNsrmc() {
        return nsrmc;
    }

    public void setNsrmc(String nsrmc) {
        this.nsrmc = nsrmc;
    }

    public String getNsrlx() {
        return nsrlx;
    }

    public void setNsrlx(String nsrlx) {
        this.nsrlx = nsrlx;
    }

    public String getCxyf() {
        return cxyf;
    }

    public void setCxyf(String cxyf) {
        this.cxyf = cxyf;
    }
}
