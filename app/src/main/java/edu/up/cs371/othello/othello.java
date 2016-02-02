package edu.up.cs371.othello;

import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 *@author Kieran Losh
 *@author Austin Moehnke
 *@author Aaron Leung
 *@author Ryan Kane
 *
 * Functionality 1: When the user taps a spot on the game board, a piece is placed (color change) [10 points]
 * Functionality 2: Functionality 1 can be applied to any spot on the game board [5 points]
 * Functionality 3: When a placed piece is tapped again, it takes the piece away (reverts being drawn in original way) [5 points]
 * Functionality 4: Whenever a spot on the board is tapped, its coordinate is displayed in a TextView in the bottom circle; applicable to every spot on board [15 points]
 * Functionality 5: Whenever the bottom confirm button is clicked, the next piece placed switches from black to white and saves the black piece [10 points]
 * Functionality 6: Whenever the top bottom is clicked, the next piece placed switches from white to black and saves the white piece [5 points]
 */

public class othello extends AppCompatActivity implements View.OnClickListener{

    protected TextView counter = null;
    protected BoardView board = null;
    protected Button confirm1 = null;
    protected Button confirm2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_othello);
        counter = (TextView)findViewById(R.id.playerCount1);
        board = (BoardView)findViewById(R.id.boardView);
        board.setTextView(counter);
        confirm1 = (Button)findViewById(R.id.confirmButton);
        confirm2 = (Button)findViewById(R.id.confirmTopButton);
        board.setConfirmButtons(confirm1, confirm2);
        confirm1.setOnClickListener(board);
        confirm2.setOnClickListener(board);
    }

    @Override
    public void onClick(View v) {

    }
}
