package steedserv.com.eco_agri.server.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 15-Sep-18.
 */

public class MemberListResponse {

    @SerializedName("data")
    @Expose
    private List<Member> data = new ArrayList<>();

    public List<Member> getData() {
        return data;
    }

    public void setData(List<Member> data) {
        this.data = data;
    }

}
