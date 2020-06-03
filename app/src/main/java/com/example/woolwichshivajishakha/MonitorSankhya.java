package com.example.woolwichshivajishakha;

import android.graphics.Point;
import android.os.Bundle;
import android.provider.ContactsContract;
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
import androidx.fragment.app.Fragment;

import com.example.woolwichshivajishakha.Model.Sankhya;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class MonitorSankhya extends Fragment {
    public static Button btnGenerateMonitor;
    DatabaseReference database;
    LineGraphSeries<DataPoint> series;
    GraphView sankhyaMonitorGraph;
    String tempName= "";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_monitor_sankhya, container, false);

        btnGenerateMonitor = (Button) v.findViewById(R.id.btnGenerateMonitor);
        sankhyaMonitorGraph = (GraphView) v.findViewById(R.id.monitorGraphView);

        //Create spinner object and dropdown for sampat lines
        final Spinner ageDropdown = (Spinner) v.findViewById(R.id.ageDropdown);
        ArrayAdapter<String> ageAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Ages));
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageDropdown.setAdapter(ageAdapter);

        //Create spinner object and dropdown for month
        final Spinner monthDropdown = (Spinner) v.findViewById(R.id.monthDropdown);
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Month));
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthDropdown.setAdapter(monthAdapter);

        //Create spinner object and dropdown for year
        final Spinner yearDropdown = (Spinner) v.findViewById(R.id.yearDropdown);
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Year));
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearDropdown.setAdapter(yearAdapter);

        //This automatically adds the monthYear value as soon as it has been selected in the dropdown for Month
        monthDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedAge = ageDropdown.getSelectedItem().toString();
                final String selectedMonth = monthDropdown.getSelectedItem().toString();
                final String selectedYear = yearDropdown.getSelectedItem().toString();
                DatabaseReference sankhyaReference = FirebaseDatabase.getInstance().getReference("Sankhya");
                sankhyaReference.orderByChild("monthYear").equalTo(selectedMonth + selectedYear).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(!selectedMonth.equals("") && !selectedYear.equals("")){
                            matchSankhyaDate(dataSnapshot);
                        }
                        else {
                            array.clear();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //This automatically adds the monthYear value as soon as it has been selected in the dropdown for Month
        yearDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedAge = ageDropdown.getSelectedItem().toString();
                final String selectedMonth = monthDropdown.getSelectedItem().toString();
                final String selectedYear = yearDropdown.getSelectedItem().toString();
                DatabaseReference sankhyaReference = FirebaseDatabase.getInstance().getReference("Sankhya");
                sankhyaReference.orderByChild("monthYear").equalTo(selectedMonth + selectedYear).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(!selectedMonth.equals("") && !selectedYear.equals("")){
                            matchSankhyaDate(dataSnapshot);
                        }
                        else {
                            array.clear();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

                //DatabaseReference sankhyaRef;
                //sankhyaRef = FirebaseDatabase.getInstance().getReference();
                //for (int counter = 0; counter < array.size(); counter ++){
                    //sankhyaRef.child("Sankhya").child(array.get(counter)).child("totalFinish").addValueEventListener(new ValueEventListener() {






        btnGenerateMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Years found = ", String.valueOf(array));
                Log.d("totalFinish", String.valueOf(totalFinishArray));


                //Log.d("null for ", s.getKey());

                //-----------------------------------------------------------------


            }
        });
    return v;


    }

    //This function matches the month and year, and puts all values which match the date key in an array
    ArrayList<String> array = new ArrayList<>();
    public void matchSankhyaDate(DataSnapshot dataSnapshot){
        for (DataSnapshot s: dataSnapshot.getChildren()) {
            array.add(s.getKey());
        }

    }
    //This function matches the date, and retrieves the totalFinish value for the corresponding date
    ArrayList<String> totalFinishArray = new ArrayList<>();
    public void matchSankhya(DataSnapshot dataSnapshot){
        totalFinishArray.add(dataSnapshot.getValue().toString());
    }



}
