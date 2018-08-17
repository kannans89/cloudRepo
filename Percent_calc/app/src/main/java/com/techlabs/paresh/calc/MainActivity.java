package com.techlabs.paresh.calc;

import com.techlabs.percent.calculator.*;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    PercentCalculator pc=new PercentCalculator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        CARD ONE

        ((EditText)findViewById(R.id.percentOf)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                EditText number=(EditText)findViewById(R.id.number);
                long secondNo=0;
                long firstNo=0;
                if(s.toString().equals("")){}
                else
                    firstNo=Long.parseLong(s.toString());


                if(number.getText().toString().equals("")){}
                else
                    secondNo=Long.parseLong(number.getText().toString());

                String a=pc.xPercentOfY(firstNo,secondNo);
                TextView p=findViewById(R.id.answer);
                p.setText(a+"%");
            }
        });


        ((EditText)findViewById(R.id.number)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                long secondNo=0;
                if(s.toString().equals("")){}
                else
                    secondNo=Long.parseLong(s.toString());
                EditText number=(EditText)findViewById(R.id.percentOf);
                long firstNo=0;
                if(number.getText().toString().equals("")){}
                else
                    firstNo=Long.parseLong(number.getText().toString());

                String a=pc.xPercentOfY(firstNo,secondNo);
                TextView p=findViewById(R.id.answer);
                p.setText(a+"%");

            }
        });

//        CARD TWO


        ((EditText)findViewById(R.id.no1)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                EditText number=(EditText)findViewById(R.id.no2);
                long secondNo=0;
                String se= (String) number.getText().toString();
                long firstNo=0;
                if(s.toString().equals("")){}
                else
                    firstNo=Long.parseLong(s.toString());

                if(number.getText().toString().equals("")){}
                else
                    secondNo=Long.parseLong(number.getText().toString());


                String a=pc.xIsWhatPercentOfY(firstNo,secondNo);
                TextView p=findViewById(R.id.answer2);
                p.setText(a+"%");

            }
        });


        ((EditText)findViewById(R.id.no2)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                long secondNo=0;
                if(s.toString().equals("")){}
                else
                    secondNo=Long.parseLong(s.toString());
                EditText number=(EditText)findViewById(R.id.no1);
                long firstNo=0;
                if(number.getText().toString().equals("")){}
                else
                    firstNo=Long.parseLong(number.getText().toString());


                String a=pc.xIsWhatPercentOfY(firstNo,secondNo);
                TextView p=findViewById(R.id.answer2);
                p.setText(a+"%");
            }
        });


//        CARD THREE


        ((EditText)findViewById(R.id.percentChangeno1)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                EditText number=(EditText)findViewById(R.id.percentChangeno2);
                long secondNo=0;
                String se= (String) number.getText().toString();
                long firstNo=0;
                if(s.toString().equals("")){}
                else
                    firstNo=Long.parseLong(s.toString());

                if(number.getText().toString().equals("")){}
                else
                    secondNo=Long.parseLong(number.getText().toString());

                String a=pc.percentChangeFromXtoY(firstNo,secondNo);
                TextView p=findViewById(R.id.answer3);
                p.setText(a+"%");
            }
        });


        ((EditText)findViewById(R.id.percentChangeno2)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                long secondNo=0;
                if(s.toString().equals("")){}
                else
                    secondNo=Long.parseLong(s.toString());
                EditText number=(EditText)findViewById(R.id.percentChangeno1);
                long firstNo=0;
                if(number.getText().toString().equals("")){}
                else
                    firstNo=Long.parseLong(number.getText().toString());

                String a=pc.percentChangeFromXtoY(firstNo,secondNo);
                TextView p=findViewById(R.id.answer3);
                p.setText(a+"%");
            }
        });
    }
}
