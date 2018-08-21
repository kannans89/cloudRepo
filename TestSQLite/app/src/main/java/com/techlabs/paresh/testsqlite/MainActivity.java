package com.techlabs.paresh.testsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button btn;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DatabaseHelper(getApplicationContext(), "authenticate", 1);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btn = findViewById(R.id.login);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean result = helper.authenticateUser(username.getText().toString(), password.getText().toString());
                if (result)
                    Toast.makeText(getApplicationContext(), "LOGIN SUCCESSFULL! ", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "LOGIN FAILED! ", Toast.LENGTH_LONG).show();
            }
        });

    }

}
