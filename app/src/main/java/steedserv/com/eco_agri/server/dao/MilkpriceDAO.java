package steedserv.com.eco_agri.server.dao;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import steedserv.com.eco_agri.server.ApiClient;
import steedserv.com.eco_agri.server.ApiInterface;
import steedserv.com.eco_agri.server.callbacks.GetMilkPriceCallback;
import steedserv.com.eco_agri.server.callbacks.SaveMilkPriceCallback;
import steedserv.com.eco_agri.server.pojo.MilkPriceListResponse;
import steedserv.com.eco_agri.server.pojo.MilkpriceResponse;
import steedserv.com.eco_agri.server.pojo.SaveMilkPriceRequest;

/**
 * Created by admin on 18-Jul-19.
 */

public class MilkpriceDAO {

    private static final MilkpriceDAO instance=new MilkpriceDAO();
    public static MilkpriceDAO getInstance() {
        return instance;
    }


    //updatepirce
    public void updateprice(SaveMilkPriceRequest saveMilkPriceRequest, final SaveMilkPriceCallback callback)
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MilkpriceResponse> call = apiService.updateprice(saveMilkPriceRequest);
        call.enqueue(new Callback<MilkpriceResponse>() {
            @Override
            public void onResponse(Call<MilkpriceResponse>call, Response<MilkpriceResponse> response) {
                if(response.body()!=null) {
                    callback.onSuccessResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<MilkpriceResponse>call, Throwable t) {
                callback.onFailure(t.toString());
            }
        });
    }

    //getMemberList
    public static void getMilkpriceList(final GetMilkPriceCallback callback)
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MilkPriceListResponse> call = apiService.getMilkpriceList();
        call.enqueue(new Callback<MilkPriceListResponse>() {
            @Override
            public void onResponse(Call<MilkPriceListResponse>call, Response<MilkPriceListResponse> response) {
                if(response.body()!=null) {
                    callback.onSuccessResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<MilkPriceListResponse>call, Throwable t) {
                callback.onFailure(t.toString());
            }
        });

    }
}
