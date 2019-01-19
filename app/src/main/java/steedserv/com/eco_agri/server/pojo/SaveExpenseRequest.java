package steedserv.com.eco_agri.server.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SaveExpenseRequest {


    @SerializedName("addedById")
    @Expose
    private Integer addedById;
    @SerializedName("addedByName")
    @Expose
    private String addedByName;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("totalAmount")
    @Expose
    private Double totalAmount;
    @SerializedName("expenseDetail")
    @Expose
    private List<ExpenseDetail> expenseDetail = null;

    public Integer getAddedById() {
        return addedById;
    }

    public void setAddedById(Integer addedById) {
        this.addedById = addedById;
    }

    public String getAddedByName() {
        return addedByName;
    }

    public void setAddedByName(String addedByName) {
        this.addedByName = addedByName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<ExpenseDetail> getExpenseDetail() {
        return expenseDetail;
    }

    public void setExpenseDetail(List<ExpenseDetail> expenseDetail) {
        this.expenseDetail = expenseDetail;
    }

}
