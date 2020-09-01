package com.example.pwpb_latihanintent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnya;
    Button btntdk;
    orank sOrank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnya = findViewById(R.id.ya);
        btnya.setOnClickListener(this);

        btntdk = findViewById(R.id.tidak);
        btntdk.setOnClickListener(this);



//        if (getIntent().getParcelableExtra(MainActivity2.EXTRA_ORANK) != null){
//            sOrank = getIntent().getParcelableExtra(MainActivity2.EXTRA_ORANK);
//
//            if(!sOrank.getNama().equals("No Data")){
//                btnya.setText("EDIT IDENTITAS");
//         }
//
//       } else {
//           sOrank = new orank("No Data");
//       }
   }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ya:
                Intent yak = new Intent(MainActivity.this, MainActivity1.class);
                yak.putExtra(MainActivity2.EXTRA_ORANK, sOrank);
                startActivity(yak);
                break;

            case R.id.tidak:
                Intent tidak = new Intent(MainActivity.this, MainActivity1.class);
                tidak.putExtra(MainActivity2.EXTRA_ORANK, sOrank);
                startActivity(tidak);
                break;

        }
    }
}
//public class MainActivity extends AppCompatActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//    }
//    public void pindah(View v){
//        Intent i = new Intent(MainActivity.this, MainActivity1.class);
//        startActivity(i);
//    }
//}
