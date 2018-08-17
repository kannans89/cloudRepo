package com.techlabs.paresh.namematcher;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.widget.ImageView.*;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private static final int PICK_CONTACT = 1;
    public int id=0;
    public void onClick(View v) {

        id=v.getId();
        Intent intent= new Intent(Intent.ACTION_PICK,  ContactsContract.Contacts.CONTENT_URI);

        startActivityForResult(intent, PICK_CONTACT);

    }
    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        switch (reqCode) {
            case (PICK_CONTACT) :
                if (resultCode == Activity.RESULT_OK) {
                    Uri contactData = data.getData();
                    Cursor c =  managedQuery(contactData, null, null, null, null);
                    if (c.moveToFirst()) {
                        String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        // TODO Fetch other Contact details as you want to use
                        if(id==2131165298){
                            EditText e=(EditText) findViewById(R.id.secondname);
                            e.setText(name);
                        }
                        else{
                            EditText e=(EditText) findViewById(R.id.firstname);
                            e.setText(name);
                        }

                    }
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img1 = (ImageView) findViewById(R.id.firstnameimage);
        img1.setOnClickListener(this);

        ImageView img2 = (ImageView) findViewById(R.id.secondnameimage);
        img2.setOnClickListener(this);


//        ImageView img1=(ImageView) findViewById(R.id.firstnameimage);
//        img1.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Log.d("image click","u clicked image 1");
//            }
//        });
//


        ((EditText) findViewById(R.id.firstname)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                int fascii = 0;
                for (int i = 0; i < s.toString().length(); i++) {
                    char character = s.toString().charAt(i);
                    fascii = fascii + (int) character;
                }
                EditText secondname = (EditText) findViewById(R.id.secondname);
                String second = secondname.getText().toString();
                int sascii = 0;
                for (int i = 0; i < second.length(); i++) {
                    char character = second.charAt(i);
                    sascii = sascii + (int) character;
                }
                int percent = (fascii + sascii) % 101;

                TextView p = findViewById(R.id.percent);
                p.setText(percent + "%");
            }
        });

        ((EditText) findViewById(R.id.secondname)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                int sascii = 0;
                for (int i = 0; i < s.length(); i++) {
                    char character = s.charAt(i);
                    sascii = sascii + (int) character;
                }

                EditText firstname = (EditText) findViewById(R.id.firstname);
                String first = firstname.getText().toString();
                int fascii = 0;
                for (int i = 0; i < first.length(); i++) {
                    char character = first.charAt(i);
                    fascii = fascii + (int) character;
                }

                int percent = (fascii + sascii) % 101;

                TextView p = findViewById(R.id.percent);
                p.setGravity(1);
                p.setText(percent + "%");
            }
        });


    }
}
