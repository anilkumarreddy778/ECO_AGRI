package steedserv.com.eco_agri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import steedserv.com.eco_agri.server.pojo.wages;

/**
 * Created by admin on 27-Sep-18.
 */

public class dailyWagesAdapter extends RecyclerView.Adapter<dailyWagesAdapter.dailywagesHolder>
{
private Context mContext;
private List<wages> mdailywagesList=new ArrayList<>();

public dailyWagesAdapter(Context context,List<wages> wagesList)
{
    mContext=context;
    mdailywagesList=wagesList;
}
@Override
    public dailyWagesAdapter.dailywagesHolder onCreateViewHolder(ViewGroup parent, int ViewType)
{
    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_wages_view,parent,false);
    return new dailywagesHolder(view);
}

@Override
    public void onBindViewHolder (dailywagesHolder holder,int positon)
{
    wages wages =mdailywagesList.get(positon);

}
@Override
    public int getItemCount()
{
    return mdailywagesList.size();
}

public class dailywagesHolder extends RecyclerView.ViewHolder
{
    View view;
    @BindView(R.id.category)
    TextView mCategory;
    @BindView(R.id.description)
    TextView mDescription;
    @BindView(R.id.rupee)
    TextView mRupee;
    @BindView(R.id.time)
    TextView mTime;
    @BindView(R.id.mntyer)
    TextView mMntyer;
    @BindView(R.id.date)
    TextView mDate;

    public dailywagesHolder (View itemView)
    {
        super(itemView);
        ButterKnife.bind(this,itemView);
        view = itemView;
        view.setOnClickListener(new View.OnClickListener()
        {
            @Override
                    public void onClick(View v)
        {
            Context context= v.getContext();
        }
    }
    );
    }
}
}

