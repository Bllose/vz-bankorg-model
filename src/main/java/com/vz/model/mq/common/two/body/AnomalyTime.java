package com.vz.model.mq.common.two.body;

/**
 * @ProjectName: bllose-utils
 * @Package: com.vz.model.mq.common.two.body
 * @ClassName: AnomalyTime
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/1 14:06
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/1 14:06
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 *
 */
public class AnomalyTime implements Cloneable{

    private String source;      // 消息来源，比如：hbzb_collect_server
    private String nsrsbh;
    private String sign;        // 系统编号，比如：ZX_HBGS_ZBYH
    private String startTime;   //yyyy-MM-dd HH:mm:ss 业务执行开始时间
    private String endTime;     // 业务执行完成时间
    private String invokeTime;  // 业务执行总耗时


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getNsrsbh() {
        return nsrsbh;
    }

    public void setNsrsbh(String nsrsbh) {
        this.nsrsbh = nsrsbh;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getInvokeTime() {
        return invokeTime;
    }

    public void setInvokeTime(String invokeTime) {
        this.invokeTime = invokeTime;
    }

    public AnomalyTime clone() {
        try {
            return (AnomalyTime) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
