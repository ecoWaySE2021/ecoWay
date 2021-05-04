package com.example.ecoway;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView vehicleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Μεχρι να συνδέσουμε τα activities, καντε uncomment τη γραμμή 17 για το σταθμό και την 18 για το προφιλ
        setContentView(R.layout.activity_main);
        // setContentView(R.layout.profile);

        //TODO: Να μπει το vehicle list στο domain του σταθμού
        //vehicle list sto station.java
// TODO: Η λίστα δε φορτωνει και κάνει το app να κρασαρει (δεν εχει θεμα το activity_main.xml αλλα η java)
        //vehicleList = (ListView)findViewById(R.id.vehiclesList);
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_main,
        // this.Station.vehicle_list); //sto telos thelw na pairnw ton pinaka apo to stations
        //vehicleList.setAdapter(arrayAdapter);
    }
}

