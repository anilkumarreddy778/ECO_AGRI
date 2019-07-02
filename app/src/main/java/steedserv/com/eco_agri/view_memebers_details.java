package steedserv.com.eco_agri;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import steedserv.com.eco_agri.server.callbacks.SaveMemberCallback;
import steedserv.com.eco_agri.server.dao.MemberDAO;
import steedserv.com.eco_agri.server.pojo.Member;
import steedserv.com.eco_agri.server.pojo.MemberResponse;
import steedserv.com.eco_agri.server.pojo.SaveMemberRequest;

public class view_memebers_details extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.user_id)
    EditText mUserId;

    @BindView(R.id.name)
    EditText mName;

    @BindView(R.id.mobile_number)
    EditText mMobileNumber;

    @BindView(R.id.email_id)
    EditText mEmailId;
    @BindView( R.id.editaadhar_number )
    EditText maadharnum;

    @BindView(R.id.editmemberdate)
    EditText mDate;

    @BindView(R.id.desc)
    EditText mDesc;

    @BindView(R.id.address)
    EditText mAddress;

    @BindView(R.id.delete)
    ImageButton mDeleteMember;

    @BindView(R.id.update)
    ImageView mUpdateMember;

    Member mMember;

    EditText editmemberdate;
    ImageView editmemgohome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_memebers_details );

        ButterKnife.bind(this);

        mDeleteMember.setOnClickListener(this);
        mUpdateMember.setOnClickListener(this);


        mMember= (Member) getIntent().getSerializableExtra("data");

        if(mMember!=null){

            mUserId.setText(mMember.getUserId());
            mAddress.setText(mMember.getAddress());
            mDesc.setText(mMember.getDesc());
            maadharnum.setText( mMember.getAddernumber() );

            mEmailId.setText(mMember.getEmailId());
            mMobileNumber.setText(mMember.getMobileNumber());
            mName.setText(mMember.getName());
            mDate.setText( mMember.getDate() );

//            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTimeInMillis(mMember.getDate());
//
//            mDate.setText(formatter.format(calendar.getTime()));

            //mUserId.setText(mMember.setUser);
            //http://192.168.0.160:8080/Myfram/MyFram/MemberService/DeleteMembers?user_id=1
        }

        final Calendar cld=Calendar.getInstance();
        int mYear=cld.get( cld.YEAR );
        int mMonth=cld.get( cld.MONTH );
        int mDay=cld.get( cld.DAY_OF_MONTH );

        editmemberdate=findViewById( R.id.editmemberdate );
        editmemberdate.setText( mDay+"-"+mMonth+"-"+mYear );
        editmemberdate.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //datePicker( editmemberdate );
            }
        } );

        editmemgohome=findViewById( R.id.editmemgohome );
        editmemgohome.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,new frag_Dashboard());
                transaction.commit();
            }
        } );

    }



    public void goBackToHomepage(View view) {
        finish();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.delete:
                deleteMember(mMember.getUserId());
                break;

            case R.id.update:
                if(isVaild())
                {
                    SaveMemberRequest saveMemberRequest=new SaveMemberRequest();
                    saveMemberRequest.setUserId(mMember.getUserId());
                    saveMemberRequest.setName(mName.getText().toString());
                    saveMemberRequest.setAddress(mAddress.getText().toString().trim());

//                    saveMemberRequest.setDate(mMember.getDate());

                    saveMemberRequest.setDesc(mDesc.getText().toString().trim());
                    saveMemberRequest.setEmailId(mEmailId.getText().toString());
                    saveMemberRequest.setMobileNumber(mMobileNumber.getText().toString());
                    saveMemberRequest.setImage("");


                    MemberDAO.getInstance().updateMember(saveMemberRequest, new SaveMemberCallback() {
                        @Override
                        public void onSuccessResponse(MemberResponse response) {

                            if(response.getResult().equalsIgnoreCase("success")){
                                Toast.makeText(view_memebers_details.this, response.getResult(), Toast.LENGTH_SHORT).show();
                                finish();

                            }else {
                                Toast.makeText(view_memebers_details.this, response.getResult(), Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(String s) {
                            Toast.makeText(view_memebers_details.this,"Plz try again later ", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                break;
        }
    }

    private void deleteMember(String userId) {
        MemberDAO.getInstance().deleteMember(userId, new SaveMemberCallback() {
            @Override
            public void onSuccessResponse(MemberResponse response) {
                if(response.getResult().equalsIgnoreCase("success")){
                    Toast.makeText(view_memebers_details.this, response.getResult(), Toast.LENGTH_SHORT).show();
                    finish();

                }else{
                    Toast.makeText(view_memebers_details.this, response.getResult(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(String s) {
                Toast.makeText(view_memebers_details.this, "Plz try again later ", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private boolean isVaild() {

        if(TextUtils.isEmpty(mName.getText().toString()))
        {
            mName.setError("Plese enter the name");
            return false;
        } else if( mMobileNumber.getText().toString().length()<10)
        {
            mMobileNumber.setError("enter vaild mobile number");
            return false;
        } else if(!emailValidator(mEmailId.getText().toString()))
        {
            mEmailId.setError("enter vaild Email");
            return false;
        }else if (TextUtils.isEmpty(mDate.getText().toString()))
        {
            mDate.setError("please select date");
            return false;
        }



        return true;
    }

    /**
     * validate your email address format. Ex-akhi@mani.com
     */
    public boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public void datePicker(final EditText Date)
    {

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        Date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMaxDate((Calendar.getInstance().getTimeInMillis()));
        datePickerDialog.show();
    }
}
