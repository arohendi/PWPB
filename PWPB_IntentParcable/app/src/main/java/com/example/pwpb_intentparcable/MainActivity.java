package com.example.pwpb_intentparcable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public Button btnMoveActivity;
    public Button btnMoveWithDataActivity;
    public Button btnMoveWithObject;
    Button btnDialNumber;
    Button btnMoveResult;
    TextView tvResult;

    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = (Button) findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveWithDataActivity = (Button) findViewById(R.id.btn_move_with_data_activity);
        btnMoveWithDataActivity.setOnClickListener(this);

        btnMoveWithObject = (Button) findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);

        btnDialNumber = (Button) findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);

        btnMoveResult = (Button) findViewById(R.id.btn_move_for_result);
        btnMoveResult.setOnClickListener(this);

        tvResult = findViewById(R.id.tv_result);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_move_activity:
            Intent MoveIntent = new Intent(MainActivity.this, MoveActivity.class);
            startActivity(MoveIntent);
            break;

            case R.id.btn_move_with_data_activity:
                Intent MoveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivity.class);
                MoveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "AGUS ROHENDI");
                MoveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 24);
                startActivity(MoveWithDataIntent);
                break;

            case R.id.btn_move_activity_object:
                Person mPerson = new Person();
                mPerson.setName("AGUS ROHENDI");
                mPerson.setAge(24);
                mPerson.setEmail("arohendi.siswa@smkn4bdg.sch.id");
                mPerson.setCity("Bandung");
                Intent MoveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                MoveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, mPerson);
                startActivity(MoveWithObjectIntent);
                break;

            case R.id.btn_dial_number:
               String phoneNumber = "088971305728";
               Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: + phoneNumber"));
               startActivity(dialPhoneIntent);
               break;

            case R.id.btn_move_for_result:
           Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
           startActivityForResult(moveForResultIntent, REQUEST_CODE);
           break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}