package com.example.ecoway;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.plus.model.people.Person;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import android.widget.TextView;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_start);

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
                active_user.setAll(usrname, pass, email, name);
                active_user = LogIn.signIn(active_user);
                if(active_user.loginFlag){
                    setContentView(R.layout.home_google_map);
                    inHome();
                }
            });
            //setContentView(R.layout.payment_screen);
            //PAYMENT
            //cancel = (Button) findViewById(R.id.cancel_button2);
            // cancel.setOnClickListener(v3 -> {
            // setContentView(R.layout.vehicle_rental_customizer);
            // });
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
                InStation();
            }));

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
                // TODO settings
            });

        });
        // Μεχρι να συνδέσουμε τα activities, καντε uncomment τις γραμμές που δε θελετε
        // setContentView(R.layout.activity_station);
        //setContentView(R.layout.payment_screen);
        //setContentView(R.layout.suggested_routes);
        //setContentView(R.layout.shop_info);
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
            home.setOnClickListener(vhome -> {
                setContentView(R.layout.home_google_map);
                inHome();
            });
        });

        //Button spend_points = (Button) findViewById(R.id.personal_points);
        //spend_points.setOnClickListener(vspend -> {
            //setContentView(R.layout.rewards);
            //TODO: οθόνη πόντων UI
            //TODO: από την οθόνη πόντων παει στο Εξαργυρωση πόντων στο κατάστημα
        //});

        Button mystats = (Button) findViewById(R.id.statistika);
        mystats.setOnClickListener(vstats -> {
            float user_stats = active_user.score;
            setContentView(R.layout.statistics);
            // TODO: οθόνη στατιστικών χρήστη - doing it Spyros
        });

    }

    protected void UserInvitations(){
        Button active = (Button) findViewById(R.id.activeInv);
        active.setOnClickListener(vactive -> {
            ArrayList <Invitations> activeInvs =  Invitations.getActiveInv(active_user.id);
            //TODO active invitations screen
        });

        Button mine = (Button) findViewById(R.id.mineInv);
        mine.setOnClickListener(vmine -> {
            ArrayList <Invitations> myInvs = Invitations.getMyInvs(active_user.id);
            //TODO my invitations screen
        });

        Button accepted = (Button) findViewById(R.id.accInv);
        accepted.setOnClickListener(vacc ->{
            ArrayList <Invitations> accInvs = Invitations.getAccInv(active_user.id);
            //TODO active invitations screen
            //TODO accept/decline
        });

        Button makeInv = (Button) findViewById(R.id.makeInv);
        makeInv.setOnClickListener(vmake -> {
            //TODO input name/email for invitations screen

        });

    }

    protected void InStation() {
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

