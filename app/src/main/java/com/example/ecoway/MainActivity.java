package com.example.ecoway;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.CheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.Switch;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Button login_butt;
    private Button guest_login_butt;
    private Button register_butt;
    private Button register_user;
    private Button cancel;
    private Button rent_this;
    private Button vehicle_type;
    private Button vehicle_button;
    private ImageButton vehicle;
    private ImageButton dropdown;
    private ImageButton dd_profile_button;
    private ImageButton dd_stations_button;
    private ImageButton dd_shops_button;
    private User active_user = new User();
    private ArrayList <Station> stations = new ArrayList<>();
    private String[] payment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_start);
        stations.add(new Station(5, 2, 1, "Τριών Ναυάρχων", 0));
        Login();
        Register();
        Guest_Login();
    }

    private void Login() {
        login_butt = (Button) findViewById(R.id.login_button);
        login_butt.setOnClickListener(vlogin -> {
            String username = ((TextInputEditText) findViewById(R.id.username)).getEditableText().toString();
            String password = ((TextInputEditText) findViewById(R.id.password)).getEditableText().toString();
            if (LogIn.Login(active_user)) {
                inHome();
            } else {
                LoginError();
            }
        });
    }

    private void Register(){
        register_butt = (Button) findViewById(R.id.register_button);
        register_butt.setOnClickListener(vregister -> {
            setContentView(R.layout.register);
            register_user = (Button) findViewById(R.id.register_user_butt);
            register_user.setOnClickListener(v1 -> {
                String usrname = ((TextInputLayout) findViewById(R.id.username_input)).getEditText().toString();
                String pass = ((TextInputLayout) findViewById(R.id.pass_input)).getEditText().toString();
                String email = ((TextInputLayout) findViewById(R.id.email_input)).getEditText().toString();
                String name = ((TextInputLayout) findViewById(R.id.name_input)).getEditText().toString();
                LogIn.signUp(usrname, pass, email, name);
                inHome();

                //runtime error

                /*if (LogIn.checkSignUpCredentials(active_user)) {
                    setContentView(R.layout.payment_screen);
                    ImageButton payment_method = (ImageButton) findViewById(R.id.MASTERCRD);
                    ImageButton payment_method2 = (ImageButton) findViewById(R.id.PAYPAL);
                    payment_method.setOnClickListener(vmaster -> {
                        payment[0] = "Mastercard";
                    });
                    payment_method2.setOnClickListener(vpaypal -> {
                        payment[0] = "Paypal";
                    });
                    if (LogIn.checkPaymentCredentials(payment, active_user)) {
                        addUserToDatabase();
                        active_user.setAll(usrname, pass, email, name);
                        if (LogIn.Login(active_user)) {
                            //PAYMENT
                            cancel = (Button) findViewById(R.id.cancel_button2);
                            cancel.setOnClickListener(v3 -> {
                                setContentView(R.layout.vehicle_rental_customizer);
                            });
                            inHome();
                        }
                    }

                }*/

            });

        });
    }

    private void Guest_Login(){
        guest_login_butt = (Button) findViewById(R.id.login_guest);
        guest_login_butt.setOnClickListener(vguest -> {
            active_user = LogIn.guestLogIn();
            if(active_user.loginFlag){
                inHome();
            }
        });
    }

    private void LoginError() {

    }

    private void addUserToDatabase() {
    }

    protected void inHome(){ //HOME
        setContentView(R.layout.home_google_map);
        active_user.points = 666;
        dropdown = (ImageButton) findViewById(R.id.dropdown_butt);
        dropdown.setOnClickListener( v2-> {

            //Dropdown
            setContentView(R.layout.home_google_map_dropdown);
            ImageButton dd_drodown;
            dd_drodown = (ImageButton) findViewById(R.id.dropdown_butt2);
            dd_drodown.setOnClickListener(vd -> {
                inHome();
            });

            //go to profile
            dd_profile_button = (ImageButton) findViewById(R.id.profilebuttondropdown);
            dd_profile_button.setOnClickListener(vp ->{
                UserProfile();
            });

            //go to nearest station
            dd_stations_button = (ImageButton) findViewById(R.id.stationsbuttondropdown);
            dd_stations_button.setOnClickListener((vs->{
                setContentView(R.layout.activity_station);
                boolean flag = false;
                do {
                    checkLocation();
                    searchRadius();
                    if (Station.showResults()) {

                    } else {
                        flag = true;
                        show_error("Please turn on your location services");
                        inputLocation();
                        checkLocation();
                        searchRadius();
                        showResults();
                    }

                }while(false);

                Float[] location = active_user.getUserLocation(active_user.id);
                if(location[0]==0.0f && location[1]==0.0f){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please turn on your location services", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    InStation(getNearestStation(location));
                }
            }));

            //go to search station by name
            Button dd_stations_byname = (Button) findViewById(R.id.stationByName);
            dd_stations_byname.setOnClickListener(vsname->{
                setContentView(R.layout.station_by_name);
                EditText station_name = (EditText) findViewById(R.id.station_by_name);
                Button search = (Button) findViewById(R.id.button8);
                search.setOnClickListener(vsearch->{
                    InStation(Station.getStationByName(station_name.toString()));
                });
            });

            //available shops
            dd_shops_button = (ImageButton) findViewById(R.id.shopsbuttondropdown);
            dd_shops_button.setOnClickListener(vshops->{
                setContentView(R.layout.available_shops);
            });

            //go to invitations
            ImageButton dd_invitations_button = (ImageButton) findViewById(R.id.invitationsbuttondropdown);
            dd_invitations_button.setOnClickListener(vinv->{
                setContentView(R.layout.invitations);
                UserInvitations();
            });

            //go to user settings
            ImageButton dd_settings = (ImageButton) findViewById(R.id.settingsdropdown);
            dd_settings.setOnClickListener(vset->{
                setContentView(R.layout.user_settings);
                //EDIT INFO
                Button edit_my_info = (Button) findViewById(R.id.edit_user_info);
                edit_my_info.setOnClickListener(vinfo->{
                    EditUserInfo(active_user);
                });
                // PAST ROUTES
                Button pastpays = (Button) findViewById(R.id.pastpays);
                pastpays.setOnClickListener(vpast->{
                    settingsPayments(active_user);

                    });
                //NOTIFICATIONS
                toggleNotifications(active_user);

                //VEHICLE OPTIONS
                toggleVehicleOptions(active_user);
            });

            // guru
           ImageButton IT = (ImageButton) findViewById(R.id.supp);
           IT.setOnClickListener(vsupp -> {
                setContentView(R.layout.support);

                //FAQ
                Button faq = (Button) findViewById(R.id.FAQ);
                faq.setOnClickListener(vfaq ->{
                    setContentView(R.layout.faq);
                });

                //Livechat
                Button chat = (Button) findViewById(R.id.LIVECHAT);
                chat.setOnClickListener(vchat->{
                    User guru = new User();
                    guru.usrname = "Guru";
                    setContentView(R.layout.live_chat);
                   live_chat(guru);
               });
           });

        });
    }

    private void showResults() {
    }

    private void inputLocation() {
    }

    private void show_error(String s) {
    }

    private void searchRadius() {
    }

    private void checkLocation() {
    }

    private void live_chat(User guru) {
    }

    private void toggleVehicleOptions(User active_user) {
        CheckBox bikes = (CheckBox) findViewById(R.id.podilatacheckBox);
        CheckBox ebikes = (CheckBox) findViewById(R.id.HpodilatacheckBox);
        CheckBox rollers = (CheckBox) findViewById(R.id.PatiniacheckBox);

       bikes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    active_user.flagB=true;
                }else{
                    active_user.flagB=false;
                }
            }
        });
        ebikes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    active_user.flagEB=true;
                }else{
                    active_user.flagEB=false;
                }
            }
        });
        rollers.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    active_user.flagP=true;
                }else{
                    active_user.flagP=false;
                }
            }
        });
    }

    private void toggleNotifications(User active_user) {
        Switch notifications = (Switch) findViewById(R.id.notifications_switch);
        notifications.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(notifications.isChecked()){
                    active_user.flagN = true;
                    notifications.setChecked(true);
                }else{
                    active_user.flagN = false;
                    notifications.setChecked(false);
                }
            }
        });
    }

    private void settingsPayments(User active_user) {
        setContentView(R.layout.pastpays);
        Routes[] routeList = Routes.getPastRoutes(active_user.id);
        Button pay_info = (Button) findViewById(R.id.payinfo);
        pay_info.setOnClickListener(vpinfo->{
            setContentView(R.layout.payment_info_validation);
            ImageButton msc = (ImageButton) findViewById(R.id.MASTERCRD);
            msc.setOnClickListener(vmsc->{
                //Payments.getVer(active_user.payment_info);
                //active_user.setPayment(active_user.payment_info);
                UserProfile();
            });
        });
    }

    private void EditUserInfo(User active_user) {
        setContentView(R.layout.user_info);
        // name edit
        EditText editname = (EditText) findViewById(R.id.editname);
        EditText changepass = (EditText) findViewById(R.id.changepass);
        EditText editemail = (EditText) findViewById(R.id.editemail);

        Button setall = (Button) findViewById(R.id.setall);
        setall.setOnClickListener(vsetall->{
            if(!(editname.toString().equals(""))){
                active_user.setName(editname.toString());
            }
            if(!(changepass.toString().equals(""))){
                active_user.setPass(changepass.toString());
            }
            if(!(editemail.toString().equals(""))){
                active_user.setEmail(editemail.toString());
            }
            setContentView(R.layout.home_google_map);
            inHome();
    });

    }

    protected Station getNearestStation(Float[] loc){

        return stations.get(0);
    }

    protected void UserProfile(){
        setContentView(R.layout.profile);
        ImageButton home = (ImageButton) findViewById(R.id.homeButton);
        home.setOnClickListener(vhome -> {
            setContentView(R.layout.home_google_map);
            inHome();
        });
        ImageButton dropdown_profile = (ImageButton) findViewById(R.id.menuBarProfile);
        dropdown_profile.setOnClickListener(vmenu -> {
            setContentView(R.layout.home_google_map);
            inHome();
        });
        TextView usrname = (TextView) findViewById(R.id.username);
        usrname.setText(String.valueOf(active_user.usrname));
        User user_data = active_user.getUserData();
        for(int count = 0; count<3; count+=1){
            Routes myroute = new Routes( );
            active_user.addRouteToRouteList(myroute);
        }
        Button myroutes = (Button) findViewById(R.id.diadromes);
        myroutes.setOnClickListener(vroutes->{
            setContentView(R.layout.suggested_routes);
            Routes RouteDetails = active_user.getRouteDetails((int)(Math.random() * (100)));
            ImageButton drp = (ImageButton) findViewById(R.id.menuBar2);
            drp.setOnClickListener(vd->{
                setContentView(R.layout.home_google_map);
                inHome();
            });
        });

        Button mypoints = (Button) findViewById(R.id.pontoi);
        mypoints.setOnClickListener(vpoints -> {
            int user_points = active_user.points;
            TextView points = (TextView) findViewById(R.id.userpoints);
            points.setText(Integer.toString(user_points));
            setContentView(R.layout.rewards);
            ImageButton drp = (ImageButton) findViewById(R.id.imageButton);
            drp.setOnClickListener(vd->{
                setContentView(R.layout.home_google_map);
                inHome();
            });
            ImageButton shop = (ImageButton) findViewById(R.id.imageButton4);
            shop.setOnClickListener(vshop->{
                setContentView(R.layout.shop_info);

                int pnts = User.getUserspoints(active_user.id);
                TextView needed = (TextView) findViewById(R.id.textView6);
                if(pnts < Integer.parseInt(needed.getText().toString())){
                    active_user.reduceUsersPoitns(Integer.parseInt(needed.getText().toString()));
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Not enough points!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                ImageButton dr = (ImageButton) findViewById(R.id.imageButton);
                dr.setOnClickListener(vd->{
                    setContentView(R.layout.home_google_map);
                    inHome();
                });
            });
            Button stoix = (Button) findViewById(R.id.stoixeiaButton);
            stoix.setOnClickListener(vs->{
                EditUserInfo(active_user);
            });
            Button plhr = (Button) findViewById(R.id.OiPlirwmesMou) ;
            plhr.setOnClickListener(vp->{
                settingsPayments(active_user);
            });
            home.setOnClickListener(vhome -> {
                setContentView(R.layout.home_google_map);
                inHome();
            });
        });
        toggleNotifications(active_user);
        toggleVehicleOptions(active_user);


        Button mystats = (Button) findViewById(R.id.statistika);
        mystats.setOnClickListener(vstats -> {
            float user_stats = active_user.score;
            setContentView(R.layout.statistics);
            ImageButton drp = (ImageButton) findViewById(R.id.menuBar2);
            drp.setOnClickListener(vd->{
                setContentView(R.layout.home_google_map);
                inHome();
            });
        });

    }

    protected void UserInvitations(){
        Button active = (Button) findViewById(R.id.activeInv);
        active.setOnClickListener(vactive -> {
            ArrayList <Invitations> activeInvs =  Invitations.getActiveInv(active_user.id);
            setContentView(R.layout.active_invitations);
            ImageButton drp = (ImageButton) findViewById(R.id.imageButton16);
            drp.setOnClickListener(vd->{
                setContentView(R.layout.home_google_map);
                inHome();
            });
            Button accept = (Button) findViewById(R.id.accept);
            accept.setOnClickListener(vaccept ->{
                String email =  ((EditText) findViewById(R.id.editTextTextEmailAddress)).getText().toString();
                for(int i=0; i<activeInvs.size(); i++){
                    if(activeInvs.get(i).sender.email.equals(email)){
                        activeInvs.get(i).setAccepted(activeInvs.get(i).id);
                    }
                }
            });
            Button decline = (Button) findViewById(R.id.decline);
            decline.setOnClickListener(vdec->{
                String email =  ((EditText) findViewById(R.id.editTextTextEmailAddress)).getText().toString();
                for(int i=0; i<activeInvs.size(); i++){
                    if(activeInvs.get(i).sender.email.equals(email)){
                        activeInvs.remove(activeInvs.get(i));
                    }
                }
            });
        });

        Button mine = (Button) findViewById(R.id.mineInv);
        mine.setOnClickListener(vmine -> {
            ArrayList <Invitations> myInvs = Invitations.getMyInvs(active_user.id);
            setContentView(R.layout.my_invitations);
            ImageButton drp = (ImageButton) findViewById(R.id.imageButton22);
            drp.setOnClickListener(vd->{
                setContentView(R.layout.home_google_map);
                inHome();
            });
            ImageButton directions = (ImageButton) findViewById(R.id.directions);
            directions.setOnClickListener(vdir ->{
                setContentView(R.layout.activity_station);
                InStation(getNearestStation(active_user.getUserLocation(active_user.id)));
            });
        });

        Button accepted = (Button) findViewById(R.id.accInv);
        accepted.setOnClickListener(vacc ->{
            ArrayList <Invitations> accInvs = Invitations.getAccInv(active_user.id);
            setContentView(R.layout.accepted_invitations);
            ImageButton drp = (ImageButton) findViewById(R.id.imageButton17);
            drp.setOnClickListener(vd->{
                setContentView(R.layout.home_google_map);
                inHome();
            });
            ImageButton dir  =(ImageButton) findViewById(R.id.imageButton23);
            dir.setOnClickListener(vdir ->{
                setContentView(R.layout.activity_station);
                InStation(getNearestStation(active_user.getUserLocation(active_user.id)));
            });
        });

        Button makeInv = (Button) findViewById(R.id.makeInv);
        final String[] way = new String[1];
        makeInv.setOnClickListener(vmake -> {
            setContentView(R.layout.create_invitation);
            ImageButton drp = (ImageButton) findViewById(R.id.imageView32);
            drp.setOnClickListener(vd->{
                setContentView(R.layout.home_google_map);
                inHome();
            });
            Button byname = (Button) findViewById(R.id.OKmail);
            byname.setOnClickListener(vname->{
                EditText fname = (EditText) findViewById(R.id.InputName);
                way[0] = fname.getEditableText().toString(); ;
                Button ok = (Button) findViewById(R.id.OKname);
                ok.setOnClickListener(vok->{
                    User sasuke = User.getResult(way[0]);
                    setContentView(R.layout.my_invitations);
                });
            });
            Button bymail = (Button) findViewById(R.id.button14);
            bymail.setOnClickListener(vmail->{
                EditText fname = (EditText) findViewById(R.id.inputEmail);
                way[0] = fname.getEditableText().toString();
                Button ok = (Button) findViewById(R.id.OKmail);
                ok.setOnClickListener(vok->{
                    User sasuke = User.getResult(way[0]);
                    setContentView(R.layout.my_invitations);
                });
            });
        });

    }

    protected void InStation(Station station) {
        TextView name = (TextView) findViewById(R.id.station_name);
        name.setText(station.location);
        vehicle_button = (Button) findViewById(R.id.vehicle_button);
        vehicle_button.setOnClickListener((vhb -> {
            setContentView(R.layout.vehicle_selection);
            ImageButton drp = (ImageButton) findViewById(R.id.imageView17);
            drp.setOnClickListener(vd->{
                setContentView(R.layout.home_google_map);
                inHome();
            });
            vehicle = (ImageButton) findViewById(R.id.imageButton13);
            vehicle.setOnClickListener(v6 -> {
                setContentView(R.layout.vehicle_rental_customizer);
                //VEHICLE RENTAL CUSTOMIZER
                rent_this = (Button) findViewById(R.id.button5);
                rent_this.setOnClickListener(v7 -> {
                    setContentView(R.layout.payment_screen);
                });

                cancel = (Button) findViewById(R.id.cancel_button3);
                cancel.setOnClickListener(v4 -> {
                    setContentView(R.layout.vehicle_selection);
                    ImageButton dr = (ImageButton) findViewById(R.id.menuBar2);
                    dr.setOnClickListener(vd->{
                        setContentView(R.layout.home_google_map);
                        inHome();
                    });
                });
            });
        }));
    }
}

