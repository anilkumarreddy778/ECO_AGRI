package steedserv.com.eco_agri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TakeoutSingleInvestDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takeout_single_invest_details);
    }

    public void goBackToMyShareDetailss(View view)
    {
        finish();
    }
}
