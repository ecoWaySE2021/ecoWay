package com.example.ecoway;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    String  receiver, sender, location;
    Type type;
    Status status;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date info = new Date();

    public Invitations(){
        this.id++;
        this.receiver="";
        this.sender="";
        this.location="";
        this.type=Type.output;
        this.formatter.format(this.info);
    }

    public Invitations(String receiver, String sender, String location, Type type){
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
}
