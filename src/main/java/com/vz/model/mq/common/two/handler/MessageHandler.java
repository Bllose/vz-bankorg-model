package com.vz.model.mq.common.two.handler;

import com.vz.model.VzoomModelCloner;
import com.vz.model.mq.common.two.BodyMessage;
import com.vz.model.mq.common.two.HeadMessage;
import com.vz.model.mq.common.two.MQMessage;
import com.vz.model.mq.common.two.body.DataGram;
import com.vz.model.mq.common.two.body.DataQuailty;
import com.vz.model.mq.common.two.body.ModelServer;
import com.vz.model.mq.common.two.body.ModelXML;
import com.vz.model.mq.common.two.body.OrderInfoMessage;
import com.vz.model.mq.common.two.body.OrderXml;
import com.vz.model.mq.common.two.body.PdfGenerate;
import com.vz.model.mq.common.two.body.datagram.BaseInfo;
import com.vz.model.mq.common.two.body.datagram.GlobalInfo;
import com.vz.model.mq.common.two.body.modelXml.ModelXmlDetail;
import com.vz.model.validate.ValidatorUtils;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.validator.constraints.NotBlank;

import com.alibaba.fastjson.JSONObject;

public class MessageHandler {
	
	/**
	 * 组装一个异常重发的Message
	 * @param mqMessageRecord 从记录中获取的MQ消息
	 * @param actionName 需要推送的MQ消息头中 actionName
	 * @param source 需要推送的MQ消息头中 SOURCE
	 * @return
	 */
	public static MQMessage establishMessage2Resend(MQMessage mqMessageRecord, 
			String actionName, String source) {
		
		logger.debug("尝试制作异常重发的订单报文...");
		MQMessage mqMessage = VzoomModelCloner.getMQMessageClone();
		
		OrderInfoMessage orderInfo = mqMessageRecord.getBody().getOrderInfo();
		String proId = orderInfo.getProId();
		
		orderInfo.setProId(proId+"_rewire");
		// 将缓存的订单信息导入重发信息中
		BodyMessage body = mqMessage.getBody();
		body.setOrderInfo(orderInfo);
		
		// message head 制作
		HeadMessage head = mqMessage.getHead();
		head.setActionName(actionName);
		head.setNsrsbh(orderInfo.getNsrsbh());
		head.setSource(source);
		
		/*
		 * 屏蔽其他节点
		 * */
		body.setDatagram(null);
		body.setDataQuality(null);
		body.setModelServer(null);
		body.setModelXml(null);
		body.setOrderXml(null);
		body.setPdfGenerate(null);
		
		return mqMessage;
	}
	

	/**组装一个最基础的有效订单请求
	 * @param mqMessage 被填充的MQ消息对象，不能为null!
	 * @param actionName
	 * @param nsrsbh
	 * @param orderNo
	 * @param orderType 订单类型，目前已知的类型包括:PRELOAN|POSTLOAN
	 * @param proId 产品编号
	 */
	public static void insertBaseOrderRequest(MQMessage mqMessage, String actionName, String nsrsbh,
			String orderNo, String serialNo, String orderType, String proId) {
		if(null == mqMessage) {
			logger.error("请输入一个MQ消息对象!");
			return;
		}
		HeadMessage head = mqMessage.getHead();
		if(null == head) {
			head = new HeadMessage();
			mqMessage.setHead(head);
		}		
		head.setActionName(actionName);
		head.setNsrsbh(nsrsbh);
		
		
		BodyMessage body = mqMessage.getBody();
		if(null == body) {
			body = new BodyMessage();
			mqMessage.setBody(body);
		}
		OrderInfoMessage orderInfo = body.getOrderInfo();
		if(null == orderInfo) {
			orderInfo = new OrderInfoMessage();
			body.setOrderInfo(orderInfo);
		}
		
		orderInfo.setNsrsbh(nsrsbh);
		orderInfo.setSubmitTime(new Date());
		orderInfo.setOrderNo(orderNo);
		orderInfo.setOrderType(orderType);
		orderInfo.setProId(proId);
		orderInfo.setProductId(proId);
		orderInfo.setSerialNo(serialNo);
	}

