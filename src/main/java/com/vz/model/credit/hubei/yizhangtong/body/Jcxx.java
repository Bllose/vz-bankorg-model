package com.vz.model.credit.hubei.yizhangtong.body;

import com.vz.model.credit.hubei.yizhangtong.body.jcxx.Bgdjmx;
import com.vz.model.credit.hubei.yizhangtong.body.jcxx.Jbxx;
import com.vz.model.credit.hubei.yizhangtong.body.jcxx.Xyjb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**基础信息
 * @ProjectName: bllose-utils
 * @Package: com.vz.model.credit.hubei.yizhangtong.body
 * @ClassName: Jcxx
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/12 17:01
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/12 17:01
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Jcxx {

    private Jbxx jbxx;
    private List<Bgdjmx> bgdjmxs;
    private List<Xyjb> xyjbs;

    public Jbxx getJbxx() {
        return jbxx;
    }

    public void setJbxx(Jbxx jbxx) {
        this.jbxx = jbxx;
    }

    @XmlElementWrapper(name = "bgdjmxs")
    @XmlElement(name = "bgdjmx")
    public List<Bgdjmx> getBgdjmxs() {
        return bgdjmxs;
    }

    public void setBgdjmxs(List<Bgdjmx> bgdjmxs) {
        this.bgdjmxs = bgdjmxs;
    }

    @XmlElementWrapper(name = "xyjbs")
    @XmlElement(name = "xyjb")
    public List<Xyjb> getXyjbs() {
        return xyjbs;
    }

    public void setXyjbs(List<Xyjb> xyjbs) {
        this.xyjbs = xyjbs;
    }
}
