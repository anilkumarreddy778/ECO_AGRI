package steedserv.com.eco_agri.server.callbacks;

import steedserv.com.eco_agri.server.pojo.CategoryListResponse;

/**
 * Created by admin on 04-Jul-19.
 */

public interface GetCategoryCallback {

    void onSuccessResponse(CategoryListResponse response);

    void onFailure(String s);
}
