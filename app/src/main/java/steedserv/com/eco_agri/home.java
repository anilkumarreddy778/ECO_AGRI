package steedserv.com.eco_agri;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

//
//        FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
//        fab.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent( home.this,addMilkPrice.class );
//                startActivity( intent );
////                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
////                        .setAction( "Action", null ).show();
//            }
//        } );


        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener( this );

        //default fragemnt calling
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame,new frag_Dashboard());
        transaction.commit();
        //add this line to display categoryViewAdd when the activity is loaded
        displaySelectedScreen( R.id.action_settings );
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.home, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected( item );
    }

    private void displaySelectedScreen(int itemId) {
        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.home:
                fragment=new frag_Dashboard();
                break;
//            case R.id.wages:
//                Intent intent2=new Intent( home.this,Daily_wages.class );
//               startActivity( intent2 );
//                break;
            case R.id.milk:
                Intent intent4=new Intent( home.this,MilkDetails.class );
                startActivity( intent4 );
                break;
//            case R.id.report:
//                fragment=new add_milk_Fragment();
//                break;
            case R.id.invest:
                Intent invest=new Intent( home.this,Shares_details.class );
                startActivity( invest );
                break;
            case R.id.cat:
                fragment = new categoryViewAdd();
                break;

            case R.id.milkprice:
                fragment = new addMilkPrice();
                break;
            case R.id.member:
                Intent intent=new Intent( home.this,members_details.class );
                startActivity( intent );
                break;
            case R.id.cattles:
                Intent intent1=new Intent( home.this,animalDetails.class );
                startActivity( intent1 );
                break;

            default:
                break;

        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace( R.id.content_frame, fragment );
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {


        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen( item.getItemId() );
        //make this method blank
        return true;
    }

}


        // Handle navigation view item clicks here.
        // int id = item.getItemId();

//        if (id == R.id.member) {
//
//            Intent member=new Intent( home.this,addMilkPrice.class );
//            startActivity( member );
//            // Handle the camera action
//        } else if (id == R.id.cattles) {
//
//            Intent cattle=new Intent( home.this,animalDetails.class );
//            startActivity( cattle );
//
//        } else if (id == R.id.wages) {
//
//        Intent wages=new Intent( home.this,Daily_wages.class );
//        startActivity( wages );
//        } else if (id == R.id.milk) {
//
//            Fragment fragment= new Fragment();
//        } else if (id == R.id.milkprice) {
//        Intent price=new Intent(home.this,milkPrice.class);
//        startActivity( price );
//        }
//        else if (id == R.id.report) {
//
//
//        }

//        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
//        drawer.closeDrawer( GravityCompat.START );
//        return true;


