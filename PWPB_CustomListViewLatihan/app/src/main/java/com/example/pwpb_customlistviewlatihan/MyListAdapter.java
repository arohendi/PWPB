package com.example.pwpb_customlistviewlatihan;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

public class MyListAdapter extends ArrayAdapter<Hero> {

    List<Hero> herolist;
    Context context;
    int resource;

    //Constructor
    public MyListAdapter(Context context,int resource, List<Hero> heroList){
        super(context,resource,heroList);
        this.context = context;
        this.herolist = heroList;
        this.resource = resource;
    }

    @NonNull
    @Override
   public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent){

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //get the View
        View view = layoutInflater.inflate(resource, null, false);
        //getview element
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textViewname = view.findViewById(R.id.textViewName);
        TextView textViewteam = view.findViewById(R.id.textViewTeam);
        Button buttonDelete = view.findViewById(R.id.buttonDelete);

        //get hero specified position
        Hero hero = herolist.get(position);

            //add value
        imageView.setImageDrawable(context.getResources().getDrawable(hero.getImage()));
        textViewname.setText(hero.getName());
        textViewteam.setText(hero.getTeam());

        //add value
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeHero(position);
            }
        });
        return view;
    }

    //Method hapus Hero ( removeHero)
    private void removeHero(final int position){
        //peringatan
    AlertDialog.Builder builder = new AlertDialog.Builder(context);
    builder.setTitle("Apakah anda yakin ?");

    //jika respon true
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                //remove item
                herolist.remove(position);
                //reload list
                notifyDataSetChanged();
            }
        });

        //jika respon false
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        });
        //create and display alert dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}