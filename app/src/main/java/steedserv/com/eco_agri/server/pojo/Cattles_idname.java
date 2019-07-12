package steedserv.com.eco_agri.server.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by admin on 12-Jul-19.
 */

public class Cattles_idname implements Serializable {

    @SerializedName("aniid")
    @Expose
    private int aniid;

    @SerializedName("aniname")
    @Expose
    private String aniname;

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
}
