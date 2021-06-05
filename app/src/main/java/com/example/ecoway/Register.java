package com.example.ecoway;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Register {
    static User[] users = new User[300];
    static int idx = 0;

    public Register(){

    }

    public static void registerUser(String username, String password, String mail, String name) throws NoSuchAlgorithmException {
        users[idx].usrname = username;
        MessageDigest digest = MessageDigest.getInstance("SHA=256");
        byte[] hashed = digest.digest( password.getBytes(StandardCharsets.UTF_8));
        users[idx].pass = hashed.toString();
        users[idx].email = mail;
        users[idx].name = name;
        idx += 1;
    }

    public Boolean findUser(String username, String password) throws NoSuchAlgorithmException {
        int index = -1;
        for(int i=0; i<300; i++){
            if(users[i].usrname.equals(username)){
                index = i;
                break;
            }
        }
        if(index >-1){
            MessageDigest digst = MessageDigest.getInstance("SHA=256");
            byte[] hashpass = digst.digest(password.getBytes(StandardCharsets.UTF_8));
            String hash = hashpass.toString();
            if(users[index].pass.equals(hash))
                return true;

        }
        return false;
    }
}
