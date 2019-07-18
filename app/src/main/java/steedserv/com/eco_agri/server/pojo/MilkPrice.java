package steedserv.com.eco_agri.server.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by admin on 18-Jul-19.
 */

public class MilkPrice implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("milkprice")
    @Expose
    private String milkprice;

    @SerializedName( "updatetime" )
    @Expose
    private String updated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMilkprice() {
        return milkprice;
    }

    public void setMilkprice(String milkprice) {
        this.milkprice = milkprice;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
