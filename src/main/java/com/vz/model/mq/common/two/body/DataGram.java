package com.vz.model.mq.common.two.body;

import com.vz.model.mq.common.two.body.datagram.BaseInfo;
import com.vz.model.mq.common.two.body.datagram.GlobalInfo;

/**
 * 报文服务提供相关内容
 * @author Administrator
 *
 */
public class DataGram implements Cloneable{

	private BaseInfo baseInfo;
	private GlobalInfo globalInfo;
	public BaseInfo getBaseInfo() {
		return baseInfo;
	}
	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}
	public GlobalInfo getGlobalInfo() {
		return globalInfo;
	}
	public void setGlobalInfo(GlobalInfo globalInfo) {
		this.globalInfo = globalInfo;
	}
	
	public DataGram clone() {
		DataGram datagram = null;;
		try {
			datagram = (DataGram) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
		datagram.baseInfo = baseInfo.clone();
		datagram.globalInfo = globalInfo.clone();
		return datagram;
	}
	
}
