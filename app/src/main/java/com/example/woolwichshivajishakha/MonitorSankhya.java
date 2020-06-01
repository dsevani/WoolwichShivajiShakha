package com.example.woolwichshivajishakha;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MonitorSankhya extends Fragment {
    public static Button btnGenerateMonitor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_monitor_sankhya, container, false);

        btnGenerateMonitor = (Button) v.findViewById(R.id.btnGenerateMonitor);

        //Create spinner object and dropdown for sampat lines
        Spinner ageDropdown = (Spinner) v.findViewById(R.id.ageDropdown);
        ArrayAdapter<String> ageAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Ages));
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageDropdown.setAdapter(ageAdapter);

        //Create spinner object and dropdown for month
        Spinner monthDropdown = (Spinner) v.findViewById(R.id.monthDropdown);
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Month));
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthDropdown.setAdapter(monthAdapter);

        //Create spinner object and dropdown for year
        Spinner yearDropdown = (Spinner) v.findViewById(R.id.yearDropdown);
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Year));
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearDropdown.setAdapter(yearAdapter);

        GraphView sankhyaMonitorGraph = (GraphView) v.findViewById(R.id.monitorGraphView);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(getDataPoint());
        sankhyaMonitorGraph.addSeries(series);

    return v;
    }

    private DataPoint[] getDataPoint(){
        DataPoint[] dp = new DataPoint[]{
                new DataPoint(4,1),
                new DataPoint(5,2)
        };
        return (dp);
    };
}
