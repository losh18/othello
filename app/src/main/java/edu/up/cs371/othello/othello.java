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
        Log.i("main", "button clicked");
    }
}
