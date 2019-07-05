package steedserv.com.eco_agri.server.callbacks;

import steedserv.com.eco_agri.server.pojo.CategoryResponse;

/**
 * Created by admin on 04-Jul-19.
 */

public interface saveCategoryCallback {
    void onSuccessResponse(CategoryResponse response);

    void onFailure(String s);
}
