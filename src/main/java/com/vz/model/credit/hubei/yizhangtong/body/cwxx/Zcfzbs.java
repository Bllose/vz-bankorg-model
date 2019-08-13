package com.vz.model.credit.hubei.yizhangtong.body.cwxx;

import com.vz.model.credit.hubei.yizhangtong.body.cwxx.zcfzb.Zcfzb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**财务信息 -> 资产负债信息
 * @ProjectName: bllose-utils
 * @Package: com.vz.model.credit.hubei.yizhangtong.body.cwxx
 * @ClassName: Zcfzbs
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/12 17:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/12 17:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Zcfzbs {

    private List<Zcfzb> zcfzbs;

    @XmlElementWrapper(name = "zcfzbs")
    @XmlElement(name = "zcfzb")
    public List<Zcfzb> getZcfzbs() {
        return zcfzbs;
    }

    public void setZcfzbs(List<Zcfzb> zcfzbs) {
        this.zcfzbs = zcfzbs;
    }
}
