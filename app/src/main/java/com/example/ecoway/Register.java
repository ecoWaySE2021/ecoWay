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

    }

    public static void registerUser(User toSign)  {
        users[idx] = toSign;
        idx += 1;
    }
}
