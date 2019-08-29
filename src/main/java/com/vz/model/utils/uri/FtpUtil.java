package com.vz.model.utils.uri;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class FtpUtil implements UriInterfaces {

	private final static String STRING_BUFFER_NEW_LINE = "\r\n";
	private static final Logger logger = LoggerFactory.getLogger(FtpUtil.class);
	private FTPClient ftpclient = new FTPClient();

	public FtpUtil(){}

	@Override
	public boolean upload(String absoluteName) {
		return false;
	}

	@Override
	public boolean download(String absoluteName, URI uri) {
		return false;
	}

	@Override
	public boolean push(String absoluteName) {
		return false;
	}

	@Override
	public UriInterfaces init(URI uri) throws Exception {
		FTPClient ftpclient = new FTPClient();

		if(StringUtils.isEmpty(uri.getHost())) 
			throw new Exception("FTP URI 配置异常! 接收到的URI：" +uri.getScheme()+uri.getSchemeSpecificPart());
		if(21 != uri.getPort()) ftpclient.setDefaultPort(uri.getPort());
		try {
			
			logger.debug("尝试连接HOST[{}], PORT[{}]", uri.getHost(), uri.getPort());
			ftpclient.connect(uri.getHost());
			printFtpResponse("尝试连接");
			
			String userInfoString = uri.getUserInfo();
			if(StringUtils.isBlank(userInfoString)) {
				throw new Exception("缺少登录信息！无法连接FTP！");
			}
			String[] userInfo = userInfoString.split(":");
			logger.debug("尝试登录USER[{}], PASSWD[{}]", userInfo[0], userInfo[1]);
			ftpclient.login(userInfo[0], userInfo[1]);
			printFtpResponse("尝试登录 ");
						
			ftpclient.setControlEncoding("UTF-8");
			ftpclient.setFileType(FTPClient.BINARY_FILE_TYPE);

			logger.info("connect...ok...");
			
			ftpclient.enterLocalPassiveMode();
//			ftpclient.enterLocalActiveMode();
			printFtpResponse("尝试进入被动模式");
			ftpclient.pwd();
			printFtpResponse("pwd:");
			ftpclient.getReplyString();
		
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return (UriInterfaces)ftpclient;
	}

	public FtpUtil(String ftpIp, String loginName, String loginPwd) {
		try {
			logger.info("connect " + ftpIp + "'...");

			ftpclient.connect(ftpIp);
			printFtpResponse("尝试连接 ");
			ftpclient.login(loginName, loginPwd);
			printFtpResponse("尝试登录 ");
			logger.debug("user:" + loginName + " pwd:" + loginPwd);
			
//			checkFtpStatus();
			ftpclient.setControlEncoding("UTF-8");
			ftpclient.setFileType(FTPClient.BINARY_FILE_TYPE);

			logger.info("connect...ok...");
			
			ftpclient.enterLocalPassiveMode();
//			ftpclient.enterLocalActiveMode();
			printFtpResponse("尝试进入被动模式");
			ftpclient.pwd();
			printFtpResponse("pwd:");
			ftpclient.getReplyString();
		} catch (Exception e) {;
			logger.error("初始化ftp异常：" + e.getMessage());
		}
	}
	
	public String[] listFiles() throws IOException{
		String[] fileNames = ftpclient.listNames();
		printFtpResponse("ls:");
		return fileNames;
	}
	
	public String printWorkingDirectory() throws IOException{
		String pwd = ftpclient.printWorkingDirectory();
		printFtpResponse("当前目录["+pwd+"]");
		return pwd;
	}


	/****
	 * 下载ftp上面的文件
	 */
	public boolean FTPDownload(String localSavedFile, String remoteFile) {
		boolean bool = false;
		try {
			File file = new File(localSavedFile);
			FileOutputStream fos = new FileOutputStream(file);
			
			
			logger.debug(ftpclient.printWorkingDirectory());
			
			bool = ftpclient.retrieveFile(remoteFile, fos);
			printFtpResponse("尝试下载远程文件"+remoteFile+" :");
			logger.debug("本地保存位置："+localSavedFile);
		} catch (Exception e) {
			logger.error("下载ftp上面的文件异常：" + e.getMessage());
		}
		return bool;
	}
	
	

	/**上传文件到ftp
	 * @param localFile
	 * @param remotePath 远端上传路径 /org/zrsf/
	 * */
	public boolean FTPUpload(String localFile, String remotePath) throws Exception{
		File localF = new File(localFile);
		if(!localF.exists())logger.warn(localFile+"不存在！");
		
		String fileName = "";
		if(isFile(remotePath)) {
			// 如果远程地址中定义的路径为一个文件的名称，
			// 那么我们认为应该按照指定名称进行上传，并且路径应该变为该文件的父目录
			File remoteFile = new File(remotePath);
			fileName = remoteFile.getName();
			remotePath = remoteFile.getParent();
		}else {
			fileName = localF.getName();
		}
		
		return FTPUpload(localFile, remotePath, fileName);
	}
	
	/**
	 * 判断当前路径为文件，而不是一个文件夹
	 * @param path
	 * @return
	 */
	private boolean isFile(String path) {

		if(StringUtils.isBlank(path)) return false;

		for(String target : suffix) {
			if(path.endsWith(target)) return true;
		}
		return false;
	}
	
	private static final String[] suffix = {".zip",".xml",".pdf",".json",".txt"};

	public boolean FTPUpload(String localFile, String remoteDir, String remoteFile) throws Exception {
		return FTPUpload( localFile,  remoteDir,  remoteFile, "0");
	}
	
	/**
	 * 直接上本地文件上传到FTP的当前工作目录
	 * */
	public void FTPUpload(File localFile){
		ftpclient.enterLocalPassiveMode();
		
		FileInputStream fis = null;
		try {
			logger.debug("当前工作路径：{}" , ftpclient.printWorkingDirectory());
			
			fis = new FileInputStream(localFile);
			ftpclient.storeFile(new String(localFile.getName().getBytes("UTF-8"), "iso-8859-1"), fis);
			printFtpResponse("upload resule:" + localFile.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 直接上本地文件上传到FTP的当前工作目录
	 * @throws IOException 
	 * */
	public void FTPUpload(File[] localFiles, StringBuffer dhJobRecorder) throws IOException{
		ftpclient.enterLocalPassiveMode();
		
		FileInputStream fis = null;
		try {
			logger.debug("当前工作路径：{}" , ftpclient.printWorkingDirectory());
			
			for(File localFile : localFiles	){
				fis = new FileInputStream(localFile);
				ftpclient.storeFile(new String(localFile.getName().getBytes("UTF-8"), "iso-8859-1"), fis);
				printFtpResponse("upload resule:" + localFile.getName());
			}
			
			dhJobRecorder.append(STRING_BUFFER_NEW_LINE + "校验远程目录：" + ftpclient.printWorkingDirectory() +
					"; 包含文件数量：" + ftpclient.listFiles().length);
		} catch (IOException e) {
			throw e;
		}
	}
	
	
	/**
	 * 用于校验远程服务器上目录下的文件数量
	 * @param remoteDir 需要校验的目录，如果为null，则校验当前目录
	 * @param dhJobRecorder 用于记录校验信息
	 * */
	public void FTPRecheckFileUploaded(String remoteDir, StringBuffer dhJobRecorder){
		FTPFile[] ftpFiles = {};
		try {
			if(remoteDir == null){
				logger.debug("校验当前目录!{}",ftpclient.printWorkingDirectory());
				dhJobRecorder.append(STRING_BUFFER_NEW_LINE + "校验目录:" + ftpclient.printWorkingDirectory());
				ftpFiles = ftpclient.listFiles();	
			}else{
				logger.debug("校验目录:{}",remoteDir);
				dhJobRecorder.append(STRING_BUFFER_NEW_LINE + "校验FTP服务器目录:" + remoteDir);
				ftpFiles = ftpclient.listFiles(remoteDir);
			}
			
			dhJobRecorder.append("  存在文件"+ ftpFiles.length + "份!");
		} catch (IOException e) {
			e.printStackTrace();
			dhJobRecorder.append(STRING_BUFFER_NEW_LINE + "校验上传后的文件异常，异常信息:" + e.getMessage());
		}
	}

	/****
	 * 上传文件到ftp
	 * 
	 * @param localFile 本地文件绝对路径
	 * @param remoteDir 远程文件存放路径
	 * @param remoteFile 远程文件保存使用的文件名
	 * @param type 主动模式传1，被动模式传0
	 */
	public boolean FTPUpload(String localFile, String remoteDir, String remoteFile, String type) throws Exception {
		boolean bool = false;

		logger.debug("local file：" + localFile);
		logger.debug("remote file：" + remoteDir +File.separator+ remoteFile);
		try {
			if("0".equals(type)){
				logger.info("Try enter pass mode");
				ftpclient.enterLocalPassiveMode();
				printFtpResponse("enter PASSMODE response:");
			}else{
				logger.info("Try enter active mode");
				ftpclient.enterLocalActiveMode();
				printFtpResponse("enter PASSMODE response:");
			}
			
			
			FileInputStream fis = null;
			File file = new File(localFile);
			fis = new FileInputStream(file);
			logger.info("ftpMake:" + remoteDir);
			CreateDirecroty(remoteDir); //进入指定目录，如果不存在则创建
			logger.info("Try to pass file!");
			ftpclient.storeFile(new String(remoteFile.getBytes("UTF-8"), "iso-8859-1"), fis);
			printFtpResponse("upload resule:" + remoteFile);
			
			logger.debug("传输完成");
			bool = recheckFileUploaded(remoteFile);
			fis.close();
		    
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("上传文件到ftp异常：" + e);
			throw new Exception();
		}
		return bool;
	}

	/**再次校验上传文件是否成功
	 * */
	private boolean recheckFileUploaded(String remoteFile) {
		try{
			FTPFile[] files = ftpclient.listFiles();
			
			printFtpResponse("扫描当前目录["+ftpclient.printWorkingDirectory()+"]，一共有文件:" +files.length +"个");
			if(0==files.length)return false;
			
			for(FTPFile file : files){
				if(remoteFile.equalsIgnoreCase(file.getName())){
					logger.info("校验上传文件["+file.getName()+"]大小为：" + file.getSize());
					return (file.getSize()>0)?true:false;
				}
			}
		}catch(Exception e){
			logger.error("校验上传结果异常!");
			return true;
		}
		
		logger.error("未找到上传文件:"+remoteFile);
		return false;
	}

	private void printFtpResponse(String content) {
		String response = ftpclient.getReplyString();
		logger.info(content + " Response - " + 
		(StringUtils.isBlank(response)? "": response.replaceAll("\r\n", "").replaceAll("\n", "")) 
		);
	}

	/**
	 * 进入远程目录，如果目录不存在则创建它并进入
	 * 
	 * @param remote
	 *            远程服务器文件绝对路径
	 * 
	 * @return 目录创建是否成功
	 * @throws Exception
	 * @throws IOException
	 */
	public boolean CreateDirecroty(String remote) throws Exception {
		boolean success = true;
		try {
			logger.info("当前处理地址:" + remote);
			/** 如果是根目录，则不创建新目录 */
			if (remote.equalsIgnoreCase("/") || remote.equalsIgnoreCase("\\")) {
				success = ftpclient.changeWorkingDirectory("/");
				printFtpResponse("尝试切换根目录");
				return success;
			}

			// 配置文件是人为写死的。所以无法使用系统的分隔符进行分割
			String[] directions = remote.split("[/\\\\]");
			List<String> pathDepth = printArrayInfo("所需存放的远端路径:", directions);
	
			return tryToEstablishDir(pathDepth);
		} catch (Exception e) {
			logger.error("创建文件夹[" + remote + "]异常：" + e.getMessage());
			throw e;
		}
	}
	
	/**
	 * 线程同步，一次只允许一个线程尝试创建目录
	 * @param pathDepth
	 * @return
	 * @throws IOException 
	 */
	private synchronized boolean tryToEstablishDir(List<String> pathDepth) throws IOException {
		for(String path : pathDepth){
			boolean enterPath = ftpclient.changeWorkingDirectory(path);
			printFtpResponse("尝试进入路径："+path);
			
			if (enterPath) {
				continue;
			} else {
				boolean mkdSuccess = ftpclient.makeDirectory(path);
				printFtpResponse("尝试创建目录" + path);

				// 如果创建成果，则进入下一层
				if (mkdSuccess) {
					ftpclient.changeWorkingDirectory(path);
					printFtpResponse("尝试再次进入路径："+path);
					continue;
				} else {
					logger.error("尝试创建目录失败");
				}
			}
		}
		return true;
	}

//	public static void main(String[] args) {
//		FtpUtil ftpClient = new FtpUtil("192.168.81.71","pdfreport","123456");
//		
//		try {
//			ftpClient.CreateDirecroty("/Bllose/Recedw/cx/11");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			logger.info(ftpClient.printWorkingDirectory());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		ftpClient.shutdown();
//	}


	/**
	 * @param content
	 *            日志头需要展示的信息
	 * @param array
	 *            需要解析的数组
	 */
	private List<String> printArrayInfo(String content, String[] array) {
		int pathDepth = 0;
		List<String> paths = new ArrayList<String>();
		for (String arrayDir : array) {
			if (!"".equals(arrayDir)) {
				paths.add(arrayDir);
				pathDepth++;
			}
		}
		logger.debug(content + pathDepth + " - " + paths.toString());
		return paths;
	}

	/**
	 * 
	 * @param file
	 *            上传的文件或文件夹
	 * @throws Exception
	 */
	private void upload(File file) throws Exception {
		try {
			if (file.isDirectory()) {
				ftpclient.makeDirectory(file.getName());
				ftpclient.changeWorkingDirectory(file.getName());
				String[] files = file.list();
				for (int i = 0; i < files.length; i++) {
					File file1 = new File(file.getPath() + "\\" + files[i]);
					if (file1.isDirectory()) {
						upload(file1);
						ftpclient.changeToParentDirectory();
					} else {
						File file2 = new File(file.getPath() + "\\" + files[i]);
						FileInputStream input = new FileInputStream(file2);
						ftpclient.storeFile(file2.getName(), input);
						input.close();
					}
				}
			} else {
				File file2 = new File(file.getPath());
				FileInputStream input = new FileInputStream(file2);
				ftpclient.storeFile(file2.getName(), input);
				input.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/****
	 * 删除ftp上的文件
	 */
	public boolean FTPDel(String fileName) {
		boolean bool = false;
		try {
			bool = ftpclient.deleteFile(fileName);
		} catch (Exception e) {
			logger.error("删除ftp上的文件异常：" + e.getMessage());
		}
		return bool;
	}

	/****
	 * 修改ftp文件名
	 */
	public void FTPUpdateFileName() {
		FTPClient ftpclient = new FTPClient();
		boolean error = false;
		String uploadFileName = "";
		try {
			ftpclient.connect("192.168.23.35");
			ftpclient.login("gdsf", "gdsf2014");
			boolean moved = ftpclient.rename("/Upload" + File.separator + uploadFileName,
					"/Success" + File.separator + uploadFileName);
			System.out.println(
					moved ? "File " + uploadFileName + " move success" : "File " + uploadFileName + " move failure");
			System.out.println(ftpclient.getReplyString());

		} catch (Exception e) {
			error = true;
			e.printStackTrace();
		} finally {
			if (ftpclient.isConnected()) {
				try {
					ftpclient.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	/**断开链接，释放对象*/
	public void shutdown(){
		try {
			ftpclient.logout();
			printFtpResponse("登出ftp");
			ftpclient.disconnect();
			printFtpResponse("ftp断开连接");
			
			ftpclient =null;
		} catch (IOException e) {
			logger.debug("ftp 非正常退出!");
		}
		
		
	}


}
