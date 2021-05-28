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

    //TODO: πρεπει να υπαρχει μια κλαση ElectricVehicle που να κανουν extend τα Roller και ElectricBike και αυτη
    // TODO:  με την σειρα της να κανει Extend στο Vehicle και να εχει την μεταβλητη Battery
    //TODO: Δοκίμασα να το κανω αλλα μου πεταγε καποιο σφαλμα στο constructor με την μεταβλητη και το εσβησα. -Χρηστος

     //TODO: το gps τί τύπος μεταβλητής θέλουμε να είναι; -Ευα
     //TODO: Νομιζω object ειναι του API του Google Maps αλλα θα το δω -Χρηστος
}
