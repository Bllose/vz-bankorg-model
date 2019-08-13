package com.vz.model.credit.hubei.yizhangtong.body.jcxx;

/**基础信息 -> 变更登记明细
 * @ProjectName: bllose-utils
 * @Package: com.vz.model.credit.hubei.yizhangtong.body.jcxx
 * @ClassName: Bgdjmx
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/12 17:07
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/12 17:07
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Bgdjmx {

    private String lrrq; // 录入日期 2017-11-10 14:38:23
    private String bghnr; // 变更后内容
    private String bgqnr; // 变更前内容
    private String bgxm_dm;// 变更项目代码

    public String getLrrq() {
        return lrrq;
    }

    public void setLrrq(String lrrq) {
        this.lrrq = lrrq;
    }

    public String getBghnr() {
        return bghnr;
    }

    public void setBghnr(String bghnr) {
        this.bghnr = bghnr;
    }

    public String getBgqnr() {
        return bgqnr;
    }

    public void setBgqnr(String bgqnr) {
        this.bgqnr = bgqnr;
    }

    public String getBgxm_dm() {
        return bgxm_dm;
    }

    public void setBgxm_dm(String bgxm_dm) {
        this.bgxm_dm = bgxm_dm;
    }
}
