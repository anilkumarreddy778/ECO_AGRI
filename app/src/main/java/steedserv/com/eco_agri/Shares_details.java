package steedserv.com.eco_agri;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.Calendar;

public class Shares_details extends AppCompatActivity {

    private Context mContext;
    private Activity mActivity;
    private PopupWindow mPopupWindow;
    private RelativeLayout mRelativeLayout;
    private ImageButton mbuttontake;
    private EditText minvesterdate =null;
    frag_transactions frag_transactions=new frag_transactions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shares_details);

        RecyclerView cycleview=(RecyclerView)findViewById(R.id.shares_members_list);
        cycleview.setLayoutManager(new LinearLayoutManager(this));
        ShareMember_Adapter sharemember=new ShareMember_Adapter(getApplicationContext());
        cycleview.setAdapter(sharemember);

        final Calendar cld = Calendar.getInstance();
        int mYear = cld.get(Calendar.YEAR);
        int mMonth = cld.get(Calendar.MONTH);
        int mDay = cld.get(Calendar.DAY_OF_MONTH);

        mContext = getApplicationContext();
        mActivity = Shares_details.this;

        mRelativeLayout = (RelativeLayout) findViewById( R.id.sharesdetails );



        mbuttontake = (ImageButton) findViewById( R.id.addinvester );
        mbuttontake.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService( LAYOUT_INFLATER_SERVICE );
                View customView = inflater.inflate( R.layout.popup_add_invester, null );
                mPopupWindow = new PopupWindow( customView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT );
                mPopupWindow.setWidth( 1000 );
                mPopupWindow.setFocusable( true );
                mPopupWindow.update();

                ImageButton closeButton = (ImageButton) customView.findViewById( R.id.investclose );
                EditText editText = null;
                editText = customView.findViewById( R.id.investerdate );
                final EditText finalEditText1 = editText;
                editText.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        datePicker( finalEditText1 );
                    }
                } );

                closeButton.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();
                    }
                } );


                FloatingActionButton addbutton = customView.findViewById( R.id.addinvesters );
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
    public void goBackToHomepage(View view)
    {
        finish();
    }
}
