package steedserv.com.eco_agri.server.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 11-Jul-19.
 */

public class CattlesListResponse {
    @SerializedName("data")
    @Expose

    private List<Cattles> data = new ArrayList<>();

    public List<Cattles> getData() {
        return data;
    }

    public void setData(List<Cattles> data) {
        this.data = data;
    }
}
