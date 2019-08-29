package com.vz.model.utils.uri;

import com.jcraft.jsch.*;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.vz.model.utils.common.StringUtils;
import com.vz.model.utils.common.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URI;
import java.util.Properties;
import java.util.Vector;

/** 
 *  
 * @ClassName: SFTPUtils 
 * @Description: sftp连接工具类 
 */
public class SFTPUtils implements UriInterfaces{
    private final static String STRING_BUFFER_NEW_LINE = "\r\n";
	private Logger log = LoggerFactory.getLogger(SFTPUtils.class.getName());
      
    private ChannelSftp sftp;  
        
    private Session session;  
    /** FTP 登录用户名*/    
    private String username;  
    /** FTP 登录密码*/    
    private String password;  
    /** 私钥 */    
    private String privateKey;  
    /** FTP 服务器地址IP地址*/    
    private String host;  
    /** FTP 端口*/  
    private int port;

    private URI uri;
        
    
    public SFTPUtils(URI uri) {
    	uri.getUserInfo();
    }
    
    /**  
     * 构造基于密码认证的sftp对象  
     * @param username
     * @param password  
     * @param host  
     * @param port  
     */    
    public SFTPUtils(String username, String password, String host, int port) {  
        this.username = username;  
        this.password = password;  
        this.host = host;  
        this.port = port;  
    }  
    
    public SFTPUtils(String username, String password, String host, String port) {  
        this.username = username;  
        this.password = password;  
        this.host = host;  
        this.port = Integer.valueOf(port);  
    } 
    
    /**  
     * 构造基于秘钥认证的sftp对象 
     * @param username
     * @param host 
     * @param port 
     * @param privateKey 
     */  
    public SFTPUtils(String username, String host, int port, String privateKey) {  
        this.username = username;  
        this.host = host;  
        this.port = port;  
        this.privateKey = privateKey;  
    }  
    
    public SFTPUtils(){}  
    
    
    
    public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public ChannelSftp getSftp() {
		return sftp;
	}

