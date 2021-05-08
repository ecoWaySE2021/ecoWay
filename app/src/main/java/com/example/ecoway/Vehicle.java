package com.example.ecoway;

 abstract public class Vehicle {
     int id;
     String type;
     String name;

    public Vehicle(int ID, String tpe, String name){
        this.id = ID;
        this.type = tpe;
        //this.battery_level = battery;
    }

    //float battery_level;
    //TODO: το gps τί τύπος μεταβλητής θέλουμε να είναι; -Ευα
}
