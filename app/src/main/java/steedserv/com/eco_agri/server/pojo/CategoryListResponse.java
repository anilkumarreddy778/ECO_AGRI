package steedserv.com.eco_agri.server.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 04-Jul-19.
 */

public class CategoryListResponse {

    @SerializedName( "data" )
    @Expose
    private List<Category> data =new ArrayList<>( );

    public   List<Category> getData(){
        return data;
    }
    public void setData(List<Category> data){
        this.data=data;
    }
}
