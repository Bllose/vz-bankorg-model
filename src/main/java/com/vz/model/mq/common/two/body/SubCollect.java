package com.vz.model.mq.common.two.body;

import java.util.Date;

/**
 * 子采集处理对象
 * @ProjectName: vz-bankorg-model
 * @Package: com.vz.model.mq.common.two.body
 * @ClassName: SubCollect
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/15 11:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/15 11:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SubCollect implements Cloneable{

    private Date createtime;
    private String flag;
    private String id;
    private String nsrsbh;
    private String remark;
    private String sign;

    public SubCollect clone(){
        try {
            return (SubCollect) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNsrsbh() {
        return nsrsbh;
    }

    public void setNsrsbh(String nsrsbh) {
        this.nsrsbh = nsrsbh;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
