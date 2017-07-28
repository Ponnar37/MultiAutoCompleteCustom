package com.multiautocomplet.multi;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;
import com.autocomplet.multiautocomplete.FilterType;
import com.autocomplet.multiautocomplete.MultiAutoCompleteCustom;
import com.autocomplet.multiautocomplete.Seprator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    List<String> values = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      /* *//*This is how elements should be added to the array list*//*
        values.add("Ajeet");
        values.add("Harry");
        values.add("Chaitanya");
        values.add("Steve");
        values.add("Anuj");*/

        /*This is how elements should be added to the LInkedList list*/
        values=new LinkedList<>();
        values.add("Ajeet");
        values.add("Harry");
        values.add("Chaitanya");
        values.add("Steve");
        values.add("Anuj");
        values.add("Test 1");
        values.add("Test 2");
        values.add("Test 3");
        values.add("Test 4");

        //Default Token
        MultiAutoCompleteCustom obj = (MultiAutoCompleteCustom) findViewById(R.id.value);
        obj.setDefaultAdapter(obj, values) //sent Parameter MultiAutoCompleteCutom and Values
                .setFilterType(FilterType.HEIGH) //Set Filter accuracy
                .setDefaultToken(Seprator.DEFAULT) //Set Tokent
                .build();


        /*//Dot Token in
        obj.setDefaultToken(Seprator.DOT)
                .setDefaultAdapter(obj, values)
                .build();


        //Dot Token in
        obj.setDefaultToken(Seprator.SPACE)
                .setDefaultAdapter(obj, values)
                .build();



         // TODO:  Custom Token
        //Custom Token
        obj.setCustomToken('*')
                .setFilterType(FilterType.LOW)
                .setDefaultAdapter(obj, values)
                .build();

        */




    }
}
