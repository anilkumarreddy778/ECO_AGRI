package steedserv.com.eco_agri;

import android.app.Activity;
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
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;


public class add_milk_Fragment extends Fragment {

    private Spinner timings;
    RecyclerView recyclerview;
    private Activity mActivity;
    MilkCowDetailsAdapter_add milkCowDetailsAdapter_add;
    private RelativeLayout mRelativeLayout;
    EditText mcows;
    private Context mContext;
    private Context applicationContext;


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


}
