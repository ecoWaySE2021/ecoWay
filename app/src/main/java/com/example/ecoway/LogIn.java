package com.example.ecoway;
import androidx.annotation.NonNull;

import java.util.ArrayList;

public class LogIn {

    boolean loggedFlag = false;
    boolean correctCredentials = false;
    String id;
    String password;

    public void signIn(){
        //Μεθοδος συνδεσης χρηστων.
        if  (auth() == true){
            User.loginFlag=true;
        }

    }

    public void signUp(){
        //Μεθοδος εγγραφης χρηστων

        String name;
        String[] paymentCred = new String[100];

        if (checkSignUpCredentials()==true){
            if (checkPaymentCredentials()==true){
                addUserToDatabase();
            }else{
                //λαθος payment
            }
        }else{
            //λαθος creds
        }


        signIn();
    }

    public boolean auth(){
        //Μεθοδος αυθεντικοποιησης χρηστων

        return loggedFlag;
    }

    public boolean checkSignUpCredentials(){
        //Σωστα Creds
        return correctCredentials;
    }

    public boolean checkPaymentCredentials(){
        //Σωστα Creds
        return correctCredentials;
    }

    public void addUserToDatabase(){
        //Καταχωρηση χρηστη

    }


    public boolean guestLogIn(){
        //Μεθοδος συνδεσης χωρις εγγραφη
        User.loginFlag=false;
        return User.loginFlag;
    }

    public void GuestLogin(){
        //Μέθοδος σύνδεσης χωρίς εγγραφή

    }



}
