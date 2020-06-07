package com.example.woolwichshivajishakha;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.woolwichshivajishakha.Model.Sankhya;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.gms.common.util.Strings;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LabelFormatter;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MonitorSankhya extends Fragment {
    public static Button btnGenerateMonitor;
    DatabaseReference database;
    LineGraphSeries<DataPoint> series;
    GraphView sankhyaMonitorGraph;
    String selectedAge = "";
    String ageItem = "";
    Spinner ageDropdown, timestampDropdown;
    ArrayList<String> timestampedDates = new ArrayList<>();
    ArrayList<String> yearMonth = new ArrayList<>();
    private LineChart linechart;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final
    Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_monitor_sankhya, container, false);

        btnGenerateMonitor = (Button) v.findViewById(R.id.btnGenerateMonitor);
        linechart = (LineChart) v.findViewById(R.id.monitorGraphView);
        btnGenerateMonitor.setEnabled(false);
        btnGenerateMonitor.setVisibility(View.INVISIBLE);
        linechart.setNoDataText("");

        //Create spinner object and dropdown for sampat lines
        final Spinner ageDropdown = (Spinner) v.findViewById(R.id.ageDropdown);
        ArrayAdapter<String> ageAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Ages));
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageDropdown.setAdapter(ageAdapter);

        //Create spinner object and dropdown for month
        final Spinner timestampDropdown = (Spinner) v.findViewById(R.id.timestampDropdown);
        final ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Timestamp));
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timestampDropdown.setAdapter(monthAdapter);


        ageDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ageItem = ageDropdown.getSelectedItem().toString();
                if (ageItem.equals("Bal")) {
                    selectedAge = "balFinish";
                }
                if (ageItem.equals("Kishore")) {
                    selectedAge = "kishoreFinish";
                }
                if (ageItem.equals("Tarun")) {
                    selectedAge = "tarunFinish";
                }
                if (ageItem.equals("Yuva")) {
                    selectedAge = "yuvaFinish";
                }
                if (ageItem.equals("Proudh")) {
                    selectedAge = "proudhFinish";
                }
                if (ageItem.equals("Anya")) {
                    selectedAge = "anyaFinish";
                }

                //Calculate monthYear depending on which value is chosen from timestamp
                calculateTimestamp(timestampDropdown.getSelectedItem().toString());
                DatabaseReference sankhyaReference = FirebaseDatabase.getInstance().getReference("Sankhya");
                for(String object: timestampedDates){
                    sankhyaReference.orderByChild("monthYear").equalTo(object).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if (!timestampDropdown.getSelectedItem().toString().equals("") && !ageDropdown.getSelectedItem().toString().equals("")) {
                                matchSankhyaDate(dataSnapshot);
                            } else {
                                timestampedDates.clear();
                                valuesArray.clear();
                                datesArray.clear();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Calculate monthYear depending on which value is chosen from timestamp
                timestampedDates.clear();
                valuesArray.clear();
                datesArray.clear();
                selectedAge = "balFinish";
            }
        });


        timestampDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position > 0){
                    btnGenerateMonitor.setEnabled(true);
                    btnGenerateMonitor.setVisibility(View.VISIBLE);
                    timestampedDates.clear();
                    valuesArray.clear();
                    datesArray.clear();
                    yearMonth.clear();
                    calculateTimestamp(timestampDropdown.getSelectedItem().toString());
                    DatabaseReference sankhyaReference = FirebaseDatabase.getInstance().getReference("Sankhya");
                    for(String object: timestampedDates){
                        sankhyaReference.orderByChild("monthYear").equalTo(object).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                if (!timestampDropdown.getSelectedItem().toString().equals("") && !ageDropdown.getSelectedItem().toString().equals("")) {
                                    matchSankhyaDate(dataSnapshot);
                                } else {
                                    timestampedDates.clear();
                                    valuesArray.clear();
                                    datesArray.clear();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                }
                else {
                    btnGenerateMonitor.setEnabled(false);
                    btnGenerateMonitor.setVisibility(View.INVISIBLE);
                    timestampedDates.clear();
                    valuesArray.clear();
                    datesArray.clear();
                    yearMonth.clear();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });

        btnGenerateMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sankhyaMonitorGraph.removeAllSeries();
                linechart.clear();
                yearMonth.clear();
                Log.d("Timeframes", String.valueOf(timestampedDates));
                Log.d("Dates found = ", String.valueOf(datesArray));
                Log.d("Values found = ", String.valueOf(valuesArray));

                String[] strDates = datesArray.toArray(new String[0]);
                float yValues[] = new float[valuesArray.size()];

                for(int i = 0; i < valuesArray.size(); i++){
                    yValues[i] = Float.parseFloat(valuesArray.get(i));
                }

                LineDataSet lds = new LineDataSet(graphValues(), "Sankhya");
                ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                dataSets.add(lds);
                LineData lData = new LineData(dataSets);
                linechart.setData(lData);
                linechart.invalidate();
                lds.setLineWidth(2);
                lds.setDrawCircleHole(true);
                lds.setValueTextSize(9);
                lds.setDrawIcons(false);
                lds.setColor(Color.BLACK);
                lds.setValueTextSize(9);
                lds.setCircleColor(Color.BLACK);
                lds.setCircleRadius(4f);
                lds.setDrawFilled(true);

                if (Utils.getSDKInt() >= 18) {
                    Drawable drawable = ContextCompat.getDrawable(v.getContext(), R.drawable.fade_orange);
                    lds.setFillDrawable(drawable);
                }
                else {
                    lds.setFillColor(Color.BLACK);
                }

                XAxis xAxis = linechart.getXAxis();
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                xAxis.setDrawGridLines(false);
                xAxis.setLabelRotationAngle(-45);
                xAxis.setGranularityEnabled(true);
                YAxis rightAxis = linechart.getAxisRight();
                rightAxis.setEnabled(false);
                linechart.getDescription().setEnabled(false);
                linechart.setTouchEnabled(true);
                linechart.setPinchZoom(true);
                linechart.getLegend().setEnabled(false);
                linechart.setExtraBottomOffset(30);

                    xAxis.setValueFormatter(new IAxisValueFormatter() {
                        @Override
                        public String getFormattedValue(float value, AxisBase axis) {
                            for (String d : datesArray) {
                                yearMonth.add(d.substring(0, 7));
                            }
                            if(value >=0) {
                                return yearMonth.get((int) value);
                            }
                            return yearMonth.get((int)value - 1);
                    }
                    });
            }
        });
        return v;

    }

    public ArrayList<Entry> graphValues(){
        ArrayList<Entry> gValues = new ArrayList<Entry>();
        for (int i = 0; i < datesArray.size(); i++) {
            gValues.add(new Entry(i, Integer.parseInt(valuesArray.get(i))));
        }
        return gValues;
    }

    //This function matches the month and year, and passes the key to checkValue function
    ArrayList<String> datesArray = new ArrayList<>();

    public void matchSankhyaDate(DataSnapshot dataSnapshot) {
        for (DataSnapshot s : dataSnapshot.getChildren()) {
            checkValue(s.getKey());
            datesArray.add(s.getKey());
        }

    }

    //This function checks the values for totalFinish for every date that is found
    ArrayList<String> valuesArray = new ArrayList<>();

    public void checkValue(String s) {
        DatabaseReference sankhyaRef;
        sankhyaRef = FirebaseDatabase.getInstance().getReference();
        sankhyaRef.child("Sankhya").child(s).child(selectedAge).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                valuesArray.add(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void calculateTimestamp(String sTimeStamp) {
        timestampedDates.clear();
        valuesArray.clear();
        datesArray.clear();
        if (sTimeStamp.equals("Past 3 months")) {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            for (int i = 3; i > 0; i--) {
                if (month == 0) {
                    month = 11;
                    year = year - 1;
                    timestampedDates.add("12" + String.valueOf(year));
                } else {
                    int monthLength = Integer.toString(month).length();
                    if (monthLength == 1) {
                        String monthYear = "0" + String.valueOf(month) + String.valueOf(year);
                        timestampedDates.add(monthYear);
                    } else {
                        String monthYear = String.valueOf(month) + String.valueOf(year);
                        timestampedDates.add(monthYear);
                    }
                    month = month - 1;
                }
            }
            Collections.reverse(timestampedDates);
            Log.d("3 months, Timestamp: ", String.valueOf(timestampedDates));
        }
            if (sTimeStamp.equals("Past 6 months")) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                for (int i = 6; i > 0; i--) {
                    if (month == 0) {
                        month = 11;
                        year = year - 1;
                        timestampedDates.add("12" + String.valueOf(year));
                    } else {
                        int monthLength = Integer.toString(month).length();
                        if (monthLength == 1) {
                            String monthYear = "0" + String.valueOf(month) + String.valueOf(year);
                            timestampedDates.add(monthYear);
                        } else {
                            String monthYear = String.valueOf(month) + String.valueOf(year);
                            timestampedDates.add(monthYear);
                        }
                        month = month - 1;
                    }
                }
                Collections.reverse(timestampedDates);
                Log.d("6 months, Timestamps: ", String.valueOf(timestampedDates));
            }
            if (sTimeStamp.equals("Past 9 months")) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                for (int i = 9; i > 0; i--) {
                    if (month == 0) {
                        month = 11;
                        year = year - 1;
                        timestampedDates.add("12" + String.valueOf(year));
                    } else {
                        int monthLength = Integer.toString(month).length();
                        if (monthLength == 1) {
                            String monthYear = "0" + String.valueOf(month) + String.valueOf(year);
                            timestampedDates.add(monthYear);
                        } else {
                            String monthYear = String.valueOf(month) + String.valueOf(year);
                            timestampedDates.add(monthYear);
                        }
                        month = month - 1;
                    }
                }
                Collections.reverse(timestampedDates);
                Log.d("9 months, Timestamps: ", String.valueOf(timestampedDates));
            }
            if (sTimeStamp.equals("Past year")) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                for (int i = 12; i > 0; i--) {
                    if (month == 0) {
                        month = 11;
                        year = year - 1;
                        timestampedDates.add("12" + String.valueOf(year));
                    } else {
                        int monthLength = Integer.toString(month).length();
                        if (monthLength == 1) {
                            String monthYear = "0" + String.valueOf(month) + String.valueOf(year);
                            timestampedDates.add(monthYear);
                        } else {
                            String monthYear = String.valueOf(month) + String.valueOf(year);
                            timestampedDates.add(monthYear);
                        }
                        month = month - 1;
                    }
                }
                Collections.reverse(timestampedDates);
                Log.d("12 months, Timestamps: ", String.valueOf(timestampedDates));
            }
            if (sTimeStamp.equals("All time")) {

            }


        }


    }

