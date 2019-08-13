package com.vz.model.bank.ningbo.push.handler;

//import com.vz.model.VzoomModelIniter;
//import com.vz.model.bank.ningbo.push.TiripPackage;
//import com.vz.model.utils.JaxbUtil;

public class NbModelHandler {

//	private static String getInitReport() {
//		return jaxb.toXml(VzoomModelIniter.getDeepInitialization(TiripPackage.class), "utf-8");
//	}
	
	public static String getReportXml(String taxDetail) {
//		if(null == initedReport) {
//			initedReport = getInitReport();
//		}
//		return initedReport.replace("<Transaction/>", taxDetail);
		
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		sb.append("<tiripPackage>");
		sb.append("<Transaction>");
		sb.append("<businessContent>");
		sb.append(taxDetail);
		sb.append("</businessContent>");
		sb.append("</Transaction>");
		sb.append("</tiripPackage>");
		
		return new String(sb);
	}
	
//	public static String initedReport;
	
//	private static JaxbUtil jaxb = new JaxbUtil(TiripPackage.class);
	
//	public static void main(String[] args) {
//		System.out.println(getReportXml("7538921y8923yh59"));
//	}
}
