package com.example.woolwichshivajishakha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class ViewSankhya extends Fragment {
    Button btnSearchSankhya, btnEditSankhya, btnDeleteSankhya;
    ListView sankhyaList;
    FirebaseDatabase database;
    DatabaseReference dbRef;
    private ArrayList<String> sankhyaDateArray = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_view_sankhya, container, false);
        database = FirebaseDatabase.getInstance();
        dbRef = database.getReference();
        btnSearchSankhya = (Button) v.findViewById(R.id.btnSearchSankhya);
        btnEditSankhya = (Button) v.findViewById(R.id.btnEditSankhya);
        btnDeleteSankhya = (Button) v.findViewById(R.id.btnDeleteSankhya);
        sankhyaList = (ListView) v.findViewById(R.id.sankhyaListView);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,sankhyaDateArray);
        sankhyaList.setAdapter(arrayAdapter);

        btnSearchSankhya.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view1) {
                DialogFragment newFragment = new SearchSankhyaFragment();
                newFragment.show(getFragmentManager(), "DatePicker");
            }
        });

        dbRef.addChildEventListener(new ChildEventListener() {
            String tempName = "";
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    tempName = data.getKey();
                    sankhyaDateArray.add(tempName);
                }
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Inflate the layout for this fragment
        return v;
    }


}
