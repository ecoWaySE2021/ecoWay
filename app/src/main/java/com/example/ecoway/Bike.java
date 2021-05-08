package com.example.ecoway;

public class Bike extends Vehicle {
    int sits;
    public Bike(){
        super();
    }
    public Bike(int ID, String tpe, String nme, int s){
        this.id = ID;
        this.type = tpe;
        this.name = nme;
        this.sits = s;
        bike_count++;
    }
}
