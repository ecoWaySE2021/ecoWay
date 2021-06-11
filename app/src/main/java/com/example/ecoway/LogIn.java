package com.example.ecoway;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LogIn {

    boolean loggedFlag = false;
    boolean correctCredentials = false;
    String id;
    String password;

    public static User signIn(User user){
        //Μεθοδος συνδεσης χρηστων.
        if  (auth(user) == true){
            user.loginFlag=true;
        }
        return user;
    }

    public static void signUp(String username,String password,String email,String name) {
        //Μεθοδος εγγραφης χρηστων
        String[] paymentCred = new String[100];
        User toSignUp = new User(username, password, email, name);
        Register.registerUser(toSignUp);


    }

    public static boolean auth(User logged_user){
        //Μεθοδος αυθεντικοποιησης χρηστων
        int index = -1;
        for(int i=0; i<300; i++){
            if(Register.users[i].usrname.equals(logged_user.usrname)){
                index = i;
                break;
            }
        }
        if(index > -1) {
            if (Register.users[index].pass.equals(logged_user.pass)) {
                logged_user.loginFlag = true;
                return true;

            }
        }
        return false;
    }

    public static boolean checkSignUpCredentials(User user){
        return true;
    }

    public static boolean checkPaymentCredentials(String[] way, User user){
        //Σωστα Creds
       // return correctCredentials;
        user.payment_info=way;
        return true;
    }

    public void addUserToDatabase(){
        //Καταχωρηση χρηστη

    }


    public static User guestLogIn(){
        User guest = new User("guest", "guest", "guest", "Guest User" );
        guest.lat = 0.1f;
        guest.lng = 0.1f;
        guest.loginFlag = true;
        return guest;
    }

    public void GuestLogin(){
        //Μέθοδος σύνδεσης χωρίς εγγραφή

    }



}
