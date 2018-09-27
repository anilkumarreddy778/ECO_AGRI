package steedserv.com.eco_agri;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import steedserv.com.eco_agri.server.pojo.wages;

public class Daily_wages extends AppCompatActivity {

    List<wages> mdailywagesList = new ArrayList<>();
    dailyWagesAdapter mdailyWagesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_wages);

        RecyclerView recyclerview=findViewById(R.id.vagedetails);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        mdailyWagesAdapter=new dailyWagesAdapter(getApplicationContext(),mdailywagesList);
        recyclerview.setAdapter(mdailyWagesAdapter);
    }

    public void goToHomescreen(View view)
    {
        finish();
    }

    public void gotoaddDailyWages(View view)
    {
        Intent addwages=new Intent(Daily_wages.this,AddDailywages.class);
        startActivity(addwages);
    }
}
