package com.vz.model.credit.hubei.yizhangtong;

/**
 * @ProjectName: bllose-utils
 * @Package: com.vz.model.credit.hubei.yizhangtong
 * @ClassName: Head
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/5 14:50
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/5 14:50
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Head {

    private String fwbm; // 服务编码
    private String yhdm; // 银行代码
    private String qqsj; // 请求时间
    private String qm;   // 签名
    private String jmbj; // 机密标记 枚举类 N - 非加密； Y - 加密

    public String getJmbj() {
        return jmbj;
    }

    public void setJmbj(String jmbj) {
        this.jmbj = jmbj;
    }

    public String getFwbm() {
        return fwbm;
    }

    public void setFwbm(String fwbm) {
        this.fwbm = fwbm;
    }

    public String getYhdm() {
        return yhdm;
    }

    public void setYhdm(String yhdm) {
        this.yhdm = yhdm;
    }

    /** yyyy-MM-dd HH:mm:ss*/
    public String getQqsj() {
        return qqsj;
    }

    /** yyyy-MM-dd HH:mm:ss*/
    public void setQqsj(String qqsj) {
        this.qqsj = qqsj;
    }

    public String getQm() {
        return qm;
    }

    public void setQm(String qm) {
        this.qm = qm;
    }
}
