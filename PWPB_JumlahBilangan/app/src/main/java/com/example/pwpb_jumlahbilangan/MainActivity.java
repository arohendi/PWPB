package com.example.pwpb_jumlahbilangan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText blg1;
    private EditText blg2;
    private EditText hsl;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initEvent();
    }

    private void initUI(){
        blg1 = (EditText) findViewById(R.id.bil1);
        blg2 = (EditText) findViewById(R.id.bil2);
        hsl = (EditText) findViewById(R.id.hasil);
        button = (Button) findViewById(R.id.btn);
    }

    private void initEvent(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungjumlah();
            }
        });
    }
    private void hitungjumlah(){
        int angka1 = Integer.parseInt(blg1.getText().toString());
        int angka2 = Integer.parseInt(blg2.getText().toString());
        int total = angka1 + angka2;
        hsl.setText(total+"");
    }

}