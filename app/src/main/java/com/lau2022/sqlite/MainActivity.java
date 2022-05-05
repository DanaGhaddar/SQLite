package com.lau2022.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView Listview;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    String tutorials[]
            = { "Mobile Computing", "Game Programing",
            "Discrete Structures", "Algorithms and Data Structures"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Listview = (ListView) findViewById(R.id.list);
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,
                tutorials);
        Listview.setAdapter(adapter);


    }


    }
