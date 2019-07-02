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
    @SerializedName("memaadhaar")
    @Expose
    private String memaadhaar;
    @SerializedName("memaddress")
    @Expose
    private String addernumber;
    @SerializedName("memjoindate")
    @Expose
    private long date;
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
        return memaadhaar;
    }

    public void setAddress(String address) {
        this.memaadhaar = address;
    }

    public String getAddernumber() {
        return addernumber;
    }

    public void setAddernumber(String addernumber) {
        this.addernumber = addernumber;
    }

    public long getDate() {
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

    public String getPassword(){return password;}
    public void setPassword(String password){
        this.password=password;
    }
}
