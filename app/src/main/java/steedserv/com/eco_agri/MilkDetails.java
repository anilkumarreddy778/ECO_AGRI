package steedserv.com.eco_agri;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MilkDetails extends AppCompatActivity {

    MilkAdapter MilkAdapter;

    private Activity mActivity;

    private EditText mdashfromdate=null;
    private EditText mdashtodate=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk_details);

        mActivity = MilkDetails.this;
        RecyclerView recyclerview=findViewById(R.id.milk_list);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        MilkAdapter=new MilkAdapter(getApplicationContext());
        recyclerview.setAdapter(MilkAdapter);

        final Calendar cld=Calendar.getInstance();
        int mYear=cld.get( Calendar.YEAR );
        int mMonth=cld.get( Calendar.MONTH );
        int mDay=cld.get( Calendar.DAY_OF_MONTH );

        mdashfromdate=(EditText) findViewById( R.id.milkfromdate );
        mdashfromdate.setText( mDay+"-"+mMonth+"-"+mYear );
        mdashtodate=(EditText)  findViewById( R.id.milktodate );
        mdashtodate.setText( mDay+"-"+mMonth+"-"+mYear );


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

    }

    public void goBackToHomepage(View view)
    {
        finish();
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
}
