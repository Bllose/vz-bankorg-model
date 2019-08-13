package com.vz.model.mq.common.two.body;

/**
 * @ProjectName: bllose-utils
 * @Package: com.vz.model.mq.common.two.body
 * @ClassName: DataCheck
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/1 11:06
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/1 11:06
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DataCheck implements Cloneable{

    private String nsrsbh;
    private String areaCode; // 区域编码
    private String preLever; // 预等级
    private String procedureNames; // 多个存储过程名称，以分号(;)分割

    public String getNsrsbh() {
        return nsrsbh;
    }

    public void setNsrsbh(String nsrsbh) {
        this.nsrsbh = nsrsbh;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPreLever() {
        return preLever;
    }

    public void setPreLever(String preLever) {
        this.preLever = preLever;
    }

    public String getProcedureNames() {
        return procedureNames;
    }

    public void setProcedureNames(String procedureNames) {
        this.procedureNames = procedureNames;
    }

    public DataCheck clone() {
        try {
            return (DataCheck) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
