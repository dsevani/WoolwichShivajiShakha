package com.example.woolwichshivajishakha;

import android.graphics.Point;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class MonitorSankhya extends Fragment {
    public static Button btnGenerateMonitor;
    DatabaseReference database;
    LineGraphSeries<DataPoint> series;
    GraphView sankhyaMonitorGraph;

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

        btnGenerateMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance().getReference("Sankhya");

                String selectedAge = ageDropdown.getSelectedItem().toString();
                String selectedMonth = monthDropdown.getSelectedItem().toString();
                String selectedYear = yearDropdown.getSelectedItem().toString();
                String ageFirebase;

                //Mapping dropdown value to field in firebase
                if (selectedAge.equals("Bal")){
                    ageFirebase = "balFinish";
                }
                if (selectedAge.equals("Kishore")){
                    ageFirebase = "kishoreFinish";
                }
                if (selectedAge.equals("Bal")){
                    ageFirebase = "tarunFinish";
                }
                if (selectedAge.equals("Bal")){
                    ageFirebase = "yuvaFinish";
                }
                if (selectedAge.equals("Bal")){
                    ageFirebase = "proudhFinish";
                }
                if (selectedAge.equals("Bal")){
                    ageFirebase = "anyaFinish";
                }

                //This retrieves values from firebase that match the select month and select year dropdown, and sets it into the line graph

                DatabaseReference sankhyaReference = FirebaseDatabase.getInstance().getReference("Sankhya");
                sankhyaReference.orderByChild("monthYear").equalTo(selectedMonth + selectedYear).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        DataPoint[] dp = new DataPoint[(int) dataSnapshot.getChildrenCount()];
                        int index = 0;

                        for (DataSnapshot s: dataSnapshot.getChildren()) {
                            Log.d("TAG", s.getKey());
                            //dp [index] = new DataPoint(Integer.parseInt(s.getKey()), pointValue.getTotalFinish());
                            //index++;
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        throw databaseError.toException(); // don't ignore errors
                    }
                });

                //-----------------------------------------------------------------


            }
        });



    return v;


    }

}
