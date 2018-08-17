package com.techlabs.paresh.expensemanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddActivity extends AppCompatActivity {

    String d = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        //        DATEPICKER
        final Calendar myCalendar = Calendar.getInstance();
        final EditText edittext = (EditText) findViewById(R.id.date);
        edittext.setHint("Click Me");

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

            public void updateLabel() {
                String myFormat = "dd/MM/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.CANADA);
                edittext.setText(sdf.format(myCalendar.getTime()));
                d = sdf.format(myCalendar.getTime()).toString();
            }

        };
        edittext.setOnClickListener(new View.OnClickListener() {
            DatePickerDialog dateDialog=new DatePickerDialog(AddActivity.this, date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH));
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                dateDialog.show();
            }
        });

//                  DATEPICKER END
        final Spinner dropdown = findViewById(R.id.category);
        String[] items = new String[]{"Food", "Entertainment", "Travel", "Health", "Personal", "Miscellaneous"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);


        ImageView ok = findViewById(R.id.ok);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText amount = findViewById(R.id.amount);
                EditText description = findViewById(R.id.description);

                if (amount.getText().toString().equals("") || description.getText().toString().equals("") || d.equals("")) {

                    alertDialogBuilder.setMessage("You need to fill all the details");
                    alertDialogBuilder.setNegativeButton("Ok",new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();

                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                } else {
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("date", d);
                    returnIntent.putExtra("amount", amount.getText().toString());
                    returnIntent.putExtra("category", dropdown.getSelectedItem().toString());
                    returnIntent.putExtra("description", description.getText().toString());
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
                }

            }
        });

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });
    }
}
