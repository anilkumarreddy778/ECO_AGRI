package steedserv.com.eco_agri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class members_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members_details);
    }


    public void goToAddMemebersDetails(View view)
    {
Intent intent=new Intent(members_details.this,add_members_details.class);
startActivity(intent);
    }

}
