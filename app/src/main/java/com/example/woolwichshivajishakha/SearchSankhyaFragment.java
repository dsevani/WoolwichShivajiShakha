package com.example.woolwichshivajishakha;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class SearchSankhyaFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    Context context;
    LayoutInflater inflater;
    private DatabaseReference mUserDatabase;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mUserDatabase = FirebaseDatabase.getInstance().getReference();
        final Calendar calendar = Calendar.getInstance();
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
            TextView shakhaDate = (TextView) getActivity().findViewById(R.id.vwDateField);
            shakhaDate.setText(day+"/"+month+"/"+year);
    }
    public void searchSankhya(){

    }


}
