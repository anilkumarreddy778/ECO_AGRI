package steedserv.com.eco_agri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class view_animals_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animals_details);
    }

    public void closeScreen(View view) {
        finish();
    }


    public void goBackToHomepage(View view)
    {
        finish();
    }
}
