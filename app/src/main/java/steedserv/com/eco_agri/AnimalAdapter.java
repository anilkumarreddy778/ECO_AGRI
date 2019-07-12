package steedserv.com.eco_agri;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 23-Jul-18.
 */

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    public AnimalAdapter(Context context) {

    }


    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_view,parent,false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class AnimalViewHolder extends RecyclerView.ViewHolder {



        View view;
        public AnimalViewHolder(View itemView) {
            super(itemView);

            view=itemView;

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, view_animals_details.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}
