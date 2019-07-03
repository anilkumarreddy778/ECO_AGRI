package steedserv.com.eco_agri.server.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 04-Aug-18.
 */

public class SaveMemberRequest {

    @SerializedName("userId")
    @Expose
    private String userId;

    @SerializedName("memname")
    @Expose
    private String name;
    @SerializedName("memphone")
    @Expose
    private String mobileNumber;
    @SerializedName("mememailid")
    @Expose
    private String emailId;

    //aadharnumber
    @SerializedName("memaadhaar")
    @Expose
    private String memaadhaar;

    //address
    @SerializedName("memaddress")
    @Expose
    private String memaddress;


    @SerializedName("memjoindate")
    @Expose
    private String memjoindate;

    @SerializedName("memstatus")
    @Expose
    private Boolean status;
    @SerializedName("memimage")
    @Expose
    private String image;
    @SerializedName("memdescr")
    @Expose
    private String desc;
    @SerializedName( "mempassword" )
    @Expose
    private String password;

    @SerializedName( "memeditedon" )
    @Expose
    private String editon;

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

    public String getaadhar() {
        return memaadhaar;
    }

    public void setaadhar(String address) {
        this.memaadhaar = address;
    }

    public String getaddress() {
        return memaddress;
    }

    public void setaddress(String addernumber) {
        this.memaddress = addernumber;
    }

    public String getDate() {
        return memjoindate;
    }

    public void setDate(String date) {
        this.memjoindate = date;
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

    public String getPassword(){return password;}
    public void setPassword(String password){
        this.password=password;
    }

    public String getEditon() {
        return editon;
    }

    public void setEditon(String editon) {
        this.editon = editon;
    }
}
