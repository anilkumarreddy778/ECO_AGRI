package steedserv.com.eco_agri.server.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by admin on 11-Jul-19.
 */

public class Cattles implements Serializable{

    @SerializedName("aniid")
    @Expose
    private int aniid;

    @SerializedName("aniname")
    @Expose
    private String aniname;

    @SerializedName("aninewchild")
    @Expose
    private String aninewchild;

    @SerializedName("aniparentid")
    @Expose
    private int aniparentid;

    @SerializedName("anibreedid")
    @Expose
    private int anibreedid;

    @SerializedName("aniprice")
    @Expose
    private int aniprice;

    @SerializedName("anibuydate")
    @Expose
    private String anibuydate;

    @SerializedName("aniage")
    @Expose
    private int aniage;

    @SerializedName("anibirthcount")
    @Expose
    private int anibirthcount;

    @SerializedName("aniimage")
    @Expose
    private String aniimage;

    @SerializedName("anidesc")
    @Expose
    private String anidesc;

    @SerializedName("anistatus")
    @Expose
    private String anistatus;
    @SerializedName( "aniupdateddate" )
    @Expose
    private String aniupdateddate;


    public int getAniid() {
        return aniid;
    }

    public void setAniid(int aniid) {
        this.aniid = aniid;
    }

    public String getAniname() {
        return aniname;
    }

    public void setAniname(String aniname) {
        this.aniname = aniname;
    }

    public String getAninewchild() {
        return aninewchild;
    }

    public void setAninewchild(String aninewchild) {
        this.aninewchild = aninewchild;
    }

    public int getAniparentid() {
        return aniparentid;
    }

    public void setAniparentid(int aniparentid) {
        this.aniparentid = aniparentid;
    }

    public int getAnibreedid() {
        return anibreedid;
    }

    public void setAnibreedid(int anibreedid) {
        this.anibreedid = anibreedid;
    }

    public int getAniprice() {
        return aniprice;
    }

    public void setAniprice(int aniprice) {
        this.aniprice = aniprice;
    }

    public String getAnibuydate() {
        return anibuydate;
    }

    public void setAnibuydate(String anibuydate) {
        this.anibuydate = anibuydate;
    }

    public int getAniage() {
        return aniage;
    }

    public void setAniage(int aniage) {
        this.aniage = aniage;
    }

    public int getAnibirthcount() {
        return anibirthcount;
    }

    public void setAnibirthcount(int anibirthcount) {
        this.anibirthcount = anibirthcount;
    }

    public String getAniimage() {
        return aniimage;
    }

    public void setAniimage(String aniimage) {
        this.aniimage = aniimage;
    }

    public String getAnidesc() {
        return anidesc;
    }

    public void setAnidesc(String anidesc) {
        this.anidesc = anidesc;
    }

    public String getAnistatus() {
        return anistatus;
    }

    public void setAnistatus(String anistatus) {
        this.anistatus = anistatus;
    }

    public String getAniupdateddate() {
        return aniupdateddate;
    }

    public void setAniupdateddate(String aniupdateddate) {
        this.aniupdateddate = aniupdateddate;
    }
}
