package steedserv.com.eco_agri.server.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 11-Jul-19.
 */

public class BreedsListResponse {

    @SerializedName("data")
    @Expose
    private List<Breeds> data = new ArrayList<>();

    public List<Breeds> getData() {
        return data;
    }

    public void setData(List<Breeds> data) {
        this.data = data;
    }
}
