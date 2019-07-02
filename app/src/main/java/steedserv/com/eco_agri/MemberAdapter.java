package steedserv.com.eco_agri;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import steedserv.com.eco_agri.server.pojo.Member;

/**
 * Created by admin on 27-Jul-18.
 */
public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MemberViewHolder>
{

    private Context mContext;
    private List<Member> mMemberList=new ArrayList<>();

    public MemberAdapter(Context context, List<Member> memberList)
    {
        mContext=context;
        mMemberList=memberList;
    }

    @Override
    public MemberAdapter.MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_view, parent, false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MemberViewHolder holder, int position)
    {

        Member member=mMemberList.get(position);
        holder.mName.setText(member.getName());
        holder.mDate.setText( member.getDate() );

//        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(member.getDate());
//
//        holder.mDate.setText(formatter.format(calendar.getTime()));

    }


    @Override
    public int getItemCount() {
        return mMemberList.size();
    }

//for recyclerviwe
    public class MemberViewHolder extends RecyclerView.ViewHolder {
        View view;

        @BindView(R.id.viewname)
        TextView mName;

        @BindView(R.id.viewdate)
        TextView mDate;

        public MemberViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);

            view = itemView;

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, view_memebers_details.class);
                    intent.putExtra("data", (Serializable) mMemberList.get(getAdapterPosition()));
                    context.startActivity(intent);
                }

            });
        }
    }
}