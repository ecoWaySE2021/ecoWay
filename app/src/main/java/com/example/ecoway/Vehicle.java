package com.example.ecoway;

public abstract class Vehicle {

    public Vehicle(int ID, String tpe){
        this.id = ID;
        this.type = tpe;
        //this.battery_level = battery;
    }
    int id;
    String type;
    //float battery_level;
    //TODO: το gps τί τύπος μεταβλητής θέλουμε να είναι; -Ευα
}
