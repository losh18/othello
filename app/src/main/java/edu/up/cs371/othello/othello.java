package edu.up.cs371.othello;

import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class othello extends AppCompatActivity implements View.OnClickListener {

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
        board.setConfirmButtons((Button)findViewById(R.id.confirmButton), (Button)findViewById(R.id.confirmTopButton));


    }

    @Override
    public void onClick(View v) {

    }
}
