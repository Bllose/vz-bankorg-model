package com.vz.model.mq.common.two.handler;

import com.vz.model.mq.common.two.HeadMessage;
import com.vz.model.mq.common.two.MQMessage;
import com.vz.model.mq.common.two.body.AnomalyTime;
import com.vz.model.mq.common.two.body.DataCheck;
import com.vz.model.mq.common.two.body.ExcepData;
import com.vz.model.mq.common.two.subcollect.SubColMqMessage;

/** 针对子采集发送消息的创建方法
 * @ProjectName: vz-bankorg-model
 * @Package: com.vz.model.mq.common.two.handler
 * @ClassName: SubColMessagerBuilder
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/19 9:37
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/19 9:37
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SubColMessagerBuilder {
    /**制作发送给数据质量的MQ报文对象
     * <pre>
     * </pre>
     * @author Administrator
     * @createTime 2019/8/1
     * @description
     * @param actionName 标记服务名称
     * @param source 请求来源
     * @param areaCode 地区码
     * @param preLevel 预等级
     * @param procedureNames 指定需要执行的所有存储过程名称，以分号(;)分割
     * */
    public static void message2DataCheck(SubColMqMessage mqMessage, String actionName, String source, String nsrsbh,
                                         String areaCode, String preLevel, String procedureNames){
        HeadMessage head = mqMessage.getHead();
        head.setActionName(actionName);
        head.setNsrsbh(nsrsbh);
        head.setSource(source);

        DataCheck dataCheck = mqMessage.getBody().getDataCheck();
        dataCheck.setAreaCode(areaCode);
        dataCheck.setNsrsbh(nsrsbh);
        dataCheck.setPreLever(preLevel);
        dataCheck.setProcedureNames(procedureNames);
    }

    /** 制作推送给异常服务的消息对象
     * <pre>
     * </pre>
     * @author Administrator
     * @createTime 2019/8/1
     * @description
     * @param  source 消息来源
     * @param actionName 服务所提供的actionName
     * @param systemSign 系统标示符, PS:ZX_HBGS_ZBYH
     * @param startTime 业务执行开始时间 yyyyMMdd HH:mm:ss
     * @param endTime 业务执行完成时间
     * @param invokeTime 业务总耗时
     * */
    public static void message2ExceptionServer(SubColMqMessage mqMessage, String source, String actionName,
                                               String systemSign, String nsrsbh,  String startTime,
                                               String endTime, String invokeTime){
        HeadMessage head = mqMessage.getHead();
        head.setSource(source);
        head.setNsrsbh(nsrsbh);
        head.setActionName(actionName);

        AnomalyTime anomalyTime = mqMessage.getBody().getAnomalyTime();
        anomalyTime.setSource(source);
        anomalyTime.setSign(systemSign);
        anomalyTime.setNsrsbh(nsrsbh);
        anomalyTime.setStartTime(startTime);
        anomalyTime.setEndTime(endTime);
        anomalyTime.setInvokeTime(invokeTime);
    }

    /**失败任务通知异常服务
     * <pre>
     * </pre>
     * @author Administrator
     * @createTime 2019/8/1
     * @description
     * @param time 异常发生时间 yyyy-MM-dd HH:mm:ss
     * @param errorCode 异常编码
     * @param errorMsg 异常信息
     * @param source 消息来源
     * @param actionName 服务提供的actionName
     * */
    public static void errorMessage2ExceptionServer(SubColMqMessage mqMessage, String source, String nsrsbh, String actionName,
                                                    String time, String errorCode, String errorMsg){
        HeadMessage head = mqMessage.getHead();
        head.setSource(source);
        head.setNsrsbh(nsrsbh);
        head.setActionName(actionName);

        ExcepData excepData = mqMessage.getBody().getExcepData();
        excepData.setNsrsbh(nsrsbh);
        excepData.setExcepTime(time);// yyyy-MM-dd HH:mm:ss
        excepData.setExcepCode(errorCode);
        excepData.setExcepMsg(errorMsg);
    }
}
