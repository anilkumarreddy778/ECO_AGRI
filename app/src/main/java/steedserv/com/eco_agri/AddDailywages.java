package steedserv.com.eco_agri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AddDailywages extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dailywages);

        LinearLayout ll = (LinearLayout) findViewById(R.id.wagesusers);
        for (int i=0;i<4;i++)
        {
            View view = LayoutInflater.from(this).inflate(R.layout.user_wages_view, null);
            if (i==0) {
                TextView imageView = view.findViewById(R.id.username);
                imageView.setText("Babu");
                EditText providerName = view.findViewById(R.id.amount);
                providerName.setText("500");
                // Assigning value to  imageview and textview here
                ll.addView(view);
            }
            if(i==1)
            {
                TextView imageView = view.findViewById(R.id.username);
                imageView.setText("Basava");
                EditText providerName = view.findViewById(R.id.amount);
                providerName.setText("600");
                ll.addView(view);
            }
            if(i==2)
            {
                TextView imageView = view.findViewById(R.id.username);
                imageView.setText("Surya");
                EditText providerName = view.findViewById(R.id.amount);
                providerName.setText("600");
                ll.addView(view);
            }
            if(i==3)
            {
                TextView imageView = view.findViewById(R.id.username);
                imageView.setText("Anil");
                EditText providerName = view.findViewById(R.id.amount);
                providerName.setText("600");
                ll.addView(view);
            }
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
    }



    public void gobacktowagesdetalis(View view)
    {
        finish();
    }

//    RelativeLayout item = (RelativeLayout)findViewById(R.id.wagesusers);
//    View child = getLayoutInflater().inflate(R.layout.child, null);
//item.addView(child);
}
