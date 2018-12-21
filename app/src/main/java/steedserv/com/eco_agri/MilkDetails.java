package steedserv.com.eco_agri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MilkDetails extends AppCompatActivity {

    MilkAdapter MilkAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk_details);


        RecyclerView recyclerview=findViewById(R.id.milk_list);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        MilkAdapter=new MilkAdapter(getApplicationContext());
        recyclerview.setAdapter(MilkAdapter);
    }

    public void goBackToHomepage(View view)
    {
        finish();
    }


}
