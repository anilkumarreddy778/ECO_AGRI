package steedserv.com.eco_agri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 20-Dec-18.
 */

public class MilkAdapter extends RecyclerView.Adapter<MilkAdapter.MilkViewHolder>
{


    public MilkAdapter(Context applicationContext)
    {
    }

    @Override
    public MilkViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.milk_view, parent, false);
        return new MilkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MilkAdapter.MilkViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 10;
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
