package com.example.ecoway;
import java.util.ArrayList;

public class User {
    static int id=0;
    String usrname = "USERNAME";
    String pass = "PASSWORD";
    String name = "NAME" ;
    String email = "EMAIL";
    String num;
    String[] payment_info = new String[100];
    float lng,lat;
    boolean loginFlag;
    float score; //ποσοστο οικολογικης μετακινησης
    Routes[] routeList = new Routes[100];
    int points;
    ArrayList <Invitations> invitationsList = new ArrayList<Invitations>();

    protected float getUserLongitude(User usr){
        return lng;
    }

    protected float getUserLatitude(User usr){ return lat; }

    public User() {
        id += 1;
        usrname = "Username";
        name = "Name";
        pass = "Pass";
        num = "6981234567";
        for (int i=0; i<100; i++){
            payment_info[i] = " ";
        }
        loginFlag = false;
        lng = 0.0f;
        lat =0.0f;
        pass = "Pass";
        lng = getUserLongitude(this);
        lat = getUserLatitude(this);
        score = 0.0f;
        points = 0;
    }

    public User(String username, String password, String email, String name){
        this.id++;
        this.loginFlag = false;
        this.usrname = username;
        this.pass= password;
        this.name = name;
        //this.num = num;
        //for(int i=0; i<payment_info.length; i++){
            //this.payment_info[i]=payment_info[i];
        //}

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

    public void setAll(String username, String password, String email, String name){
        this.usrname = username;
        this.pass = password;
        this.email = email;
        this.name = name;
    }
}
