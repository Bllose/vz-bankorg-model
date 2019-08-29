package com.vz.model.credit.guangxi.taxation;

/** 广西税局返回报文
 * @ProjectName: vz-bankorg-model
 * @Package: com.vz.model.credit.guangxi.taxation
 * @ClassName: ResponseGX
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/21 11:25
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/21 11:25
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ResponseGX {

    public enum status_code{
        SUCCESS("000000", "成功"),
        FAILED("999999", "失败");

        private String code;
        private String msg;

        status_code(String code, String msg){
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    private String statusCode; // 系统调用状态码
    private String statusMsg; // 系统调用状态信息

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }
}
