package com.techlabs.paresh.multiactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                TextView genderText=findViewById(R.id.genderText);
                genderText.setText(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("--Main","Create");
        setContentView(R.layout.activity_main);

        Button btn=findViewById(R.id.btnNew);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText data=findViewById(R.id.data);
                String data1=data.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("data",data1);
                startActivity(intent);
            }
        });

        Button btnGenderSelect=findViewById(R.id.btnGenderSelect);
        btnGenderSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), GenderSelect.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("--Main","Destroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("--Main","Start");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("--Main","Resume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("--Main","Pause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("--Main","Stop");
    }
}
