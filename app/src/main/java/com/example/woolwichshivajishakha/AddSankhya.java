package com.example.woolwichshivajishakha;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.woolwichshivajishakha.Model.Sankhya;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddSankhya extends Fragment {
    EditText anyaStart, anyaFinish, proudhStart, proudhFinish, yuvaStart, yuvaFinish, tarunStart, tarunFinish,
            kishoreStart, kishoreFinish, balStart, balFinish, subStart, subFinish, balShikshaks, ktyShikshaks,
            balShareerik, ktyShareerik, comments, subashita, riskassessment,shakhaDate;
    TextView totalStart, totalFinish;
    Button selectDate, btnSubmitSankhya;
    View firstaid;
    Integer anyaStartValue, anyaFinishValue, proudhStartValue, proudhFinishValue, yuvaStartValue,
            yuvaFinishValue, tarunStartValue, tarunFinishValue,
            kishoreStartValue, kishoreFinishValue, balStartValue, balFinishValue, subStartValue, subFinishValue, totalStartValue, totalFinishValue;
    String  balShikshaksValue, ktyShikshaksValue,
            balShareerikValue, ktyShareerikValue, commentsValue, subashitaValue, riskassessmentValue;
    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseReference = mDatabase.getReference();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_add_sankhya, container, false);

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
        shakhaDate = (EditText) v.findViewById(R.id.edtDateField);
        selectDate = (Button) v.findViewById(R.id.btnDate);
        balShikshaks = (EditText) v.findViewById(R.id.edtBalShikshaks);
        ktyShikshaks = (EditText) v.findViewById(R.id.edtKTYShikshaks);
        balShareerik = (EditText) v.findViewById(R.id.edtBSShareerik);
        ktyShareerik = (EditText) v.findViewById(R.id.edtKTYShareerik);
        comments = (EditText) v.findViewById(R.id.edtComments);
        riskassessment = (EditText) v.findViewById(R.id.edtRiskAssessment);
        subashita = (EditText) v.findViewById(R.id.edtSubashita);
        //firstaid = (Switch) v.findViewById(R.id.switchFirstAid);
        btnSubmitSankhya = (Button) v.findViewById(R.id.btnSubmitSankhya);

        //------------------------------------------------------------------------
        //Code below is for selecting the sankhya date
        //------------------------------------------------------------------------

        selectDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view1) {
                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getFragmentManager(), "DatePicker");
            }
        });


        //------------------------------------------------------------------------
        //Code below is for updating the total field when the numbers are changed after adding numbers in previous fields under the start column
        //------------------------------------------------------------------------

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
                totalStartValue = addStartNumbers();
                totalStart.setText(totalStartValue.toString());
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stu

                if(subStart.length()>1)
                {
                    anyaFinish.requestFocus();
                }

            }

        });

        //------------------------------------------------------------------------
        //Code below is for updating the total field when the numbers are changed after adding numbers in previous fields under the "Finish" column
        //------------------------------------------------------------------------

        anyaFinish.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                totalFinishValue = addFinishNumbers();
                totalFinish.setText(totalFinishValue.toString());
            }

        });
        proudhFinish.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                totalFinishValue = addFinishNumbers();
                totalFinish.setText(totalFinishValue.toString());
            }

        });
        yuvaFinish.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                totalFinishValue = addFinishNumbers();
                totalFinish.setText(totalFinishValue.toString());
            }

        });

        tarunFinish.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                totalFinishValue = addFinishNumbers();
                totalFinish.setText(totalFinishValue.toString());
            }

        });
        kishoreFinish.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                totalFinishValue = addFinishNumbers();
                totalFinish.setText(totalFinishValue.toString());
            }

        });
        balFinish.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                totalFinishValue = addFinishNumbers();
                totalFinish.setText(totalFinishValue.toString());
            }

        });
        subFinish.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                totalFinishValue = addFinishNumbers();
                totalFinish.setText(totalFinishValue.toString());
            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });

        btnSubmitSankhya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitSankhya();

            }
        });

        return v;

    }
    //------------------------------------------------------------------------
    //Code below is for adding the numbers for the start column and updating the total number field
    //------------------------------------------------------------------------

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

        return number1 + number2 + number3 + number4 + number5 + number6 + number7;
    }
    private int addFinishNumbers() {
        int number1;
        int number2;
        int number3;
        int number4;
        int number5;
        int number6;
        int number7;

        if(anyaFinish.getText().toString() != "" && anyaFinish.getText().length() > 0) {
            number1 = Integer.parseInt(anyaFinish.getText().toString());
        } else {
            number1 = 0;
        }
        if(proudhFinish.getText().toString() != "" && proudhFinish.getText().length() > 0) {
            number2 = Integer.parseInt(proudhFinish.getText().toString());
        } else {
            number2 = 0;
        }
        if(yuvaFinish.getText().toString() != "" && yuvaFinish.getText().length() > 0) {
            number3 = Integer.parseInt(yuvaFinish.getText().toString());
        } else {
            number3 = 0;
        }
        if(tarunFinish.getText().toString() != "" && tarunFinish.getText().length() > 0) {
            number4 = Integer.parseInt(tarunFinish.getText().toString());
        } else {
            number4 = 0;
        }
        if(kishoreFinish.getText().toString() != "" && kishoreFinish.getText().length() > 0) {
            number5 = Integer.parseInt(kishoreFinish.getText().toString());
        } else {
            number5 = 0;
        }
        if(balFinish.getText().toString() != "" && balFinish.getText().length() > 0) {
            number6 = Integer.parseInt(balFinish.getText().toString());
        } else {
            number6 = 0;
        }
        if(subFinish.getText().toString() != "" && subFinish.getText().length() > 0) {
            number7 = Integer.parseInt(subFinish.getText().toString());
        } else {
            number7 = 0;
        }

        return number1 + number2 + number3 + number4 + number5 + number6 + number7;
    }

    public void submitSankhya(){
        //Puts all values from the fields into an value type

        if (anyaStart.getText().toString().equals("")){
            anyaStartValue = 0;
        }
        else{
            anyaStartValue = Integer.parseInt(anyaStart.getText().toString());
        }

        if (anyaFinish.getText().toString().equals("")){
            anyaFinishValue = 0;
        }
        else {
            anyaFinishValue = Integer.parseInt(anyaFinish.getText().toString());
        }
        if (proudhStart.getText().toString().equals("")){
            proudhStartValue = 0;
        }
        else {
            proudhStartValue = Integer.parseInt(proudhStart.getText().toString());
        }

        if (proudhFinish.getText().toString().equals("")){
            proudhFinishValue = 0;
        }
        else {
            proudhFinishValue = Integer.parseInt(proudhFinish.getText().toString());
        }

        if (yuvaStart.getText().toString().equals("")){
            yuvaStartValue = 0;
        }
        else {
            yuvaStartValue = Integer.parseInt(yuvaStart.getText().toString());
        }

        if (yuvaFinish.getText().toString().equals("")){
            yuvaFinishValue = 0;
        }
        else {
            yuvaFinishValue = Integer.parseInt(yuvaFinish.getText().toString());
        }

        if (tarunStart.getText().toString().equals("")){
            tarunStartValue = 0;
        }
        else {
            tarunStartValue = Integer.parseInt(tarunStart.getText().toString());
        }
        if (tarunFinish.getText().toString().equals("")){
            tarunFinishValue = 0;
        }
        else {
            tarunFinishValue = Integer.parseInt(tarunFinish.getText().toString());
        }
        if(kishoreStart.getText().toString().equals("")){
            kishoreStartValue = 0;
        }
        else {
            kishoreStartValue = Integer.parseInt(kishoreStart.getText().toString());
        }
        if(kishoreFinish.getText().toString().equals("")){
            kishoreFinishValue = 0;
        }
        else {
            kishoreFinishValue = Integer.parseInt(kishoreFinish.getText().toString());
        }
        if(balStart.getText().toString().equals("")){
            balStartValue = 0;
        }
        else {
            balStartValue = Integer.parseInt(balStart.getText().toString());
        }
        if(balFinish.getText().toString().equals("")){
            balFinishValue = 0;
        }
        else {
            balFinishValue = Integer.parseInt(balFinish.getText().toString());
        }
        if (subStart.getText().toString().equals("")){
            subStartValue = 0;
        }
        else {
            subStartValue = Integer.parseInt(subStart.getText().toString());
        }
        if(subFinish.getText().toString().equals("")){
            subFinishValue = 0;
        }
        else {
            subFinishValue = Integer.parseInt(subFinish.getText().toString());
        }
        if (totalStart.getText().toString().equals("")){
            totalStartValue = 0;
        }
        else {
            totalStartValue = Integer.parseInt(totalStart.getText().toString());
        }
        if(totalFinish.getText().toString().equals("")){
            totalFinishValue = 0;
        }
        else {
            totalFinishValue = Integer.parseInt(totalFinish.getText().toString());
        }

        riskassessmentValue = riskassessment.getText().toString();
        balShikshaksValue = balShikshaks.getText().toString();
        ktyShikshaksValue = ktyShikshaks.getText().toString();
        balShareerikValue = balShareerik.getText().toString();
        ktyShareerikValue = ktyShareerik.getText().toString();
        commentsValue = comments.getText().toString();
        subashitaValue = subashita.getText().toString();
        // = shakhaDate.getText().toString();

        //Creates object
        Sankhya sankhya = new Sankhya(balStartValue, balFinishValue, kishoreStartValue, kishoreFinishValue,
                tarunStartValue, tarunFinishValue, yuvaStartValue, yuvaFinishValue, proudhStartValue, proudhFinishValue,
                anyaStartValue, anyaFinishValue, subStartValue, subFinishValue, totalStartValue, totalFinishValue,
                riskassessmentValue, subashitaValue, balShikshaksValue, ktyShikshaksValue, balShareerikValue,
                ktyShareerikValue, commentsValue);

        mDatabaseReference = mDatabase.getReference().child("Sankhya").child(sankhya.getComments());
        mDatabaseReference.setValue(sankhya);

    }


}

