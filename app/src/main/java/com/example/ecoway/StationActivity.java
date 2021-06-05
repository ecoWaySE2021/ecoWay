package com.example.ecoway;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ListView;
import android.widget.Button;
//import java.util.ArrayList;


public class StationActivity extends AppCompatActivity {
    ListView vehicleList;
    //ArrayAdapter<String> arrayAdapter;
    //Station S1 = new Station(1, 2, 3, "Τριών Ναυάρχων", 1);
    private Button login_butt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_start);
        login_butt = (Button) findViewById(R.id.login_guest);
        login_butt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setContentView(R.layout.home_google_map);
            }
        });

        // Μεχρι να συνδέσουμε τα activities, καντε uncomment τις γραμμές που δε θελετε
        // setContentView(R.layout.activity_station);
        //setContentView(R.layout.profile);
         //setContentView(R.layout.rewards);
        //setContentView(R.layout.available_shops);
        //setContentView(R.layout.payment_screen);
        //setContentView(R.layout.suggested_routes);
        //TODO suggested routes
        //setContentView(R.layout.vehicle_selection);
        //setContentView(R.layout.shop_info);



        vehicleList = (ListView)findViewById(R.id.vehiclesList);
        //arrayAdapter = new ArrayAdapter<String>(this,
            // R.layout.activity_main, S1.vehicle_List);

        //TODO: Η λίστα δε φορτωνει και κάνει το app να κρασαρει
        // (δεν εχει θεμα το activity_main.xml αλλα η java )
        //TODO: αλλαγη χρωματος/στυλ στα buttons στο payment screen
        //TODO: γιατι θελουμε να τα αλλαξουν, τι εχουν; -Χρηστος
        //vehicleList.setAdapter(arrayAdapter);

    }

}

