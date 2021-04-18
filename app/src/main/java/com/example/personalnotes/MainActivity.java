package com.example.personalnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1userName , e2password ;
    Button b1login ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        e1userName = (EditText) findViewById(R.id.userName);
        e2password = (EditText) findViewById(R.id.password);
        b1login = (Button) findViewById(R.id.logIn);

        b1login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = e1userName.getText().toString();
                String password = e2password.getText().toString();

                if(userName.equals("tahami") && password.equals("1234")){
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(getBaseContext(),"Wrong entered",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}


