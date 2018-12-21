package steedserv.com.eco_agri;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class homepage extends AppCompatActivity implements homeFragment.OnFragmentInteractionListener,add_milk_Fragment.OnFragmentInteractionListener,report_Fragment.OnFragmentInteractionListener,reports_Fragment.OnFragmentInteractionListener
{
    private ActionBar toolbare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbare = getSupportActionBar();


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        toolbar.setTitle("Home");

        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new Bottom_navigation_hiding());

//by default loading the fragment in home page
        toolbar.setTitle("Home");
        loadFragment(new homeFragment());
        toolbar.hasFocus();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;

            switch (item.getItemId())
            {
                case R.id.navigation_home:
                    toolbare.setTitle("Menu");
                    fragment = new homeFragment();
                    loadFragment(fragment);
                    return true;

                case R.id.navigation_addwages:
                    toolbare.setTitle("Add Wages");
                    fragment=new report_Fragment();
                    loadFragment(fragment);
//                    Intent intent=new Intent(homepage.this,AddDailywages.class);
//                    startActivity(intent);
                    return true;

                case R.id.navigation_addmilk:
                    toolbare.setTitle("Add Milk");
                    fragment=new add_milk_Fragment();
                    loadFragment(fragment);
                    return true;

                case R.id.navigation_reports:
                    toolbare.setTitle("Reports");
                    fragment=new reports_Fragment();
                    loadFragment(fragment);
                    return true;





            }
            return true;
        }
    };

    private void loadFragment(Fragment fragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        //transaction.addToBackStack(null);
        transaction.commit();
        //transaction.isEmpty();
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

    public void goDailyWagesdetails(View view)
    {
        Intent wages=new Intent(homepage.this,Daily_wages.class);
        startActivity(wages);
    }

    public void gotomilkdetails(View view)
    {
        Intent milk=new Intent(homepage.this,MilkDetails.class);
        startActivity(milk);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.navigation_home:
                Intent member=new Intent(homepage.this,members_details.class);
                startActivity(member);
                Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.navigation_addwages:
                Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.navigation_addmilk:
                Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.navigation_reports:
                Toast.makeText(getApplicationContext(),"Item 4 Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri)
    {

    }


    public void gobacktowagesdetalis(View view)
    {
        finish();
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


