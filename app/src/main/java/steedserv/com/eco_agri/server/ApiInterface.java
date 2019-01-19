package steedserv.com.eco_agri.server;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import steedserv.com.eco_agri.server.pojo.MemberListByIdResponse;
import steedserv.com.eco_agri.server.pojo.MemberListResponse;
import steedserv.com.eco_agri.server.pojo.MemberResponse;
import steedserv.com.eco_agri.server.pojo.SaveExpenseRequest;
import steedserv.com.eco_agri.server.pojo.SaveMemberRequest;



public interface ApiInterface {

    @POST("/Myfram/MyFram/MemberService/SaveMember")
    Call<MemberResponse> saveMember(@Body  SaveMemberRequest request);

    @GET("/Myfram/MyFram/MemberService/ReadMembers")
    Call<MemberListResponse> getMemberList();

    @GET("/Myfram/MyFram/MemberService/DeleteMembers")
    Call<MemberResponse> deleteMember(@Query("user_id") String userId);

    @POST("/Myfram/MyFram/MemberService/UpdateMember")
    Call<MemberResponse> updateMember(@Body SaveMemberRequest saveMemberRequest);

    @GET("/Myfram/MyFram/MemberService/ReadMembersWithId")
    Call<MemberListByIdResponse> getMemberListById();

    @POST("/Myfram/MyFram/ExpenseService/SaveMember")
    Call<MemberResponse> saveExpense(@Body SaveExpenseRequest saveExpenseRequest);
}
