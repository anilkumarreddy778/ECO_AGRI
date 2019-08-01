package steedserv.com.eco_agri;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import steedserv.com.eco_agri.server.callbacks.GetMilkPriceCallback;
import steedserv.com.eco_agri.server.callbacks.SaveMilkPriceCallback;
import steedserv.com.eco_agri.server.dao.MilkpriceDAO;
import steedserv.com.eco_agri.server.pojo.MilkPrice;
import steedserv.com.eco_agri.server.pojo.MilkPriceListResponse;
import steedserv.com.eco_agri.server.pojo.MilkpriceResponse;
import steedserv.com.eco_agri.server.pojo.SaveMilkPriceRequest;


public class addMilkPrice extends Fragment {

    private Context mContext;
    private Context applicationContext;

    List<MilkPrice> prices=new ArrayList<>( );

    List<String> stringprice=new ArrayList<String>(  );

    public addMilkPrice(){

    }

//    @BindView( R.id.milkpricee)
//    EditText milkpricee;
    EditText milkpriceee;
    Button priceupdate;
    MilkPrice milkPrice;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.frag_milkprice, container, false );

        milkpriceee=(EditText) view.findViewById( R.id.milkpricee ) ;
        priceupdate=(Button) view.findViewById( R.id.priceupdate );
        mContext = this.getContext();
        priceupdate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isVaild())
                {
                    SaveMilkPriceRequest saveMilkPriceRequest=new SaveMilkPriceRequest();
//                    saveMilkPriceRequest.setId( milkPrice.getId() );
                    saveMilkPriceRequest.setMilkprice( milkpriceee.getText().toString() );
                    saveMilkPriceRequest.setUpdatetime(getDateTime());
                    MilkpriceDAO.getInstance().updateprice( saveMilkPriceRequest, new SaveMilkPriceCallback() {
                        @Override
                        public void onSuccessResponse(MilkpriceResponse response) {
                            if(response.getResult().equalsIgnoreCase("Milk Pirce Updated..")) {
                                Toast.makeText( mContext.getApplicationContext(), response.getResult(), Toast.LENGTH_SHORT ).show();

                                   // onResume();
                            }else {
                                Toast.makeText(mContext.getApplicationContext(), response.getResult(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(String s) {
                            Toast.makeText(mContext.getApplicationContext(),"Plz try again later ", Toast.LENGTH_SHORT).show();
                        }
                    } );
                }
            }
        } );

        return view;
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle( "Milk Price" );

    }
    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
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

                    for (MilkPrice price:response.getData() ){
                        stringprice.add( price.getMilkprice() );
                        milkpriceee.setText( stringprice.get( 0 ) );
                    }

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

    private boolean isVaild() {

        if(TextUtils.isEmpty(milkpriceee.getText().toString()))
        {
            milkpriceee.setError("Plese enter the Price");
            return false;
        }


        return true;
    }
    public Context getApplicationContext() {
        return applicationContext;
    }

}


