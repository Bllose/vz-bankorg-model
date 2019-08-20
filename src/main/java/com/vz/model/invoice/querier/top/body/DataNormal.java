package com.vz.model.invoice.querier.top.body;

import java.util.List;

/**
 * @ProjectName: vz-bankorg-model
 * @Package: com.vz.model.invoice.querier.top.body
 * @ClassName: DataNormal
 * @Description: java类作用描述
 * @Author: Bllose
 * @CreateDate: 2019/8/19 17:44
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/8/19 17:44
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DataNormal {
    private String billingDate; // 样例: 2019-08-07
    private String amountTax;
    private String administrativeDivisionNo; // 样例: 42
    private String salesBank; // 样例: 招商银行股份有限公司北京青年路支行 110914326410501
    private String purchaserTaxNo; // 样例: 91442000X180811958
    private String amountTaxCN; // 样例: 贰仟零肆拾玖元整
    private String remarks; // 样例: dd71904687159(00001,101009138802)
    private String purchaserBank; // 样例: 招商银行珠海分行755903824910206
    private String invoiceNumber; // 样例: 00316144
    private String administrativeDivisionName; // 样例: 湖北
    private String salesAddressPhone; // 样例: 武汉市东西湖区高桥产业园台中大道特1号 027-84295702
    private String purchaserName; // 样例: 珠海联邦制药股份有限公司中山分公司
    private String salesTaxNo; // 样例: 914201125683714021
    private String salesName; // 样例: 武汉京东世纪贸易有限公司
    private String invoiceCode; // 样例: 4200174130
    private String state; // 样例: 1
    private String machineCode; // 样例: 661620032431
    private String purchaserAddressPhone; // 样例: 广东省中山市坦洲镇嘉联路12号0760-86655310
    private String totalTax;
    private String totalAmount; // 样例: 1813.28
    private String checkCode; // 样例: 65717191401118039518
    private List<InvoiceList> invoiceList;

    public String getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(String billingDate) {
        this.billingDate = billingDate;
    }

    public String getAmountTax() {
        return amountTax;
    }

    public void setAmountTax(String amountTax) {
        this.amountTax = amountTax;
    }

    public String getAdministrativeDivisionNo() {
        return administrativeDivisionNo;
    }

    public void setAdministrativeDivisionNo(String administrativeDivisionNo) {
        this.administrativeDivisionNo = administrativeDivisionNo;
    }

    public String getSalesBank() {
        return salesBank;
    }

    public void setSalesBank(String salesBank) {
        this.salesBank = salesBank;
    }

    public String getPurchaserTaxNo() {
        return purchaserTaxNo;
    }

    public void setPurchaserTaxNo(String purchaserTaxNo) {
        this.purchaserTaxNo = purchaserTaxNo;
    }

    public String getAmountTaxCN() {
        return amountTaxCN;
    }

    public void setAmountTaxCN(String amountTaxCN) {
        this.amountTaxCN = amountTaxCN;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPurchaserBank() {
        return purchaserBank;
    }

    public void setPurchaserBank(String purchaserBank) {
        this.purchaserBank = purchaserBank;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getAdministrativeDivisionName() {
        return administrativeDivisionName;
    }

    public void setAdministrativeDivisionName(String administrativeDivisionName) {
        this.administrativeDivisionName = administrativeDivisionName;
    }

    public String getSalesAddressPhone() {
        return salesAddressPhone;
    }

    public void setSalesAddressPhone(String salesAddressPhone) {
        this.salesAddressPhone = salesAddressPhone;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    public String getSalesTaxNo() {
        return salesTaxNo;
    }

    public void setSalesTaxNo(String salesTaxNo) {
        this.salesTaxNo = salesTaxNo;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public String getPurchaserAddressPhone() {
        return purchaserAddressPhone;
    }

    public void setPurchaserAddressPhone(String purchaserAddressPhone) {
        this.purchaserAddressPhone = purchaserAddressPhone;
    }

    public String getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public List<InvoiceList> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<InvoiceList> invoiceList) {
        this.invoiceList = invoiceList;
    }

    class InvoiceList {
        private String amount;
        private String rowNo; // 样例: 1
        private String quantity; // 样例: 1
        private String tax;
        private String taxRate;
        private String unitPrice;
        private String specificationModel; // 样例: 55PUF7194/T3
        private String commodityName; // 样例: *家用音视频设备*飞利浦（PHILIPS）55PUF7194/T355英寸人工智能一级能效超薄全面屏4K超高清H
        private String unit; // 样例: 台

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getRowNo() {
            return rowNo;
        }

        public void setRowNo(String rowNo) {
            this.rowNo = rowNo;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getTax() {
            return tax;
        }

        public void setTax(String tax) {
            this.tax = tax;
        }

        public String getTaxRate() {
            return taxRate;
        }

        public void setTaxRate(String taxRate) {
            this.taxRate = taxRate;
        }

        public String getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(String unitPrice) {
            this.unitPrice = unitPrice;
        }

        public String getSpecificationModel() {
            return specificationModel;
        }

        public void setSpecificationModel(String specificationModel) {
            this.specificationModel = specificationModel;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }
    }
}
