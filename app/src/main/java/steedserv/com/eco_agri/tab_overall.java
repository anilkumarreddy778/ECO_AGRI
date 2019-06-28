package steedserv.com.eco_agri;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by admin on 27-Jun-19.
 */

public class tab_overall extends Fragment {

    public tab_overall(){}
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }



        RecyclerView recyclerView;
        adapter_overall overall;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
// Inflate the layout for this fragment
            View view=inflater.inflate( R.layout.tab_overall_report, container, false);

            recyclerView=view.findViewById( R.id.overallrecycle);
            final FragmentActivity c=getActivity();
            LinearLayoutManager layoutManager=new LinearLayoutManager(c);
            recyclerView.setLayoutManager( layoutManager );
            overall=new adapter_overall(c);
            recyclerView.setAdapter( overall );


            BarChart chart = view.findViewById(R.id.barchart);

            ArrayList NoOfEmp = new ArrayList();

            NoOfEmp.add(new BarEntry(945f, 0));
            NoOfEmp.add(new BarEntry(1040f, 1));
            NoOfEmp.add(new BarEntry(1133f, 2));
            NoOfEmp.add(new BarEntry(1240f, 3));
            NoOfEmp.add(new BarEntry(1369f, 4));
            NoOfEmp.add(new BarEntry(1487f, 5));
            NoOfEmp.add(new BarEntry(1501f, 6));
            NoOfEmp.add(new BarEntry(1645f, 7));
            NoOfEmp.add(new BarEntry(1578f, 8));
            NoOfEmp.add(new BarEntry(1695f, 9));

            ArrayList year = new ArrayList();

            year.add("2010");
            year.add("2011");
            year.add("2012");
            year.add("2013");
            year.add("2014");
            year.add("2015");
            year.add("2016");
            year.add("2017");
            year.add("2018");
            year.add("2019");

            BarDataSet bardataset = new BarDataSet(NoOfEmp, "Farm Status");
            chart.animateY(5000);
            BarData data = new BarData(year, bardataset);
            bardataset.setColors( ColorTemplate.COLORFUL_COLORS);
            chart.setData(data);
            return view;
        }
}
