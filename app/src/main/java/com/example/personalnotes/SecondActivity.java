package com.example.personalnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SQLiteDatabase db;

        db = openOrCreateDatabase("NotesDb" , Context.MODE_PRIVATE, null) ;
        db.execSQL("CREATE TABLE IF NOT EXISTS notes (description VARCHAR) ;");

        EditText e1Insert ;
        Button view , insert ;


        e1Insert = (EditText) findViewById(R.id.insertText);
        view = (Button) findViewById(R.id.viewButton);
        insert = (Button) findViewById(R.id.insertButton);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String description = e1Insert.getText().toString();
                Intent intent  = new Intent(SecondActivity.this,ThirdActivity.class);
                intent.putExtra("Keyname",description) ;
                startActivity(intent);

                //display records
                if(v == view){
                    Cursor c = db.rawQuery("SELECT * FROM notes" , null);
                    if(c.getCount()==0){
                        Toast.makeText(getApplicationContext(),"no record found", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //insert record in notes table
                if(v == insert){
                    //checking for empty fields
                    if(e1Insert.getText().toString().trim().length()==0){
                        Toast.makeText(getApplicationContext(),"Error empty!!", Toast.LENGTH_SHORT).show();
                    }
                    db.execSQL("INSERT INTO notes VALUES ('"+e1Insert.getText()+"') ;");
                    Toast.makeText(getApplicationContext(),"record added", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}