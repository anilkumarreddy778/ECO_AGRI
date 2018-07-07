package steedserv.com.eco_agri;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class homepage extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_calendar:
                    mTextMessage.setText(R.string.title_calendar);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

//        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        GridView simpleGrid;
        int animal[] = {R.drawable.farmer, R.drawable.money, R.drawable.seeds, R.drawable.paddy, R.drawable.cow, R.drawable.bufflo, R.drawable.sheep, R.drawable.milkbottle,
                R.drawable.tractor, R.drawable.sickle, R.drawable.technol, R.drawable.home, R.drawable.corn, R.drawable.greenfood,R.drawable.greenfood,R.drawable.greenfood,R.drawable.greenfood,R.drawable.greenfood,R.drawable.greenfood};


        simpleGrid = (GridView) findViewById(R.id.gridview);
        ImageAdapter customAdapter = new ImageAdapter(getApplicationContext(), animal);
        simpleGrid.setAdapter(customAdapter);
    }
    public void gotoAdditems() {
        Intent intent = new Intent(homepage.this, homepage.class);
        startActivity(intent);
    }

    public void showpopup(View view) {
        View view1 = LayoutInflater.from(this).inflate(R.layout.homepopupvalues, null);

        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(view1)
                .setCancelable(true)
                .setTitle("Enter Details :")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                }) //Set to null. We override the onclick
                .setNegativeButton(android.R.string.cancel, null)
                .create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener()
        {
            @Override
            public void onShow(final DialogInterface dialog)
            {
                Button b = ((AlertDialog)dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                b.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {

                    }
                });
            }
        });
        dialog.show();
    }

//    this popup screen code


}


//        GridView gridview = (GridView) findViewById(R.id.gridview);
//        gridview.setAdapter(new ImageAdapter(this));
//
//        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                Toast.makeText(homepage.this, "" + position, Toast.LENGTH_SHORT).show();
//            }
//        });


