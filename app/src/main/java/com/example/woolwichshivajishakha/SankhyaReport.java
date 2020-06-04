package com.example.woolwichshivajishakha;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class SankhyaReport extends Fragment {
    public static Button btnGenerateMonitor;
    DatabaseReference database;
    LineGraphSeries<DataPoint> series;
    GraphView sankhyaMonitorGraph;
    String ageItem= "";
    String selectedAge = "";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_monitor_sankhya, container, false);

        btnGenerateMonitor = (Button) v.findViewById(R.id.btnGenerateMonitor);
        sankhyaMonitorGraph = (GraphView) v.findViewById(R.id.monitorGraphView);

        //Create spinner object and dropdown for sampat lines
        //final Spinner ageDropdown = (Spinner) v.findViewById(R.id.ageDropdown);
        //ArrayAdapter<String> ageAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Ages));
        //ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //ageDropdown.setAdapter(ageAdapter);

        //Create spinner object and dropdown for month
        //final Spinner monthDropdown = (Spinner) v.findViewById(R.id.monthDropdown);
        //ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Month));
        //monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //monthDropdown.setAdapter(monthAdapter);

        //Create spinner object and dropdown for year
        //final Spinner yearDropdown = (Spinner) v.findViewById(R.id.yearDropdown);
        //ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Year));
        //yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //yearDropdown.setAdapter(yearAdapter);

        //This automatically adds the monthYear value as soon as it has been selected in the dropdown for Month

        //ageDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //@Override
            //public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //ageItem = ageDropdown.getSelectedItem().toString();
                if (ageItem.equals("Bal")){
                    selectedAge = "balFinish";
                }
                if (ageItem.equals("Kishore")){
                    selectedAge = "kishoreFinish";
                }
                if (ageItem.equals("Tarun")){
                    selectedAge = "tarunFinish";
                }
                if (ageItem.equals("Yuva")){
                    selectedAge = "yuvaFinish";
                }
                if (ageItem.equals("Proudh")){
                    selectedAge = "proudhFinish";
                }
                if (ageItem.equals("Anya")){
                    selectedAge = "anyaFinish";
                }
                if (ageItem.equals("Total")){
                    selectedAge = "totalFinish";
                }
            //}

            //@Override
           // public void onNothingSelected(AdapterView<?> parent) {

            //}
        //});


        //This automatically adds the monthYear value as soon as it has been selected in the dropdown for Month
        //monthDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //@Override
            //public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //final String selectedMonth = monthDropdown.getSelectedItem().toString();
                //final String selectedYear = yearDropdown.getSelectedItem().toString();
                //DatabaseReference sankhyaReference = FirebaseDatabase.getInstance().getReference("Sankhya");
                //sankhyaReference.orderByChild("monthYear").equalTo(selectedMonth + selectedYear).addValueEventListener(new ValueEventListener() {
                    //@Override
                    //public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //if(!selectedMonth.equals("") && !selectedYear.equals("")){
                            //matchSankhyaDate(dataSnapshot);
                        //}
                        //else {
                            //valuesArray.clear();
                            //datesArray.clear();
                        //}
                    //}

                    //@Override
                    //public void onCancelled(@NonNull DatabaseError databaseError) {

                    //}
                //});
            //}

            //@Override
            //public void onNothingSelected(AdapterView<?> parent) {

            //}
        //});

        //This automatically adds the monthYear value as soon as it has been selected in the dropdown for Month
        //yearDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //@Override
            //public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String selectedAge = ageDropdown.getSelectedItem().toString();
                //final String selectedMonth = monthDropdown.getSelectedItem().toString();
                //final String selectedYear = yearDropdown.getSelectedItem().toString();
                //DatabaseReference sankhyaReference = FirebaseDatabase.getInstance().getReference("Sankhya");
                //sankhyaReference.orderByChild("monthYear").equalTo(selectedMonth + selectedYear).addValueEventListener(new ValueEventListener() {
                    //@Override
                    //public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //if(!selectedMonth.equals("") && !selectedYear.equals("")){
                            //matchSankhyaDate(dataSnapshot);
                        //}
                        //else {
                          //  valuesArray.clear();
                            //datesArray.clear();
                        //}
                    //}

                    //@Override
                    //public void onCancelled(@NonNull DatabaseError databaseError) {

                    //}
                //});
            //}

            //@Override
            //public void onNothingSelected(AdapterView<?> parent) {

            //}
        //});

        btnGenerateMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Dates found = ", String.valueOf(datesArray));
                Log.d("Values found = ", String.valueOf(valuesArray));
                Log.d("age is ", selectedAge);
                datesArray.clear();
                valuesArray.clear();
            }
        });
    return v;


    }

    //This function matches the month and year, and passes the key to checkValue function
    ArrayList<String> datesArray = new ArrayList<>();
    public void matchSankhyaDate(DataSnapshot dataSnapshot){
        for (DataSnapshot s: dataSnapshot.getChildren()) {
                checkValue(s.getKey());
                datesArray.add(s.getKey());
            }

    }

    //This function checks the values for totalFinish for every date that is found
    ArrayList<String> valuesArray = new ArrayList<>();
    public void checkValue(String s){
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



}
