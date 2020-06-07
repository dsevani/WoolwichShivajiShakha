package com.example.woolwichshivajishakha;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SankhyaReport extends Fragment {

    String selectedMonth = "";
    String selectedYear = "";
    Bitmap bmpLogo;
    Bitmap bmpScaled;

    public static Button btnReport;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final
    Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_report_sankhya, container, false);
        btnReport = (Button) v.findViewById(R.id.btnReport);
        bmpLogo = BitmapFactory.decodeResource(getResources(),R.drawable.logo);
        bmpScaled = Bitmap.createScaledBitmap(bmpLogo,275,250,false);
        ActivityCompat.requestPermissions(getActivity(), new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        final Spinner monthDropdown = (Spinner) v.findViewById(R.id.monthDropdown);
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Month));
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthDropdown.setAdapter(monthAdapter);
        final Spinner yearDropdown = (Spinner) v.findViewById(R.id.yearDropdown);
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Year));
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearDropdown.setAdapter(yearAdapter);

        monthDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedMonth = monthDropdown.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedMonth = "01";
            }
        });

        yearDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedYear = yearDropdown.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedYear = "2020";
            }
        });

        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference sankhyaReference = FirebaseDatabase.getInstance().getReference("Sankhya");
                sankhyaReference.orderByChild("monthYear").equalTo(selectedMonth+selectedYear).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        matchSankhyaDate(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        return v;
    }

    ArrayList<String> datesArray = new ArrayList<>();
    public void matchSankhyaDate(DataSnapshot dataSnapshot) {
        for (DataSnapshot s : dataSnapshot.getChildren()) {
            datesArray.add(s.getKey());
        }
        if(datesArray.size() == 0){
            Toast.makeText(getActivity(), "No dates found", Toast.LENGTH_SHORT).show();
        }
        else{
            createPDF();
            }
        }

        private void createPDF(){
        PdfDocument pdfDoc = new PdfDocument();
        Paint title = new Paint();
        Paint logo = new Paint();
        PdfDocument.PageInfo pInfo = new PdfDocument.PageInfo.Builder(1200,2010,1).create();
        PdfDocument.Page pg = pdfDoc.startPage(pInfo);
            Canvas canvas = pg.getCanvas();

            //Creates the title of the pdf
            title.setTextAlign(Paint.Align.CENTER);
            title.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
            title.setTextSize(40f);
            canvas.drawText("Sankhya Report for " + selectedMonth + "-" + selectedYear,600,173, title);


            //Adds the logo to PDF
            canvas.drawBitmap(bmpScaled,40,40, logo);



            pdfDoc.finishPage(pg);

            File file = new File(Environment.getExternalStorageDirectory(),selectedMonth+"-"+selectedYear+".pdf");

            try{
                pdfDoc.writeTo(new FileOutputStream(file));
                Toast.makeText(getActivity(), "Created", Toast.LENGTH_SHORT).show();
                //openPDF();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            pdfDoc.close();
        }

        private void openPDF(){
            File pdfFile = new File(Environment.getExternalStorageDirectory() + selectedMonth+"-"+selectedYear+".pdf");
            Uri path = Uri.fromFile(pdfFile);
            Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
            pdfIntent.setDataAndType(path, "application/pdf");
            pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            try{
                startActivity(pdfIntent);
            }catch(ActivityNotFoundException e){
                Toast.makeText(getActivity(), "Could not open PDF", Toast.LENGTH_SHORT).show();
            }
        }
    }


