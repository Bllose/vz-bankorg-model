package com.vz.model.credit.hubei.yizhangtong;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ProjectName: hbzb-front
 * @Package: com.vzoom.front.hbzb.common.xml.body
 * @ClassName: ServiceResponse
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/28 18:19
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/28 18:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@XmlRootElement(name = "service")
public class ServiceResponse {

    private Head head;

    private String body;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
