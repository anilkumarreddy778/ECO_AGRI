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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link report_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link report_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
public class report_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_wages, container, false);
       /* View rootview =  inflater.inflate(R.layout.fragment_wages, container,false);
         LinearLayout ll=(LinearLayout) rootview.findViewById( R.id.wagesusersf );*/
        LinearLayout view2 = (LinearLayout) inflater.inflate(R.layout.user_wages_view,null);
        LinearLayout lLayout = (LinearLayout) view2.findViewById(R.id.wagesusersf);
        lLayout.addView(rootView);
        return rootView;
    }

    public void gobacktowagesdetalis(View view)
    {
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        LinearLayout lLayout = null;
        View view;
        for (int i = 0; i < 4; i++) {
        view= getLayoutInflater().inflate( R.layout.user_wages_view, null );
            if (i == 0) {
                TextView imageView = view.findViewById( R.id.username );
                imageView.setText( "Babu" );
                EditText providerName = view.findViewById( R.id.amount );
                providerName.setText( "500" );
                // Assigning value to  imageview and textview here
                lLayout.addView( view );
            }
            if (i == 1) {
                TextView imageView = view.findViewById( R.id.username );
                imageView.setText( "Basava" );
                EditText providerName = view.findViewById( R.id.amount );
                providerName.setText( "400" );
                lLayout.addView(view);
            }
            if (i == 2) {
                TextView imageView = view.findViewById( R.id.username );
                imageView.setText( "Surya" );
                EditText providerName = view.findViewById( R.id.amount );
                providerName.setText( "600" );
                lLayout.addView( view );
            }
            if (i == 3) {
                TextView imageView = view.findViewById( R.id.username );
                imageView.setText( "Anil" );
                EditText providerName = view.findViewById( R.id.amount );
                providerName.setText( "300" );
                lLayout.addView( view );
            }
        }
    }

    public report_Fragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment report_Fragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static report_Fragment newInstance(String param1, String param2) {
//        report_Fragment fragment = new report_Fragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_wages, container, false);
//    }
//
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
