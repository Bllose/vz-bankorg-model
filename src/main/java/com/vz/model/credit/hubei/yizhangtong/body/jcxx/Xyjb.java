package com.vz.model.credit.hubei.yizhangtong.body.jcxx;

/**基础信息 -> 纳税人信用等级
 * @ProjectName: bllose-utils
 * @Package: com.vz.model.credit.hubei.yizhangtong.body.jcxx
 * @ClassName: Xyjb
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/12 17:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/12 17:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Xyjb {

    private String nsrxyjb_dm;  // 信用级别
    private String yxndq;       // 评定年度

    public String getNsrxyjb_dm() {
        return nsrxyjb_dm;
    }

    public void setNsrxyjb_dm(String nsrxyjb_dm) {
        this.nsrxyjb_dm = nsrxyjb_dm;
    }

    public String getYxndq() {
        return yxndq;
    }

    public void setYxndq(String yxndq) {
        this.yxndq = yxndq;
    }
}
