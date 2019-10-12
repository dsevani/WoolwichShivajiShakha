package com.example.woolwichshivajishakha;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class DeleteSankhya extends Fragment {
    Button btnDeleteSankhya;
    ListView sankhyaList;
    EditText dateFilter;
    FirebaseDatabase database;
    DatabaseReference dbRef;
    private ArrayList<String> sankhyaDateArray = new ArrayList<>();
    private ArrayList<String> selectedItems = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_delete_sankhya, container, false);
        database = FirebaseDatabase.getInstance();
        dbRef = database.getReference();
        btnDeleteSankhya = (Button) v.findViewById(R.id.btnDeleteSankhya);
        sankhyaList = (ListView) v.findViewById(R.id.deleteSankhyaListView);
        dateFilter = (EditText) v.findViewById(R.id.deleteSankhyaFilter);

        sankhyaList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        arrayAdapter = new ArrayAdapter<String>(getContext(),R.layout.row_layout_delete,R.id.rowLayout, sankhyaDateArray);
        sankhyaList.setAdapter(arrayAdapter);

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

        //Filter for searched sankhya
        dateFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (DeleteSankhya.this).arrayAdapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        sankhyaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = ((TextView)view).getText().toString();
                if (selectedItems.contains(selectedItem)){
                    selectedItems.remove(selectedItem);
                }
                else{
                    selectedItems.add(selectedItem);
                }
            }
        });

        // Inflate the layout for this fragment
        return v;
    }
}
