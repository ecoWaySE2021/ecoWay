package com.example.ecoway;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Rent {
    static int id=0;
    int usr_id;
    int vehicle_id;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    float dur;

    public Rent(){
        this.id++;
        this.usr_id=0;
        this.vehicle_id=0;
        this.dur=0.0f;
        this.formatter.format(this.date);
    }

    public Rent(User usr, Vehicle vhc){
        super();
        this.id++;
        this.usr_id = usr.id;
        this.vehicle_id = vhc.id;
        this.formatter.format(this.date);
    }


}
