package com.vz.model.credit.hubei.yizhangtong;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ProjectName: bllose-utils
 * @Package: com.vz.model.credit.hubei.yizhangtong
 * @ClassName: Service
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/5 14:46
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/5 14:46
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@XmlRootElement
public class Service {

    /**众邦所提供的服务编码
     * HDPT.SQXX -> 查询申请信息
     * HDPT.QYXX -> 查询企业信息
     * HDPT.DKJG -> 推送贷款结果
     * */
    public enum serviceType{
        SQXX("HDPT.SQXX"), QYXX("HDPT.QYXX") , DKJG("HDPT.DKJG");
        private String type;

        serviceType(String type){
            this.type = type;
        }

        public String type(){
            return type;
        }
    }

    private Head head;

    private Body body;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
