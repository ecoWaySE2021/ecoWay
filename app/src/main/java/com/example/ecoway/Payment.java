package com.example.ecoway;
enum payment {cash, credit_card, paypal};
enum State {successful, failed, on_hold};

public class Payment{
    static int ID;
    int ID_rent;
    double total;
    payment pway;
    State state;

    public Payment(){
        super();
                    }
    public Payment(int ID, int ID_rent, double total, payment tropos, State state)
    {
        this.ID=ID;
        this.ID_rent=ID_rent;
        this.total=total;
        this.pway=tropos;
        this.state=state;
    }


}
