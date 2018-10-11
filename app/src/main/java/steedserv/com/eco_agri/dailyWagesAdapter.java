package steedserv.com.eco_agri;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class dailyWagesAdapter extends RecyclerView.Adapter<dailyWagesAdapter.dailywagesHolder>
{
    public dailyWagesAdapter(Context context){

    }
    @Override
    public dailywagesHolder onCreateViewHOlder(ViewGroup parent,int viewType)
    {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_wages_view,parent,false);
       return new dailywagesHolder(view);
    }

    @Override
    public void onBindViewHolder(dailywagesHolder holder, int postion){

    }

    @Override
    public int gerItemCount() {
        return 5;
    }

    public class dailywagesHolder extends RecyclerView.ViewHolder
    {
        View view;

        public dailywagesHolder(View itemView)
        {
            super(itemView);
            view = itemView;
            view.setOnClickListener(new  View.OnClickListener()
            {
                @Override
                public void onClick (View v)
                {
                    Context context=v.getContext();
                    Intent intent = new Intent(context, View_daily_wages_details.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}

