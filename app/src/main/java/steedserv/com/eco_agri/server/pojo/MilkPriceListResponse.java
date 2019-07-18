package steedserv.com.eco_agri.server.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 18-Jul-19.
 */

public class MilkPriceListResponse {
    @SerializedName("data")
    @Expose

    private List<MilkPrice> data = new ArrayList<>();

    public List<MilkPrice> getData() {
        return data;
    }

    public void setData(List<MilkPrice> data) {
        this.data = data;
    }
}
