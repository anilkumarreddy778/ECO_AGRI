package steedserv.com.eco_agri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 22-May-19.
 */

public class categoryAdopter extends RecyclerView.Adapter<categoryAdopter.CategoryViewHolder> {

    private Context mcontext;
//    private List<Categoryad> mCategorylist=new ArrayList<>();

    public categoryAdopter(categoryAdopter categoryAdopter){

    }

    public categoryAdopter(Context applicationContext){

    }

    public categoryAdopter.CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view= LayoutInflater.from(parent.getContext()).inflate( R.layout.category_view,parent,false );
        return new CategoryViewHolder(view);
    }
    @Override
    public void onBindViewHolder(categoryAdopter.CategoryViewHolder holder, int position) {

//        Categoryad categorye=mCategorylist.get( position );
//        holder.mname.setText( categorye.getName() );
//        holder.cid.setText( categorye.getCid() );
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        View view;

        @BindView( R.id.catname)
        TextView mname;
        @BindView( R.id.cid )
        TextView cid;



        public CategoryViewHolder (View itemView){
            super(itemView);

            ButterKnife.bind(this,itemView);
            view=itemView;

            view.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            } );

        }
    }
}
