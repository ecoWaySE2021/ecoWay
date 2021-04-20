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
        setContentView(R.layout.activity_main);

        String[] vehicle_List = {"Ποδήλατα", "Πατίνια", "Ηλεκτρικά Ποδήλατα"};
    //TODO: Η λίστα δε φορτωνει και κάνει το app να κρασαρει (δεν εχει θεμα το activity_main.xml αλλα η java)
    //TODO: ΠΗΓΑΙΝΕΤΕ ΣΤΟ gradle.build ΚΑΙ ΚΟΙΤΑΞΤΕ ΤΟ minSdkVersion ΝΑ ΕΙΝΑΙ 16
        //vehicleList = (ListView)findViewById(R.id.vehiclesList);
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_main, vehicle_List);
        //vehicleList.setAdapter(arrayAdapter);
    }


}