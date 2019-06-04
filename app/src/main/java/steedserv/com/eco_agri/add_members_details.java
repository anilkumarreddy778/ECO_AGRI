package steedserv.com.eco_agri;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import steedserv.com.eco_agri.server.callbacks.SaveMemberCallback;
import steedserv.com.eco_agri.server.dao.MemberDAO;
import steedserv.com.eco_agri.server.pojo.MemberResponse;
import steedserv.com.eco_agri.server.pojo.SaveMemberRequest;

public class add_members_details extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.name)
    EditText mName;
    @BindView(R.id.mobile_number)
    EditText mMobileNumber;
    @BindView(R.id.email_id)
    EditText mEmailId;
    @BindView(R.id.aadhar_number)
    EditText mAadhar;
    @BindView(R.id.address)
    EditText mAddress;
    @BindView(R.id.date)
    EditText mDate;
    @BindView(R.id.status_group)
    RadioGroup mStatusGroup;
    @BindView(R.id.desc)
    EditText mDesc;
    @BindView(R.id.savedetails)
    Button mSaveMember;

    private Calendar todayDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_members_details);

        ButterKnife.bind(this);

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        mDate.setText(mDay+"-"+mMonth+"-"+mYear);

        mDate.setOnClickListener(this);


        mSaveMember.setOnClickListener(this);
    }

    public void goBacktomembersdetails(View view)
    {
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

            case R.id.date:
                datePicker(mDate);
                break;
            case R.id.savedetails:

                if(isVaild())
                {
                    SaveMemberRequest saveMemberRequest=new SaveMemberRequest();
                    saveMemberRequest.setName(mName.getText().toString());
                    saveMemberRequest.setAddernumber(mAadhar.getText().toString().trim());
                    saveMemberRequest.setAddress(mAddress.getText().toString().trim());

                    String input = mDate.getText().toString().trim();

                    Date date = null;
                    try {
                        date = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(input);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    long milliseconds = date.getTime();

                    saveMemberRequest.setDate(milliseconds);

                    saveMemberRequest.setDesc(mDesc.getText().toString().trim());
                    saveMemberRequest.setEmailId(mEmailId.getText().toString());
                    saveMemberRequest.setMobileNumber(mMobileNumber.getText().toString());
                    saveMemberRequest.setImage("");
                    saveMemberRequest.setStatus(true);





                    MemberDAO.getInstance().saveMember(saveMemberRequest, new SaveMemberCallback() {
                        @Override
                        public void onSuccessResponse(MemberResponse response) {

                            if(response.getResult().equalsIgnoreCase("success")){
                                Toast.makeText(add_members_details.this, response.getResult(), Toast.LENGTH_SHORT).show();
                                finish();

                            }else {
                                Toast.makeText(add_members_details.this, response.getResult(), Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(String s) {
                            Toast.makeText(add_members_details.this,"Plz try again later ", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                break;
        }
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

    public void goBackToHomepage(View view)
    {
        finish();
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
