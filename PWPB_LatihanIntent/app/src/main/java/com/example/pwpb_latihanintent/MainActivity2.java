package com.example.pwpb_latihanintent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView ;
import android.content.Intent;
import android.view.View;
import android.graphics.drawable.Drawable;


public class MainActivity2 extends AppCompatActivity{
    public static String EXTRA_ORANK = "extra_orank";
    orank sorank;
    TextView nama;
    TextView jenkel;
    ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loby_activity);

        nama = findViewById(R.id.viewdata);
        jenkel = findViewById(R.id.viewdata2);

        foto = findViewById(R.id.poto);


        sorank = getIntent().getParcelableExtra(EXTRA_ORANK);
        nama.setText(sorank.getNama());
        jenkel.setText(sorank.getJenis_kelamin());
    }

//    public void poto(View poto){
//
//        if (jenkel = equals("Pria")){
//            foto.setImageDrawable(R.drawable.cwok);
//        }else if (jenkel == R.id.rd2){
//            foto.setImageDrawable(R.drawable.cwek);
//        }
//    }
    public void kehome(View v){
        Intent home = new Intent(MainActivity2.this, MainActivity.class);
        home.putExtra(EXTRA_ORANK, sorank);
        startActivity(home);
    }

}