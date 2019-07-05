package steedserv.com.eco_agri.server.dao;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import steedserv.com.eco_agri.server.ApiClient;
import steedserv.com.eco_agri.server.ApiInterface;
import steedserv.com.eco_agri.server.callbacks.GetCategoryCallback;
import steedserv.com.eco_agri.server.callbacks.saveCategoryCallback;
import steedserv.com.eco_agri.server.pojo.CategoryListResponse;
import steedserv.com.eco_agri.server.pojo.CategoryResponse;
import steedserv.com.eco_agri.server.pojo.SaveCategoryRequest;

/**
 * Created by admin on 04-Jul-19.
 */

public class CategoryDAO {


    private static final CategoryDAO instance=new CategoryDAO();

    public static CategoryDAO getInstance(){
        return instance;
    }

    //saveCategory
    public void saveCategory(SaveCategoryRequest saveCategoryRequest, final saveCategoryCallback saveCategoryCallback){

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<CategoryResponse> call=apiService.saveCategory(saveCategoryRequest);
        call.enqueue( new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if(response.body()!=null) {
                    saveCategoryCallback.onSuccessResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                saveCategoryCallback.onFailure( t.toString() );
            }
        } );
    }

    //get list
    public  static void getCategoryList(final GetCategoryCallback categoryCallback)
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<CategoryListResponse> call = apiService.getCategoryList();
        call.enqueue( new Callback<CategoryListResponse>() {
            @Override
            public void onResponse(Call<CategoryListResponse> call, Response<CategoryListResponse> response) {
                if(response.body()!=null) {
                    categoryCallback.onSuccessResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<CategoryListResponse> call, Throwable t) {
                categoryCallback.onFailure(t.toString());
            }
        } );
    }
}
