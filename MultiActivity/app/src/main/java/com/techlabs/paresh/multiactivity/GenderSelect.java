package com.techlabs.paresh.multiactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class GenderSelect extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_select);
        Button ok = findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
                int id=radioSexGroup.getCheckedRadioButtonId();
                RadioButton radioButton=(RadioButton)findViewById(id);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",radioButton.getText());
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }
}
