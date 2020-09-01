package com.example.belajarintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button explictintent;
    Button implictintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        explictintent = (Button) findViewById(R.id.explictintent);
        explictintent.setOnClickListener(this);

        implictintent = (Button) findViewById(R.id.implictintent);
        implictintent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.explictintent:
                Intent explicit = new Intent(MainActivity.this, IntentActivity.class);
                startActivity(explicit);
                break;
            case R.id.implictintent:
                Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("www.w3school.com"));
                startActivity(implicit);
                break;
            default:break;
        }
    }
}