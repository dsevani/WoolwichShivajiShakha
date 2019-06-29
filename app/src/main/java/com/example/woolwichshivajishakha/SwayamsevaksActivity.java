package com.example.woolwichshivajishakha;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SwayamsevaksActivity extends AppCompatActivity {

    GridLayout grid;
    TextView cardTitleSwayamsevaks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swayamsevaks);

        //Resets tile to default style
        //cardTitleSwayamsevaks = (TextView)findViewById(R.id.swayamsevaksCard);
        //grid = (GridLayout)findViewById(R.id.mainGrid);
        //final CardView cardView = (CardView)grid.getChildAt(0);
        //cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));


    }
}
