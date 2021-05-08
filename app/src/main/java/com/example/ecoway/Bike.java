package com.example.ecoway;

public class Bike extends Vehicle {
    int sits;
    protected static int bike_count = 0;

    public Bike(){
        super();
    }
    public Bike(int ID, String nme, int s)
    {
        super(ID,nme);
        this.sits = s;
        bike_count++;
    }
    String get_Info()
    {
        return super.get_info()+ "\n" +sits;
    }
}
