
package com.smart.myapplication.model.logindetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("provide_invoice")
    @Expose
    private Integer provideInvoice;
    @SerializedName("invoice_name")
    @Expose
    private String invoiceName;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("current_invoice_no")
    @Expose
    private Integer currentInvoiceNo;
    @SerializedName("send_email_to_user")
    @Expose
    private Integer sendEmailToUser;
    @SerializedName("company_logo")
    @Expose
    private Object companyLogo;
    @SerializedName("protocol_bg_color")
    @Expose
    private String protocolBgColor;
    @SerializedName("protocol_txt_color")
    @Expose
    private String protocolTxtColor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getProvideInvoice() {
        return provideInvoice;
    }

    public void setProvideInvoice(Integer provideInvoice) {
        this.provideInvoice = provideInvoice;
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCurrentInvoiceNo() {
        return currentInvoiceNo;
    }

    public void setCurrentInvoiceNo(Integer currentInvoiceNo) {
        this.currentInvoiceNo = currentInvoiceNo;
    }

    public Integer getSendEmailToUser() {
        return sendEmailToUser;
    }

    public void setSendEmailToUser(Integer sendEmailToUser) {
        this.sendEmailToUser = sendEmailToUser;
    }

    public Object getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(Object companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getProtocolBgColor() {
        return protocolBgColor;
    }

    public void setProtocolBgColor(String protocolBgColor) {
        this.protocolBgColor = protocolBgColor;
    }

    public String getProtocolTxtColor() {
        return protocolTxtColor;
    }

    public void setProtocolTxtColor(String protocolTxtColor) {
        this.protocolTxtColor = protocolTxtColor;
    }

}
