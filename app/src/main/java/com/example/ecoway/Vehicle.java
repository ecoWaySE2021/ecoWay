package com.example.ecoway;

 abstract public class Vehicle {
     int id;
     String type;
     String name;
     protected static int bike_count = 0;
     protected static int elec_count = 0;
     protected static int roller_count = 0;

     public Vehicle(){
         this.id = 0;
         this.type = "vehicle";
         this.name = "placeholder";
     }

     public Vehicle(int ID, String tpe, String nme){
        this.id = ID;
        this.type = tpe;
        this.name = nme;
    }

    //TODO: το gps τί τύπος μεταβλητής θέλουμε να είναι; -Ευα
}
