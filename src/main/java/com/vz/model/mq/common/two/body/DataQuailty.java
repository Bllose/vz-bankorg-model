package com.vz.model.mq.common.two.body;

import java.util.HashMap;

/**
 * 数据质量服务提供
 * <pre>
 * 用以描述当前业务请求的数据质量要求
 * </pre>
 * @author Administrator
 */
public class DataQuailty implements Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dataLevel;

	public String getDataLevel() {
		return dataLevel;
	}

	public void setDataLevel(String dataLevel) {
		this.dataLevel = dataLevel;
	}
	
	public DataQuailty clone() {
		try {
			return (DataQuailty) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
