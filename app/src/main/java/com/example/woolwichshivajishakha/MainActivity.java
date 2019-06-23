package com.example.woolwichshivajishakha;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText edtEmail, edtPassword;
    Button buttonLogin;
    TextView txtSlogan;
    private FirebaseAuth database;
    ProgressDialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        buttonLogin = (Button)findViewById(R.id.Login);
        txtSlogan = (TextView)findViewById(R.id.txtSlogan);
        mDialog = new ProgressDialog(MainActivity.this);

        //Initialise firebase database
        database = FirebaseAuth.getInstance();
        //DatabaseReference table_login = database.getReference("Login");

        buttonLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                mDialog.setMessage("Logging in..");
                mDialog.show();
        logIn();
            }
        });

    }
    //Method to check credentials
    private void logIn(){
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            mDialog.dismiss();
            Toast.makeText(MainActivity.this, "Email or Password field cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else{
            database.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        mDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Namaste!", Toast.LENGTH_SHORT).show();
                    } else {
                        mDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Login Failed. Please check you have entered the correct details", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}
