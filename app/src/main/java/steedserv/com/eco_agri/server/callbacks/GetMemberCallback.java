package steedserv.com.eco_agri.server.callbacks;

import steedserv.com.eco_agri.server.pojo.MemberListResponse;



public interface GetMemberCallback {
    void onSuccessResponse(MemberListResponse response);

    void onFailure(String s);
}
