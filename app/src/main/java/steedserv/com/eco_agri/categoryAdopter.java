package steedserv.com.eco_agri;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import steedserv.com.eco_agri.server.pojo.Category;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by admin on 22-May-19.
 */

public class categoryAdopter extends RecyclerView.Adapter<categoryAdopter.CategoryViewHolder> {

    private Context mcontext;
    private PopupWindow mPopupWindow;
    private List<Category> mCategorylist=new ArrayList<>();
    Category category;

    public categoryAdopter(categoryAdopter categoryAdopter){

    }

    public categoryAdopter(Context context, List<Category> categoryList){
        mcontext=context;
        mCategorylist=categoryList;

    }

    public categoryAdopter.CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view= LayoutInflater.from(parent.getContext()).inflate( R.layout.category_view,parent,false );
        return new CategoryViewHolder(view);
    }
    @Override
    public void onBindViewHolder(categoryAdopter.CategoryViewHolder holder, int position) {

        Category categorye=mCategorylist.get( position );

        for(int i=0;i<mCategorylist.size();i++){


            holder.mname.setText( categorye.getCatname() );
            holder.catid.setId( categorye.getCatid() );
        }

    }

    @Override
    public int getItemCount() {
        return mCategorylist.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        View view;

        @BindView( R.id.catname)
        TextView mname;
        @BindView( R.id.catid )
        ImageView catid;



        public CategoryViewHolder (View itemView){
            super(itemView);

            ButterKnife.bind(this,itemView);
            view=itemView;

            view.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();

                    LayoutInflater inflater=(LayoutInflater) context.getSystemService( LAYOUT_INFLATER_SERVICE );
                    View customview=inflater.inflate( R.layout.popup_category_edit,null );
                    mPopupWindow=new PopupWindow( customview, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT );
                    mPopupWindow.setWidth( 1080 );
                    mPopupWindow.setFocusable( true );
                    //mPopupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.border_circle));
                    mPopupWindow.update();

                    ButterKnife.bind(customview);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("data", (Serializable) mCategorylist.get(getAdapterPosition()));

                    if(Build.VERSION.SDK_INT>=21){
                        mPopupWindow.setElevation(250.5f);
                    }


                    ImageButton closepopup=(ImageButton) customview.findViewById( R.id.cateditclose );
                    EditText editText = null;

                    EditText editcat=(EditText) customview.findViewById( R.id.editcat );
                    editcat.setText( category.getCatname() );

                    closepopup.setOnClickListener( new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mPopupWindow.dismiss();
                        }
                    } );

                    FloatingActionButton floatingActionButton=customview.findViewById( R.id.catupdate);
                    final EditText finalEditText = editText;
                    floatingActionButton.setOnClickListener( new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            mPopupWindow.dismiss();
                        }
                    } );

                    mPopupWindow.showAtLocation( view, Gravity.CENTER,0,0 );



                }
            } );

        }
    }
}
