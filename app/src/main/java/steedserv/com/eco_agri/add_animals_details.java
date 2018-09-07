package steedserv.com.eco_agri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class add_animals_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animals_details);
    }

    public void goBacktoAnimalsdetails(View view)
    {
        finish();
    }

    public void goBackToHomepage(View view)
    {
        finish();
    }
}
