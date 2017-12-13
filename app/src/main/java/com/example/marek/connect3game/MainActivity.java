package com.example.marek.connect3game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 0 - yellow player, 1 - red player  2 - empty state
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int activePlayer = 0;
    boolean activeGame = true;

    public void dropIn (View view) {
        ImageView counter = (ImageView) view;
        //counter.getTag(0);
        Log.i("Our tag test", counter.getTag().toString());



        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter]==2 && activeGame) {
        gameState[tappedCounter] = activePlayer;
        counter.setTranslationY(-1500);

        if (activePlayer == 0) {
            counter.setImageResource(R.drawable.yellowbutton);
            activePlayer = 1;
        } else {
            counter.setImageResource(R.drawable.redbutton);
            activePlayer = 0;
        }
        counter.animate().translationYBy(1500).setDuration(300);

        for (int[]winningPosition : winningPositions) {
            if(gameState[winningPosition[0]]==gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] !=2) {

                String winner = "";
                if (activePlayer==1) {
                    winner = "Yellow"; //other way round
                } else {
                    winner = "Red";
                }
                activeGame = false;
//                Toast.makeText(this, winner + " has won", Toast.LENGTH_SHORT).show();
                Button playAgainButton = findViewById(R.id.playAgainButton);
                TextView winnerTextView = findViewById(R.id.winnerTextView);
                winnerTextView.setText(winner + " has won");
                playAgainButton.setVisibility(View.VISIBLE);
                winnerTextView.setVisibility(View.VISIBLE);

            }
        }
        }
    }

    public void playAgain(View view) {
        Button playAgainButton = findViewById(R.id.playAgainButton);
        TextView winnerTextView = findViewById(R.id.winnerTextView);

        playAgainButton.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);

        GridLayout gridLayout = findViewById(R.id.gridLayoutId);

        for(int i=0; i<gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }

        for (int i = 0; i <gameState.length; i++) {
            gameState[i]=2;
        }

        activePlayer = 0;
        activeGame = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
