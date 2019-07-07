package com.example.woolwichshivajishakha;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddSankhya extends Fragment {
    private FrameLayout fragment;
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
        View v = inflater.inflate(R.layout.fragment_add_sankhya, container, false);

        anyaStart = (EditText) v.findViewById(R.id.edtAnyaStart);
        anyaFinish = (EditText) v.findViewById(R.id.edtAnyaFinish);
        proudhStart = (EditText) v.findViewById(R.id.edtProudhStart);
        proudhFinish = (EditText) v.findViewById(R.id.edtProudhFinish);
        yuvaStart = (EditText) v.findViewById(R.id.edtYuvaStart);
        yuvaFinish = (EditText) v.findViewById(R.id.edtYuvaFinish);
        tarunStart = (EditText) v.findViewById(R.id.edtTarunStart);
        tarunFinish = (EditText) v.findViewById(R.id.edtTarunFinish);
        kishoreStart = (EditText) v.findViewById(R.id.edtKishoreStart);
        kishoreFinish = (EditText) v.findViewById(R.id.edtKishoreFinish);
        balStart = (EditText) v.findViewById(R.id.edtBalStart);
        balFinish = (EditText) v.findViewById(R.id.edtBalFinish);
        subStart = (EditText) v.findViewById(R.id.edtSubtotalStart);
        subFinish = (EditText) v.findViewById(R.id.edtSubtotalFinish);
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
                totalStartValue = addStartNumbers();
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
                totalStartValue = addStartNumbers();
                totalStart.setText(totalStartValue.toString());
            }

        });
        yuvaStart.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                totalStartValue = addStartNumbers();
                totalStart.setText(totalStartValue.toString());
            }

        });

        tarunStart.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                totalStartValue = addStartNumbers();
                totalStart.setText(totalStartValue.toString());
            }

        });
        kishoreStart.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                totalStartValue = addStartNumbers();
                totalStart.setText(totalStartValue.toString());
            }

        });
        balStart.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                totalStartValue = addStartNumbers();
                totalStart.setText(totalStartValue.toString());
            }

        });
        subStart.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                totalStartValue = addStartNumbers();
                totalStart.setText(totalStartValue.toString());
            }

        });
        return v;

}

    private int addStartNumbers() {
        int number1;
        int number2;
        int number3;
        int number4;
        int number5;
        int number6;
        int number7;

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
        if(anyaStart.getText().toString() != "" && anyaStart.getText().length() > 0) {
            number1 = Integer.parseInt(anyaStart.getText().toString());
        } else {
            number1 = 0;
        }
        if(yuvaStart.getText().toString() != "" && yuvaStart.getText().length() > 0) {
            number3 = Integer.parseInt(yuvaStart.getText().toString());
        } else {
            number3 = 0;
        }
        if(tarunStart.getText().toString() != "" && tarunStart.getText().length() > 0) {
            number4 = Integer.parseInt(tarunStart.getText().toString());
        } else {
            number4 = 0;
        }
        if(kishoreStart.getText().toString() != "" && kishoreStart.getText().length() > 0) {
            number5 = Integer.parseInt(kishoreStart.getText().toString());
        } else {
            number5 = 0;
        }
        if(balStart.getText().toString() != "" && balStart.getText().length() > 0) {
            number6 = Integer.parseInt(balStart.getText().toString());
        } else {
            number6 = 0;
        }
        if(subStart.getText().toString() != "" && subStart.getText().length() > 0) {
            number7 = Integer.parseInt(subStart.getText().toString());
        } else {
            number7 = 0;
        }

        return number1 + number2 + number3 + number4 + number5 + number6;
    }
}
