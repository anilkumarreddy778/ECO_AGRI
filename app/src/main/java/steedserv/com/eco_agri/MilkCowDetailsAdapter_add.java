package steedserv.com.eco_agri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by admin on 21-Dec-18.
 */

public class MilkCowDetailsAdapter_add extends RecyclerView.Adapter<MilkCowDetailsAdapter_add.MilkViewHolder> {
    private Context mcontext;

    add_milk_Fragment add_milk_fragment=new add_milk_Fragment();

    public MilkCowDetailsAdapter_add(MilkCowDetailsAdapter_add milkCowDetailsAdapter_add) {
    }

    public MilkCowDetailsAdapter_add(Context applicationContext) {
    }

    @Override
    public MilkCowDetailsAdapter_add.MilkViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.milkcow_details_view,parent, false);
        return new MilkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MilkCowDetailsAdapter_add.MilkViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 2;
    }


    public class MilkViewHolder extends RecyclerView.ViewHolder {
        View view;

        public MilkViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
            view = itemView;

            view.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    //Context context=v.getContext();

                }

            });
        }
    }
}