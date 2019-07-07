package com.example.woolwichshivajishakha;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddSankhya extends Fragment {
    EditText anyaStart;
    EditText anyaFinish;
    EditText proudhStart;
    EditText proudhFinish;
    EditText yuvaStart;
    EditText yuvaFinish;
    EditText tarunStart;
    EditText tarunFinish;
    EditText kishoreStart;
    EditText kishoreFinish;
    EditText balStart;
    EditText balFinish;
    EditText subStart;
    EditText subFinish;
    TextView totalStart;
    TextView totalFinish;
    String anyaStartValue;
    String proudhStartValue;
    Integer totalStartValue;
    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_add_sankhya, container, false);
        anyaStart = (EditText) v.findViewById(R.id.edtAnyaStart);
        anyaStartValue = anyaStart.getText().toString();
        anyaFinish = (EditText) v.findViewById(R.id.edtAnyaFinish);
        String anyaFinishValue = anyaFinish.getText().toString();
        proudhStart = (EditText) v.findViewById(R.id.edtProudhStart);
        proudhStartValue = proudhStart.getText().toString();
        proudhFinish = (EditText) v.findViewById(R.id.edtProudhFinish);
        String proudhFinishValue = proudhFinish.getText().toString();
        yuvaStart = (EditText) v.findViewById(R.id.edtYuvaStart);
        final String yuvaStartValue = yuvaStart.getText().toString();
        yuvaFinish = (EditText) v.findViewById(R.id.edtYuvaFinish);
        String yuvaFinishValue = yuvaFinish.getText().toString();
        tarunStart = (EditText) v.findViewById(R.id.edtTarunStart);
        final String tarunStartValue = tarunStart.getText().toString();
        tarunFinish = (EditText) v.findViewById(R.id.edtTarunFinish);
        String tarunFinishValue = tarunFinish.getText().toString();
        kishoreStart = (EditText) v.findViewById(R.id.edtKishoreStart);
        final String kishoreStartValue = kishoreStart.getText().toString();
        kishoreFinish = (EditText) v.findViewById(R.id.edtKishoreFinish);
        String kishoreFinishValue = kishoreFinish.getText().toString();
        balStart = (EditText) v.findViewById(R.id.edtBalStart);
        final String balStartValue = balStart.getText().toString();
        balFinish = (EditText) v.findViewById(R.id.edtBalFinish);
        String balFinishValue = balFinish.getText().toString();
        subStart = (EditText) v.findViewById(R.id.edtSubtotalStart);
        final String subStartValue = subStart.getText().toString();
        subFinish = (EditText) v.findViewById(R.id.edtSubtotalFinish);
        String subFinishValue = subFinish.getText().toString();
        totalStart = (TextView) v.findViewById(R.id.txtTotalStart);
        totalFinish = (TextView) v.findViewById(R.id.txtTotalFinish);



        anyaStart.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                totalStartValue = addNumbers();
                totalStart.setText(totalStartValue.toString());
            }

        });
        proudhStart.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                totalStartValue = addNumbers();
                totalStart.setText(totalStartValue.toString());
            }
        });


// Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_sankhya, container, false);
}

    private int addNumbers() {
        int number1;
        int number2;
        if(anyaStart.getText().toString() != "" && anyaStart.getText().length() > 0) {
            number1 = Integer.parseInt(anyaStart.getText().toString());
        } else {
            number1 = 0;
        }
        if(proudhStart.getText().toString() != "" && proudhStart.getText().length() > 0) {
            number2 = Integer.parseInt(proudhStart.getText().toString());
        } else {
            number2 = 0;
        }

        return number1 + number2;
    }
}
