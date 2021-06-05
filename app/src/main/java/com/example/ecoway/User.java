package com.example.ecoway;
import java.util.ArrayList;

public class User {
    static int id=0;
    String usrname =  new String();
    String pass = new String();
    String name = new String();
    String email = new String();
    String num= new String();
    String[] payment_info = new String[100];
    float lng,lat;
    static boolean loginFlag;
    float score; //ποσοστο οικολογικης μετακινησης
    Routes[] routeList = new Routes[100];
    int points;
    ArrayList <Invitations> invitationsList = new ArrayList<Invitations>();

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
        this.loginFlag = false;
        this.lng = 0.0f;
        this.lat =0.0f;

        this.lng = getUserLongitude(this);
        this.lat = getUserLatitude(this);
        this.score = 0.0f;
        this.points = 0;
    }

    public User(String name, String num, String[] payment_info){
        this.id++;
        this.loginFlag = false;
        this.name = name;
        this.num = num;
        for(int i=0; i<payment_info.length; i++){
            this.payment_info[i]=payment_info[i];
        }

        this.lng = getUserLongitude(this);
        this.lat = getUserLatitude(this);
        this.score = calcUserScore(this);
    }

    public float calcUserScore(User user){
        return score;
    }

    public void addPoints(User user, int points){
        user.points = user.points + points;
    }

    public void removePoints(User user, int points){
        user.points = user.points - points;
    }
}
