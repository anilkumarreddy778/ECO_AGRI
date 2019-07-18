package steedserv.com.eco_agri;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import steedserv.com.eco_agri.server.callbacks.GetMilkPriceCallback;
import steedserv.com.eco_agri.server.dao.MilkpriceDAO;
import steedserv.com.eco_agri.server.pojo.MilkPrice;
import steedserv.com.eco_agri.server.pojo.MilkPriceListResponse;


public class addMilkPrice extends Fragment {

    private Context mContext;

    List<MilkPrice> prices=new ArrayList<>( );

    public addMilkPrice(){

    }

    @BindView( R.id.milkpricee)
    TextView milkpricee;

    MilkPrice milkPrice;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );



        //milkpricee.setText( milkPrice.getMilkprice() );
    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.frag_milkprice, container, false );

        return view;


    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle( "Milk Price" );

    }


    @Override
    public void onResume() {
        super.onResume();

        MilkpriceDAO.getMilkpriceList( new GetMilkPriceCallback() {
            @Override
            public void onSuccessResponse(MilkPriceListResponse response) {
                if(response.getData().size()>0){
                    prices.clear();
                    prices.addAll(response.getData());


                }else{
                    prices.clear();
                }
            }

            @Override
            public void onFailure(String s) {
                Toast.makeText(mContext.getApplicationContext(), "plz try again Later", Toast.LENGTH_SHORT).show();
            }
        } );
    }

}


