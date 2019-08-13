package com.vz.model.mq.common.two.body;

/**
 * @ProjectName: bllose-utils
 * @Package: com.vz.model.mq.common.two.body.orderinfo
 * @ClassName: ExcepData
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/1 15:38
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/1 15:38
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ExcepData implements Cloneable{

    private String excepCode;
    private String excepMsg;
    private String excepTime;
    private String nsrsbh;

    public String getExcepCode() {
        return excepCode;
    }

    public void setExcepCode(String excepCode) {
        this.excepCode = excepCode;
    }

    public String getExcepMsg() {
        return excepMsg;
    }

    public void setExcepMsg(String excepMsg) {
        this.excepMsg = excepMsg;
    }

    public String getExcepTime() {
        return excepTime;
    }

    public void setExcepTime(String excepTime) {
        this.excepTime = excepTime;
    }

    public String getNsrsbh() {
        return nsrsbh;
    }

    public void setNsrsbh(String nsrsbh) {
        this.nsrsbh = nsrsbh;
    }

    public ExcepData clone() {
        try {
            return (ExcepData) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
