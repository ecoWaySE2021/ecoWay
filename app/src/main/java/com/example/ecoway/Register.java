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
    }

    static int idx = 0;

    public Register(){
        users = new User[300];
    }

    public static void registerUser(String username, String password, String mail, String name)  {
        users[idx].usrname = username;
        users[idx].pass = password;
        users[idx].email = mail;
        users[idx].name = name;
        idx += 1;
    }

    public static Boolean findUser(String username, String password)  {
        int index = -1;
        for(int i=0; i<300; i++){
            if(users[i].usrname.equals(username)){
                index = i;
                break;
            }
        }
        if(index > -1){

            if(users[index].pass.equals(password))
                return true;

        }
        return false;
    }
}
