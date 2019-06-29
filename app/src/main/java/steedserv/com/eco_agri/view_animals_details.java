package steedserv.com.eco_agri;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

public class view_animals_details extends AppCompatActivity {


    EditText editanimldate;
    ImageView editanimlhome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_animals_details );

        final Calendar cld=Calendar.getInstance();
        int mYear=cld.get( cld.YEAR );
        int mMonth=cld.get( cld.MONTH );
        int mDay=cld.get( cld.DAY_OF_MONTH );

        editanimldate=findViewById( R.id.editanimldate );
        editanimldate.setText( mDay+"-"+mMonth+"-"+mYear );
        editanimldate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker( editanimldate );
            }
        } );

        editanimlhome=findViewById( R.id.editanimlhome );
        editanimlhome.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,new frag_Dashboard());
                transaction.commit();
            }
        } );

    }


    public void datePicker(final EditText Date)
    {

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        Date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMaxDate((Calendar.getInstance().getTimeInMillis()));
        datePickerDialog.show();
    }

    public void closeScreen(View view) {
        finish();
    }


    public void goBackToHomepage(View view)
    {
        finish();
    }
}
