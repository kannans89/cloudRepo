package com.techlabs.paresh.expensemanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class UpdateActivity extends AppCompatActivity {
    String d;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_expense);
        final Spinner dropdown = findViewById(R.id.category);
        String[] items = new String[]{"Food", "Entertainment", "Travel","Health","Personal","Miscellaneous"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        Intent intent = getIntent();
        EditText date1=findViewById(R.id.date);
        EditText amount=findViewById(R.id.amount);
        EditText description=findViewById(R.id.description);
        Spinner category=findViewById(R.id.category);
        id=intent.getStringExtra("id");
        date1.setText(intent.getStringExtra("date"));
        amount.setText(intent.getStringExtra("amount"));
        description.setText(intent.getStringExtra("description"));
        TextView txt=findViewById(R.id.title1);
        txt.setText(intent.getStringExtra("description"));
        d=date1.getText().toString();
        int position=0;
        for(int i=0;i<items.length;i++){
            if(items[i].equals(intent.getStringExtra("category"))){
                position=i;
                break;
            }
        }
        category.setSelection(position);
        final Calendar myCalendar = Calendar.getInstance();
        final EditText edittext= (EditText) findViewById(R.id.date);
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
            public void updateLabel(){
                String myFormat = "dd/MM/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.CANADA);
                edittext.setText(sdf.format(myCalendar.getTime()));
                d=sdf.format(myCalendar.getTime()).toString();
            }

        };
        edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(UpdateActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        ImageView delete = findViewById(R.id.delete);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDialogBuilder.setMessage("Are you sure,You want to delete this expense?");
                        alertDialogBuilder.setPositiveButton("yes",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        Intent returnIntent = new Intent();
                                        returnIntent.putExtra("id", id);
                                        setResult(Activity.RESULT_FIRST_USER, returnIntent);
                                        finish();
                                    }
                                });

                alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        ImageView ok = findViewById(R.id.ok);
        final AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(this);
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

                    Spinner category = findViewById(R.id.category);
                    returnIntent.putExtra("id", id);
                    returnIntent.putExtra("date", d);
                    returnIntent.putExtra("amount", amount.getText().toString());
                    returnIntent.putExtra("category", category.getSelectedItem().toString());
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
