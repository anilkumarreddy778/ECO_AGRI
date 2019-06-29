package steedserv.com.eco_agri;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Calendar;

public class edit_Milk_details extends AppCompatActivity {

    RecyclerView recyclerview;
    MilkCowDetailsAdapter_add milkCowDetailsAdapter_add;

    EditText editmilkdate;
    ImageButton editmilgohome;

    Context mcontext;
    Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_milk );


        mActivity=edit_Milk_details.this;


        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.editmilk_detaiss);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         milkCowDetailsAdapter_add=new MilkCowDetailsAdapter_add(getApplicationContext());
        recyclerView.setAdapter(milkCowDetailsAdapter_add);

        final Calendar cld = Calendar.getInstance();
        int mYear = cld.get(Calendar.YEAR);
        int mMonth = cld.get(Calendar.MONTH);
        int mDay = cld.get(Calendar.DAY_OF_MONTH);

        editmilkdate=findViewById( R.id.editmilkdate );
        editmilkdate.setText( mDay+"-"+mMonth+"-"+mYear );
        editmilkdate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=getApplicationContext();
                datePicker( editmilkdate);

            }
        } );


        editmilgohome=findViewById( R.id.editmilgohome );
        editmilgohome.setOnClickListener( new View.OnClickListener() {
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


    public void gobcktowagesdetls(View view)
    {
        finish();
    }

    public void goBackToShareDetails(View view) {
        finish();
    }
}
