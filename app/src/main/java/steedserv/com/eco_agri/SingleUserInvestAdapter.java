package steedserv.com.eco_agri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 03-Aug-18.
 */

public class SingleUserInvestAdapter extends RecyclerView.Adapter<SingleUserInvestAdapter.SingleShareHolder> {
    public SingleUserInvestAdapter(Context context)
    {

    }

    @Override
    public SingleShareHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_share_view, parent, false);
        return new SingleShareHolder(view);
    }

    @Override
    public void onBindViewHolder(SingleUserInvestAdapter.SingleShareHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class SingleShareHolder extends RecyclerView.ViewHolder {
        View view;
        public SingleShareHolder(View itemView) {

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
