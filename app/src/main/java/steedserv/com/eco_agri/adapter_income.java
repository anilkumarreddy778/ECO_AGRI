package steedserv.com.eco_agri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 28-Jun-19.
 */

public class adapter_income extends RecyclerView.Adapter<adapter_income.icomeholder> {

    public adapter_income(Context applicationContext){
    }


    @Override
    public icomeholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from( parent.getContext()).inflate( R.layout.view_graph_income,parent,false );

        return new icomeholder(view);
    }

    @Override
    public void onBindViewHolder(icomeholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class icomeholder extends RecyclerView.ViewHolder{

        View view;
        public icomeholder(View itemView) {
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
