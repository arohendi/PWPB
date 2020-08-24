package com.example.pwpb_intentparcable;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class MoveWithDataActivity extends AppCompatActivity {
    public static String EXTRA_NAME = "extra name";
    public static String EXTRA_AGE = "extra age";
    private TextView tvDataRecieved;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);
        tvDataRecieved = (TextView) findViewById(R.id.tv_data_recieved);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE, 0);
        String text =  "Name: " + name + " Your Age : " + age ;
        tvDataRecieved.setText(text);
    }
}
