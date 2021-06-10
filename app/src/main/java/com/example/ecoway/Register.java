package com.example.ecoway;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Register {
    static User[] users = new User[300];
    static{
        for(int i=0; i < 300; ++i ){
            users[i] = new User();
        }
        users[16].usrname = "test";
        users[16].pass = "test123";
        users[16].lng = 0.1f;
        users[16].lat = 0.1f;
    }

    static int idx = 0;

    public Register(){

    }

    public static void registerUser(User toSign)  {
        users[idx] = toSign;
        idx += 1;
    }

    public static User getUserByID(int id){
        User user =  new User();
        for(int i=0; i<300; ++i){
            if(users[i].id == id){
                user = users[i];
            }
        }
        return user;
    }
}
