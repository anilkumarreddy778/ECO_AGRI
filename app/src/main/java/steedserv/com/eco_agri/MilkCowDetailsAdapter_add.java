package steedserv.com.eco_agri;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 21-Dec-18.
 */

public class MilkCowDetailsAdapter_add extends RecyclerView.Adapter<MilkCowDetailsAdapter_add.MilkViewHolder>
{
int coute =2;

    public MilkCowDetailsAdapter_add(MilkCowDetailsAdapter_add applicationContext)
    {
    }

    @Override
    public MilkCowDetailsAdapter_add.MilkViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.milkcow_details_view, parent, false);
        return new MilkCowDetailsAdapter_add.MilkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MilkCowDetailsAdapter_add.MilkViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 3;
    }


    public class MilkViewHolder extends RecyclerView.ViewHolder {
        View view;
        public MilkViewHolder(View itemView)
        {
            super(itemView);

            view = itemView;
            view.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {

                }

            });
        }
    }
}