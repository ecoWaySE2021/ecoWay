package com.example.ecoway;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.widget.ArrayAdapter;
import android.widget.ListView;
//import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView vehicleList;
    //ArrayAdapter<String> arrayAdapter;
    //Station S1 = new Station(1, 2, 3, "Τριών Ναυάρχων", 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Μεχρι να συνδέσουμε τα activities, καντε uncomment τη γραμμή 18 για το σταθμό και την 19 για το προφιλ
        setContentView(R.layout.activity_main);
        // setContentView(R.layout.profile);

        vehicleList = (ListView)findViewById(R.id.vehiclesList);
        //arrayAdapter = new ArrayAdapter<String>(this,
          //      R.layout.activity_main, S1.vehicle_List);

        //TODO: Η λίστα δε φορτωνει και κάνει το app να κρασαρει
        // (δεν εχει θεμα το activity_main.xml αλλα η java )
        //vehicleList.setAdapter(arrayAdapter);
    }
}

