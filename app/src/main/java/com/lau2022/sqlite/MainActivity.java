package com.lau2022.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView Listview;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    String tutorials[]
            = {"Mobile Computing", "Game Programing",
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


        Listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = (String) adapterView.getItemAtPosition(i);
                Log.i(selectedItem, "Start");
                if (selectedItem.equals("Mobile Computing")) {
                    String URL = "https://www.javatpoint.com/mobile-computing";
                    Intent intent = new Intent(getApplicationContext(), website.class);
                    intent.putExtra("Url", URL);
                    startActivity(intent);
                }
                if (selectedItem.equals("Game Programing")) {
                    String URL = "https://www.freecodecamp.org/news/game-development-for-beginners-unity-course/";
                    Intent intent = new Intent(getApplicationContext(), website.class);
                    intent.putExtra("Url", URL);
                    startActivity(intent);
                }
                if (selectedItem.equals("Discrete Structures")) {
                    String URL = "https://www.tutorialspoint.com/discrete_mathematics/index.htm";
                    Intent intent = new Intent(getApplicationContext(), website.class);
                    intent.putExtra("Url", URL);
                    startActivity(intent);
                }
                if (selectedItem.equals("Algorithms and Data Structures")) {
                    String URL = "https://www.geeksforgeeks.org/data-structures/";
                    Intent intent = new Intent(getApplicationContext(), website.class);
                    intent.putExtra("Url", URL);
                    startActivity(intent);
                }
            }


        });


        try {

            SQLiteDatabase sql = this.openOrCreateDatabase("FinalExam", MODE_PRIVATE, null);
            sql.execSQL("CREATE Table IF NOT EXISTS courses (name VARCHAR)");

            Cursor cursor = sql.rawQuery("Select * from courses", null);
            int coursename = cursor.getColumnIndex("name");
            cursor.moveToFirst();


        }catch(Exception e){

        }
    }
}



