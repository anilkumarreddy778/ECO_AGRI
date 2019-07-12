package steedserv.com.eco_agri.server.callbacks;

import steedserv.com.eco_agri.server.pojo.Cattles_idnameListResponse;

/**
 * Created by admin on 12-Jul-19.
 */

public interface GetCattlesIdNameCallback {
    void onSuccessResponse(Cattles_idnameListResponse response);

    void onFailure(String s);
}

