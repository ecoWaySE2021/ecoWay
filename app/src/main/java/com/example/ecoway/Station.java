package com.example.ecoway;

public class Station{
        public Station(int bikes, int rollers, int elecs, String loc, int ID){
                int[] vehicle_amount = {bikes, rollers, elecs};
                //String[] vehicle_List = {"Ποδήλατα", "Πατίνια", "Ηλεκτρικά Ποδήλατα"};
                Vehicle[] vehicle_List = {};
                String location = loc;
                int id = ID;
        }
        /*φτιαχνω εναν πινακα ακεραιων για την ποσοτητα οχηματων στο σταθμο. Η θεση του αριθμού
            αντιστοιχει στο οχημα βασει του vehicle list -Εύα*/
        int[] vehicle_amount;
        String[] vehicle_List;
        String location;
        int id;

        public void AddVehicleAmount(String type){
                if (type.equals(this.vehicle_List[0])){
                        this.vehicle_amount[0] += this.vehicle_amount[0];
                }else if (type.equals(this.vehicle_List[1])){
                        this.vehicle_amount[1] += this.vehicle_amount[1];
                }else if (type.equals(this.vehicle_List[2])){
                        this.vehicle_amount[2] += this.vehicle_amount[2];
                }
        }

        public void ReduceVehicleAmount(String type){
                if (type.equals(this.vehicle_List[0])){
                        this.vehicle_amount[0] -= this.vehicle_amount[0];
                }else if (type.equals(this.vehicle_List[1])){
                        this.vehicle_amount[1] -= this.vehicle_amount[1];
                }else if (type.equals(this.vehicle_List[2])){
                        this.vehicle_amount[2] -= this.vehicle_amount[2];
                }
        }
}
