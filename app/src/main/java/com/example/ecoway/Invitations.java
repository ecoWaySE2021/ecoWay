package com.example.ecoway;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

enum Status
{
    onDemand, accept, reject;
}
enum Type
{
    incoming, output;
}

public class Invitations {

    static int id=0;
    String  location;
    User sender = new User();
    User receiver = new User();
    Type type;
    Status status;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date info = new Date();

    public Invitations(){
        this.id++;

        this.location="";
        this.type=Type.output;
        this.formatter.format(this.info);
    }

    public Invitations(User receiver, User sender, String location, Type type){
        this.id++;
        this.receiver=receiver;
        this.sender=sender;
        this.location=location;
        this.type=type;
        this.formatter.format(this.info);
    }

    public void ChangeStatus(int StatusNum)
    {
        if(StatusNum==0)
        {
            status=Status.onDemand;
        }
        if(StatusNum==1)
        {
            status=Status.accept;
        }
        if(StatusNum==0)
        {
            status=Status.reject;
        }
    }

    public static ArrayList <Invitations> getActiveInv(int user_id){
        User active_usr = Register.getUserByID(user_id);
        ArrayList <Invitations> ActiveInv = new ArrayList<>();
        for(int i=0; i<active_usr.invitationsList.size(); ++i){
            if(active_usr.invitationsList.get(i).status==Status.accept){
                ActiveInv.add(active_usr.invitationsList.get(i));
            }
        }
        return ActiveInv;
    }

    public static ArrayList <Invitations> getMyInvs(int user_id){
        User active_usr = Register.getUserByID(user_id);
        ArrayList <Invitations> MyInv =  new ArrayList<>();
        for(int i=0; i<active_usr.invitationsList.size(); ++i){
            if(active_usr.invitationsList.get(i).sender == active_usr){
                MyInv.add(active_usr.invitationsList.get(i));
            }
        }
        return MyInv;
    }

    public static ArrayList <Invitations> getAccInv(int user_id){
        User active_usr = Register.getUserByID(user_id);
        ArrayList <Invitations> AccInv =  new ArrayList<>();
        for(int i=0; i<active_usr.invitationsList.size(); ++i){
            if(active_usr.invitationsList.get(i).status==Status.accept){
                AccInv.add(active_usr.invitationsList.get(i));
            }
        }
        return AccInv;
    }

    public void setAccepted(int id){
        this.status = Status.accept;
    }


}
