package steedserv.com.eco_agri.server.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExpenseDetail {

    @SerializedName("expenseId")
    @Expose
    private Integer expenseId;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("amount")
    @Expose
    private Double amount;

    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
