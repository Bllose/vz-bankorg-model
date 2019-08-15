package com.vz.model.mq.common.two.body;

/**
 * 大采集处理内容
 * @ProjectName: vz-bankorg-model
 * @Package: com.vz.model.mq.common.two.body
 * @ClassName: Collect
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/15 11:19
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/15 11:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Collect implements Cloneable{

    private String nsrsbh;
    private String dataType;

    public Collect clone() {
        try {
            return (Collect) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getNsrsbh() {
        return nsrsbh;
    }

    public void setNsrsbh(String nsrsbh) {
        this.nsrsbh = nsrsbh;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
