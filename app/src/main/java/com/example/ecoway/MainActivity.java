package com.example.ecoway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.CheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import android.widget.RadioGroup;
import android.widget.TextClock;
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

        //LOGIN
        login_butt = (Button) findViewById(R.id.login_button);
        login_butt.setOnClickListener(vlogin -> {
            //@Override
            String username = ((TextInputEditText) findViewById(R.id.username)).getEditableText().toString();
            String password = ((TextInputEditText) findViewById(R.id.password)).getEditableText().toString();
            active_user = LogIn.signIn(active_user);
            if(active_user.loginFlag){
                setContentView(R.layout.home_google_map);
                inHome();
            }
        });
        //GUEST LOGIN
        guest_login_butt = (Button) findViewById(R.id.login_guest);
        guest_login_butt.setOnClickListener(vguest -> {
            active_user = LogIn.guestLogIn();
            if(active_user.loginFlag){
                setContentView(R.layout.home_google_map);
                inHome();
            }
        });
        //REGISTER
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
                if (LogIn.checkSignUpCredentials(active_user) == true) {

                    setContentView(R.layout.payment_screen);
                    ImageButton payment_method = (ImageButton) findViewById(R.id.MASTERCRD);
                    ImageButton payment_method2 = (ImageButton) findViewById(R.id.PAYPAL);
                    payment_method.setOnClickListener(vmaster -> {
                       payment[0] = "Mastercard";

                    });
                    payment_method2.setOnClickListener(vpaypal -> {
                        payment[0] = "Paypal";
                    });
                    if (LogIn.checkPaymentCredentials(payment, active_user) == true) {
                        //  addUserToDatabase();
                        // }else{
                        //λαθος payment
                        // }
                        // }else{
                        //λαθος creds
                        // }
                        active_user.setAll(usrname, pass, email, name);
                        active_user = LogIn.signIn(active_user);
                        if (active_user.loginFlag) {
                            //PAYMENT
                            cancel = (Button) findViewById(R.id.cancel_button2);
                            cancel.setOnClickListener(v3 -> {
                                setContentView(R.layout.vehicle_rental_customizer);
                            });
                            setContentView(R.layout.home_google_map);
                            inHome();
                        }
                    }

                }

            });

        });
    }

    protected void inHome(){ //HOME
        active_user.points = 666;
        dropdown = (ImageButton) findViewById(R.id.dropdown_butt);
        dropdown.setOnClickListener( v2-> {
            setContentView(R.layout.home_google_map_dropdown);
            ImageButton dd_drodown;
            dd_drodown = (ImageButton) findViewById(R.id.dropdown_butt2);
            dd_drodown.setOnClickListener(vd -> {
                setContentView(R.layout.home_google_map);
                inHome();
            });

            dd_profile_button = (ImageButton) findViewById(R.id.profilebuttondropdown);
            dd_profile_button.setOnClickListener(vp ->{
                UserProfile();
            });

            dd_stations_button = (ImageButton) findViewById(R.id.stationsbuttondropdown);
            dd_stations_button.setOnClickListener((vs->{
                setContentView(R.layout.activity_station);
                Float[] location = active_user.getUserLocation(active_user.id);
                if(location[0]==0.0f && location[1]==0.0f){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please turn on your location services", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    InStation(getNearestStation(location));
                }
            }));

            Button dd_stations_byname = (Button) findViewById(R.id.stationByName);
            dd_stations_byname.setOnClickListener(vsname->{
                setContentView(R.layout.station_by_name);
                EditText station_name = (EditText) findViewById(R.id.station_by_name);
                Button search = (Button) findViewById(R.id.button8);
                search.setOnClickListener(vsearch->{
                    InStation(Station.getStationByName(station_name.toString()));
                });
            });

            dd_shops_button = (ImageButton) findViewById(R.id.shopsbuttondropdown);
            dd_shops_button.setOnClickListener(vshops->{
                setContentView(R.layout.available_shops);
            });

            ImageButton dd_invitations_button = (ImageButton) findViewById(R.id.invitationsbuttondropdown);
            dd_invitations_button.setOnClickListener(vinv->{
                setContentView(R.layout.invitations);
                UserInvitations();
            });

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
                });
                //NOTIFICATIONS
                toggleNotifications(active_user);

                //VEHICLE OPTIONS
                toggleVehicleOptions(active_user);

            });

            ImageButton IT = (ImageButton) findViewById(R.id.supp);
            IT.setOnClickListener(vsupp -> {
                setContentView(R.layout.support);
                Button faq = (Button) findViewById(R.id.FAQ);
                faq.setOnClickListener(vfaq ->{
                    //TODO FAQ screen
                    //setContentView(R.layout.faq);
                });
                Button chat = (Button) findViewById(R.id.LIVECHAT);
                chat.setOnClickListener(vchat->{
                    //TODO Livechat screen
                    User guru = new User();
                    guru.usrname = "Guru";
                    //setContentView(R.layout.livechat);
                    //TODO livechat merthod with user guru
                    //livechat(guru);
                });
            });

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
                Payment.getVer(active_user.payment_info);
                active_user.setPayment(active_user.payment_info);
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
        // TODO Στο register δεν γινεται σωστα display το username
        User user_data = active_user.getUserData();
        for(int count = 0; count<3; count+=1){
            Routes myroute = new Routes( );
            active_user.addRouteToRouteList(myroute);
        }
        Button myroutes = (Button) findViewById(R.id.diadromes);
        myroutes.setOnClickListener(vroutes->{
            setContentView(R.layout.suggested_routes);
            Routes RouteDetails = active_user.getRouteDetails((int)(Math.random() * (100)));
        });

        Button mypoints = (Button) findViewById(R.id.pontoi);
        mypoints.setOnClickListener(vpoints -> {
            int user_points = active_user.points;
            TextView points = (TextView) findViewById(R.id.userpoints);
            points.setText(Integer.toString(user_points));
            setContentView(R.layout.rewards);
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
        });

    }

    protected void UserInvitations(){
        Button active = (Button) findViewById(R.id.activeInv);
        active.setOnClickListener(vactive -> {
            ArrayList <Invitations> activeInvs =  Invitations.getActiveInv(active_user.id);
            setContentView(R.layout.active_invitations);
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
            vehicle = (ImageButton) findViewById(R.id.imageButton13);
            vehicle.setOnClickListener(v6 -> {
                setContentView(R.layout.vehicle_rental_customizer);
                //VEHICLE RENTAL CUSTOMIZER
                rent_this = (Button) findViewById(R.id.button5);
                rent_this.setOnClickListener(v7 -> {
                    setContentView(R.layout.payment_screen);
                    //VEHICLE RENTAL CUSTOMIZER
                    cancel = (Button) findViewById(R.id.cancel_button3);
                    cancel.setOnClickListener(v4 -> {
                        setContentView(R.layout.vehicle_selection);
                    });
                });
            });
        }));
    }
}

