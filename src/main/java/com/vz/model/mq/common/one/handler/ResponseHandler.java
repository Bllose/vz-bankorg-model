package com.vz.model.mq.common.one.handler;

import java.util.Date;

import com.vz.model.VzoomModelCloner;
import com.vz.model.enums.OrderEnum;
import com.vz.model.mq.common.one.FeedbackInfo;
import com.vz.model.mq.common.one.HeadResponse;
import com.vz.model.mq.common.one.OrderFlow;
import com.vz.model.mq.common.one.OrderUpdate;
import com.vz.model.mq.common.one.Response;

public class ResponseHandler {
	
	/**
	 * 反馈信息基础内容插入
	 * @param response
	 * @param nsrsbh
	 * @param proId 产品id
	 * @param orderStatus 订单状态
	 * <pre>
	 * 所谓的基础字段，即订单服务要求的必输字段
	 * </pre>
	 */
	public static void insertBaseFeedback(Response response,String nsrsbh, String proId, String orderStatus) {
		FeedbackInfo feedbackInfo = response.getBody().getFeedbackInfo();
		feedbackInfo.setNsrsbh(nsrsbh);
		feedbackInfo.setProId(proId);
		feedbackInfo.setOrderStatus(orderStatus);
	}
	
	/**
	 * 插入Response的Head部分
	 * <pre>
	 * 不想修改传null值就可以了
	 * </pre>
	 * @param response
	 * @param nsrsbh
	 * @param source
	 * @param actionName
	 */
	public static void fillHeadFields(Response response, String nsrsbh, String source, String actionName) {
		HeadResponse head = response.getHead();
		if(nsrsbh != null)head.setNsrsbh(nsrsbh);
		if(source != null)head.setSource(source);
		if(actionName != null)head.setActionName(actionName);
	}
	

	/**
	 * 创建一个针对仅反馈订单流水的反馈报文
	 * 
	 * @param actionName 必输项
	 * @param source 必输项
	 * @param nodeStatus 必输项 success|failed
	 * @param nodeDealResult 必输项
	 * @param nsrsbh 尽可能输入
	 * @param dataLevel 必输项，如果实在没有，就输入X
	 * @param serialNo 尽可能输入
	 * @param orderNo 尽可能输入
	 * @return reponse java 对象
	 */
	public static Response establishResponse4OrderFlowOnly(String actionName, String source,
			String nodeStatus, String nodeDealResult, String dataLevel, String nsrsbh,
			String serialNo, String orderNo) {
		Response response = VzoomModelCloner.getResponseClone();
		
		HeadResponse head = response.getHead();
		head.setActionName(actionName);
		head.setNsrsbh(nsrsbh);
		head.setSource(source);
		
		OrderFlow orderFlow = response.getBody().getOrderFlow();
		orderFlow.setDataLevel(dataLevel);
		orderFlow.setNodeStatus(nodeStatus);
		orderFlow.setNodeDealResult(nodeDealResult);
		orderFlow.setOrderNode(source);
		orderFlow.setSerialNo(serialNo);
		orderFlow.setOrderNo(orderNo);
		
		return response;
	}
	
	
	/**填充其他字段
	 * @param response 被填充对象
	 * @param dataLevel 数据等级，反馈给订单流水
	 * @param source	信息来源，本项目名称	
	 * @param postloanListId	贷后ID，贷后任务后用于通知贷后名单更新ID
	 * @param nsrsbh	纳税人识别号
	 * @param actionName推送队列的业务名称
	 * <pre>
	 * 此方法包含了head部分
	 * </pre>
	 */
	public static void fillRequiredFields(Response response, String dataLevel, String source,
			String postloanListId, String nsrsbh, String actionName) {
		OrderFlow flow = response.getBody().getOrderFlow();
		OrderUpdate update = response.getBody().getOrderUpdate();
		
		flow.setDataLevel(dataLevel);
		flow.setOrderNode(source);
		
//		update.setProId(proId);
		update.setPostloanListId(postloanListId);
		update.setOrderNode(source);
		
		HeadResponse head = response.getHead();
		head.setNsrsbh(nsrsbh);
		head.setSource(source);
		head.setActionName(actionName);
	}
	
