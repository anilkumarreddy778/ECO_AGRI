package steedserv.com.eco_agri;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;



public class report_Fragment extends Fragment {

    LinearLayout lLayout;

    @Override
    public NestedScrollView onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_wages, container, false);
       /* View rootview =  inflater.inflate(R.layout.fragment_wages, container,false);
         LinearLayout ll=(LinearLayout) rootview.findViewById( R.id.wagesusersf );*/

//        LinearLayout lLayout = (LinearLayout) rootView.findViewById(R.id.wagesusersf);
//     lLayout.addView( rootView );
        lLayout = (LinearLayout) rootView.findViewById(R.id.wagesusersf);

        return (NestedScrollView) rootView;
    }

    public void gobacktowagesdetalis(View view)
    {
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {




        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                View rootview =  getLayoutInflater().inflate(R.layout.user_wages_view, null,false);
                TextView imageView = rootview.findViewById( R.id.username );
                imageView.setText( "Babu" );
                EditText providerName = rootview.findViewById( R.id.amount );
                providerName.setText( "500" );
                // Assigning value to  imageview and textview here
                lLayout.addView( rootview );
            }
            if (i == 1) {
                View rootview =  getLayoutInflater().inflate(R.layout.user_wages_view, null,false);
                TextView imageView = rootview.findViewById( R.id.username );
                imageView.setText( "Basava" );
                EditText providerName = rootview.findViewById( R.id.amount );
                providerName.setText( "400" );
                lLayout.addView(rootview);
            }
            if (i == 2) {
                View rootview =  getLayoutInflater().inflate(R.layout.user_wages_view, null,false);
                TextView imageView = rootview.findViewById( R.id.username );
                imageView.setText( "Surya" );
                EditText providerName = rootview.findViewById( R.id.amount );
                providerName.setText( "600" );
                lLayout.addView( rootview );
            }
            if (i == 3) {
                View rootview =  getLayoutInflater().inflate(R.layout.user_wages_view, null,false);
                TextView imageView = rootview.findViewById( R.id.username );
                imageView.setText( "Anil" );
                EditText providerName = rootview.findViewById( R.id.amount );
                providerName.setText( "300" );
                lLayout.addView( rootview );
            }
        }
    }
    public interface OnFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
