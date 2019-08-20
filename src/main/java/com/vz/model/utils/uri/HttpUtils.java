package com.vz.model.utils.uri;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <pre>
 * 传输XML请求报文时。通常数据类型（Content-Type）为：application/xml和text/xml 
 * 
 * 其中application/xml使用的是XML报文头中的编码，
 * 比如：<?xml version="1.0" encoding="utf-8"?>，报文使用的就是utf-8
 * 
 * text/xml采用的是us-ascii编码
 * =======================================================================
 * =======================================================================
 * 
 * 传输JSON报文时，数据类型为：text/json
 * </pre>
 * */
public class HttpUtils {
	private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);
	private static int connectTimeOut = 5000;
	private static int readTimeOut = 50000;
	private static String requestEncoding = "UTF-8";

	public static int getConnectTimeOut() {
		return connectTimeOut;
	}

	public static void setConnectTimeOut(int connectTimeOut) {
		HttpUtils.connectTimeOut = connectTimeOut;
	}

	public static int getReadTimeOut() {
		return readTimeOut;
	}

	public static void setReadTimeOut(int readTimeOut) {
		HttpUtils.readTimeOut = readTimeOut;
	}

	public static String getRequestEncoding() {
		return requestEncoding;
	}

	public static void setRequestEncoding(String requestEncoding) {
		HttpUtils.requestEncoding = requestEncoding;
	}

	public static String doGet(String requrl, Map<?, ?> parameters, String recvEndcoding) {
		HttpURLConnection url_con = null;
		String responseContent = null;
		String vchartset = recvEndcoding == "" ? HttpUtils.requestEncoding : recvEndcoding;
		try {
			StringBuffer params = new StringBuffer();
			for (Iterator<?> iter = parameters.entrySet().iterator(); iter.hasNext();) {
				Entry<?, ?> element = (Entry<?, ?>) iter.next();
				params.append(element.getKey().toString());
				params.append("=");
				params.append(URLEncoder.encode(element.getValue().toString(), vchartset));
				params.append("&");
			}
			if (params.length() > 0) {
				params = params.deleteCharAt(params.length() - 1);
			}
			URL url = new URL(requrl);
			url_con = (HttpURLConnection) url.openConnection();
			url_con.setRequestMethod("GET");
			System.setProperty("462743247", String.valueOf(HttpUtils.connectTimeOut));
			System.setProperty("48921742314", String.valueOf(HttpUtils.readTimeOut));
			url_con.setDoOutput(true);//
			byte[] b = params.toString().getBytes();
			url_con.getOutputStream().write(b, 0, b.length);
			url_con.getOutputStream().flush();
			url_con.getOutputStream().close();
			InputStream in = url_con.getInputStream();
			byte[] echo = new byte[10 * 1024];
			int len = in.read(echo);
			responseContent = (new String(echo, 0, len).trim());
			int code = url_con.getResponseCode();
			if (code != 200) {
				responseContent = "ERROR" + code;
			}
		} catch (Exception e) {
			logger.debug("尝试get连接异常:" + e.toString());
		} finally {
			if (url_con != null) {
				url_con.disconnect();
			}
		}
		return responseContent;

	}

	public static String doGet(String reqUrl, String recvEncoding) {
		HttpURLConnection url_con = null;
		String responseContent = null;
		String vchartset = recvEncoding == "" ? HttpUtils.requestEncoding : recvEncoding;
		try {
			StringBuffer params = new StringBuffer();
			String queryUrl = reqUrl;
			int paramIndex = reqUrl.indexOf("?");

			if (paramIndex > 0) {
				queryUrl = reqUrl.substring(0, paramIndex);
				String parameters = reqUrl.substring(paramIndex + 1, reqUrl.length());
				String[] paramArray = parameters.split("&");
				for (int i = 0; i < paramArray.length; i++) {
					String string = paramArray[i];
					int index = string.indexOf("=");
					if (index > 0) {
						String parameter = string.substring(0, index);
						String value = string.substring(index + 1, string.length());
						params.append(parameter);
						params.append("=");
						params.append(URLEncoder.encode(value, vchartset));
						params.append("&");
					}
				}

				params = params.deleteCharAt(params.length() - 1);
			}
			URL url = new URL(queryUrl);
			url_con = (HttpURLConnection) url.openConnection();
			url_con.setRequestMethod("GET");
			System.setProperty("sun.net.client.defaultConnectTimeout", String.valueOf(HttpUtils.connectTimeOut));
			System.setProperty("sun.net.client.defaultReadTimeout", String.valueOf(HttpUtils.readTimeOut));
			url_con.setDoOutput(true);
			byte[] b = params.toString().getBytes();
			url_con.getOutputStream().write(b, 0, b.length);
			url_con.getOutputStream().flush();
			url_con.getOutputStream().close();
			InputStream in = url_con.getInputStream();
			byte[] echo = new byte[10 * 1024];
			int len = in.read(echo);
			responseContent = (new String(echo, 0, len)).trim();
			int code = url_con.getResponseCode();
			if (code != 200) {
				responseContent = "ERROR" + code;
			}
		} catch (Exception e) {
			logger.debug("尝试get连接异常:"+ e.toString());
			e.printStackTrace();
		} finally {
			if (url_con != null) {
				url_con.disconnect();
			}
		}
		return responseContent;

	}
	
	/**指定传输内容进行POST传输
	 * @param contentType 在请求头中设置属性"Content-Type",比如：application/json; application/x-www-form-urlencoded
	 * */
	public static String doPost(String reqUrl, String requestContent, String recvEncoding, String contentType){

		HttpURLConnection url_con = null;
		String responseContent = null;
		
		try{

			URL url = new URL(reqUrl);
			url_con = (HttpURLConnection) url.openConnection();
			url_con.setRequestMethod("POST");
			url_con.setRequestProperty("Content-Type",contentType);
			url_con.setRequestProperty("Accept-Charset", recvEncoding);
			url_con.setConnectTimeout(HttpUtils.connectTimeOut);
			url_con.setReadTimeout(HttpUtils.readTimeOut);
			url_con.setDoOutput(true);
			
			if(logger.isDebugEnabled()) {
				logger.debug("推送地址："+reqUrl);
				logger.debug("Request Paramters: "+url_con.getRequestProperties());
				logger.debug("尝试发送消息...");
			}

			url_con.connect();
			url_con.getOutputStream().write(requestContent.getBytes(recvEncoding));
			url_con.getOutputStream().flush();
			url_con.getOutputStream().close();
			logger.debug("发送消息完成...");

			logger.debug("尝试解析接收的返回报文...");	
			int code = url_con.getResponseCode();
			if (code != 200) {
				responseContent = "ERROR" + code;
			}

			InputStream in = url_con.getInputStream();
			responseContent = new String(readResponseStream(in, recvEncoding));
		} catch(SocketException e) {
			if("Unexpected end of file from server".equals(e.getMessage())) {
				logger.warn("JRE 在尝试解析收到的返回报文时出错。 JRE认为此返回的内容不是合法的 HTTP 报文！当前JAVA运行环境：{}");//,InformationHandler.getJreInformation());
			}
		} catch (IOException e) {
			logger.debug("异常:"+ e.getMessage());
			e.printStackTrace();
		} finally {
			if (url_con != null) {
				url_con.disconnect();
			}
		}
		return responseContent;
	}

	/**尝试读取返回报文
	 * <pre>
	 *     当返回报文内容很多时，该方法不会等待所有内容返回。
	 *     而是当调用方法时，实时返回已经接收到的内容。
	 *     有可能中途出现没有接收到内容的情况。
	 *     返回内容有效长度9510, 读取长度9510
	 * 返回内容有效长度9644, 读取长度9644
	 * 返回内容有效长度6724, 读取长度6724
	 * 返回内容有效长度4380, 读取长度4380
	 * 返回内容有效长度0, 读取长度0
	 * 返回内容有效长度8184, 读取长度8184
	 * 返回内容有效长度8184, 读取长度8184
	 * 返回内容有效长度8184, 读取长度8184
	 * 返回内容有效长度8184, 读取长度8184
	 * 返回内容有效长度8184, 读取长度8184
	 * 返回内容有效长度6061, 读取长度6061
	 * 返回内容有效长度0, 读取长度0
	 * 返回内容有效长度0, 读取长度0
	 * 返回内容有效长度0, 读取长度0
	 * </pre>
	 * @author Administrator
	 * @createTime 2019/7/26
	 * @description
	 * */
	private static StringBuffer readResponseStream(InputStream in, String recvEncoding) throws IOException {
		int zeroSizeCounter = 0;
		StringBuffer sb = new StringBuffer();
		for(int len1 = in.available() ; ;  len1 = in.available()){
			byte[] echo = new byte[len1];
			int len = in.read(echo);
			if(0 == len && zeroSizeCounter > 2){
				break;
			}else if(0 == len){
				zeroSizeCounter ++;
				logger.debug("当前没有接收到任何数据，稍后再尝试获取...");
				try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
				continue;
			}

			logger.debug("返回内容有效长度{}, 读取长度{}", len1, len);
			sb.append(new String(echo, recvEncoding));
			zeroSizeCounter = 0;
		}

		return sb;
	}

	public static String doPost(String reqUrl, String requestContent, String recvEncoding) throws Exception{
		HttpURLConnection url_con = null;
		String responseContent = null;
		
		try{

			String request= requestContent;

			URL url = new URL(reqUrl);
			url_con = (HttpURLConnection) url.openConnection();
			url_con.setRequestMethod("POST");
			url_con.setConnectTimeout(HttpUtils.connectTimeOut);
			url_con.setReadTimeout(HttpUtils.readTimeOut);
			url_con.setRequestProperty("Content-Type", "application/octet-stream;charset="+recvEncoding);
			url_con.setDoOutput(true);
			byte[] b = request.getBytes();
			logger.debug("推送地址："+reqUrl);
			url_con.getOutputStream().write(b, 0, b.length);
			url_con.getOutputStream().flush();
			url_con.getOutputStream().close();

			InputStream in = url_con.getInputStream();
			
			int len1 = in.available();
			byte[] echo = new byte[len1];
			int len = in.read(echo);
			
			responseContent = (new String(echo, "UTF-8")).trim();
			int code = url_con.getResponseCode();
			if (code != 200) {
				responseContent = "ERROR" + code;
			}

		}catch (IOException e) {
			logger.debug("异常:"+ e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			if (url_con != null) {
				url_con.disconnect();
			}
		}
		return responseContent;
	}

	/**POST连接方式
	 * @param reqUrl 连接地址
	 * @param parameters 传递参数表单key1=value1&key2=value2&...
	 * @param recvEncoding 
	 * <pre>
	 * 	常见异常：
	 * 	code: 400
	 * 	400错误码通常是服务器无法理解请求内容
	 * </pre>
	 * */
	public static String doPost(String reqUrl, Map<String, String> parameters, String recvEncoding) {
		HttpURLConnection url_con = null;
		String responseContent = null;
		String vchartset = recvEncoding == "" ? HttpUtils.requestEncoding : recvEncoding;
		try {
			StringBuffer params = new StringBuffer();
			for (Iterator<?> iter = parameters.entrySet().iterator(); iter.hasNext();) {
				Entry<?, ?> element = (Entry<?, ?>) iter.next();
				params.append(element.getKey().toString());
				params.append("=");
				params.append(URLEncoder.encode(element.getValue().toString(), vchartset));
				params.append("&");
			}

			if (params.length() > 0) {
				params = params.deleteCharAt(params.length() - 1);
			}

			URL url = new URL(reqUrl);
			url_con = (HttpURLConnection) url.openConnection();
			url_con.setRequestMethod("POST");
			url_con.setConnectTimeout(HttpUtils.connectTimeOut);
			url_con.setReadTimeout(HttpUtils.readTimeOut);
			url_con.setDoOutput(true);
			byte[] b = params.toString().getBytes();
			url_con.getOutputStream().write(b, 0, b.length);
			url_con.getOutputStream().flush();
			url_con.getOutputStream().close();

			InputStream in = url_con.getInputStream();
			byte[] echo = new byte[10 * 1024];
			int len = in.read(echo);
			responseContent = (new String(echo, 0, len)).trim();
			int code = url_con.getResponseCode();
			if (code != 200) {
				responseContent = "ERROR" + code;
			}

		}
		 catch (IOException e) {
			logger.debug("异常:"+ e.getMessage());
			e.printStackTrace();
		} finally {
			if (url_con != null) {
				url_con.disconnect();
			}
		}
		return responseContent;
	}


}