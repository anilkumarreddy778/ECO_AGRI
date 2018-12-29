package steedserv.com.eco_agri;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link add_milk_Fragment.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link add_milk_Fragment#newInstance} factory method to
// * create an instance of this fragment.
// */

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment add_milk_Fragment.
//     */
// TODO: Rename and change types and number of parameters


public class add_milk_Fragment extends Fragment {

    RecyclerView recyclerViewRFP;
    MilkCowDetailsAdapter_add milkCowDetailsAdapter_add;

    public add_milk_Fragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
            View view = inflater.inflate( R.layout.fragment_add_milk, container, false );
            recyclerViewRFP = (RecyclerView) view.findViewById( R.id.milk_detais );
            return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    milkCowDetailsAdapter_add = new MilkCowDetailsAdapter_add( milkCowDetailsAdapter_add );
    recyclerViewRFP.setAdapter( milkCowDetailsAdapter_add );
    LinearLayoutManager llm = new LinearLayoutManager( getActivity() );
    recyclerViewRFP.setLayoutManager( llm );
}



    public interface OnFragmentInteractionListener
    {
    }
}