	/**
	 * 插入基础数据
	 * @param response 待处理的response对象
	 * @param serialNo 业务流水号
	 * @param orderNo	订单号
	 * @param dealResult 节点处理结果（订单流水记录）,如果什么都不输入或者null则传：未知
	 * @param status	订单状态 2000|0000|9999
	 * @param notdStatus success|failed
	 */
	public static void insertBaseInfo(Response response, String serialNo, 
			String orderNo, String dealResult, String status, String noteStatus) {
		OrderFlow flow = response.getBody().getOrderFlow();
		OrderUpdate update = response.getBody().getOrderUpdate();
		
		//针对成功情况插入必输字段
		flow.setSerialNo(serialNo);
		flow.setOrderNo(orderNo);
		flow.setNodeStatus(noteStatus);
		flow.setNodeDealResult((null==dealResult || "".equals(dealResult))?"未知":dealResult);
		
		update.setSerialNo(serialNo);
		update.setOrderNo(orderNo);
		update.setOrderStatus(status);
		update.setUpdateTime(new Date());
	}
	
	
	/**
	 * 插入基础信息
	 * @param response
	 * @param serialNo
	 * @param orderNo
	 * @param dealResult
	 * @param status
	 */
	@Deprecated
	public static void insertBaseInfo(Response response, String serialNo, String orderNo, String dealResult, String status) {
		insertBaseInfo( response,  serialNo,  orderNo,  dealResult,  status, "success");
	}


	/**
	 * 请使用方法：{@code com.vz.model.mq.common.one.handler.ResponseHandler.insertBaseInfo(Response response, String serialNo, String orderNo, String dealResult, String status,String notdStatus) } 代替
	 * */
	@Deprecated
	public static void insertBaseSuccess(Response response, String serialNo, String orderNo){
		insertBaseSuccess( response,  serialNo,  orderNo, null);
	}
	
	/**
	 * 请使用方法：{@code com.vz.model.mq.common.one.handler.ResponseHandler.insertBaseInfo(Response response, String serialNo, String orderNo, String dealResult, String status,String notdStatus) } 代替
	 * */
	@Deprecated
	public static void insertBaseSuccess(Response response, String serialNo, String orderNo, String dealResult){
		OrderFlow flow = response.getBody().getOrderFlow();
		OrderUpdate update = response.getBody().getOrderUpdate();
		
		//针对成功情况插入必输字段
		flow.setSerialNo(serialNo);
		flow.setOrderNo(orderNo);
		flow.setNodeStatus("success");
		flow.setNodeDealResult((null==dealResult || "".equals(dealResult))?"未知":dealResult);
		
		update.setSerialNo(serialNo);
		update.setOrderNo(orderNo);
		update.setOrderStatus(OrderEnum.SUCCESS.getCode());
		update.setUpdateTime(new Date());
	}
	
	/**
	 * 请使用方法：{@code com.vz.model.mq.common.one.handler.ResponseHandler.insertBaseInfo(Response response, String serialNo, String orderNo, String dealResult, String status,String notdStatus) } 代替
	 * */
	@Deprecated
	public static void insertBaseError(Response response, String serialNo, String orderNo, String errorInfo){
		insertBaseError( response,  serialNo,  orderNo,  errorInfo, null);
	}
	
	/**
	 * 请使用方法：{@code com.vz.model.mq.common.one.handler.ResponseHandler.insertBaseInfo(Response response, String serialNo, String orderNo, String dealResult, String status,String notdStatus) } 代替
	 * */
	@Deprecated
	public static void insertBaseError(Response response, String serialNo, String orderNo, String errorInfo, String dealResult){
		OrderFlow flow = response.getBody().getOrderFlow();
		OrderUpdate update = response.getBody().getOrderUpdate();
		
		//针对失败况插入必输字段
		flow.setSerialNo(serialNo);
		flow.setOrderNo(orderNo);
		flow.setNodeStatus("failed");
		flow.setNodeDealResult(((null==dealResult||"".equals(dealResult))?"未知":dealResult)+errorInfo);
		
		update.setSerialNo(serialNo);
		update.setOrderNo(orderNo);
		update.setOrderStatus(OrderEnum.FAILED.getCode());
		update.setUpdateTime(new Date());
	}
	
}
