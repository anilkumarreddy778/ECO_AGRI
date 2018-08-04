package steedserv.com.eco_agri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MilkDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk_details);
    }

    public void goBackToHomepage(View view)
    {
        finish();
    }

    public void goToAddmilkcow(View view)
    {

    }
}
