package com.vz.model.invoice.querier.top.root;

/**
 * @ProjectName: vz-bankorg-model
 * @Package: com.vz.model.invoice.querier.root
 * @ClassName: Service
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/19 16:39
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/19 16:39
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Service {
    private String replyCode;
    private String replyMsg;

    public String getReplyCode() {
        return replyCode;
    }

    public void setReplyCode(String replyCode) {
        this.replyCode = replyCode;
    }

    public String getReplyMsg() {
        return replyMsg;
    }

    public void setReplyMsg(String replyMsg) {
        this.replyMsg = replyMsg;
    }
}
