package steedserv.com.eco_agri.server.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MemberListByIdResponse {


    @SerializedName("data")
    @Expose
    private List<MemberById> data = new ArrayList<>();

    public List<MemberById> getData() {
        return data;
    }

    public void setData(List<MemberById> data) {
        this.data = data;
    }

}
