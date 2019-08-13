package com.vz.model.credit.hubei.yizhangtong.body;

/** 违法违章信息
 * @ProjectName: bllose-utils
 * @Package: com.vz.model.credit.hubei.yizhangtong.body
 * @ClassName: Wfwz
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/12 17:02
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/12 17:02
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Wfwz {

    private String djrq; // 登记日期 2019-01-21
//<wfwzss><![CDATA[2018-12-01至2018-12-31逾期未缴纳税款]]></wfwzss>
    private String wfwzss; // 主要违法违章事实
    private String wfwzsd_dm; // 主要违法违章手段代码 050202
    private String wfwzsd_mc; // 主要违法违章手段名称 逾期未缴纳税款
    private String wfwzlx_dm; // 违法违章类型代码 05
    private String wfwzzt_dm; // 违法违章状态代码 38
    private String wfwzzt_mc; // 违法违章状态名称 处理完毕
    private String zfbz_1; // 作废标志 N
    private String zfrq_1; // 作废日期
//<zfrq_1 xsi:nil="true"/>
    private String ajly; // 案件来源 6
    private String jcajbz; // 稽查案件标志 N
    private String ssqjz_1; // 所属期止 2018-12-31

    public String getZfrq_1() {
        return zfrq_1;
    }

    public void setZfrq_1(String zfrq_1) {
        this.zfrq_1 = zfrq_1;
    }

    public String getDjrq() {
        return djrq;
    }

    public void setDjrq(String djrq) {
        this.djrq = djrq;
    }

    public String getWfwzss() {
        return wfwzss;
    }

    public void setWfwzss(String wfwzss) {
        this.wfwzss = wfwzss;
    }

    public String getWfwzsd_dm() {
        return wfwzsd_dm;
    }

    public void setWfwzsd_dm(String wfwzsd_dm) {
        this.wfwzsd_dm = wfwzsd_dm;
    }

    public String getWfwzsd_mc() {
        return wfwzsd_mc;
    }

    public void setWfwzsd_mc(String wfwzsd_mc) {
        this.wfwzsd_mc = wfwzsd_mc;
    }

    public String getWfwzlx_dm() {
        return wfwzlx_dm;
    }

    public void setWfwzlx_dm(String wfwzlx_dm) {
        this.wfwzlx_dm = wfwzlx_dm;
    }

    public String getWfwzzt_dm() {
        return wfwzzt_dm;
    }

    public void setWfwzzt_dm(String wfwzzt_dm) {
        this.wfwzzt_dm = wfwzzt_dm;
    }

    public String getWfwzzt_mc() {
        return wfwzzt_mc;
    }

    public void setWfwzzt_mc(String wfwzzt_mc) {
        this.wfwzzt_mc = wfwzzt_mc;
    }

    public String getZfbz_1() {
        return zfbz_1;
    }

    public void setZfbz_1(String zfbz_1) {
        this.zfbz_1 = zfbz_1;
    }

    public String getAjly() {
        return ajly;
    }

    public void setAjly(String ajly) {
        this.ajly = ajly;
    }

    public String getJcajbz() {
        return jcajbz;
    }

    public void setJcajbz(String jcajbz) {
        this.jcajbz = jcajbz;
    }

    public String getSsqjz_1() {
        return ssqjz_1;
    }

    public void setSsqjz_1(String ssqjz_1) {
        this.ssqjz_1 = ssqjz_1;
    }
}
