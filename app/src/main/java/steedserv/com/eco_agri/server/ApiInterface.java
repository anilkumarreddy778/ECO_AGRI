package steedserv.com.eco_agri.server;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import steedserv.com.eco_agri.server.pojo.MemberListResponse;
import steedserv.com.eco_agri.server.pojo.MemberResponse;
import steedserv.com.eco_agri.server.pojo.SaveMemberRequest;



public interface ApiInterface {

    @POST("/memberservice/saveMember")
    Call<MemberResponse> saveMember(SaveMemberRequest request);

    @GET("/memberservice/")
    Call<MemberListResponse> getMemberList();
}
