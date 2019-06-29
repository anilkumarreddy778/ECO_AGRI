package steedserv.com.eco_agri;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import java.util.Calendar;


public class add_animals_details extends AppCompatActivity {

    Activity mActivity;
    EditText addanimldate;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animals_details);

        mActivity=add_animals_details.this;

        final Calendar cld=Calendar.getInstance();
        int mYear=cld.get( cld.YEAR );
        int mMonth=cld.get( cld.MONTH );
        int mDay=cld.get( cld.DAY_OF_MONTH );


        addanimldate=findViewById( R.id.addanimldate );
        addanimldate.setText( mDay+"-"+mMonth+"-"+mYear );
        addanimldate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker( addanimldate );

            }
        } );

        RadioGroup group=(RadioGroup) findViewById( R.id.animaltype );
        final LinearLayout layout=(LinearLayout) findViewById( R.id.aniparent );
        final TextInputLayout inputEditText=(TextInputLayout) findViewById( R.id.aniamount );
        group.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.aninew)
                {
                    layout.setVisibility( view.GONE );
                    inputEditText.setVisibility( view.VISIBLE );

                }
                else if(checkedId==R.id.anichild)
                {
                    inputEditText.setVisibility( view.GONE );
                    layout.setVisibility( view.VISIBLE );
                }
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
    public void goBacktoAnimalsdetails(View view)
    {
        finish();
    }

    public void goBackToHomepage(View view)
    {
        finish();
    }
}
