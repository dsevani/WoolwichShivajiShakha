package com.example.woolwichshivajishakha;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtEmail, edtPassword;
    Button buttonLogin;
    TextView txtSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        buttonLogin = (Button)findViewById(R.id.Login);
        txtSlogan = (TextView)findViewById(R.id.txtSlogan);

        //Initialise firebase database
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //final DatabaseReference table_login = database.getReference("Login");

        buttonLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                final ProgressDialog mDialog = new ProgressDialog(MainActivity.this);
                mDialog.setMessage("Logging in..");
                mDialog.show();

                //table_login.addValueEventListener(new ValueEventListener() {
                    //@Override
                    //public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //mDialog.dismiss();
                        //Check if user does not exist in database
                        //if(dataSnapshot.child(edtEmail.getText().toString()).exists()) {
                            //Gets user information
                            //Login login = dataSnapshot.child(edtEmail.getText().toString()).getValue(Login.class);
                            //if (login.getPassword().equals(edtPassword.getText().toString())) {
                                //Toast.makeText(MainActivity.this, "Namaste!", Toast.LENGTH_SHORT).show();
                            //} else {
                                //Toast.makeText(MainActivity.this, "Incorrect password. Please check you have entered the correct credentials.", Toast.LENGTH_SHORT).show();
                            //}
                        //}
                        //else{
                            //Toast.makeText(MainActivity.this, "Login Failed. Please check you have entered the correct details", Toast.LENGTH_SHORT).show();
                        //}


                    //}

                    //@Override
                    //public void onCancelled(@NonNull DatabaseError databaseError) {

                    //}
                //});
            }

        });

    }
}
