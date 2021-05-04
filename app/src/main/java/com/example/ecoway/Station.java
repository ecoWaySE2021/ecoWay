package com.example.ecoway;

public class Station{
        public Station(int bikes, int rollers, int elecs, String loc, int ID){
                int[] vehicle_amount = {bikes, rollers, elecs};
                String[] vehicle_List = {"Ποδήλατα", "Πατίνια", "Ηλεκτρικά Ποδήλατα"};
                String location = loc;
                int id = ID;
        }
        /*φτιαχνω ενσν πινακα ακεραιων για την ποσοτητα οχηματων στο σταθμο. Η θεση του αριθμού
            αντιστοιχει στο οχημα βασει του vehicle list -Εύα*/
        //TODO: Να μπει το vehicle list στο domain του σταθμού

}
