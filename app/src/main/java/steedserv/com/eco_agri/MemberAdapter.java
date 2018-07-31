package steedserv.com.eco_agri;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 27-Jul-18.
 */
public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MemberViewHolder>
{
    public MemberAdapter(Context context) {

    }

    @Override
    public MemberAdapter.MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_view, parent, false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MemberViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 5;
    }


    public class MemberViewHolder extends RecyclerView.ViewHolder {
        View view;

        public MemberViewHolder(View itemView) {
            super(itemView);

            view = itemView;

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, view_memebers_details.class);
                    context.startActivity(intent);
                }

            });
        }
    }
}