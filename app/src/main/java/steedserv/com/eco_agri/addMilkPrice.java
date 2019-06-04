package steedserv.com.eco_agri;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class addMilkPrice extends Fragment {

//    MilkCowDetailsAdapter_add milkCowDetailsAdapter_add;

    public addMilkPrice(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View view = inflater.inflate( R.layout.frag_milkprice, container, false );
        return view;
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle( "Milk Price" );
    }
}
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate( savedInstanceState );
//        setContentView( R.layout.activity_add_milk );
//
//        RecyclerView recyclerview=findViewById(R.id.milk_detais);
//        recyclerview.setLayoutManager(new LinearLayoutManager(this));
//        milkCowDetailsAdapter_add=new MilkCowDetailsAdapter_add(getApplicationContext());
//        recyclerview.setAdapter(milkCowDetailsAdapter_add);
//    }
//
//    public void goback(View view) {
//        finish();
//    }

