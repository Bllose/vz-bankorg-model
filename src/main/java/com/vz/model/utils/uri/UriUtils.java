package com.vz.model.utils.uri;

import com.vz.model.utils.common.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @ProjectName: bllose-utils
 * @Package: com.vzoom.blloseutils.uri
 * @ClassName: UriUtils
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/7/22 15:56
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/7/22 15:56
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UriUtils {

    private static final Logger logger = LoggerFactory.getLogger(UriUtils.class);
    private static UriInterfaces uriHandler;


    public static boolean transforFile(String uri, TYPE type, String fileAbsoluteName) throws URISyntaxException {
        uri = TimeUtils.dayTransfer(uri);
        return transforFile(new URI(uri), type, fileAbsoluteName);
    }
    /**
     * <pre>
     * </pre>
     * @author Administrator
     * @createTime 2019/8/22
     * @description
     * @param uri 操作文件地址
     * @param type 操作类型： 下载、上传等
     * @param fileAbsoluteName 如果是下载则表示下载路径或者下载文件
     * */
    public static boolean transforFile(URI uri, TYPE type, String fileAbsoluteName){

        String scheme = uri.getScheme().toUpperCase();

        switch (scheme){
            case "FTP": uriHandler = new FtpUtil();break;
            case "SFTP": uriHandler = new SFTPUtils();break;
            case "HTTP": ;
            default:
                logger.warn("{} 暂不支持此种协议的操作...");
                return false;
        }

        try {
            switch (type) {
                case PUSH:
                    return uriHandler.init(uri).push(fileAbsoluteName);
                case UP_LOAD:
                    return uriHandler.init(uri).upload(fileAbsoluteName);
                case DOWN_LOAD:
                    return uriHandler.init(uri).download(fileAbsoluteName, uri);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public enum TYPE{
        UP_LOAD("upLoad"), DOWN_LOAD("downLoad"), PUSH("push");

        private String type;

        TYPE(String type){
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
