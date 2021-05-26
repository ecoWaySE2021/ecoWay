package com.example.ecoway;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.widget.ArrayAdapter;
import android.widget.ListView;
//import java.util.ArrayList;

public class StationActivity extends AppCompatActivity {
    ListView vehicleList;
    //ArrayAdapter<String> arrayAdapter;
    //Station S1 = new Station(1, 2, 3, "Τριών Ναυάρχων", 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Μεχρι να συνδέσουμε τα activities, καντε uncomment τις γραμμές που δε θελετε
        // setContentView(R.layout.activity_station);
        setContentView(R.layout.profile);
        // setContentView(R.layout.rewards);

        vehicleList = (ListView)findViewById(R.id.vehiclesList);
        //arrayAdapter = new ArrayAdapter<String>(this,
            // R.layout.activity_main, S1.vehicle_List);

        //TODO: Η λίστα δε φορτωνει και κάνει το app να κρασαρει
        // (δεν εχει θεμα το activity_main.xml αλλα η java )
        //TODO: διορθωση τ layout στο top τ rewards γτ δεν το διαβαζει ετσι ωστε να μπει χρωμα
        //vehicleList.setAdapter(arrayAdapter);
    }
}

