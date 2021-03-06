package com.example.woolwichshivajishakha;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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

        String strDay = String.valueOf(day);
        if (strDay.length() == 1) {
            strDay = "0" + strDay;
        }

        String strMonth = String.valueOf(month);
        if (strMonth.length() == 1) {
            strMonth = "0" + strMonth;
        }

        String strYear = String.valueOf(year);
        shakhaDate.setText(strYear + "-" + strMonth + "-" + strDay);

    }
}
