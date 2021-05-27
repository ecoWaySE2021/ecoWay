package com.example.ecoway;

public class User {
    static int id=0;
    String name;
    String num;
    String[] payment_info = new String[100];
    float lng,lat;

    protected float getUserLongitude(User usr){
        return lng;
    }

    protected float getUserLatitude(User usr){

        return lat;
    }

    public User() {
        this.id++;
        this.name = "Name Placeholder";
        this.num = "6981234567";
        for (int i=0; i<100; i++){
            this.payment_info[i] = " ";
        }
        this.lng = 0.0f;
        this.lat =0.0f;

        this.lng = getUserLongitude(this);
        this.lat = getUserLatitude(this);
    }

    public User(String name, String num, String[] payment_info){
        this.id++;
        this.name = name;
        this.num = num;
        for(int i=0; i<payment_info.length; i++){
            this.payment_info[i]=payment_info[i];
        }

        this.lng = getUserLongitude(this);
        this.lat = getUserLatitude(this);
    }

}
