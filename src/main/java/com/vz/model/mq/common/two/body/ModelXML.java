package com.vz.model.mq.common.two.body;

public class ModelXML implements Cloneable{

	private String modelXmlDetail;
	
	public ModelXML clone() {
		ModelXML modelXml = null;
		try {
			modelXml =  (ModelXML) super.clone();
//			modelXml.modelXmlDetail = modelXmlDetail.clone();
			return modelXml;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}		
	}

	public String getModelXmlDetail() {
		return modelXmlDetail;
	}

	public void setModelXmlDetail(String modelXmlDetail) {
		this.modelXmlDetail = modelXmlDetail;
	}

//	public ModelXmlDetail getModelXmlDetail() {
//		return modelXmlDetail;
//	}
//
//	public void setModelXmlDetail(ModelXmlDetail modelXmlDetail) {
//		this.modelXmlDetail = modelXmlDetail;
//	}
	
	
}
