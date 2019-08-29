package com.vz.model.invoice.querier.top;

import com.alibaba.fastjson.JSONObject;

/**
 * @ProjectName: vz-bankorg-model
 * @Package: com.vz.model.invoice.querier.root
 * @ClassName: Body
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/19 16:40
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/19 16:40
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Body {

    private String invoiceType;
    private String message;
    private String success;
    private String code;
    private JSONObject data;

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}
