package com.vz.model.enums;

/**发票种类
 * <pre>
 * 信息参考：
 * https://inv-veri.chinatax.gov.cn/index.html
 * </pre>
 * @ProjectName: vz-bankorg-model
 * @Package: com.vz.model.enums
 * @ClassName: InvoiceTypeEnum
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/19 16:18
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/19 16:18
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public enum InvoiceTypeEnum {

    ADDED_VALUE_TAX_NORMAL("04", "增值税普通发票"),
    ADDED_VALUE_TAX_E_NORMAL("10", "增值税电子普通发票"),
    ADDED_VALUE_TAX_NORMAL_ROLL("11", "增值税普通发票（卷式）"),
    ADDED_VALUE_TAX_NORMAL_PIKE("14", "增值税普通发票（通行费）"),
    ADDED_VALUE_TAX_SPECIAL("01", "增值税专用发票"),

    ADDED_VALUE_VEHICLES("03", "机动车增值税专用发票"),
    SECEND_HAND_CAR("15", "二手车发票"),
    ADDED_VALUE_TAX_TRANSPORT("02", "货运运输业增值税专用发票");


    InvoiceTypeEnum(String type, String name){
        this.type = type;
        this.name = name;
    }

    private String type;
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
