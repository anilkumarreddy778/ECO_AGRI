package steedserv.com.eco_agri;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.util.Calendar;


public class add_milk_Fragment extends Fragment {

    private Spinner timings;
    RecyclerView recyclerview;
    private Activity mActivity;
    MilkCowDetailsAdapter_add milkCowDetailsAdapter_add;
    private RelativeLayout mRelativeLayout;
    EditText mcows;
    private Context mContext;
    private Context applicationContext;

    EditText addmilkdate;

    static int tes;
    static Integer result = Integer.valueOf(tes);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_add_milk, container, false );

//        EditText editText1=(EditText) view.findViewById( R.id.numberofcows );
//        String dd=editText1.getText().toString();
//         tes= Integer.parseInt(dd);
        recyclerview = (RecyclerView) view.findViewById( R.id.milk_detaiss );
        final FragmentActivity c = getActivity();
        //final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.milk_detaiss);
        LinearLayoutManager layoutManager = new LinearLayoutManager( c );
        recyclerview.setLayoutManager( layoutManager );

        milkCowDetailsAdapter_add = new MilkCowDetailsAdapter_add( c );
        recyclerview.setAdapter( milkCowDetailsAdapter_add );
        mContext = this.getContext();
        mRelativeLayout = (RelativeLayout) view.findViewById( R.id.mainaddmilk );



        final Calendar calendar=Calendar.getInstance();
        int mYear=calendar.get( calendar.YEAR );
        int mMonth=calendar.get( calendar.MONTH );
        int MDay=calendar.get( calendar.DAY_OF_MONTH );

        addmilkdate=view.findViewById( R.id.addmilkdate );
        addmilkdate.setText( MDay+"-"+mMonth+"-"+mYear );
        addmilkdate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            datePicker( addmilkdate );
            }
        } );

            return view;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Add Milk");
    }

    public Context getApplicationContext() {
        return applicationContext;
    }

    public void datePicker(final EditText Date)
    {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(mContext,
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
