package com.vz.model.invoice.querier.top;

import com.vz.model.invoice.querier.top.root.Service;

/**
 * @ProjectName: vz-bankorg-model
 * @Package: com.vz.model.invoice.querier.top
 * @ClassName: Root
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/19 16:49
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/19 16:49
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Root {
    private Service service;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
