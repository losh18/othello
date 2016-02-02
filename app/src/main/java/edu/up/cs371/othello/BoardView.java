package edu.up.cs371.othello;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by AaronLeung on 1/31/16.
 */
public class BoardView extends SurfaceView implements View.OnTouchListener, View.OnClickListener{

    protected Piece pieces[][];
    protected float height;
    protected float width;
    protected long downTime;
    protected TextView counter = null;
    protected Button confirmButton1 = null;
    protected Button confirmButton2 = null;
    protected int lastX = -1;
    protected int lastY;

    protected boolean color;


    /**
     * Constructors
     * (overridden)
     */
    public BoardView(Context context) {
        super(context);
        setWillNotDraw(false);
        initPieces();
        this.setOnTouchListener(this);
        color = Piece.BLACK; //Black goes first, so start with black

    }
    public BoardView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setWillNotDraw(false);
        initPieces();
        this.setOnTouchListener(this);
        color = Piece.BLACK;
    }

    public BoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        initPieces();
        this.setOnTouchListener(this);
        color = Piece.BLACK;
    }

    public BoardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
        initPieces();
        this.setOnTouchListener(this);
        color = Piece.BLACK;
    }

    /**
     *  Initializes pieces array with empty-state pieces.
     *  This must be done before drawing
     */
    private void initPieces(){

        pieces = new Piece[8][8];

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                pieces[i][j] = new Piece();
            }

        }

    }

    @Override
    public void onDraw(Canvas canvas) {
        //get surfaceview size
        float width = this.getWidth();
        float height = this.getHeight();

        //we have 8 pieces, so the size of each piece will be 1/8th of each dimension
        height = height/8.0f;
        width = width/8.0f;

        //create paints
        Paint whitePaint = new Paint();
        whitePaint.setColor(Color.WHITE);
        whitePaint.setStyle(Paint.Style.FILL);
        Paint blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStyle(Paint.Style.FILL);
        Paint clearPaint = new Paint();
        clearPaint.setColor(0x00000000);
        clearPaint.setStyle(Paint.Style.FILL);

        //Draw the pieces. Uses array indices to offset the pieces,
        // size is determined based on view dimensions
        //@// TODO: 2/1/2016 Replace hard-coded padding values with variable
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece current = pieces[i][j];
                if (current.isEmpty() == true){
                    canvas.drawRect(5+i*width, 5+j*height, (i+1)*width -5, (j+1)*height -5, clearPaint);
                }
                else if (current.getColor() == Piece.WHITE) {
                    canvas.drawOval(5 + i * width, 5 + j * height, (i + 1) * width - 5, (j + 1) * height - 5, whitePaint);

                }
                else if (current.getColor() == Piece.BLACK) {
                    canvas.drawOval(5+ i*width, 5+ j*height, (i+1)*width -5, (j+1)*height -5, blackPaint);
                }

            }
        }


    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //make sure that we only process one touch per drag
        if (event.getDownTime() == this.downTime){
            return false;
        }
        this.downTime = event.getDownTime();

        float x = event.getX();
        float y = event.getY();

        float width = this.getWidth();
        float height = this.getHeight();

        height = height/8.0f;
        width = width/8.0f;

        x /= width;
        y /= height;

        int i = (int) x;
        int j = (int) y;

        pieces[i][j].setEmpty(!pieces[i][j].isEmpty());
        pieces[i][j].setColor(color);
        if(lastX != -1 && !(lastX == i && lastY == j)) {
            pieces[lastX][lastY].setEmpty(true);
        }
        lastX = i;
        lastY = j;
        counter.setText("" + i + ", " + j);
        //Log.i("board", "" + i + " " + j);

        this.invalidate();


        return true;
    }

    public void setTextView(TextView counter) {
        this.counter = counter;
    }

    public void setConfirmButtons(Button confirm1, Button confirm2){
        this.confirmButton1 = confirm1;
        this.confirmButton2 = confirm2;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.confirmButton && color == Piece.BLACK) {
            Log.i("Button1", "Clicked");
            lastX = -1;
            color = Piece.WHITE;
        }
        if (v.getId() == R.id.confirmTopButton && color == Piece.WHITE){
            Log.i("Button2", "Clicked");
            lastX = -1;
            color = Piece.BLACK;
        }
    }
}

