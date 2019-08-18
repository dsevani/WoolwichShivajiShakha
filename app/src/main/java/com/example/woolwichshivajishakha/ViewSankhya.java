package com.example.woolwichshivajishakha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;


public class ViewSankhya extends Fragment {
    EditText anyaStart, anyaFinish, proudhStart, proudhFinish, yuvaStart, yuvaFinish, tarunStart, tarunFinish,
            kishoreStart, kishoreFinish, balStart, balFinish, subStart, subFinish, balShikshaks, ktyShikshaks,
            balShareerik, ktyShareerik, comments, subashita, riskassessment,shakhaDate;
    TextView totalStart, totalFinish;
    Button btnSearchSankhya, btnApplyChanges;
    Boolean boolFirstAid;
    Integer anyaStartValue, anyaFinishValue, proudhStartValue, proudhFinishValue, yuvaStartValue,
            yuvaFinishValue, tarunStartValue, tarunFinishValue,
            kishoreStartValue, kishoreFinishValue, balStartValue, balFinishValue, subStartValue, subFinishValue, totalStartValue, totalFinishValue;
    String  balShikshaksValue, ktyShikshaksValue,
            balShareerikValue, ktyShareerikValue, commentsValue, subashitaValue, riskassessmentValue, validations;
    Date shakhaDateValue;
    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseReference = mDatabase.getReference();
    SwitchCompat firstaid;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_view_sankhya, container, false);
        btnSearchSankhya = (Button) v.findViewById(R.id.btnSearchSankhya);
        anyaStart = (EditText) v.findViewById(R.id.vwAnyaStart);
        anyaFinish = (EditText) v.findViewById(R.id.vwAnyaFinish);
        proudhStart = (EditText) v.findViewById(R.id.vwProudhStart);
        proudhFinish = (EditText) v.findViewById(R.id.vwProudhFinish);
        yuvaStart = (EditText) v.findViewById(R.id.vwYuvaStart);
        yuvaFinish = (EditText) v.findViewById(R.id.vwYuvaFinish);
        tarunStart = (EditText) v.findViewById(R.id.vwTarunStart);
        tarunFinish = (EditText) v.findViewById(R.id.vwTarunFinish);
        kishoreStart = (EditText) v.findViewById(R.id.vwKishoreStart);
        kishoreFinish = (EditText) v.findViewById(R.id.vwKishoreFinish);
        balStart = (EditText) v.findViewById(R.id.vwBalStart);
        balFinish = (EditText) v.findViewById(R.id.vwBalFinish);
        subStart = (EditText) v.findViewById(R.id.vwSubtotalStart);
        subFinish = (EditText) v.findViewById(R.id.vwSubtotalFinish);
        totalStart = (TextView) v.findViewById(R.id.vwTotalStart);
        totalFinish = (TextView) v.findViewById(R.id.vwTotalFinish);
        shakhaDate = (EditText) v.findViewById(R.id.vwDateField);
        balShikshaks = (EditText) v.findViewById(R.id.vwBalShikshaks);
        ktyShikshaks = (EditText) v.findViewById(R.id.vwKTYShikshaks);
        balShareerik = (EditText) v.findViewById(R.id.vwBSShareerik);
        ktyShareerik = (EditText) v.findViewById(R.id.vwKTYShareerik);
        comments = (EditText) v.findViewById(R.id.vwComments);
        riskassessment = (EditText) v.findViewById(R.id.vwRiskAssessment);
        subashita = (EditText) v.findViewById(R.id.vwSubashita);
        btnApplyChanges = (Button) v.findViewById(R.id.btnApplyChanges);
        firstaid = (SwitchCompat) v.findViewById(R.id.vwFirstAid);

        btnSearchSankhya.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view1) {
                DialogFragment newFragment = new SearchSankhyaFragment();
                newFragment.show(getFragmentManager(), "DatePicker");
            }
        });


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_sankhya, container, false);
    }


}
