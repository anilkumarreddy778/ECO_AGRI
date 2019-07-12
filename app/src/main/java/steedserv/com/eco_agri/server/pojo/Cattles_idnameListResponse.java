package steedserv.com.eco_agri.server.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 12-Jul-19.
 */

public class Cattles_idnameListResponse {

    @SerializedName("data")
    @Expose
    private List<Cattles_idname> data = new ArrayList<>();

    public List<Cattles_idname> getData() {
        return data;
    }

    public void setData(List<Cattles_idname> data) {
        this.data = data;
    }
}
