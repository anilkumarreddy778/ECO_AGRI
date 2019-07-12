package steedserv.com.eco_agri.server.callbacks;

import steedserv.com.eco_agri.server.pojo.CattlesResponse;

/**
 * Created by admin on 11-Jul-19.
 */

public interface saveCattlesCallback {
    void onSuccessResponse(CattlesResponse response);

    void onFailure(String s);
}
