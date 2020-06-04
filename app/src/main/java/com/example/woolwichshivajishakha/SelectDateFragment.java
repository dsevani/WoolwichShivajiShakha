package com.example.woolwichshivajishakha;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    Context context;
    LayoutInflater inflater;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH);
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, yy, mm, dd);
    }

    public void onDateSet(DatePicker view, int yy, int mm, int dd) {
        populateSetDate(yy, mm+1, dd);
    }

    public void populateSetDate(int year, int month, int day) {
                TextView shakhaDate = (TextView) getActivity().findViewById(R.id.DateField);
                int dayLength = String.valueOf(day).length();
        int monthLength = String.valueOf(month).length();

        if ((dayLength == 1) && (monthLength ==1)){
            shakhaDate.setText(year + "-" + "0" + month + "-" + "0" + day);
        }
        else if ((dayLength == 1) && (monthLength == 2)){
            shakhaDate.setText(year + "-" + month + "-" + "0" + day);

        }
        else if ((dayLength == 2) && (monthLength == 1)){
            shakhaDate.setText(year + "-" + "0" + month + "-" + day);
        }


    }
}
