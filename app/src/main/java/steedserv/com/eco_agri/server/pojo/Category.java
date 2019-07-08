package steedserv.com.eco_agri.server.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 04-Jul-19.
 */

public class Category {

    @SerializedName( "catid" )
    @Expose
    private int catid;
    @SerializedName("catname")
    @Expose
    private String catname;
    @SerializedName( "catupdated" )
    @Expose
    private String catupdated;
    @SerializedName( "trstypeid" )
    @Expose
    private int trstypeid;
    @SerializedName( "parentid" )
    @Expose
    private int parentid;

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getCatupdated() {
        return catupdated;
    }

    public void setCatupdated(String catupdated) {
        this.catupdated = catupdated;
    }

    public int getTrstypeid() {
        return trstypeid;
    }

    public void setTrstypeid(int trstypeid) {
        this.trstypeid = trstypeid;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }
}
