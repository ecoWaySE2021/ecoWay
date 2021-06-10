package com.example.ecoway;


public class Routes {

    float latitde, longitude; //Συντεταγμένες
    String address; //Ακριβείς διεύθυνση
    static int id=0; //id κάθε διαδρομής
    String type; //τυπος διαδρομης
    String equip[] = new String[6]; //κρανος-γαντια-επιγονατιδες, το πολυ 6 εξοπλισμοι
    int difficulty;
    int[] dur = new int[3]; //0->μερες, 1->ωρες, 2->λεπτα
    int age_limit;
    float how_far;
    double route_length;
    double pop;

    public Routes()
    {
        this.latitde=0.0f;
        this.longitude=0.0f;
        this.address=" ";
        this.id++;
        this.type = " ";
        this.equip[0] = "NONE";
        this.difficulty = 0;
        for(int i =0; i<6; i++){
            this.dur[i] = 0;
        }
        this.age_limit = 100;
        this.how_far = 0.0f;
        this.route_length = 0.0;
        this.pop = 0.0;
    }

    public Routes(float latitde, float longitude, String address,String type,String equip[],
                  int difficulty, int dur[], int age_limit, double route_length, double pop)
    {
        this.latitde=latitde;
        this.longitude=longitude;
        this.address=address;
        this.id++;
        this.type = type;
        for (int i=0; i<equip.length; i++){
            this.equip[i] = equip[i];
        }
        //difficulty must be in range 0-10
        if(difficulty>10){
            do{
                difficulty--;
            }while(difficulty>10);
        }else if (difficulty<0){
            do{
                difficulty++;
            }while (difficulty<0);
        }
        this.difficulty = difficulty;

        for(int i=0; i<dur.length; i++){
            this.dur[i]=dur[i];
        }

        this.age_limit = age_limit;
        this.route_length = route_length;

        //popularity between 0 and 10 stars
        if(pop>10.0){
            do{
                pop = pop - 0.1;
            }while(pop>10.0);
        }else if (pop<0.0){
            do{
                pop = pop + 0.1;
            }while(pop<0.0);
        }
        this.pop = pop;

    }


    //Μέθοδος Υπολογισμού Χιλιομέτρων
    //Μέθοδος Υπολογισμού Ώρας


}
