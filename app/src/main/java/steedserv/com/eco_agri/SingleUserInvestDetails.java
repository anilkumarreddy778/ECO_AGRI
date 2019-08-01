package steedserv.com.eco_agri;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.Calendar;

public class SingleUserInvestDetails extends AppCompatActivity {

    private Context mContext;
    private Activity mActivity;
    private PopupWindow mPopupWindow;
    private RelativeLayout mRelativeLayout;
    private Button mbuttontake;
    private ImageButton mgohome;

    Fragment fragment = null;
   // private ImageButton mButtoninvest;

    SingleUserInvestAdapter single;
    FloatingActionButton floatingActionButton;
    private Context applicationContext;

    private EditText mdashfromdate=null;
    private EditText mdashtodate=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_single_user_invest_details );

        RecyclerView singleshare = (RecyclerView) findViewById( R.id.my_shares_members_list );
        singleshare.setLayoutManager( new LinearLayoutManager( this ) );
        single = new SingleUserInvestAdapter( getApplicationContext() );
        singleshare.setAdapter( single );
//          View view = null;

        mContext = getApplicationContext();
        mActivity = SingleUserInvestDetails.this;
        mRelativeLayout = (RelativeLayout) findViewById( R.id.singleivestparent );

        final Calendar cld = Calendar.getInstance();
        int mYear = cld.get(Calendar.YEAR);
        int mMonth = cld.get(Calendar.MONTH);
        int mDay = cld.get(Calendar.DAY_OF_MONTH);


        mdashfromdate=(EditText) findViewById( R.id.dashfromdate );
        mdashfromdate.setText(mDay+"-"+mMonth+"-"+mYear);
        mdashtodate=(EditText) findViewById( R.id.dashtodate );
        mdashtodate.setText(mDay+"-"+mMonth+"-"+mYear);

        mdashfromdate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker( mdashfromdate );
            }
        } );

        mdashtodate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker( mdashtodate );

            }
        } );

        mbuttontake = (Button) findViewById( R.id.addtakeoutmoney );
        mbuttontake.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService( LAYOUT_INFLATER_SERVICE );
                View customView = inflater.inflate( R.layout.popup_add_takeout_single_invest, null );
                mPopupWindow = new PopupWindow( customView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT );
                mPopupWindow.setWidth( 1080 );

                mPopupWindow.setFocusable( true );
                mPopupWindow.update();

                ImageButton closeButton = (ImageButton) customView.findViewById( R.id.sinvestclose );
                EditText editText = null;
                editText = customView.findViewById( R.id.addtakesdate );
                final EditText finalEditText2 = editText;
                editText.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        datePicker( finalEditText2 );
                    }
                } );

                closeButton.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();
                    }
                } );


                FloatingActionButton addbutton = customView.findViewById( R.id.addtakoutsinvst );
                final EditText finalEditText = editText;
                addbutton.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //need to write java add category code
                    }
                } );
                mPopupWindow.showAtLocation( mRelativeLayout, Gravity.CENTER, 0, 0 );
            }
        } );

                 mgohome=(ImageButton) findViewById( R.id.gohome );
                 mgohome.setOnClickListener( new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         fragment=new frag_transactions();
                     }
                 } );
    }

    public void datePicker(final EditText Date)
    {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(mActivity,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        Date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMaxDate((Calendar.getInstance().getTimeInMillis()));
        datePickerDialog.show();
    }
    public void goBackToShareDetails(View view)
    {
        finish();
    }

}
