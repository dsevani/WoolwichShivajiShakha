package com.example.woolwichshivajishakha;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class SearchSankhya extends Fragment {
    Button btnEditSankhya;
    ListView sankhyaList;
    EditText dateFilter, shakhaDate;
    FirebaseDatabase database;
    DatabaseReference dbRef;
    private ArrayList<String> sankhyaDateArray = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    public static String dateClicked;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_view_sankhya, container, false);
        database = FirebaseDatabase.getInstance();
        dbRef = database.getReference();
        btnEditSankhya = (Button) v.findViewById(R.id.btnEditSankhya);
        sankhyaList = (ListView) v.findViewById(R.id.sankhyaListView);
        dateFilter = (EditText) v.findViewById(R.id.searchSankhyaFilter);
        shakhaDate = (EditText) v.findViewById(R.id.DateField);
        dateClicked = null;



        arrayAdapter = new ArrayAdapter<String>(getContext(),R.layout.row_layout_delete,sankhyaDateArray);
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
                (SearchSankhya.this).arrayAdapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //On click of the list, it will open popup whether user wants to view, and will take the date and display the data on the view fragment

        sankhyaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                 dateClicked = sankhyaDateArray.get(i);
                 builder.setMessage("Are you sure you want to view sankhya for date " + dateClicked + "?");
                 builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int id) {
                         //
                         Toast.makeText(getActivity(), "View" + dateClicked, Toast.LENGTH_SHORT).show();
                         populateSankhyaDetails(dateClicked);
                     }
                 });
                 builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int id) {
                         Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();
                     }
                 });
                 AlertDialog dialog = builder.create();
                 dialog.show();
             }

         });

        // Inflate the layout for this fragment
        return v;
    }

    public void populateSankhyaDetails(final String dateToPopulate){
        // Create new fragment and transaction
        Fragment newFragment = new AddEditSankhya();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(((ViewGroup)getView().getParent()).getId(),newFragment);
        transaction.commit();
        SankhyaActivity.nav_bar.setSelectedItemId(R.id.navigation_addSankhya);

        //This code below gets the values of the database where the date is the same as selected, and populates all the fields with that data

        dbRef.child("Sankhya").child(dateToPopulate).child("anyaStart").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.anyaStart.setText(dataSnapshot.getValue().toString());
                    } else {
                        AddEditSankhya.anyaStart.setText("0");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        dbRef.child("Sankhya").child(dateToPopulate).child("anyaFinish").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.anyaFinish.setText(dataSnapshot.getValue().toString());
                    } else {
                        AddEditSankhya.anyaFinish.setText("0");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        dbRef.child("Sankhya").child(dateToPopulate).child("proudhStart").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.proudhStart.setText(dataSnapshot.getValue().toString());
                    } else {
                        AddEditSankhya.proudhStart.setText("0");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        dbRef.child("Sankhya").child(dateToPopulate).child("proudhFinish").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.proudhFinish.setText(dataSnapshot.getValue().toString());
                    } else {
                        AddEditSankhya.proudhFinish.setText("0");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        dbRef.child("Sankhya").child(dateToPopulate).child("yuvaStart").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.yuvaStart.setText(dataSnapshot.getValue().toString());
                    } else {
                        AddEditSankhya.yuvaStart.setText("0");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        dbRef.child("Sankhya").child(dateToPopulate).child("yuvaFinish").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.yuvaFinish.setText(dataSnapshot.getValue().toString());
                    } else {
                        AddEditSankhya.yuvaFinish.setText("0");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        dbRef.child("Sankhya").child(dateToPopulate).child("tarunStart").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.tarunStart.setText(dataSnapshot.getValue().toString());
                    } else {
                        AddEditSankhya.tarunStart.setText("0");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        dbRef.child("Sankhya").child(dateToPopulate).child("tarunFinish").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.tarunFinish.setText(dataSnapshot.getValue().toString());
                    } else {
                        AddEditSankhya.tarunFinish.setText("0");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        dbRef.child("Sankhya").child(dateToPopulate).child("kishoreStart").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.kishoreStart.setText(dataSnapshot.getValue().toString());
                    } else {
                        AddEditSankhya.kishoreStart.setText("0");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        dbRef.child("Sankhya").child(dateToPopulate).child("kishoreFinish").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.kishoreFinish.setText(dataSnapshot.getValue().toString());
                    } else {
                        AddEditSankhya.kishoreFinish.setText("0");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        dbRef.child("Sankhya").child(dateToPopulate).child("balStart").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.balStart.setText(dataSnapshot.getValue().toString());
                    } else {
                        AddEditSankhya.balStart.setText("0");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        dbRef.child("Sankhya").child(dateToPopulate).child("balFinish").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.balFinish.setText(dataSnapshot.getValue().toString());
                    } else {
                        AddEditSankhya.balFinish.setText("0");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        dbRef.child("Sankhya").child(dateToPopulate).child("subtotalStart").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.subStart.setText(dataSnapshot.getValue().toString());
                    } else {
                        AddEditSankhya.subStart.setText("0");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        dbRef.child("Sankhya").child(dateToPopulate).child("subtotalFinish").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.subFinish.setText(dataSnapshot.getValue().toString());
                    } else {
                        AddEditSankhya.subFinish.setText("0");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        dbRef.child("Sankhya").child(dateToPopulate).child("riskassessment").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.riskassessment.setText(dataSnapshot.getValue().toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        dbRef.child("Sankhya").child(dateToPopulate).child("subashita").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.subashita.setText(dataSnapshot.getValue().toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        dbRef.child("Sankhya").child(dateToPopulate).child("firstAid").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        if (dataSnapshot.getValue().equals(true)){
                            AddEditSankhya.firstaid.setChecked(true);
                        }
                    } else {
                        AddEditSankhya.firstaid.setChecked(false);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        dbRef.child("Sankhya").child(dateToPopulate).child("balShikshaks").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.balShikshaks.setText(dataSnapshot.getValue().toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        dbRef.child("Sankhya").child(dateToPopulate).child("ktyShikshaks").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.ktyShikshaks.setText(dataSnapshot.getValue().toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        dbRef.child("Sankhya").child(dateToPopulate).child("balShareerik").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.balShareerik.setText(dataSnapshot.getValue().toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        dbRef.child("Sankhya").child(dateToPopulate).child("ktyShareerik").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.ktyShareerik.setText(dataSnapshot.getValue().toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        dbRef.child("Sankhya").child(dateToPopulate).child("comments").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        AddEditSankhya.comments.setText(dataSnapshot.getValue().toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        dbRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                try {
                    for(DataSnapshot data: dataSnapshot.getChildren()){
                        if (data.getKey() == dateToPopulate) {
                            AddEditSankhya.shakhaDate.setText(data.getKey());
                            AddEditSankhya.selectDate.setVisibility(View.GONE);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

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
    }


}
