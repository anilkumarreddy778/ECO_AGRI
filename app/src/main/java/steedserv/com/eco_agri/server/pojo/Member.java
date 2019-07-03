package steedserv.com.eco_agri.server.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Member implements Serializable{

    @SerializedName("memid")
    @Expose
    private String memid;

    @SerializedName("memname")
    @Expose
    private String memname;
    @SerializedName("memphone")
    @Expose
    private String memphone;
    @SerializedName("mememailid")
    @Expose
    private String mememailid;

    @SerializedName("memaddress")
    @Expose
    private String memaddress;

    @SerializedName("memaadhaar")
    @Expose
    private String memaadhaar;

    @SerializedName("memjoindate")
    @Expose
    private String memjoindate;

    @SerializedName("memstatus")
    @Expose
    private Boolean memstatus;
    @SerializedName("memimage")
    @Expose
    private String memimage;
    @SerializedName("memdescr")
    @Expose
    private String memdescr;
    @SerializedName( "mempassword" )
    @Expose
    private String password;


    public String getUserId() {
        return memid;
    }

    public void setUserId(String userId) {
        this.memid = userId;
    }

    public String getName() {
        return memname;
    }

    public void setName(String name) {
        this.memname = name;
    }

    public String getMobileNumber() {
        return memphone;
    }

    public void setMobileNumber(String mobileNumber) {
        this.memphone = mobileNumber;
    }

    public String getEmailId() {
        return mememailid;
    }

    public void setEmailId(String emailId) {
        this.mememailid = emailId;
    }

    public String getAddress() {
        return memaddress;
    }

    public void setAddress(String address) {
        this.memaddress = address;
    }

    public String getAddernumber() {
        return memaadhaar;
    }

    public void setAddernumber(String addernumber) {
        this.memaadhaar = addernumber;
    }

    public String getDate() {
        return memjoindate;
    }

//dd
    public void setDate(String date) {
        this.memjoindate = date;
    }

    public Boolean getStatus() {
        return memstatus;
    }

    public void setStatus(Boolean status) {
        this.memstatus = status;
    }

    public String getImage() {
        return memimage;
    }

    public void setImage(String image) {
        this.memimage = image;
    }

    public String getDesc() {
        return memdescr;
    }

    public void setDesc(String desc) {
        this.memdescr = desc;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
