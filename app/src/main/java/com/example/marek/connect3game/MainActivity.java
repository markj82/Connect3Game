package com.example.marek.connect3game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // 0 - yellow player, 1 - red player
    int activePlayer = 0;

    public void dropIn (View view) {
        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1500);

        if (activePlayer == 0) {
            counter.setImageResource(R.drawable.yellowbutton);
            activePlayer = 1;
        } else {
            counter.setImageResource(R.drawable.redbutton);
            activePlayer = 0;
        }
        counter.animate().translationYBy(1500).setDuration(300);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
