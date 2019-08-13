package com.vz.model.credit.hubei.yizhangtong.body;

import com.vz.model.credit.hubei.yizhangtong.body.cwxx.Qylrb;
import com.vz.model.credit.hubei.yizhangtong.body.cwxx.Zcfzbs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**财务信息
 * @ProjectName: bllose-utils
 * @Package: com.vz.model.credit.hubei.yizhangtong.body
 * @ClassName: Cwxx
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/12 17:02
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/12 17:02
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Cwxx {

    private List<Zcfzbs> zcfzbs;
    private Qylrb qylrb;

    @XmlElementWrapper(name = "zcfzbs")
    @XmlElement(name = "zcfzb")
    public List<Zcfzbs> getZcfzbs() {
        return zcfzbs;
    }

    public void setZcfzbs(List<Zcfzbs> zcfzbs) {
        this.zcfzbs = zcfzbs;
    }

    public Qylrb getQylrb() {
        return qylrb;
    }

    public void setQylrb(Qylrb qylrb) {
        this.qylrb = qylrb;
    }
}
