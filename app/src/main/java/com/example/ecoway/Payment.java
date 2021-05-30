package com.example.ecoway;
enum payment {cash, credit_card, paypal, NULL};
enum State {successful, failed, on_hold};

public class Payment{
    static int ID=0;
    int ID_rent;
    double total;
    payment pway;
    State state;

    public Payment(){
        ID++;
        ID_rent=0;
        total=0;
        pway=payment.NULL;
        state=State.on_hold;
                    }
    public Payment(int ID, int ID_rent, double total, payment pway, State state)
    {
        this.ID=ID;
        this.ID_rent=ID_rent;
        this.total=total;
        this.pway=pway;
        this.state=state;
    }


}
