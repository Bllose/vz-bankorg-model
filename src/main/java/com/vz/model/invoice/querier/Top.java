package com.vz.model.invoice.querier;

import com.vz.model.invoice.querier.top.Body;
import com.vz.model.invoice.querier.top.Root;

/**从税票查提供的接口中，查询出的发票数据对象结构
 * <pre>
 * </pre>
 * @author Administrator
 * @createTime 2019/8/20
 * @description
 * */
public class Top {
    private Root root;
    private Body body;

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
