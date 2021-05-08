package com.example.ecoway;

public class ElectricBike extends Bike {
    float battery_level;

    public ElectricBike(int ID, String tpe, String nme, int s, float battery){
        this.id = ID;
        this.type = tpe;
        this.name = nme;
        this.sits = s;
        this.battery_level = battery;
        elec_count++;
    }
}
