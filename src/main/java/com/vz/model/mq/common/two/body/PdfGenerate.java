package com.vz.model.mq.common.two.body;

public class PdfGenerate implements Cloneable{

	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public PdfGenerate clone() {
		try {
			return (PdfGenerate) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}	
	}
}
