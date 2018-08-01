package steedserv.com.eco_agri;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    public void goToAnimalsDetails(View view) {
        Intent intent=new Intent(homepage.this,animalDetails.class);
        startActivity(intent);
    }

    public void goToMembersdetails(View view)
    {
        Intent member=new Intent(homepage.this,members_details.class);
        startActivity(member);
    }

    public void goToShareHoldersDetails(View view)
    {
    Intent share=new Intent(homepage.this,Shares_details.class);
    startActivity(share);
    }
}
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
//                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
//                    return true;
//                case R.id.navigation_calendar:
//                    mTextMessage.setText(R.string.title_calendar);
//                    return true;
//            }
//            return false;
//        }
//    };



//        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);




//    public void gotoAdditems() {
//        Intent intent = new Intent(homepage.this, Login.class);
//        startActivity(intent);
//    }


   //    this popup screen code
//    public void showpopup(View view) {
//        View view1 = LayoutInflater.from(this).inflate(R.layout.homepopupvalues, null);
//
//        final AlertDialog dialog = new AlertDialog.Builder(this)
//                .setView(view1)
//                .setCancelable(true)
//                .setTitle("Enter Details :")
//                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener()
//                {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which)
//                    {
//                        dialog.dismiss();
//                    }
//                }) //Set to null. We override the onclick
//                .setNegativeButton(android.R.string.cancel, null)
//                .create();
//        dialog.setOnShowListener(new DialogInterface.OnShowListener()
//        {
//            @Override
//            public void onShow(final DialogInterface dialog)
//            {
//                Button b = ((AlertDialog)dialog).getButton(AlertDialog.BUTTON_POSITIVE);
//                b.setOnClickListener(new View.OnClickListener()
//                {
//                    @Override
//                    public void onClick(View view)
//                    {
//
//                    }
//                });
//            }
//        });
//        dialog.show();
//    }

//        GridView gridview = (GridView) findViewById(R.id.gridview);
//        gridview.setAdapter(new ImageAdapter(this));
//
//        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                Toast.makeText(homepage.this, "" + position, Toast.LENGTH_SHORT).show();
//            }
//        });


