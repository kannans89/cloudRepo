package com.techlabs.paresh.tic_tac_toe;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class GameConsole extends AppCompatActivity implements View.OnClickListener {
    TextView turn;
    TextView display;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Intent intent;
    Board board;
    Player[] player;
    ResultAnalyzer analyzer;
    Game g;
    int count = 0;
    String winner;
    Button reset;
    Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_console);
        turn = findViewById(R.id.turn);
        display = findViewById(R.id.display);
        c = GameConsole.this;
        reset = findViewById(R.id.reset);
        intent = getIntent();
        String p1 = intent.getStringExtra("player1");
        String p2 = intent.getStringExtra("player2");
        turn.setText(p1);

        board = new Board();
        player = new Player[2];
        player[0] = new Player(1, p1);
        player[1] = new Player(2, p2);

        analyzer = new ResultAnalyzer(board);
        g = new Game(player, analyzer, board);

        btn1 = findViewById(R.id.b1);
        btn2 = findViewById(R.id.b2);
        btn3 = findViewById(R.id.b3);
        btn4 = findViewById(R.id.b4);
        btn5 = findViewById(R.id.b5);
        btn6 = findViewById(R.id.b6);
        btn7 = findViewById(R.id.b7);
        btn8 = findViewById(R.id.b8);
        btn9 = findViewById(R.id.b9);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        reset.setOnClickListener(this);

    }


    public void onClick(View v) {

        Button b = (Button) v;
        String id = b.getText().toString();
        Log.d("btn", id);
        if (id.equals("reset")) {
            Log.d("RESETTTT", id);
            Intent intent = new Intent();
            setResult(Activity.RESULT_OK, intent);
            finish();
        } else {


            if (count == 0) {
                b.setText("X");
                b.setTextColor(Color.rgb(210, 0, 0));
            } else {
                b.setText("0");
                b.setTextColor(Color.rgb(0, 100, 0));
            }
            count = (count + 1) % 2;
            turn.setText(player[count].getName());

            g.play((Integer.parseInt(id) - 1));
            analyzer.checkResult();
            String result = analyzer.getResult().toString();
            if (result.equals("WIN")) {
                winner = player[(analyzer.getWinner() + 1) % 2].getName();

                AlertDialog.Builder builder1 = new AlertDialog.Builder(c);
                builder1.setMessage(winner + " Wins!");
                builder1.setCancelable(true);
                builder1.setPositiveButton(
                        "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
                display.setText("WINNER: ");
                display.setTextColor(Color.rgb(0, 100, 0));
                turn.setText(winner);
                turn.setTextColor(Color.rgb(0, 100, 0));
                reset.setVisibility(View.VISIBLE);
                disableBtns();
            } else if (result.equals("DRAW")) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(c);
                builder1.setMessage("Its a DRAW!");
                builder1.setCancelable(true);
                builder1.setPositiveButton(
                        "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
                display.setText("DRAW ");
                display.setTextColor(Color.BLUE);
                turn.setVisibility(View.INVISIBLE);
                reset.setVisibility(View.VISIBLE);
                disableBtns();
            }
        }
    }

    void disableBtns() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);

    }
}
