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
import steedserv.com.eco_agri.server.pojo.Cattles;

/**
 * Created by admin on 23-Jul-18.
 */

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {
    private Context mContext;
    private List<Cattles> mcattleslist=new ArrayList<>( );


    public AnimalAdapter(Context context, List<Cattles> cattleslist) {
        mContext=context;
        mcattleslist=cattleslist;
    }


    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_view,parent,false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {

        Cattles cattles=mcattleslist.get( position );
        holder.mAnimalname.setText( cattles.getAniname() );
        holder.manimdate.setText( cattles.getAnibuydate() );

    }

    @Override
    public int getItemCount() {
        return mcattleslist.size();
    }

    public class AnimalViewHolder extends RecyclerView.ViewHolder {
        View view;

        @BindView(R.id.vieanimal)
        TextView mAnimalname;

        @BindView(R.id.viewanidate)
        TextView manimdate;



        public AnimalViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            view=itemView;

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, view_animals_details.class);
                    intent.putExtra( "data",(Serializable) mcattleslist.get( getAdapterPosition() ) );
                    context.startActivity(intent);
                }
            });
        }
    }
}
