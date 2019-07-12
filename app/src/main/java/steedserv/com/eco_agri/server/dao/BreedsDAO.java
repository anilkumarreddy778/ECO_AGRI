package steedserv.com.eco_agri.server.dao;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import steedserv.com.eco_agri.server.ApiClient;
import steedserv.com.eco_agri.server.ApiInterface;
import steedserv.com.eco_agri.server.callbacks.GetBreedsCallback;
import steedserv.com.eco_agri.server.pojo.BreedsListResponse;

/**
 * Created by admin on 11-Jul-19.
 */

public class BreedsDAO {

    private static final BreedsDAO instance=new BreedsDAO();

    public static BreedsDAO getInstance() {
        return instance;
    }


    public static void getBreedsList(final GetBreedsCallback callback){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<BreedsListResponse> call = apiService.getBreedsList();
        call.enqueue( new Callback<BreedsListResponse>() {
            @Override
            public void onResponse(Call<BreedsListResponse> call, Response<BreedsListResponse> response) {
                if(response.body()!=null) {
                    callback.onSuccessResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<BreedsListResponse> call, Throwable t) {
                callback.onFailure(t.toString());
            }
        } );
    }
}
