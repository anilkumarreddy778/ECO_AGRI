package steedserv.com.eco_agri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Shares_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shares_details);

        RecyclerView cycleview=(RecyclerView)findViewById(R.id.shares_members_list);
        cycleview.setLayoutManager(new LinearLayoutManager(this));
        ShareMember_Adapter sharemember=new ShareMember_Adapter(getApplicationContext());
        cycleview.setAdapter(sharemember);
    }
}
