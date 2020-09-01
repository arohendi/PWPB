package com.example.pwpb_latihanintent;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.graphics.drawable.Drawable;

import static android.view.View.*;


public class MainActivity1 extends AppCompatActivity implements OnClickListener {
    orank sorank;
    EditText nama;
    RadioGroup jek;
    Button submit;
    Drawable cek;
    ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_activity);

        nama = findViewById(R.id.edttextdata);
        jek = findViewById(R.id.jenkel);

        foto = findViewById(R.id.poto);


        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);

        if (getIntent().getParcelableExtra(MainActivity2.EXTRA_ORANK) != null){
            sorank = getIntent().getParcelableExtra(MainActivity2.EXTRA_ORANK);
            if (!sorank.getNama().equals("No Data")){
                nama.setText(sorank.getNama());
                jek(sorank.getJenis_kelamin());

                submit.setText("Nama");
            }
        }
    }
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.submit){
            sorank = new orank();
            sorank.setNama(nama.getText().toString());
            sorank.setJenis_kelamin(jk());

            Intent buka = new Intent(MainActivity1.this, MainActivity2.class);
            buka.putExtra(MainActivity2.EXTRA_ORANK, sorank);
            startActivity(buka);
        }

    }
    public String jk(){
        if(jek.getCheckedRadioButtonId() != 0){
            String value = "No Data";

            switch (jek.getCheckedRadioButtonId()){
                case R.id.rd1:
                    value = "Pria";
                    break;

                case R.id.rd2:
                    value = "Wanita";
                    break;
            }
            return value;
        }
        return "No Data";
    }
    public void jek(String jkterisi){
        if (jek.equals("Pria")){
            jek.check(R.id.rd1);
        }
        else if (jek.equals("Wanita")){
            jek.check(R.id.rd2);
        }

}


}

//public static String EXTRA_NAME = "extra_name";
//public static String EXTRA_JK = "extra_jk";
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.name_activity);
//
//        final EditText name = (EditText) findViewById(R.id.edttextdata);
//        Button button = (Button) findViewById(R.id.submit);
//
//
//
//        button.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity1.this, MainActivity2.class);
//                i.putExtra("name", name.getText().toString());
//                startActivity(i);
//            }
//
//        });
//    }
//    @Override
//    public void onClick(View v){
//        if(v.getId() ==  R.id.submit){
//            if (jenkel.getCheckedRadioButtonId() != 0){
//                switch (jenkel.getCheckedRadioButtonId()){
//                    case R.id.rd1:
//                        value = "Pria";
//                        break;
//                    case R.id.rd2:
//                        value = "Wanita";
//                        break;
//                }
//                return value;
//            }
//        }
//    }

//    public String jenisKelamin() {
//        if (jenkel.getCheckedRadioButtonId() != 0) {
//            String value = "No Data";
//
//            switch (jenkel.getCheckedRadioButtonId()) {
//                case R.id.rd1:
//                    value = "Pria";
//                    break;
//
//                case R.id.rd2:
//                    value = "Wanita";
//                    break;
//            }
//
//            return value;
//        }
//    public void onRadioButtonClicked(View view){
//        boolean check = ((RadioButton) view).isChecked();
//        switch (view.getId()){
//            case R.id.rd1:
//                if (check)
//                    break;
//            case R.id.rd2:
//                if (check)
//                    break;
//    }
//}
//public void onButton1(View view){
//    Intent intent =  new Intent(this, MainActivity2.class);
//    EditText editText = (EditText) findViewById(R.id.viewdata2);
//    String jk = editText.getText().toString();
//    intent.putExtra("jk", jk);
//    startActivity(intent);
//}
//    }


