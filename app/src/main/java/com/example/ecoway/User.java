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
    boolean flagN=  true;
    boolean flagB = true;
    boolean flagEB = true;
    boolean flagP = true;
    float score; //ποσοστο οικολογικης μετακινησης
    Routes[] routeList = new Routes[100];
    static int route_idx = 0;
    int points;
    ArrayList <Invitations> invitationsList = new ArrayList<>();

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
        usrname = username;
        pass= password;
        name = name;
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

    public void addRouteToRouteList( Routes toAdd){
        this.routeList[route_idx] = toAdd;
        route_idx += 1;
    }

    public Routes getRouteDetails(int index){
        return this.routeList[index];
    }

    public User getUserData(){
        return this;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPass(String password){
        this.pass = password;
    }

    public void setEmail(String email){
        this.email = email;
    }


    public  Float[] getUserLocation(int id){
        User usr = Register.getUserByID(id);
        Float[] loc = {0.0f, 0.0f};
        loc[0] = getUserLatitude(usr);
        loc[1] = getUserLongitude(usr);
        return loc;
    }

    public static User getResult(String identifier){
        User naruto = new User();
        for(int i=0; i<Register.users.length; i++){
            if(identifier.equals(Register.users[i].name)||identifier.equals(Register.users[i].email)){
                naruto = Register.users[i];
            }
        }
        return naruto;
    }


    public void setPayment(String[] payment_info) {

    }
}
