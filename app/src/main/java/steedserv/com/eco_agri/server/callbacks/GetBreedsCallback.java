package steedserv.com.eco_agri.server.callbacks;

import steedserv.com.eco_agri.server.pojo.BreedsListResponse;

/**
 * Created by admin on 11-Jul-19.
 */

public interface GetBreedsCallback {

    void onSuccessResponse(BreedsListResponse response);

    void onFailure(String s);
}
