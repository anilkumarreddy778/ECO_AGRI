package steedserv.com.eco_agri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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

    public void goToInvestMoney(View view)
    {
        Intent share=new Intent(Shares_details.this,add_investers_details.class);
        startActivity(share);
    }

    public void goBackToHomepage(View view)
    {
        finish();
    }
}
