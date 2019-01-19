package steedserv.com.eco_agri.server.dao;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import steedserv.com.eco_agri.server.ApiClient;
import steedserv.com.eco_agri.server.ApiInterface;
import steedserv.com.eco_agri.server.callbacks.GetMemberByIDCallback;
import steedserv.com.eco_agri.server.callbacks.GetMemberCallback;
import steedserv.com.eco_agri.server.callbacks.SaveMemberCallback;
import steedserv.com.eco_agri.server.pojo.MemberListByIdResponse;
import steedserv.com.eco_agri.server.pojo.MemberListResponse;
import steedserv.com.eco_agri.server.pojo.MemberResponse;
import steedserv.com.eco_agri.server.pojo.SaveMemberRequest;


public class MemberDAO {

    private static final MemberDAO instance=new MemberDAO();

    public static MemberDAO getInstance() {
        return instance;
    }

    //saveMember
    public void saveMember(SaveMemberRequest typeMemberRequest, final SaveMemberCallback callback)
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MemberResponse> call = apiService.saveMember(typeMemberRequest);
        call.enqueue(new Callback<MemberResponse>() {
            @Override
            public void onResponse(Call<MemberResponse>call, Response<MemberResponse> response) {
                if(response.body()!=null) {
                    callback.onSuccessResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<MemberResponse>call, Throwable t) {
                callback.onFailure(t.toString());
            }
        });

    }
    //getMemberList
    public static void getMemberList(final GetMemberCallback callback)
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MemberListResponse> call = apiService.getMemberList();
        call.enqueue(new Callback<MemberListResponse>() {
            @Override
            public void onResponse(Call<MemberListResponse>call, Response<MemberListResponse> response) {
                if(response.body()!=null) {
                    callback.onSuccessResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<MemberListResponse>call, Throwable t) {
                callback.onFailure(t.toString());
            }
        });

    }

//deletMember
    public void deleteMember(String userId, final SaveMemberCallback callback)
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MemberResponse> call = apiService.deleteMember(userId);
        call.enqueue(new Callback<MemberResponse>() {
            @Override
            public void onResponse(Call<MemberResponse>call, Response<MemberResponse> response) {
                if(response.body()!=null) {
                    callback.onSuccessResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<MemberResponse>call, Throwable t) {
                callback.onFailure(t.toString());
            }
        });

    }

//updatemember
    public void updateMember(SaveMemberRequest saveMemberRequest, final  SaveMemberCallback callback)
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MemberResponse> call = apiService.updateMember(saveMemberRequest);
        call.enqueue(new Callback<MemberResponse>() {
            @Override
            public void onResponse(Call<MemberResponse>call, Response<MemberResponse> response) {
                if(response.body()!=null) {
                    callback.onSuccessResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<MemberResponse>call, Throwable t) {
                callback.onFailure(t.toString());
            }
        });
    }

    //getMemberListById
    public static void getMemberListById(final GetMemberByIDCallback callback)
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MemberListByIdResponse> call = apiService.getMemberListById();
        call.enqueue(new Callback<MemberListByIdResponse>() {
            @Override
            public void onResponse(Call<MemberListByIdResponse>call, Response<MemberListByIdResponse> response) {
                if(response.body()!=null) {
                    callback.onSuccessResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<MemberListByIdResponse>call, Throwable t) {
                callback.onFailure(t.toString());
            }
        });

    }
}
