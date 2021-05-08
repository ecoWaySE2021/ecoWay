package com.example.ecoway;

public class ElectricBike extends Vehicle {
    float battery_level;
    int sits;
    protected static int elec_count = 0;

    public ElectricBike(int ID, String nme, int s, float battery)
    {
        super(ID,nme);
        this.sits = s;
        this.battery_level = battery;
        elec_count++;
    }

    String get_Info()
    {
        return super.get_info()+ "\n" +sits+ "\n" +battery_level;
    }
}
