package com.vz.model.mq.common.two.subcollect;

import com.vz.model.mq.common.two.HeadMessage;

/**子采集MQ消息体
 * @ProjectName: vz-bankorg-model
 * @Package: com.vz.model.mq.common.two.subcollect
 * @ClassName: SubColMqMessage
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/19 9:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/19 9:23
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SubColMqMessage implements Cloneable{

    private HeadMessage head;
    private SubColBody body;

    public SubColMqMessage clone(){
        try {
            SubColMqMessage mqMessage = (SubColMqMessage) super.clone();
            this.head = head.clone();
            this.body = body.clone();
            return mqMessage;
        } catch (CloneNotSupportedException e) {
            System.err.println("尝试创建子采集消息对象的复制体失败!");
            e.printStackTrace();
            return null;
        }
    }

    public HeadMessage getHead() {
        return head;
    }

    public void setHead(HeadMessage head) {
        this.head = head;
    }

    public SubColBody getBody() {
        return body;
    }

    public void setBody(SubColBody body) {
        this.body = body;
    }
}