	public static MQMessage transferMessage(String message) {
		
		// MQMessage mqMessage = JSONObject.parseObject(message, MQMessage.class);
		
//		Map<String,String> validateResultMap = ValidatorUtils.validate(mqMessage);
//		if(null == validateResultMap || validateResultMap.isEmpty()	) {
//			logger.debug("MQ消息必要参数齐全...");
//		}else {
//			Set<Entry<String, String>> sets = validateResultMap.entrySet();
//			for(Entry<String,String> entry : sets) {
//				logger.info("检测到问题：{}, 详情：{}", entry.getKey(), entry.getValue());
//			}
//		}
		
		return JSONObject.parseObject(message, MQMessage.class);
	}
	
	
	public static OrderInfoMessage getOrderInfo(@Valid MQMessage mqMessage) {
		if(null == mqMessage) {
			logger.warn("MQ消息为空，无法获取订单信息!");
			return null;
		}
		
		BodyMessage body = null;
		if(null == (body = mqMessage.getBody())) {
			logger.warn("MQ消息的body没有数据，无法获取订单信息!");
			return null;
		}
		
		return body.getOrderInfo();
	}
	
	
	
	/*
	 * 以下部分直接从MQ消息中提取某个值
	 * 适合过程中提取一个值时使用
	 * */
	public static String getNsrsbh(MQMessage mqMessage) {
		if(null == mqMessage) {
			logger.warn("MQ消息为空，无法获取纳税人识别号!");
			return null;
		}
		
		BodyMessage body = null;
		if(null == (body = mqMessage.getBody())) {
			logger.warn("MQ消息的body没有数据，无法获取纳税人识别号!");
			return null;
		}
		
		OrderInfoMessage orderInfo = null;
		if(null == (orderInfo = body.getOrderInfo())) {
			logger.warn("MQ消息缺少订单信息，无法获取纳税人识别号!");
			return null;
		}
		
		return orderInfo.getNsrsbh();
	}
	
	/**
	 * 获取贷后ID
	 * @param mqMessage
	 * @return
	 */
	public static String getPostloanListId(MQMessage mqMessage) {
		if(null == mqMessage) {
			logger.warn("MQ消息为空，无法获取贷后ID!");
			return null;
		}
		
		BodyMessage body = null;
		if(null == (body = mqMessage.getBody())) {
			logger.warn("MQ消息的body没有数据，无法获取贷后ID!");
			return null;
		}
		
		OrderInfoMessage orderInfo = null;
		if(null == (orderInfo = body.getOrderInfo())) {
			logger.warn("MQ消息缺少订单信息，无法获取贷后ID!");
			return null;
		}
		
		return orderInfo.getPostloanListId();
	}
	
	public static String getProId(MQMessage mqMessage) {
		if(null == mqMessage) {
			logger.warn("MQ消息为空，无法获取业务ID!");
			return null;
		}
		
		BodyMessage body = null;
		if(null == (body = mqMessage.getBody())) {
			logger.warn("MQ消息的body没有数据，无法获取业务ID!");
			return null;
		}
		
		OrderInfoMessage orderInfo = null;
		if(null == (orderInfo = body.getOrderInfo())) {
			logger.warn("MQ消息缺少订单信息，无法获取业务ID!");
			return null;
		}
		
		return orderInfo.getProId();
	}
	
	/**
	 * 获取订单信息中的批次号
	 * <pre>
	 * 此字段由贷后服务，将postloan_list表中的yf字段，转化为pch字段 
	 * </pre>
	 * @param mqMessage
	 * @return
	 */
	public static String getPCH(MQMessage mqMessage) {
		if(null == mqMessage) {
			logger.warn("MQ消息为空，无法获取批次号!");
			return null;
		}
		
		BodyMessage body = null;
		if(null == (body = mqMessage.getBody())) {
			logger.warn("MQ消息的body没有数据，无法获取批次号!");
			return null;
		}
		
		OrderInfoMessage orderInfo = null;
		if(null == (orderInfo = body.getOrderInfo())) {
			logger.warn("MQ消息缺少订单信息，无法获取批次号!");
			return null;
		}
		
		return orderInfo.getPch();
	}
	
	/**
	 * 尝试获取认证时间
	 * @param mqMessage
	 * @return
	 */
	public static Date getSubmitTime(MQMessage mqMessage) {
		if(null == mqMessage) {
			logger.warn("MQ消息为空，无法获认证时间!");
			return null;
		}
		
		BodyMessage body = null;
		if(null == (body = mqMessage.getBody())) {
			logger.warn("MQ消息的body没有数据，无法获取认证时间!");
			return null;
		}
		
		OrderInfoMessage orderInfo = null;
		if(null == (orderInfo = body.getOrderInfo())) {
			logger.warn("MQ消息缺少订单信息，无法获取认证时间!");
			return null;
		}
		
		return orderInfo.getSubmitTime();
	}
	
