package steedserv.com.eco_agri;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SingleUserInvestDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_user_invest_details);

        RecyclerView singleshare= (RecyclerView)findViewById(R.id.my_shares_members_list);
        singleshare.setLayoutManager(new LinearLayoutManager(this));
        SingleUserInvestAdapter single=new SingleUserInvestAdapter(getApplicationContext());
        singleshare.setAdapter(single);

    }

    public void goBackToShareDetails(View view)
    {
        finish();
    }

    public void goToAddSingleInvest(View view)
    {
        Intent addsinginvest=new Intent(SingleUserInvestDetails.this,AddSingleInvestDetails.class);
        startActivity(addsinginvest);
    }

    public void goToTakeOutSingleInvest(View view)
    {
        Intent takeout=new Intent(SingleUserInvestDetails.this,TakeoutSingleInvestDetails.class);
        startActivity(takeout);
    }


//    public void goToaddMySharesDetails(View view)
//    {
//        Intent myshares=new Intent(SingleUserInvestDetails.this,AddSingleInvestDetails.class);
//        startActivity(myshares);
//    }

   //    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        int itemId = item.getItemId();
//        if (itemId == R.id.navigation_remove) {
//            startActivity(new Intent(this, AddSingleInvestDetails.class));
//        } else if (itemId == R.id.navigation_add) {
//            startActivity(new Intent(this, AddSingleInvestDetails.class));
//        }
//        return true;
//    }
}
