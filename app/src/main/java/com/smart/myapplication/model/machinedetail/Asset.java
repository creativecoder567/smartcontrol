
package com.smart.myapplication.model.machinedetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Asset {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("company_id")
    @Expose
    private Integer companyId;
    @SerializedName("check_list_id")
    @Expose
    private Integer checkListId;
    @SerializedName("image_id")
    @Expose
    private Integer imageId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("availability")
    @Expose
    private String availability;
    @SerializedName("inventory_number")
    @Expose
    private Object inventoryNumber;
    @SerializedName("serial_number")
    @Expose
    private Object serialNumber;
    @SerializedName("check_list")
    @Expose
    private CheckList checkList;
    @SerializedName("image")
    @Expose
    private Image image;

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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCheckListId() {
        return checkListId;
    }

    public void setCheckListId(Integer checkListId) {
        this.checkListId = checkListId;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Object getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(Object inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public Object getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Object serialNumber) {
        this.serialNumber = serialNumber;
    }

    public CheckList getCheckList() {
        return checkList;
    }

    public void setCheckList(CheckList checkList) {
        this.checkList = checkList;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
