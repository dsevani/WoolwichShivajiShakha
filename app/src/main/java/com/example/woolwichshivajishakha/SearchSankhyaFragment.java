package com.example.woolwichshivajishakha;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class SearchSankhyaFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    Context context;
    LayoutInflater inflater;
    //FirebaseDatabase firebaseDatabase;
    //DatabaseReference databaseReference;
    //String searchedDate;
    //ArrayList<String> shakhaDateList = new ArrayList<>();
    //final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.activity_list_item);


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //firebaseDatabase = FirebaseDatabase.getInstance();
        //databaseReference = firebaseDatabase.getReference("Sankhya");
        Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH);
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, yy, mm, dd);
    }


    public void onDateSet(DatePicker view, int yy, int mm, int dd) {
        populateSetDate(yy, mm+1, dd);
    }

    public void populateSetDate(int year, int month, int day) {
            //TextView shakhaDate = (TextView) getActivity().findViewById(R.id.vwDateField);
            //shakhaDate.setText(day+"/"+month+"/"+year);
        //DecimalFormat mFormat= new DecimalFormat("00");
        //mFormat.format(Double.valueOf(year));
        //mFormat.setRoundingMode(RoundingMode.DOWN);
        //searchedDate =  mFormat.format(Double.valueOf(day))
                //+ "-" +  mFormat.format(Double.valueOf(month)) + "-" +  year;
    }

    }
