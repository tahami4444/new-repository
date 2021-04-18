package com.example.personalnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    ListView listview ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        listview = (ListView) findViewById(R.id.listview1) ;

        ArrayList<String> arlist = new ArrayList<>();
        String description1 = getIntent().getStringExtra("Keyname");


        arlist.add(description1);

        ArrayAdapter arAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arlist);
        listview.setAdapter(arAdapter);



    }
}