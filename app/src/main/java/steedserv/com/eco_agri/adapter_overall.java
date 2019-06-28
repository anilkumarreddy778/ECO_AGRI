package steedserv.com.eco_agri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 28-Jun-19.
 */

public class adapter_overall extends RecyclerView.Adapter<adapter_overall.onholdeoverall> {

    public adapter_overall(Context applicationContext)
    {

    }

    @Override
    public onholdeoverall onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from( parent.getContext() ).inflate( R.layout.view_graph_overall,parent,false );
        return new onholdeoverall( view );
    }

    @Override
    public void onBindViewHolder(onholdeoverall holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class onholdeoverall extends RecyclerView.ViewHolder{

        View view;
        public onholdeoverall(View itemView) {

            super( itemView );
            view=itemView;
            view.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context=v.getContext();

                }
            } );
        }
    }
}
