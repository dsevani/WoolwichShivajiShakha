package com.example.woolwichshivajishakha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonLogin;
    TextView txtSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin = (Button)findViewById(R.id.Login);
        txtSlogan = (TextView)findViewById(R.id.txtSlogan);

        buttonLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent login = new Intent(MainActivity.this,activity_login.class);
                startActivity(login);
            }

        });

    }
}
