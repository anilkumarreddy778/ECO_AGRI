package steedserv.com.eco_agri;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import steedserv.com.eco_agri.server.callbacks.GetMemberByIDCallback;
import steedserv.com.eco_agri.server.dao.MemberDAO;
import steedserv.com.eco_agri.server.pojo.MemberListByIdResponse;


public class report_Fragment extends Fragment implements View.OnClickListener {

    LinearLayout lLayout;

    EditText ed;

    List<EditText> allEds = new ArrayList<EditText>();

    Button mSubmit;

    EditText mTotalAmount;

    @Override
    public NestedScrollView onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_wages, container, false);
       /* View rootview =  inflater.inflate(R.layout.fragment_wages, container,false);
         LinearLayout ll=(LinearLayout) rootview.findViewById( R.id.wagesusersf );*/

//        LinearLayout lLayout = (LinearLayout) rootView.findViewById(R.id.wagesusersf);
//     lLayout.addView( rootView );


        lLayout = (LinearLayout) rootView.findViewById(R.id.wagesusersf);

        mSubmit=(Button) rootView.findViewById(R.id.submit);

        mTotalAmount=(EditText) rootView.findViewById(R.id.amount);

        mSubmit.setOnClickListener(this);

        return (NestedScrollView) rootView;
    }

    public void gobacktowagesdetalis(View view)
    {
    }


    @Override
    public void onResume() {
        super.onResume();

        MemberDAO.getInstance().getMemberListById(new GetMemberByIDCallback() {
            @Override
            public void onSuccessResponse(MemberListByIdResponse response) {

                lLayout.removeAllViewsInLayout();
                allEds.clear();

                for (int i=0;i<response.getData().size();i++){

                    View rootview =  getLayoutInflater().inflate(R.layout.user_wages_view, null,false);
                    TextView imageView = rootview.findViewById( R.id.username );
                    imageView.setText( response.getData().get(i).getName() );
                    EditText providerName = rootview.findViewById( R.id.amount );
                    providerName.setText( "0" );
                    allEds.add(providerName);
                    // Assigning value to  imageview and textview here
                    lLayout.addView( rootview );
                }

            }

            @Override
            public void onFailure(String s) {

            }
        });
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        /*for (int i = 0; i < 4; i++) {
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
        }*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit:

                int amount=0;

                String[] strings = new String[allEds.size()];

                for(int i=0; i < allEds.size(); i++){
                    strings[i] = allEds.get(i).getText().toString();
                    amount+=Integer.valueOf(strings[i]);
                }

                if(amount!=Integer.valueOf(mTotalAmount.getText().toString())){
                    Toast.makeText(getContext(), "Amount did'nt match", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Amount  match", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }


    public interface OnFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
