package steedserv.com.eco_agri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_members_details);

        ButterKnife.bind(this);



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
            case R.id.savedetails:

                if(isVaild())
                {
                    SaveMemberRequest saveMemberRequest=new SaveMemberRequest();
                    saveMemberRequest.setName(mName.getText().toString());




                    MemberDAO.getInstance().saveMember(saveMemberRequest, new SaveMemberCallback() {
                        @Override
                        public void onSuccessResponse(MemberResponse response) {

                        }

                        @Override
                        public void onFailure(String s) {

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

}
