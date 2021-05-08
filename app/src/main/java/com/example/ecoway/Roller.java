package com.example.ecoway;

public class Roller extends Vehicle {

    static int roller_count = 0;

    public Roller(){
        super();
    }
    public Roller(int ID, String nme)
    {
        super(ID,nme);
        roller_count++;
    }

    String get_Info()
    {
        return super.get_info();
    }
}
