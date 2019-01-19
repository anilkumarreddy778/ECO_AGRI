package steedserv.com.eco_agri.server.callbacks;

import steedserv.com.eco_agri.server.pojo.MemberListByIdResponse;

public interface GetMemberByIDCallback {
    void onSuccessResponse(MemberListByIdResponse response);

    void onFailure(String s);

}
