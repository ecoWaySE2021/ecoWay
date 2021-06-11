package com.example.ecoway;

 abstract public class Vehicle {
     int id;
     String type;
     String name;

     public Vehicle()
     {
         this.id = 0;
         this.type = "vehicle";
         this.name = "placeholder";
     }

     public Vehicle(int ID, String nme)
     {
        this.id = ID;
        this.name = nme;
    }



    public String get_info()
    {
        return id+ "\n" +name ;
    }


    abstract String get_Info();
}
