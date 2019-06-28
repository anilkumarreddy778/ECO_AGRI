package steedserv.com.eco_agri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import steedserv.com.eco_agri.server.pojo.wages;


public class adapter_expense extends RecyclerView.Adapter<adapter_expense.dailywagesHolder>
{

    public adapter_expense(Context applicationContext){
    }
    public adapter_expense(Context context, List<wages> dailywagesList){

    }
    @Override
    public dailywagesHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_graph_data,parent,false);
       return new dailywagesHolder(view);
    }

    @Override
    public void onBindViewHolder(dailywagesHolder holder, int postion){

    }

    @Override
    public int getItemCount() {
        return 10;
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
//                    Intent intent = new Intent(context, edit_Milk_details.class);
//                    context.startActivity(intent);
                }
            });
        }
    }
}

