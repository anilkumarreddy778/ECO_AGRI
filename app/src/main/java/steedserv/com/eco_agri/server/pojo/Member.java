package steedserv.com.eco_agri.server.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Member implements Serializable{

    @SerializedName("userId")
    @Expose
    private String userId;

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("emailId")
    @Expose
    private String emailId;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("addernumber")
    @Expose
    private String addernumber;
    @SerializedName("date")
    @Expose
    private long date;
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("desc")
    @Expose
    private String desc;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddernumber() {
        return addernumber;
    }

    public void setAddernumber(String addernumber) {
        this.addernumber = addernumber;
    }

    public Long getDate() {
        return date;
    }


    public void setDate(long date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
