package com.example.woolwichshivajishakha;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.woolwichshivajishakha.Model.Login;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class activity_login extends AppCompatActivity {
    EditText edtEmail, edtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtPassword = (MaterialEditText)findViewById(R.id.edtPassword);
        edtEmail = (MaterialEditText)findViewById(R.id.edtEmail);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        //Initialise firebase database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_login = database.getReference("Login");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog(activity_login.this);
                mDialog.setMessage("Logging in..");
                mDialog.show();

                table_login.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        mDialog.dismiss();
                        //Check if user does not exist in database
                        if(dataSnapshot.child(edtEmail.getText().toString()).exists()) {
                            //Gets user information
                            Login login = dataSnapshot.child(edtEmail.getText().toString()).getValue(Login.class);
                            if (login.getPassword().equals(edtPassword.getText().toString())) {
                                Toast.makeText(activity_login.this, "Namaste!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(activity_login.this, "Incorrect password. Please check you have entered the correct credentials.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(activity_login.this, "Login Failed. Please check you have entered the correct details", Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
