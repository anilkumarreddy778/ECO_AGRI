package steedserv.com.eco_agri;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.Calendar;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by admin on 03-Aug-18.
 */

public class SingleUserInvestAdapter extends RecyclerView.Adapter<SingleUserInvestAdapter.SingleShareHolder> {

    private PopupWindow mPopupWindow;
    private RelativeLayout mRelativeLayout;
    private Context mContext;
    private Activity mActivity;

    private EditText mupdate=null;


    public SingleUserInvestAdapter(Context mContext)
    {

    }

    @Override
    public SingleShareHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.single_share_view, parent, false );
        return new SingleShareHolder( view );



        //mActivity = SingleUserInvestAdapter.this;
    }

    @Override
    public void onBindViewHolder(SingleUserInvestAdapter.SingleShareHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }



    public class SingleShareHolder extends RecyclerView.ViewHolder {
        View view;
        public SingleShareHolder(View itemView) {

            super(itemView);

            view = itemView;


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRelativeLayout = (RelativeLayout) view.findViewById( R.id.singleivestparent );

                     Context context = v.getContext();
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService( LAYOUT_INFLATER_SERVICE );

                final View customView = inflater.inflate( R.layout.popup_add_takeout_single_invest_edit, null );

                mPopupWindow = new PopupWindow( customView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT );
                mPopupWindow.setWidth( 1080 );

                mPopupWindow.setFocusable( true );
                mPopupWindow.update();

                ImageButton closeButton = (ImageButton) customView.findViewById( R.id.catseditclose );
                final ImageButton deletrecord =(ImageButton) closeButton.findViewById( R.id.sidelete ) ;

                    final Calendar cld = Calendar.getInstance();
                    int mYear = cld.get(Calendar.YEAR);
                    int mMonth = cld.get(Calendar.MONTH);
                    int mDay = cld.get(Calendar.DAY_OF_MONTH);

                mupdate = customView.findViewById( R.id.updatesdate );
                    mupdate.setText( mDay+"-"+mMonth+"-"+mYear );
                    final EditText finalEditText3 = mupdate;
                    mupdate.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context2=customView.getContext();
                            datePicker( finalEditText3,context2 );
                    }
                } );

                closeButton.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();
                    }
                } );

//                deletrecord.setOnClickListener( new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        mPopupWindow.dismiss();
//                    }
//                } );
                    EditText editText = null;
                FloatingActionButton addbutton = customView.findViewById( R.id.updatesivest );
                final EditText finalEditText = editText;
                addbutton.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //need to write java add category code
                        mPopupWindow.dismiss();
                    }
                } );
                mPopupWindow.showAtLocation( view, Gravity.CENTER, 0, 0 );


            }

            });


        }

    }
    public void datePicker(final EditText Date,Context context2) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get( Calendar.YEAR );
        int mMonth = c.get( Calendar.MONTH );
        int mDay = c.get( Calendar.DAY_OF_MONTH );


        DatePickerDialog datePickerDialog = new DatePickerDialog(context2,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        Date.setText( dayOfMonth + "-" + (monthOfYear + 1) + "-" + year );

                    }
                }, mYear, mMonth, mDay );
        datePickerDialog.getDatePicker().setMaxDate( (Calendar.getInstance().getTimeInMillis()) );
        datePickerDialog.show();
    }


}
