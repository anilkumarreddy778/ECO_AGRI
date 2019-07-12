package steedserv.com.eco_agri.server.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 11-Jul-19.
 */

public class Breeds {
    @SerializedName( "breedid" )
    @Expose
    private int breedid;
    @SerializedName("breedname")
    @Expose
    private String breedname;

    public int getBreedid() {
        return breedid;
    }

    public void setBreedid(int breedid) {
        this.breedid = breedid;
    }

    public String getBreedname() {
        return breedname;
    }

    public void setBreedname(String breedname) {
        this.breedname = breedname;
    }
}
