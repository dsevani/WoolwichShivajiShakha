package com.example.woolwichshivajishakha;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainScreenActivity extends AppCompatActivity {

    GridLayout grid;
    TextView cardTitleSwayamsevak;
    TextView cardTitleRegister;
    TextView cardTitleSankhya;
    TextView cardTitleCalendar;
    TextView cardTitleEmail;
    TextView cardTitleKhel;
    TextView cardTitleSettings;
    TextView cardTitlePolicies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        grid = (GridLayout) findViewById(R.id.mainGrid);
        cardTitleSwayamsevak = (TextView) findViewById(R.id.swayamsevaksCard);
        cardTitleRegister = (TextView) findViewById(R.id.registerCard);
        cardTitleSankhya = (TextView) findViewById(R.id.sankhyaCard);
        cardTitleCalendar = (TextView) findViewById(R.id.calendarCard);
        cardTitleEmail = (TextView) findViewById(R.id.emailCard);
        cardTitleKhel = (TextView) findViewById(R.id.khelCard);
        cardTitleSettings = (TextView) findViewById(R.id.settingsCard);
        cardTitlePolicies = (TextView) findViewById(R.id.policiesCard);
        clickCard(grid);
    }

    private void clickCard(GridLayout grid) {
        //Loops the child items of the grid
        for (int i = 0; i < grid.getChildCount(); i++) {
            final CardView cardView = (CardView) grid.getChildAt(i);
            final int finalInt = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (finalInt == 0) {
                        //This if statement sets the colour on click, -1 means its not the default colour
                        if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                            cardView.setCardBackgroundColor(Color.parseColor("#ffff8800"));
                            cardTitleSwayamsevak.setTextColor(Color.parseColor("#FFFFFF"));
                        }
                        Intent intent = new Intent(MainScreenActivity.this, SwayamsevaksActivity.class);
                        startActivity(intent);
                    } else if (finalInt == 1) {
                        if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                            cardView.setCardBackgroundColor(Color.parseColor("#ffff8800"));
                            cardTitleRegister.setTextColor(Color.parseColor("#FFFFFF"));
                        }
                        Intent intent = new Intent(MainScreenActivity.this, RegisterActivity.class);
                        startActivity(intent);
                    } else if (finalInt == 2) {
                        if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                            cardView.setCardBackgroundColor(Color.parseColor("#ffff8800"));
                            cardTitleSankhya.setTextColor(Color.parseColor("#FFFFFF"));
                        }
                        Intent intent = new Intent(MainScreenActivity.this, SankhyaActivity.class);
                        startActivity(intent);
                    } else if (finalInt == 3) {
                        if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                            cardView.setCardBackgroundColor(Color.parseColor("#ffff8800"));
                            cardTitleCalendar.setTextColor(Color.parseColor("#FFFFFF"));
                        }
                        Intent intent = new Intent(MainScreenActivity.this, CalendarActivity.class);
                        startActivity(intent);
                    } else if (finalInt == 4) {
                        if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                            cardView.setCardBackgroundColor(Color.parseColor("#ffff8800"));
                            cardTitleEmail.setTextColor(Color.parseColor("#FFFFFF"));
                        }
                        Intent intent = new Intent(MainScreenActivity.this, EmailActivity.class);
                        startActivity(intent);
                    } else if (finalInt == 5) {
                        if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                            cardView.setCardBackgroundColor(Color.parseColor("#ffff8800"));
                            cardTitleKhel.setTextColor(Color.parseColor("#FFFFFF"));
                        }
                        Intent intent = new Intent(MainScreenActivity.this, KhelActivity.class);
                        startActivity(intent);
                    } else if (finalInt == 6) {
                        if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                            cardView.setCardBackgroundColor(Color.parseColor("#ffff8800"));
                            cardTitleSettings.setTextColor(Color.parseColor("#FFFFFF"));
                        }
                        Intent intent = new Intent(MainScreenActivity.this, SettingsActivity.class);
                        startActivity(intent);
                    } else if (finalInt == 7) {
                        if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                            cardView.setCardBackgroundColor(Color.parseColor("#ffff8800"));
                            cardTitlePolicies.setTextColor(Color.parseColor("#FFFFFF"));
                        }
                        Intent intent = new Intent(MainScreenActivity.this, PoliciesActivity.class);
                        startActivity(intent);
                    }

                }
            });


        }
    }
    @Override
    public void onResume(){
        super.onResume();
        //Loops the child items of the grid
        for (int i = 0; i < grid.getChildCount(); i++) {
            final CardView cardView = (CardView) grid.getChildAt(i);
            final int finalInt = i;

                //This if statement sets the colour on click, -1 means its not the default colour
                if (cardView.getCardBackgroundColor().getDefaultColor() != -1) {
                    cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                }
        }
        cardTitleSwayamsevak.setTextColor(Color.parseColor("#ffff8800"));
        cardTitleRegister.setTextColor(Color.parseColor("#ffff8800"));
        cardTitleSankhya.setTextColor(Color.parseColor("#ffff8800"));
        cardTitleCalendar.setTextColor(Color.parseColor("#ffff8800"));
        cardTitleEmail.setTextColor(Color.parseColor("#ffff8800"));
        cardTitleKhel.setTextColor(Color.parseColor("#ffff8800"));
        cardTitleSettings.setTextColor(Color.parseColor("#ffff8800"));
        cardTitlePolicies.setTextColor(Color.parseColor("#ffff8800"));
    }

}
