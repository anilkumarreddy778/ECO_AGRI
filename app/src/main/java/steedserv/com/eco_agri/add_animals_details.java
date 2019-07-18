package steedserv.com.eco_agri;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import steedserv.com.eco_agri.server.callbacks.GetBreedsCallback;
import steedserv.com.eco_agri.server.callbacks.GetCattlesIdNameCallback;
import steedserv.com.eco_agri.server.callbacks.saveCattlesCallback;
import steedserv.com.eco_agri.server.dao.BreedsDAO;
import steedserv.com.eco_agri.server.dao.CattlesDAO;
import steedserv.com.eco_agri.server.pojo.Breeds;
import steedserv.com.eco_agri.server.pojo.BreedsListResponse;
import steedserv.com.eco_agri.server.pojo.CattlesResponse;
import steedserv.com.eco_agri.server.pojo.Cattles_idname;
import steedserv.com.eco_agri.server.pojo.Cattles_idnameListResponse;
import steedserv.com.eco_agri.server.pojo.SaveCattlesRequest;


public class add_animals_details extends AppCompatActivity {

List<String> mbreednamelist=new ArrayList<String>( );
List<Breeds> mbreedlist=new ArrayList<>();
List<String> mcattlesidnamearry=new ArrayList<String>();
List<Cattles_idname> mcattlesIdNameList=new ArrayList<>();


        @BindView( R.id.aniname)
                EditText caniname;
        @BindView( R.id.aniprice )
                EditText caniprice;
        @BindView( R.id.anidate )
                EditText canidate;
        @BindView( R.id.yearsold )
                EditText cyearsold;
        @BindView( R.id.birthcount )
                EditText cbirthcount;
        @BindView( R.id.anidescription )
                EditText canidescription;
        @BindView( R.id.milkcapacity )
                EditText cmilkcapacity;


