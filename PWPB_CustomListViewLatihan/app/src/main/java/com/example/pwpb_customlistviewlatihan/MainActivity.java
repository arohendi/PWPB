package com.example.pwpb_customlistviewlatihan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Hero> heroList;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initial object
        heroList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);

        //add value
        heroList.add(new Hero(R.drawable.spiderman, "Spiderman", "Avenger"));
        heroList.add(new Hero(R.drawable.joker, "Joker", "Injustice Gang"));
        heroList.add(new Hero(R.drawable.batman, "Batman", "Justice League"));
        heroList.add(new Hero(R.drawable.ironman, "Iron Man", "Avenger"));
        heroList.add(new Hero(R.drawable.doctorstrange, "Doctor Strange", "Avenger"));
        heroList.add(new Hero(R.drawable.captainamerica, "Captain America", "Avenger"));

            // create adapter
        MyListAdapter adapter = new MyListAdapter(this,R.layout.my_custom_list,heroList);
        //attach adapter
        listView.setAdapter(adapter);
    }
}