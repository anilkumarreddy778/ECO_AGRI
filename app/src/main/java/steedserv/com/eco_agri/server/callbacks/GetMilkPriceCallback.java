package steedserv.com.eco_agri.server.callbacks;

import steedserv.com.eco_agri.server.pojo.MilkPriceListResponse;

/**
 * Created by admin on 18-Jul-19.
 */

public interface GetMilkPriceCallback {

    void onSuccessResponse(MilkPriceListResponse response);

    void onFailure(String s);
}
