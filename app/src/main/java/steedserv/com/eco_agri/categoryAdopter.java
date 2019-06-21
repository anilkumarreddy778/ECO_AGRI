package steedserv.com.eco_agri;

import android.content.Context;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by admin on 22-May-19.
 */

public class categoryAdopter extends RecyclerView.Adapter<categoryAdopter.CategoryViewHolder> {

    private Context mcontext;
    private PopupWindow mPopupWindow;
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
        return 25;
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
                    Context context = v.getContext();
                    LayoutInflater inflater=(LayoutInflater) context.getSystemService( LAYOUT_INFLATER_SERVICE );
                    View customview=inflater.inflate( R.layout.popup_category_edit,null );
                    mPopupWindow=new PopupWindow( customview, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT );
                    mPopupWindow.setHeight( 1090 );
                    mPopupWindow.setWidth( 1000 );
                    mPopupWindow.setFocusable( true );
                    //mPopupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.border_circle));
                    mPopupWindow.update();

                    if(Build.VERSION.SDK_INT>=21){
                        mPopupWindow.setElevation(250.5f);
                    }


                    ImageButton closepopup=(ImageButton) customview.findViewById( R.id.cateditclose );

                    // creating objects of all compnets
                    EditText editText = null;
                    //editText = customview.findViewById( R.id.edittranamount );

                    closepopup.setOnClickListener( new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //close popup
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
//                    Context context = v.getContext();
//                    Intent intent = new Intent(context, view_animals_details.class);
//                    context.startActivity(intent);

                }
            } );

        }
    }
}
