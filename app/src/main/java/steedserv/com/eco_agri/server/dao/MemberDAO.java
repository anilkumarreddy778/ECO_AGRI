package steedserv.com.eco_agri.server.dao;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import steedserv.com.eco_agri.server.ApiClient;
import steedserv.com.eco_agri.server.ApiInterface;
import steedserv.com.eco_agri.server.callbacks.SaveMemberCallback;
import steedserv.com.eco_agri.server.pojo.MemberResponse;
import steedserv.com.eco_agri.server.pojo.SaveMemberRequest;

/**
 * Created by admin on 04-Aug-18.
 */

public class MemberDAO {

    private static final MemberDAO instance=new MemberDAO();

    public static MemberDAO getInstance() {
        return instance;
    }

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

}
