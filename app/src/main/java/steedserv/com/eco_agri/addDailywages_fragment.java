package steedserv.com.eco_agri;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by admin on 27-Dec-18.
 */

public class addDailywages_fragment extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_wages, container, true);
       // final LinearLayout ll=(LinearLayout) getTargetFragment().getView().findViewById( R.id.wagesusersf );


        final LinearLayout ll = (LinearLayout) view.findViewById( R.id.wagesusersf );

        return view;
    }

    public void gobacktowagesdetalis(View view)
    {

    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        LinearLayout ll = null;
        for (int i = 0; i < 4; i++) {
          View view= getActivity().getLayoutInflater().inflate( R.layout.user_wages_view, null );
            if (i == 0) {
                TextView imageView = view.findViewById( R.id.username );
                imageView.setText( "Babu" );
                EditText providerName = view.findViewById( R.id.amount );
                providerName.setText( "500" );
                // Assigning value to  imageview and textview here
                ll.addView( view );
            }
            if (i == 1) {
                TextView imageView = view.findViewById( R.id.username );
                imageView.setText( "Basava" );
                EditText providerName = view.findViewById( R.id.amount );
                providerName.setText( "400" );
                ll.addView( view );
            }
            if (i == 2) {
                TextView imageView = view.findViewById( R.id.username );
                imageView.setText( "Surya" );
                EditText providerName = view.findViewById( R.id.amount );
                providerName.setText( "600" );
                ll.addView( view );
            }
            if (i == 3) {
                TextView imageView = view.findViewById( R.id.username );
                imageView.setText( "Anil" );
                EditText providerName = view.findViewById( R.id.amount );
                providerName.setText( "300" );
                ll.addView( view );
            }
        }
    }

}
