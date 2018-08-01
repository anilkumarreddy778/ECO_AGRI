package steedserv.com.eco_agri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 01-Aug-18.
 */

public class ShareMember_Adapter extends RecyclerView.Adapter<ShareMember_Adapter.SharememberViewHolder>
{
public ShareMember_Adapter(Context context){

}
@Override
    public SharememberViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
{
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shares_members_view, parent, false);
    return new SharememberViewHolder(view);
}

    @Override
    public void onBindViewHolder(SharememberViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class SharememberViewHolder extends RecyclerView.ViewHolder
    {
        View view;

        public SharememberViewHolder(View itemView)
        {
            super(itemView);

            view = itemView;

            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                }
            });

        }
    }
}

