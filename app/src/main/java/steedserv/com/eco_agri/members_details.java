package steedserv.com.eco_agri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import steedserv.com.eco_agri.server.callbacks.GetMemberCallback;
import steedserv.com.eco_agri.server.dao.MemberDAO;
import steedserv.com.eco_agri.server.pojo.Member;
import steedserv.com.eco_agri.server.pojo.MemberListResponse;

public class members_details extends AppCompatActivity {


    List<Member> mMemberList=new ArrayList<>();

    MemberAdapter memberAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members_details);

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.member_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        memberAdapter=new MemberAdapter(getApplicationContext(),mMemberList);
        recyclerView.setAdapter(memberAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();

        MemberDAO.getMemberList(new GetMemberCallback() {
            @Override
            public void onSuccessResponse(MemberListResponse response) {

                if(response.getData().size()>0){
                    mMemberList.clear();
                    mMemberList.addAll(response.getData());
                    memberAdapter.notifyDataSetChanged();
                }else{
                    mMemberList.clear();
                }

            }

            @Override
            public void onFailure(String s) {
                Toast.makeText(members_details.this, "plz try again Later", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void goToAddMemebersDetails(View view)
    {
Intent intent=new Intent(members_details.this,add_members_details.class);
startActivity(intent);
    }

    public void goBackToHomepage(View view)
    {
        finish();
    }
}
