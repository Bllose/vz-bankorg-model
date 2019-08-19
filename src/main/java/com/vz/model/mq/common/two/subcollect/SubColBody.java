package com.vz.model.mq.common.two.subcollect;

import com.vz.model.mq.common.two.body.AnomalyTime;
import com.vz.model.mq.common.two.body.DataCheck;
import com.vz.model.mq.common.two.body.ExcepData;

/**子采集用于推送MQ消息的对象
 * @ProjectName: vz-bankorg-model
 * @Package: com.vz.model.mq.common.two.subcollect
 * @ClassName: SubColBody
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/19 9:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/19 9:23
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SubColBody implements Cloneable{

    private DataCheck dataCheck; // 质量服务处理对象
    private AnomalyTime anomalyTime; // 异常服务处理对象
    private ExcepData excepData; // 异常服务处理对象

    /**初始化body部分，重新拿原始的复制对象顶替目前内存中的body内的对象*/
    public void init(){
        this.dataCheck = dataCheck.clone();
        this.anomalyTime = anomalyTime.clone();
        this.excepData = excepData.clone();
    }

    public SubColBody clone(){
        try {
            SubColBody body = (SubColBody) super.clone();
            this.dataCheck = dataCheck.clone();
            this.anomalyTime = anomalyTime.clone();
            this.excepData = excepData.clone();
            return body;
        } catch (CloneNotSupportedException e) {
            System.err.println("子采集的消息体创建拷贝对象异常失败!");
            e.printStackTrace();
            return null;
        }
    }

    public DataCheck getDataCheck() {
        return dataCheck;
    }

    public void setDataCheck(DataCheck dataCheck) {
        this.dataCheck = dataCheck;
    }

    public AnomalyTime getAnomalyTime() {
        return anomalyTime;
    }

    public void setAnomalyTime(AnomalyTime anomalyTime) {
        this.anomalyTime = anomalyTime;
    }

    public ExcepData getExcepData() {
        return excepData;
    }

    public void setExcepData(ExcepData excepData) {
        this.excepData = excepData;
    }
}
