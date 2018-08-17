package com.techlabs.paresh.tic_tac_toe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
     EditText p1;
    Button btn;
    Context c;
     EditText p2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c=MainActivity.this;
        p1=findViewById(R.id.p1);
        p2=findViewById(R.id.p2);
        btn=findViewById(R.id.play);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String player1=p1.getText().toString();
                String player2=p2.getText().toString();

                if(player1.equals("") || player2.equals("")) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(c);
                    builder1.setMessage("Please enter a name");
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
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), GameConsole.class);
                    intent.putExtra("player1", player1);
                    intent.putExtra("player2", player2);
                    startActivityForResult(intent,1);
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                btn.setText("PLAY AGAIN");
            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }
}
