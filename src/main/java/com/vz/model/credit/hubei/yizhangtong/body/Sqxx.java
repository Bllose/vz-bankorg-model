package com.vz.model.credit.hubei.yizhangtong.body;

/**查询"申请信息"时返回结果对象
 * @ProjectName: bllose-utils
 * @Package: com.vz.model.credit.hubei.yizhangtong.body
 * @ClassName: Sqxx
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/6 17:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/6 17:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Sqxx {

    private String pch;     // PS: 8DDC1F0319053D7BE0537F1C10946A18
    private String nsrsbh;
    private String nsrmc;
    private String nsrlx;
    private String lxdh;    // 联系电话
    private String sqsj;    // 申请时间 PS:2019-05-11 16:51:05

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

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getSqsj() {
        return sqsj;
    }

    public void setSqsj(String sqsj) {
        this.sqsj = sqsj;
    }
}
