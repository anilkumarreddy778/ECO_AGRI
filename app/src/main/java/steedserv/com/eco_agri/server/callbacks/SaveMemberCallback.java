package steedserv.com.eco_agri.server.callbacks;

import steedserv.com.eco_agri.server.pojo.MemberResponse;



public interface SaveMemberCallback {
     void onSuccessResponse(MemberResponse response);

    void onFailure(String s);
}