	public void setSftp(ChannelSftp sftp) {
		this.sftp = sftp;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

    @Override
    public boolean upload(String absoluteName) {
        return false;
    }

    @Override
    public boolean download(String absoluteName, URI uri) {
//        com.jcraft.jsch.JSchException e;
        // 文件名可能存在需要转化的部分： 20-APOLLO-bdiloaninfo-2G-{{yyyyMMdd|-1}}
        String path = uri.getPath();
        int lastIndex = path.lastIndexOf("/");
        if(-1 == lastIndex) lastIndex = path.lastIndexOf("\\");
        String fileName = path.substring(lastIndex);
        if(StringUtils.isBlank(fileName.trim())){
            log.info("路径中没有定义文件名，使用传入的文件名: {}", absoluteName);
        }else{
            absoluteName = absoluteName + File.separator + fileName;
        }
        log.info("尝试下载文件[{}], 保存到[{}]", path, absoluteName);

        try {
            this.download(path, absoluteName);
        } catch (SftpException | FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        File localFile = new File(absoluteName);
        if(localFile.exists() && localFile.length() > 0) return true;
        log.error("已经尝试下载文件，但是本地文件依然不存在或者大小为零，下载失败!");
        return false;
    }

    @Override
    public boolean push(String absoluteName) {
        return false;
    }

    @Override
    public UriInterfaces init(URI uri) throws Exception {

        this.uri = uri;
        String[] userInfos = uri.getUserInfo().split(":");

        SFTPUtils sftpUtils = new SFTPUtils(userInfos[0], userInfos[1], uri.getHost(), uri.getPort());

        log.info("尝试登录服务器:{}", uri.toString());
        sftpUtils.login();

        return sftpUtils;
    }

	/** 
     * 连接sftp服务器 
     * 
     * @throws Exception  
     */  
    public boolean login(){  
        try {  
            JSch jsch = new JSch();  
            if (privateKey != null) {  
                jsch.addIdentity(privateKey);// 设置私钥  
                log.info("sftp connect,path of private key file：{}" , privateKey);  
            }  
            log.info("sftp connect by host:{} username:{}",host,username);  
    
            session = jsch.getSession(username, host, port);  
            log.info("Session is build");  
            if (password != null) {  
                session.setPassword(password);    
            }  
            Properties config = new Properties();  
            config.put("StrictHostKeyChecking", "no");  
                
            session.setConfig(config);  
            session.connect();  
            log.info("Session is connected");  
              
            Channel channel = session.openChannel("sftp");  
            channel.connect();  
            log.info("channel is connected");  
    
            sftp = (ChannelSftp) channel;  
            log.info(String.format("sftp server host:[%s] port:[%s] is connect successfull", host, port));  
        } catch (JSchException e) {  
            log.error("Cannot connect to specified sftp server : {}:{} \n Exception message is: {}", new Object[]{host, port, e.getMessage()});    
            return false;
        }  
        return true;
    }    
    
    /** 
     * 关闭连接 server  
     */  
    public void logout(){  
        if (sftp != null) {  
            if (sftp.isConnected()) {  
                sftp.disconnect();  
                log.info("sftp is closed already");  
            }  
        }  
        if (session != null) {  
            if (session.isConnected()) {  
                session.disconnect();  
                log.info("sshSession is closed already");  
            }  
        }  
    }  
    
    /**  
     * 将输入流的数据上传到sftp作为文件  
     *   
     * @param directory  
     *            上传到该目录  
     * @param sftpFileName  
     *            sftp端文件名  
     * @param input  
     *            输入流  
     * @throws SftpException   
     * @throws Exception  
     */    
    public void upload(String directory, String sftpFileName, InputStream input) throws SftpException{  
        try {
            sftp.cd(directory);  
        } catch (SftpException e) {  
            log.warn("directory is not exist");              
            sftp.mkdir(directory);
            sftp.cd(directory);
        }  
        sftp.put(input, sftpFileName);  
        log.info("sftp:{}/{} is upload successful" ,directory, sftpFileName);  
    }  
    
    
    public void upload(String directory, String sftpFileName, InputStream input, StringBuffer dhJobRecorder) throws SftpException{  
        try {    
            sftp.cd(directory);  
        } catch (SftpException e) {  
            log.warn("directory is not exist");              
            sftp.mkdir(directory);
            sftp.cd(directory);
        }  
        sftp.put(input, sftpFileName);  
        log.info("sftp:{}/{} is upload successful" ,directory, sftpFileName);  
        dhJobRecorder.append(STRING_BUFFER_NEW_LINE + "sftp:"+directory+"/"+sftpFileName+" is upload successful");
        Vector channelSftp = sftp.ls(directory+"/"+sftpFileName);
        dhJobRecorder.append(STRING_BUFFER_NEW_LINE + "复查上传后的文件详细信息:" +channelSftp.toString());
    }  
    
    /** 
     * 判断目录是否存在 
     */  
    public boolean isDirExist(String directory) {  
       boolean isDirExistFlag = false;
       try {
           SftpATTRS sftpATTRS = sftp.lstat(directory);
           isDirExistFlag = true;
           return sftpATTRS.isDir();
       } catch (Exception e) {
           if (e.getMessage().toLowerCase().equals("no such file")) {
               isDirExistFlag = false;
           }
       }
       return isDirExistFlag;
    }
//    private void mkdirs(String directory) throws SftpException {
//		String[] directories = directory.split("/");
//		
//		for(int i = 0 ; i < directories.length ; i ++){
//			if(directories[i]==null || "".equals(directories[i])) continue;
//			try{
//				sftp.mkdir(directories[i]);  
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//	        sftp.cd(directories[i]); 
//		}
//		
//	}

	/**  
     * 上传单个文件 
     * 
     * @param directory  
     *            上传到sftp目录 
     * @param uploadFile 
     *            要上传的文件,包括路径  
     * @throws FileNotFoundException 
     * @throws SftpException 
     * @throws Exception 
     */  
    public void upload(String directory, String uploadFile) throws FileNotFoundException, SftpException{  
        File file = new File(uploadFile); 
        
        if(!directory.endsWith("/")) directory += "/";
        String remoteFileName = directory + file.getName();
        
        try {
        	sftp.cd(directory);
        }catch(Exception e) {
        	sftp.mkdir(directory);
        }
        
        sftp.put(new FileInputStream(file), remoteFileName);      
        
        Vector vector = sftp.ls(remoteFileName);
        String vectorMessage = vector.toString();
        log.debug("复查上传的文件：{}",vectorMessage);
        log.debug("上传后文件大小：{}",vectorMessage.split(" +")[4]);
        
    }  
    
    /** 
     * 将byte[]上传到sftp，作为文件。注意:从String生成byte[]是，要指定字符集。 
     *  
     * @param directory 
     *            上传到sftp目录 
     * @param sftpFileName 
     *            文件在sftp端的命名 
     * @param byteArr 
     *            要上传的字节数组 
     * @throws SftpException 
     * @throws Exception 
     */  
    public void upload(String directory, String sftpFileName, byte[] byteArr) throws SftpException{  
        upload(directory, sftpFileName, new ByteArrayInputStream(byteArr));  
    }  
    
    /**  
     * 将字符串按照指定的字符编码上传到sftp 
     *   
     * @param directory 
     *            上传到sftp目录 
     * @param sftpFileName 
     *            文件在sftp端的命名 
     * @param dataStr 
     *            待上传的数据 
     * @param charsetName 
     *            sftp上的文件，按该字符编码保存 
     * @throws UnsupportedEncodingException 
     * @throws SftpException 
     * @throws Exception 
     */  
    public void upload(String directory, String sftpFileName, String dataStr, String charsetName) throws UnsupportedEncodingException, SftpException{    
        upload(directory, sftpFileName, new ByteArrayInputStream(dataStr.getBytes(charsetName)));    
    }  
    
    /** 
     * 下载文件  
     * 
     * @param directory 
     *            下载目录  
     * @param downloadFile 
     *            下载的文件 
     * @param saveFile 
     *            存在本地文件的绝对路径 
     * @throws SftpException 
     * @throws FileNotFoundException 
     * @throws Exception 
     */    
    public void download(String directory, String downloadFile, String saveFile) throws SftpException, FileNotFoundException{  
//        if (directory != null && !"".equals(directory)) {  
//            sftp.cd(directory);  
//        }  
        File file = new File(saveFile);  
        FileOutputStream outputStream = new FileOutputStream(file);
        sftp.get(directory+ downloadFile, outputStream);  
        try {
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        log.info("file:{} is download successful" , downloadFile);  
    }

    public boolean download(String remoteAbsolutDir, String localAbsolutDir) throws SftpException, FileNotFoundException {
        File file = new File(localAbsolutDir);
        FileOutputStream outputStream = new FileOutputStream(file);
        sftp.get(remoteAbsolutDir, outputStream);
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("file:{} is download successful" , localAbsolutDir);
        return true;
    }
//    /**
//     * 下载文件
//     * @param directory 下载目录
//     * @param downloadFile 下载的文件名
//     * @return 字节数组
//     * @throws SftpException
//     * @throws IOException
//     * @throws Exception
//     * <pre>
//     * 此方法并非下载到本地保存文件，而是直接将文件中的数据，以byte形式解读
//     * </pre>
//     */
//    public byte[] download(String directory, String downloadFile) throws SftpException, IOException{
//        if (directory != null && !"".equals(directory)) {
//            sftp.cd(directory);
//        }
//        InputStream is = sftp.get(downloadFile);
//
//        byte[] fileData = org.apache.commons.io.IOUtils.toByteArray(is);
//
//        log.info("file:{} is download successful" , downloadFile);
//        return fileData;
//    }
    
    /** 
     * 删除文件 
     *   
     * @param directory 
     *            要删除文件所在目录 
     * @param deleteFile 
     *            要删除的文件 
     * @throws SftpException 
     * @throws Exception 
     */  
    public void delete(String directory, String deleteFile) throws SftpException{  
        sftp.cd(directory);  
        sftp.rm(deleteFile);  
    }  
    
    /** 
     * 列出目录下的文件 
     *  
     * @param directory 
     *            要列出的目录
     * @return 
     * @throws SftpException 
     */  
    public Vector<LsEntry> listFiles(String directory) throws SftpException {  
        return sftp.ls(directory);  
    }  
      
    public static void main(String[] args) throws SftpException, IOException {  
        SFTPUtils sftp = new SFTPUtils("sftp_test", "a123456", "114.67.132.56", 22);  
        sftp.login();  
        //byte[] buff = sftp.download("/opt", "start.sh");  
        //System.out.println(Arrays.toString(buff));  
        File file = new File("D:\\11111.txt");  
        InputStream is = new FileInputStream(file);  
          
        sftp.upload("/shared", "11111.txt", is);  
        sftp.logout();  
    }

    /**
     * 尝试进入远程目录。如果不存在则先建立，然后进入。
     * */
	public void intoTheWorkplace(String directory) throws SftpException {
		 try {    
	            sftp.cd(directory);  
	        } catch (SftpException e) {  
	            log.warn("directory is not exist");              
	            sftp.mkdir(directory);
	            sftp.cd(directory);
	        }  
		
	}


}