	/**
	 * 获取MQ消息中GlobalInfo中的税务数据taxDetail
	 * */
	public static String getGlobalInfo(MQMessage mqMessage) {
		if(null == mqMessage) {
			logger.warn("MQ消息为空，无法获取全量数据!");
			return null;
		}
		
		BodyMessage body = null;
		if(null == (body = mqMessage.getBody())) {
			logger.warn("MQ消息的body没有数据，无法获取全量数据!");
			return null;
		}
		
		DataGram dataGram = null;
		if(null == (dataGram = body.getDatagram())) {
			logger.warn("MQ消息缺少报文信息，无法获取全量数据!");
			return null;
		}
		
		GlobalInfo globalInfo = null;
		if(null == (globalInfo = dataGram.getGlobalInfo())){
			logger.warn("MQ消息缺少全量报文数据，无法获取全量数据!");
			return null;
		}
		
		return String.valueOf(globalInfo.getTaxDetail());
	}
	
	/**
	 * 获取MQ消息中BaseInfo中的税务数据taxDetail
	 * @param mqMessage
	 * @return
	 */
	public static String getBaseInfo(MQMessage mqMessage) {
		if(null == mqMessage) {
			logger.warn("MQ消息为空，无法获取基础数据!");
			return null;
		}
		
		BodyMessage body = null;
		if(null == (body = mqMessage.getBody())) {
			logger.warn("MQ消息的body没有数据，无法获取基础数据!");
			return null;
		}
		
		DataGram dataGram = null;
		if(null == (dataGram = body.getDatagram())) {
			logger.warn("MQ消息缺少报文信息，无法获取基础数据!");
			return null;
		}
		
		BaseInfo baseInfo = null;
		if(null == (baseInfo = dataGram.getBaseInfo())){
			logger.warn("MQ消息缺少基础报文数据，无法获取基础数据!");
			return null;
		}
		
		return String.valueOf(baseInfo.getTaxDetail());
	}
	
	
	/**
	 * 获取报文服务组装的订单报文
	 * @param mqMessage
	 * @return
	 */
	public static String getOrderDetailFromGlobalInfo(MQMessage mqMessage) {
		if(null == mqMessage) {
			logger.warn("MQ消息为空，无法获取订单报文数据!");
			return null;
		}
		
		BodyMessage body = null;
		if(null == (body = mqMessage.getBody())) {
			logger.warn("MQ消息的body没有数据，无法获取订单报文数据!");
			return null;
		}
		DataGram dataGram = null;
		if(null == (dataGram = body.getDatagram())) {
			logger.warn("MQ消息dataGram为空，无法获取订单报文数据!");
			return null;
		}
		
		GlobalInfo globalInfo = null;
		if(null == ( globalInfo = dataGram.getGlobalInfo())) {
			logger.warn("MQ消息globalInfo为空，无法获取订单报文数据!");
			return null;
		}
		
		return globalInfo.getOrderDetail();
	}
	
	
	public static String getOrderXml(MQMessage mqMessage) {
		if(null == mqMessage) {
			logger.warn("MQ消息为空，无法获取订单XML报文数据!");
			return null;
		}
		
		BodyMessage body = null;
		if(null == (body = mqMessage.getBody())) {
			logger.warn("MQ消息的body没有数据，无法获取订单XML报文数据!");
			return null;
		}
		
		OrderXml orderXml = null;
		if(null == (orderXml = body.getOrderXml())) {
			logger.warn("body内缺少订单XML信息，无法获取订单XML报文数据!");
			return null;
		}
		
		return orderXml.getOrderXmlDetail();
	}
	
	
	/**
	 * 获取模型结果
	 * @param mqMessage
	 * @return
	 */
	public static String getPreAccess(MQMessage mqMessage) {
		if(null == mqMessage) {
			logger.warn("MQ消息为空，无法获取模型结果!");
			return null;
		}
		
		BodyMessage body = null;
		if(null == (body = mqMessage.getBody())) {
			logger.warn("MQ消息的body没有数据，无法获取模型结果!");
			return null;
		}
		
		ModelServer modelServer = null;
		if(null == (modelServer = body.getModelServer())) {
			logger.warn("body内缺少模型结果信息，无法获取模型结果!");
			return null;
		}
		
		return modelServer.getPreAccess();
	}
	
	
	/**
	 * 获取准入结果
	 * @param mqMessage
	 * @return
	 */
	public static String getPreAccessDesc(MQMessage mqMessage) {
		if(null == mqMessage) {
			logger.warn("MQ消息为空，无法获取模型结果!");
			return null;
		}
		
		BodyMessage body = null;
		if(null == (body = mqMessage.getBody())) {
			logger.warn("MQ消息的body没有数据，无法获取模型结果!");
			return null;
		}
		
		ModelServer modelServer = null;
		if(null == (modelServer = body.getModelServer())) {
			logger.warn("body内缺少模型结果信息，无法获取模型结果!");
			return null;
		}
		
		return modelServer.getPreAccessDesc();
	}
	
	
	/**
	 * 获取预授信额度
	 * @param mqMessage
	 * @return
	 */
	public static String getPreAccessAmount(MQMessage mqMessage) {
		if(null == mqMessage) {
			logger.warn("MQ消息为空，无法获取模型结果!");
			return null;
		}
		
		BodyMessage body = null;
		if(null == (body = mqMessage.getBody())) {
			logger.warn("MQ消息的body没有数据，无法获取模型结果!");
			return null;
		}
		
		ModelServer modelServer = null;
		if(null == (modelServer = body.getModelServer())) {
			logger.warn("body内缺少模型结果信息，无法获取模型结果!");
			return null;
		}
		
		return modelServer.getCreditAmount();
	}
	
