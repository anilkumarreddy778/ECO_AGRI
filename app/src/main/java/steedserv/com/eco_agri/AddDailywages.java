package steedserv.com.eco_agri;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AddDailywages extends AppCompatActivity implements report_Fragment.OnFragmentInteractionListener, AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_wages);


        LinearLayout ll = (LinearLayout) findViewById(R.id.wagesusersf);
        for (int i = 0; i < 4; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.user_wages_view, null);
            if (i == 0) {
                TextView imageView = view.findViewById(R.id.username);
                imageView.setText("Babu");
                EditText providerName = view.findViewById(R.id.amount);
                providerName.setText("500");
                // Assigning value to  imageview and textview here
                ll.addView(view);
            }
            if (i == 1) {
                TextView imageView = view.findViewById(R.id.username);
                imageView.setText("Basava");
                EditText providerName = view.findViewById(R.id.amount);
                providerName.setText("400");
                ll.addView(view);
            }
            if (i == 2) {
                TextView imageView = view.findViewById(R.id.username);
                imageView.setText("Surya");
                EditText providerName = view.findViewById(R.id.amount);
                providerName.setText("600");
                ll.addView(view);
            }
            if (i == 3) {
                TextView imageView = view.findViewById(R.id.username);
                imageView.setText("Anil");
                EditText providerName = view.findViewById(R.id.amount);
                providerName.setText("300");
                ll.addView(view);
            }
        }
        Spinner spinner = (Spinner) findViewById(R.id.spinnercat);
        spinner.setOnItemSelectedListener(this);


        // Spinner Drop down elements
        List<String> list =new ArrayList<String>();
        list.add("Automobile");
        list.add("Business Services");
        list.add("Computers");
        list.add("Education");
        list.add("Personal");
        list.add("Travel");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

//        LinearLayout parentlayout=(LinearLayout)findViewById(R.id.wagesusers);
//        parentlayout.addView(parentlayout, 0);
//        LayoutInflater layoutInflater=getLayoutInflater();
//        View view;
//        for (int i=1; i<=4; i++)
//        {
//            view=layoutInflater.inflate(R.layout.user_wages_view,parentlayout,false);
//            if (i==1) {
//                TextView textView = (TextView) view.findViewById(R.id.username);
//                textView.setText("Surya_ " + i);
//                parentlayout.addView(textView);
//                EditText editText = (EditText) view.findViewById(R.id.amount);
//                editText.setText("1000");
//                parentlayout.addView(editText);
//              }
//            if (i==2) {
//                TextView textView = (TextView) view.findViewById(R.id.username);
//                textView.setText("Babu_ " + i);
//                parentlayout.addView(textView);
//                EditText editText = (EditText) view.findViewById(R.id.amount);
//                editText.setText("1000");
//                parentlayout.addView(editText);
//            }
//            if (i==3) {
//                TextView textView = (TextView) view.findViewById(R.id.username);
//                textView.setText("Basava_ " + i);
//                parentlayout.addView(textView);
//                EditText editText = (EditText) view.findViewById(R.id.amount);
//                editText.setText("1000");
//                parentlayout.addView(editText);
//
//
//            }
//            if (i==4) {
//                TextView textView = (TextView) view.findViewById(R.id.username);
//                textView.setText("Anil_ " + i);
//                parentlayout.addView(textView);
//                EditText editText = (EditText) view.findViewById(R.id.amount);
//                editText.setText("1000");
//                parentlayout.addView(editText);
//            }
//        }




    public void gobacktowagesdetalis(View view)
    {
        finish();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

//    RelativeLayout item = (RelativeLayout)findViewById(R.id.wagesusers);
//    View child = getLayoutInflater().inflate(R.layout.child, null);
//item.addView(child);
}
