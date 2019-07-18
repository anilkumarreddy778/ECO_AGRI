package steedserv.com.eco_agri.server.callbacks;

import steedserv.com.eco_agri.server.pojo.MilkpriceResponse;

/**
 * Created by admin on 18-Jul-19.
 */

public interface SaveMilkPriceCallback {
    void onSuccessResponse(MilkpriceResponse response);

    void onFailure(String s);
}
