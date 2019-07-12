package steedserv.com.eco_agri.server.callbacks;

import steedserv.com.eco_agri.server.pojo.CattlesListResponse;

/**
 * Created by admin on 11-Jul-19.
 */

public interface GetCattlesCallback {
    void onSuccessResponse(CattlesListResponse response);

    void onFailure(String s);
}
