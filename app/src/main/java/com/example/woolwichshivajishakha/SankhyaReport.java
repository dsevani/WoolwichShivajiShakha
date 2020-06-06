package com.example.woolwichshivajishakha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.woolwichshivajishakha.R;

public class SankhyaReport extends Fragment {
    public static Button btnReport;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final
    Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_report_sankhya, container, false);
        btnReport = (Button) v.findViewById(R.id.btnReport);
        Spinner monthDropdown = (Spinner) v.findViewById(R.id.monthDropdown);
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Month));
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthDropdown.setAdapter(monthAdapter);
        Spinner yearDropdown = (Spinner) v.findViewById(R.id.yearDropdown);
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Year));
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearDropdown.setAdapter(yearAdapter);




        return v;
    }

    }
