package steedserv.com.eco_agri.server;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import steedserv.com.eco_agri.server.pojo.BreedsListResponse;
import steedserv.com.eco_agri.server.pojo.CategoryListResponse;
import steedserv.com.eco_agri.server.pojo.CategoryResponse;
import steedserv.com.eco_agri.server.pojo.CattlesListResponse;
import steedserv.com.eco_agri.server.pojo.CattlesResponse;
import steedserv.com.eco_agri.server.pojo.Cattles_idnameListResponse;
import steedserv.com.eco_agri.server.pojo.MemberListByIdResponse;
import steedserv.com.eco_agri.server.pojo.MemberListResponse;
import steedserv.com.eco_agri.server.pojo.MemberResponse;
import steedserv.com.eco_agri.server.pojo.MilkPriceListResponse;
import steedserv.com.eco_agri.server.pojo.MilkpriceResponse;
import steedserv.com.eco_agri.server.pojo.SaveCategoryRequest;
import steedserv.com.eco_agri.server.pojo.SaveCattlesRequest;
import steedserv.com.eco_agri.server.pojo.SaveMemberRequest;
import steedserv.com.eco_agri.server.pojo.SaveMilkPriceRequest;


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

    @POST("/Myfram/MyFram/CategoryService/SaveCategory")
    Call<CategoryResponse> saveCategory(@Body SaveCategoryRequest saveCategoryRequest);

    @GET("/Myfram/MyFram/CategoryService/ReadCategory")
    Call<CategoryListResponse> getCategoryList();

    @GET("/Myfram/MyFram/BreedsService/ReadBreeds")
    Call<BreedsListResponse> getBreedsList();

    @POST("/Myfram/MyFram/CattlesService/SaveCattles")
    Call<CattlesResponse> saveCattles(@Body SaveCattlesRequest request);

    @GET("/Myfram/MyFram/CattlesService/ReadCattles")
    Call<CattlesListResponse> getCattlesList();

    @GET("/Myfram/MyFram/CattlesService/ReadCattleidn")
    Call<Cattles_idnameListResponse> getCattleidname();

    @POST("/Myfram/MyFram/MilkPriceService/UpdateMilkprice")
    Call<MilkpriceResponse> updateprice(@Body SaveMilkPriceRequest saveMilkPriceRequest);

    @GET("/Myfram/MyFram/MilkPriceService/ReadMilkPrice")
    Call<MilkPriceListResponse> getMilkpriceList();
}
