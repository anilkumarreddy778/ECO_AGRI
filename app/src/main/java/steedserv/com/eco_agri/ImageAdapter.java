package steedserv.com.eco_agri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by admin on 03-Jul-18.
 */

public class ImageAdapter extends BaseAdapter {
    Context context;
    int animla[];
    LayoutInflater inflter;

    public ImageAdapter(Context applicationContext, int[] animla) {
        this.context = applicationContext;
        this. animla= animla;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return animla.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.home_gridview, null);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        icon.setImageResource(animla[i]);
        return view;
        }
        }