package com.techlabs.paresh.myapplication;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public MainActivity() {
        Log.d("Constructor", "constructor created");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        TextView countText = findViewById(R.id.count);
        Log.d("onCreate", "onCreate fired" + new Date().toString());
        int count;
        final SharedPreferences pref = getApplicationContext().getSharedPreferences("store", 0);

        Test testa=null;
        if (!pref.contains("test3")) {

            Test t1=new Test("1");

            Test t3=new Test("3");
            List<Test> test=new ArrayList<Test>();
            test.add(t1);
            Gson gson = new Gson();
            String json=gson.toJson(test);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("test3", json);
            editor.commit();

        } else {
            Gson gson = new Gson();
            String json = pref.getString("test3", "");
            Type type = new TypeToken<List<Test>>(){}.getType();
            List<Test> t = gson.fromJson(json, type);
            testa=t.get(0);
            Log.d("^^^",testa.getA());
        }

        Button btnRipple = findViewById(R.id.btn);
        btnRipple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Test t2=new Test("2");
                Test testa=null;
                Gson gson = new Gson();
                String json = pref.getString("test3", "");
                Type type = new TypeToken<List<Test>>(){}.getType();
                List<Test> t = gson.fromJson(json, type);
                t.add(t2);

                String json1=gson.toJson(t);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("test3", json1);
                editor.commit();

                for(int i=0;i<t.size();i++) {
                    testa = t.get(i);
                    Log.d("^^^", testa.getA());
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Destroy", "activity destroyed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Stop", "activity stopped");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("pause", "activity Paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("resume", "activity resumed");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("start", "activity started");
    }
}


