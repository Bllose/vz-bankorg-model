package com.vz.model.credit.hubei.yizhangtong.body.cwxx;

import com.vz.model.credit.hubei.yizhangtong.body.cwxx.qylrb.Qykjzd;
import com.vz.model.credit.hubei.yizhangtong.body.cwxx.qylrb.Xqykjzd;
import com.vz.model.credit.hubei.yizhangtong.body.cwxx.qylrb.Ybqykjzd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**财务信息 -> 企业利润表
 * @ProjectName: bllose-utils
 * @Package: com.vz.model.credit.hubei.yizhangtong.body.cwxx
 * @ClassName: Qylrb
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/12 17:16
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/12 17:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Qylrb {

    private List<Xqykjzd> xqykjzds;
    private List<Ybqykjzd> ybqykjzds;
    private List<Qykjzd> qykjzds;

    @XmlElementWrapper(name = "xqykjzds")
    @XmlElement(name = "xqykjzd")
    public List<Xqykjzd> getXqykjzds() {
        return xqykjzds;
    }

    public void setXqykjzds(List<Xqykjzd> sqykjzds) {
        this.xqykjzds = sqykjzds;
    }

    @XmlElementWrapper(name = "ybqykjzds")
    @XmlElement(name = "ybqykjzd")
    public List<Ybqykjzd> getYbqykjzds() {
        return ybqykjzds;
    }

    public void setYbqykjzds(List<Ybqykjzd> ybqykjzds) {
        this.ybqykjzds = ybqykjzds;
    }

    @XmlElementWrapper(name = "qykjzds")
    @XmlElement(name = "qykjzd")
    public List<Qykjzd> getQykjzds() {
        return qykjzds;
    }

    public void setQykjzds(List<Qykjzd> qykjzds) {
        this.qykjzds = qykjzds;
    }
}
