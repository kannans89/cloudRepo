package com.techlabs.paresh.multiactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("--Sub","Create");
        setContentView(R.layout.activity_sub);
        Intent i = getIntent();
        TextView text=findViewById(R.id.textView);
        text.setText(i.getStringExtra("data"));
        SharedPreferences pref = getApplicationContext().getSharedPreferences("a", 0);

        String name=pref.getString("name",null);

        Map<String,?> keys = pref.getAll();

        for(Map.Entry<String,?> entry : keys.entrySet()){
            Log.d("map values",entry.getKey() + ": " + entry.getValue().toString());
        }

        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name",i.getStringExtra("data"));

        editor.commit();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("--Sub","Destroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("--Sub","Start");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("--Sub","Resume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("--Sub","Pause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("--Sub","Stop");
    }
}


