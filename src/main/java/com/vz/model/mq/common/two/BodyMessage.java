package com.vz.model.mq.common.two;

import com.vz.model.mq.common.two.body.*;


/**
 * MQ消息体部分
 * <pre>
 * 一个有效的订单信息至少包含如下信息:
 * <hr>
 * <ul>
 * <li>orderInfo
 * <ol>
 * 	<li>submitTime</li>
 * 	<li>proId</li>
 * 	<li>orderType(PRELOAN|POSTLOAN)</li>
 * 	<li>orderNo</li>
 * 	<li>nsrsbh</li>
 * 	<li>orderFrom 订单来源。报文服务在有的情况下是必输的</li>
 * </ol>
 * </li>
 * </ul>
 * </pre>
 *
 */
public class BodyMessage implements Cloneable{

	private DataQuailty dataQuality;
	private OrderInfoMessage orderInfo;
	private DataGram datagram;
	private ModelServer modelServer;
	private ModelXML modelXml;
	private OrderXml orderXml;
	private PdfGenerate pdfGenerate;
	private DataCheck dataCheck; // 质量服务处理对象
	private AnomalyTime anomalyTime; // 异常服务处理对象
	private ExcepData excepData;

	public BodyMessage clone() {
		try {
			BodyMessage body = (BodyMessage) super.clone();
			body.dataQuality = dataQuality.clone();
			body.datagram = datagram.clone();
			body.modelServer = modelServer.clone();
			body.modelXml = modelXml.clone();
			body.orderInfo = orderInfo.clone();
			body.orderXml = orderXml.clone();
			body.pdfGenerate = pdfGenerate.clone();
			body.dataCheck = dataCheck.clone();
			body.anomalyTime = anomalyTime.clone();
			body.excepData = excepData.clone();
			return body;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}	
	}

	public ExcepData getExcepData() {
		return excepData;
	}

	public void setExcepData(ExcepData excepData) {
		this.excepData = excepData;
	}

	public AnomalyTime getAnomalyTime() {
		return anomalyTime;
	}
	/**异常服务处理对象*/
	public void setAnomalyTime(AnomalyTime anomalyTime) {
		this.anomalyTime = anomalyTime;
	}

	public DataCheck getDataCheck() {
		return dataCheck;
	}
	/** 推送给质量服务，检查具体数据的质量，调用具体存储过程等
	 * */
	public void setDataCheck(DataCheck dataCheck) {
		this.dataCheck = dataCheck;
	}


	/**
	 * PDF文件生成路径
	 * @return
	 */
	public PdfGenerate getPdfGenerate() {
		return pdfGenerate;
	}
	public void setPdfGenerate(PdfGenerate pdfGenerate) {
		this.pdfGenerate = pdfGenerate;
	}
	
	
	/**
	 * 模型报文，由模型服务提供
	 * <pre>
	 * 针对需要模型结果的银行，模型服务提供模型报文
	 * </pre>
	 * @return
	 */
	public ModelXML getModelXml() {
		return modelXml;
	}
	public void setModelXml(ModelXML modelXml) {
		this.modelXml = modelXml;
	}
	
	/**
	 * 数据质量，由质量服务生成
	 * */
	public DataQuailty getDataQuality() {
		return dataQuality;
	}
	public void setDataQuality(DataQuailty dataQuality) {
		this.dataQuality = dataQuality;
	}
	
	/**
	 * 订单信息，由订单服务生成
	 * */
	public OrderInfoMessage getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(OrderInfoMessage orderInfo) {
		this.orderInfo = orderInfo;
	}
	
	/**
	 * 报文信息，由报文服务提供
	 * */
	public DataGram getDatagram() {
		return datagram;
	}
	public void setDatagram(DataGram datagram) {
		this.datagram = datagram;
	}
	
	public ModelServer getModelServer() {
		return modelServer;
	}
	/**
	 * 准入（模型）结果，由模型服务提供
	 * @param modelServer
	 */
	public void setModelServer(ModelServer modelServer) {
		this.modelServer = modelServer;
	}


	/**
	 * 订单信息，又订单服务提供
	 * @return
	 */
	public OrderXml getOrderXml() {
		return orderXml;
	}
	public void setOrderXml(OrderXml orderXml) {
		this.orderXml = orderXml;
	}
	
	
}