    String [] subString;
    String [] parentselect;
    Spinner breedselect;
    Spinner aniparentspinner;
    Activity mActivity;
    View view;
    Button saveanidetails;
    String newanmil;
    String aniStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animals_details);

        mActivity=add_animals_details.this;
        ButterKnife.bind(this);
        final Calendar cld=Calendar.getInstance();
        int mYear=cld.get( cld.YEAR );
        int mMonth=cld.get( cld.MONTH );
        int mDay=cld.get( cld.DAY_OF_MONTH );

        canidate=findViewById( R.id.anidate );
        canidate.setText( mDay+"-"+mMonth+"-"+mYear );
        canidate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker( canidate );

            }
        } );


        breedselect=(Spinner) findViewById( R.id.breedselect );
        aniparentspinner=(Spinner) findViewById( R.id.aniparentspinner );

        RadioGroup group=(RadioGroup) findViewById( R.id.animaltype );
        final LinearLayout layout=(LinearLayout) findViewById( R.id.aniparent );
        final TextInputLayout inputEditText=(TextInputLayout) findViewById( R.id.aniamount );
        group.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.aninew)
                {
                    layout.setVisibility( view.GONE );
                    inputEditText.setVisibility( view.VISIBLE );
                     newanmil ="New";
                }
                else if(checkedId==R.id.anichild)
                {
                    inputEditText.setVisibility( view.GONE );
                    layout.setVisibility( view.VISIBLE );
                    newanmil ="Child";
                }
            }
        } );

        RadioGroup statusgroup=(RadioGroup) findViewById( R.id.statusgroup );

        statusgroup.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.activeradio)
                {
                    aniStatus ="1";
                }
                else if(checkedId==R.id.inactiveradio)
                {
                    aniStatus ="0";
                }
            }
        } );


        saveanidetails=(Button) findViewById( R.id. saveanidetails );
        saveanidetails.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if(isVaild()){
                    SaveCattlesRequest saveCattlesRequest=new SaveCattlesRequest();
                    saveCattlesRequest.setAniname( caniname.getText().toString());
                    saveCattlesRequest.setAniprice( caniprice.getText().toString());
                    saveCattlesRequest.setAnibuydate( canidate.getText().toString() );
                    saveCattlesRequest.setAnibirthcount( cbirthcount.getText().toString() );
                    saveCattlesRequest.setAniage( cyearsold.getText().toString() );
                    saveCattlesRequest.setAnidesc( canidescription.getText().toString() );
                    saveCattlesRequest.setAnimmilkcapacity(cmilkcapacity.getText().toString()  );
                    saveCattlesRequest.setAniimage( "" );
                    saveCattlesRequest.setAnibreedid( 1 );
                    saveCattlesRequest.setAninewchild( newanmil );
                    saveCattlesRequest.setAnistatus( aniStatus );

                    CattlesDAO.getInstance().saveCattles( saveCattlesRequest, new saveCattlesCallback() {
                        @Override
                        public void onSuccessResponse(CattlesResponse response) {
                            if(response.getResult().equalsIgnoreCase("success")){
                                Toast.makeText(add_animals_details.this, response.getResult(), Toast.LENGTH_SHORT).show();
                                finish();

                            }else {
                                Toast.makeText(add_animals_details.this, response.getResult(), Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(String s) {
                            Toast.makeText(add_animals_details.this,"Plz try again later ", Toast.LENGTH_SHORT).show();
                        }
                    } );

                              //}
            }
        } );

    }




    public void datePicker(final EditText Date)
    {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(mActivity,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        Date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMaxDate((Calendar.getInstance().getTimeInMillis()));
        datePickerDialog.show();
    }

    public void goBackToHomepage(View view)
    {
        finish();
    }


    private boolean isVaild() {

        if(TextUtils.isEmpty(caniprice.getText()))
        {
            caniprice.setError("Plese enter the name");
            return false;
        } else if(TextUtils.isEmpty(cbirthcount.getText()))
        {
            cbirthcount.setError("enter vaild mobile number");
            return false;
        } else if(TextUtils.isEmpty(cyearsold.getText()))
        {
            cyearsold.setError("plz enter how yerar old");
            return false;
        }else if (TextUtils.isEmpty(canidate.getText()))
        {
            canidate.setError("please select date");
            return false;
        }
        return true;
    }

    @Override
    protected void onResume(){
        super.onResume();

        BreedsDAO.getBreedsList( new GetBreedsCallback() {
            @Override
            public void onSuccessResponse(BreedsListResponse response) {

                if(response.getData().size()>0){
                    mbreedlist.clear();
                    mbreedlist.addAll( response.getData() );

                   // mbreedlist.notifyAll();
                    mbreednamelist.add("Select Breed");

                    for(Breeds breeds:response.getData()){
                        mbreednamelist.add( breeds.getBreedname() );
                    }

//                    subString=new String[mbreedlist.size()];
//                    for(int i=0;i<mbreedlist.size();i++){
//                        subString[i]=mbreedlist.get( i ).getBreedname();
//                    }
                    ArrayAdapter<String> myadapter=new ArrayAdapter<String>(add_animals_details.this,android.R.layout.simple_spinner_item,mbreednamelist);
                    myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    breedselect.setAdapter(myadapter);
                }
                else {
                    mbreedlist.clear();
                }
            }

            @Override
            public void onFailure(String s) {
                Toast.makeText(add_animals_details.this, "breeds message", Toast.LENGTH_SHORT).show();
            }
        } );

        CattlesDAO.getCattleidname( new GetCattlesIdNameCallback() {

            @Override
            public void onSuccessResponse(Cattles_idnameListResponse response) {
                if(response.getData().size()>0)
                {
                    mcattlesIdNameList.clear();
                    mcattlesIdNameList.addAll( response.getData() );

                    mcattlesidnamearry.add( "Select Parent" );
                    for(Cattles_idname cattlesIdname:response.getData()){
                        mcattlesidnamearry.add( cattlesIdname.getAniname() );
                    }

                    ArrayAdapter<String> myadapter2=new ArrayAdapter<String>( add_animals_details.this,android.R.layout.simple_spinner_item,mcattlesidnamearry );
                    myadapter2.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
                    aniparentspinner.setAdapter( myadapter2 );
                }
            }

            @Override
            public void onFailure(String s) {
                Toast.makeText(add_animals_details.this, "cattle idName message", Toast.LENGTH_SHORT).show();
            }
        } );
    }
}
