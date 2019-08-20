package com.vz.model.invoice.querier.top.body.data14;

import java.util.List;


public class Data14 {

    private String purchaserBank; // 样例:
    private String salesName; // 样例: 南京夫子庙贵宾楼美食中心有限责任公司
    private String amountTaxCN; // 样例:
    private String billingDate; // 样例: 2019-07-01
    private String administrativeDivisionNo; // 样例: 32
    private String totalAmount; // 样例: 2660.38
    private String amountTax;
    private String purchaserName; // 样例: 苏银金融租赁股份有限公司
    private String purchaserTaxNo; // 样例: 91320000339022591N
    private String uuid; // 样例: 87d4d2840fc44df3977a3168f79b09f0
    private String remarks; // 样例:
    private String machineCode; // 样例: 539905297987
    private String state; // 样例: 1
    private String totalTax;
    private String salesBank; // 样例:
    private String purchaserAddressPhone; // 样例:
    private String checkCode; // 样例: 06174583519052998305
    private String invoiceCode; // 样例: 032001700207
    private String invoiceNumber; // 样例: 27001421
    private String salesTaxNo; // 样例: 91320100249702235A
    private String administrativeDivisionName; // 样例: 江苏
    private String salesAddressPhone; // 样例:
    private List<InvoiceList> invoiceList;// 发票细节列表

    public String getPurchaserBank() {
        return purchaserBank;
    }

    public void setPurchaserBank(String purchaserBank) {
        this.purchaserBank = purchaserBank;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public String getAmountTaxCN() {
        return amountTaxCN;
    }

    public void setAmountTaxCN(String amountTaxCN) {
        this.amountTaxCN = amountTaxCN;
    }

    public String getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(String billingDate) {
        this.billingDate = billingDate;
    }

    public String getAdministrativeDivisionNo() {
        return administrativeDivisionNo;
    }

    public void setAdministrativeDivisionNo(String administrativeDivisionNo) {
        this.administrativeDivisionNo = administrativeDivisionNo;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getAmountTax() {
        return amountTax;
    }

    public void setAmountTax(String amountTax) {
        this.amountTax = amountTax;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    public String getPurchaserTaxNo() {
        return purchaserTaxNo;
    }

    public void setPurchaserTaxNo(String purchaserTaxNo) {
        this.purchaserTaxNo = purchaserTaxNo;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    public String getSalesBank() {
        return salesBank;
    }

    public void setSalesBank(String salesBank) {
        this.salesBank = salesBank;
    }

    public String getPurchaserAddressPhone() {
        return purchaserAddressPhone;
    }

    public void setPurchaserAddressPhone(String purchaserAddressPhone) {
        this.purchaserAddressPhone = purchaserAddressPhone;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getSalesTaxNo() {
        return salesTaxNo;
    }

    public void setSalesTaxNo(String salesTaxNo) {
        this.salesTaxNo = salesTaxNo;
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

    public List<InvoiceList> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<InvoiceList> invoiceList) {
        this.invoiceList = invoiceList;
    }

    class InvoiceList{
        private String startDate; // 样例: 20190605
        private String carNumber; // 样例: 豫AQ725H
        private String realTaxRate; // 样例: 0
        private String taxRate; // 样例: 不征收
        private String tax; // 样例: ***
        private String totalAmount; // 样例: 60.45
        private String realTax; // 样例: 0
        private String endDate; // 样例: 20190605
        private String goodType; // 样例: 客车
        private String goodsName; // 样例: *经营租赁*代收通行费
        private String specialSign; // 样例: 2

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getCarNumber() {
            return carNumber;
        }

        public void setCarNumber(String carNumber) {
            this.carNumber = carNumber;
        }

        public String getRealTaxRate() {
            return realTaxRate;
        }

        public void setRealTaxRate(String realTaxRate) {
            this.realTaxRate = realTaxRate;
        }

        public String getTaxRate() {
            return taxRate;
        }

        public void setTaxRate(String taxRate) {
            this.taxRate = taxRate;
        }

        public String getTax() {
            return tax;
        }

        public void setTax(String tax) {
            this.tax = tax;
        }

        public String getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(String totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getRealTax() {
            return realTax;
        }

        public void setRealTax(String realTax) {
            this.realTax = realTax;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getGoodType() {
            return goodType;
        }

        public void setGoodType(String goodType) {
            this.goodType = goodType;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getSpecialSign() {
            return specialSign;
        }

        public void setSpecialSign(String specialSign) {
            this.specialSign = specialSign;
        }
    }
}
