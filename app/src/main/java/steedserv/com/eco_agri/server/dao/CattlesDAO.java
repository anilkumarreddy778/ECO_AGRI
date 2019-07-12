package steedserv.com.eco_agri.server.dao;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import steedserv.com.eco_agri.server.ApiClient;
import steedserv.com.eco_agri.server.ApiInterface;
import steedserv.com.eco_agri.server.callbacks.GetCattlesCallback;
import steedserv.com.eco_agri.server.callbacks.GetCattlesIdNameCallback;
import steedserv.com.eco_agri.server.callbacks.saveCattlesCallback;
import steedserv.com.eco_agri.server.pojo.CattlesListResponse;
import steedserv.com.eco_agri.server.pojo.CattlesResponse;
import steedserv.com.eco_agri.server.pojo.Cattles_idnameListResponse;
import steedserv.com.eco_agri.server.pojo.SaveCattlesRequest;

/**
 * Created by admin on 11-Jul-19.
 */

public class CattlesDAO {

    private  static final  CattlesDAO instance=new CattlesDAO();
    public static CattlesDAO getInstance(){
        return instance;
    }

    //savecattles
    public void saveCattles(SaveCattlesRequest saveCattlesRequest, final saveCattlesCallback callback)
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<CattlesResponse> call = apiService.saveCattles(saveCattlesRequest);
        call.enqueue( new Callback<CattlesResponse>() {
            @Override
            public void onResponse(Call<CattlesResponse> call, Response<CattlesResponse> response) {
                if(response.body()!=null) {
                    callback.onSuccessResponse( response.body() );
                }
            }

            @Override
            public void onFailure(Call<CattlesResponse> call, Throwable t){
                callback.onFailure(t.toString());
            }

            } );

    }


    //list
    public static void getCattlesList(final GetCattlesCallback callback){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<CattlesListResponse> call = apiService.getCattlesList();
        call.enqueue( new Callback<CattlesListResponse>() {
            @Override
            public void onResponse(Call<CattlesListResponse> call, Response<CattlesListResponse> response) {
                if(response.body()!=null) {
                    callback.onSuccessResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<CattlesListResponse> call, Throwable t) {
                callback.onFailure(t.toString());
            }
        } );
    }

    //list id name

    public static void getCattleidname(final GetCattlesIdNameCallback callback){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Cattles_idnameListResponse> call=apiService.getCattleidname();
        call.enqueue( new Callback<Cattles_idnameListResponse>() {
            @Override
            public void onResponse(Call<Cattles_idnameListResponse> call, Response<Cattles_idnameListResponse> response) {
                if(response.body()!=null) {
                    callback.onSuccessResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<Cattles_idnameListResponse> call, Throwable t) {
                callback.onFailure(t.toString());
            }
        } );
    }


}
