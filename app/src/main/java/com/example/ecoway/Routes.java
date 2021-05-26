package com.example.ecoway;

public class Routes {

    double latitde, longitude; //Συντεταγμένες
    String address; //Ακριβείς διεύθυνση
    static int id=0; //id κάθε διαδρομής

    public Routes()
    {
        this.latitde=0.0;
        this.longitude=0.0;
        this.address=" ";
        this.id++;
    }

    public Routes(double latitde, double longitude, String address)
    {
        this.latitde=latitde;
        this.longitude=longitude;
        this.address=address;
        this.id++;
    }

    //Μέθοδος Υπολογισμού Χιλιομέτρων
    //Μέθοδος Υπολογισμού Ώρας


}