	/**
	 * 获取预授信额度(区间)
	 * @param mqMessage
	 * @return
	 */
	public static String getPreCreditAmountRange(MQMessage mqMessage) {
		if(null == mqMessage) {
			logger.warn("MQ消息为空，无法获取预授信额度(区间)!");
			return null;
		}
		
		BodyMessage body = null;
		if(null == (body = mqMessage.getBody())) {
			logger.warn("MQ消息的body没有数据，无法获取预授信额度(区间)!");
			return null;
		}
		
		ModelServer modelServer = null;
		if(null == (modelServer = body.getModelServer())) {
			logger.warn("body内缺少模型结果信息，无法获取预授信额度(区间)!");
			return null;
		}
		
		return modelServer.getPreCreditAmountRange();
	}
	
	/**
	 * 获取模型结果报文
	 * <pre>
	 * 典型的就是微众银行推送报文中的 authz节点
	 * </pre>
	 * @param mqMessage
	 * @return
	 */
	public static String getModelXml(MQMessage mqMessage) {
		if(null == mqMessage) {
			logger.warn("MQ消息为空，无法获取模型报文!");
			return null;
		}
		
		BodyMessage body = null;
		if(null == (body = mqMessage.getBody())) {
			logger.warn("MQ消息的body没有数据，无法获取模型报文!");
			return null;
		}
		
		ModelXML modelXml = null;
		if(null == (modelXml = body.getModelXml())) {
			logger.warn("body内缺少模型结果信息，无法获取模型报文!");
			return null;
		}
		
//		ModelXmlDetail modelXmlDetail = null;
//		if(null == (modelXmlDetail = modelXml.getModelXmlDetail())) {
//			logger.warn("body内缺少模型结果信息，无法获取模型结果!");
//			return null;
//		}
		
		return modelXml.getModelXmlDetail();
	} 
	
	public static String getDataLevel(MQMessage mqMessage) {
		if(null == mqMessage) {
			logger.warn("MQ消息为空，无法获取数据等级!");
			return null;
		}
		
		BodyMessage body = null;
		if(null == (body = mqMessage.getBody())) {
			logger.warn("MQ消息的body没有数据，无法获取数据等级!");
			return null;
		}
		
		DataQuailty quailty = null;
		if(null == (quailty = body.getDataQuality())) {
			logger.warn("body内的数据等级没有数据，无法获取数据等级!");
			return null;
		}
		
		return quailty.getDataLevel();
	}
	
	/**
	 * 获取MQ消息中，PDF下载路径
	 * @param mqMessage
	 * @return
	 */
	public static String getPdfInfo(MQMessage mqMessage) {
		if(null == mqMessage) {
			logger.warn("MQ消息为空，无法获取PDF获取地址!");
			return null;
		}
		
		BodyMessage body = null;
		if(null == (body = mqMessage.getBody())) {
			logger.warn("MQ消息的body没有数据，无法获取PDF获取地址!");
			return null;
		}
		
		PdfGenerate pdfGenerate = null;
		if(null == (pdfGenerate = body.getPdfGenerate())) {
			logger.warn("body内的PDF节点没有数据，无法获取PDF获取地址!");
			return null;
		}
		return pdfGenerate.getPath();
	}
	
	/**
	 * 获取head中的actionName
	 * @param message
	 * @return
	 */
	public static String getActionName(MQMessage mqMessage) {
		if(null == mqMessage) {
			logger.warn("MQ消息为空，无法获取ActionName!");
			return null;
		}
		
		HeadMessage head = null;
		if(null == (head = mqMessage.getHead())) {
			logger.warn("MQ消息的head没有数据，无法获取ActionName!");
			return null;
		}
		return head.getActionName();
	}
	


	
	private static final Logger logger = LogManager.getLogger(MessageHandler.class);



}
