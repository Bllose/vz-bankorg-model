package com.vz.model.mq.common.two.body.modelXml;

public class ModelXmlDetail implements Cloneable{

	private String authz;

	public String getAuthz() {
		return authz;
	}

	public void setAuthz(String authz) {
		this.authz = authz;
	}
	
	public ModelXmlDetail clone() {
		try {
			return (ModelXmlDetail) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
