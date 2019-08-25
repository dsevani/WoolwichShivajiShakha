package com.example.woolwichshivajishakha;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.DatePicker;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Calendar;

public class SearchSankhyaFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    Context context;
    LayoutInflater inflater;
    ListView listView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String searchedDate;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Sankhya");
        Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH);
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, yy, mm, dd);
    }

    public void onDateSet(DatePicker view, int yy, int mm, int dd) {
        searchSankhya();
        populateSetDate(yy, mm+1, dd);
    }

    public void populateSetDate(int year, int month, int day) {
            //TextView shakhaDate = (TextView) getActivity().findViewById(R.id.vwDateField);
            //shakhaDate.setText(day+"/"+month+"/"+year);
        DecimalFormat mFormat= new DecimalFormat("00");
        mFormat.format(Double.valueOf(year));
        mFormat.setRoundingMode(RoundingMode.DOWN);
        searchedDate =  mFormat.format(Double.valueOf(day))
                + "-" +  mFormat.format(Double.valueOf(month)) + "-" +  year;
    }

    public void searchSankhya(){
        final AlertDialog.Builder builderSingle = new AlertDialog.Builder(getContext());

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    //This below is pulling a null value
                    if (data.child("Sankhya").getValue(String.class).equals(searchedDate)) {
                        builderSingle.setTitle("Found "  + searchedDate);
                        builderSingle.setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dismiss();
                            }

                        });
                                builderSingle.show();
                    }
                    else
                        {
                        builderSingle.setTitle("Not found " + searchedDate);
                        builderSingle.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dismiss();
                            }

                            });
                        builderSingle.show();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //AlertDialog.Builder builderSingle = new AlertDialog.Builder(getContext());
        //builderSingle.setTitle("Select One Name:-");

        //final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.select_dialog_singlechoice);
        //arrayAdapter.add("Hardik");
        //arrayAdapter.add("Archit");
        //arrayAdapter.add("Jignesh");
        //arrayAdapter.add("Umang");
        //arrayAdapter.add("Gatti");

        //builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            //@Override
            //public void onClick(DialogInterface dialog, int which) {
                //dialog.dismiss();
            //}
        //});

        //builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            //@Override
            //public void onClick(DialogInterface dialog, int which) {
                //String strName = arrayAdapter.getItem(which);
                //AlertDialog.Builder builderInner = new AlertDialog.Builder(getContext());
                //builderInner.setMessage(strName);
                //builderInner.setTitle("Your Selected Item is");
                //builderInner.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    //@Override
                    //public void onClick(DialogInterface dialog,int which) {
                        //dialog.dismiss();
                    //}
                //});
                //builderInner.show();
            //}
        //});
        //builderSingle.show();
    }


}
