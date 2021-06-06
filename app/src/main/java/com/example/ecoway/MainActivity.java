package com.example.ecoway;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputEditText;

import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    private Button login_butt;
    private Button guest_login_butt;
    private Button register_butt;
    private Button register_user;
    private Button cancel;
    private Button rent_this;
    private Button vehicle_type;
    private ImageButton vehicle;
    private ImageButton dropdown;
    private ImageButton dd_profile_button;
    private ImageButton dd_stations_button;
    private ImageButton dd_shops_button;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_start);
        //LOGINS
        login_butt = (Button) findViewById(R.id.login_button);
        login_butt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){}

            String username = ((TextInputEditText) findViewById(R.id.username)).getEditableText().toString();
            String password = ((TextInputEditText) findViewById(R.id.password)).getEditableText().toString();
            Boolean flg = false;
            {System.out.println(username);}
            { flg = Register.findUser(username, password); }

            {
                if (flg) {
                    setContentView(R.layout.home_google_map);
                }
            }
        });
        //GUEST LOGIN
        guest_login_butt = (Button) findViewById(R.id.login_guest);
        guest_login_butt.setOnClickListener(v -> {
            setContentView(R.layout.home_google_map);
               //HOME
                dropdown = (ImageButton) findViewById(R.id.dropdown_butt);
                dropdown.setOnClickListener( v2-> {
                    setContentView(R.layout.home_google_map_dropdown);
                    dd_profile_button = (ImageButton) findViewById(R.id.profilebuttondropdown);
                    dd_profile_button.setOnClickListener(vp ->{
                        setContentView(R.layout.profile);
                    });
                    dd_stations_button = (ImageButton) findViewById(R.id.stationsbuttondropdown);
                    dd_stations_button.setOnClickListener((vs->{
                        setContentView(R.layout.activity_station);
                    }));
                    dd_shops_button = (ImageButton) findViewById(R.id.shopsbuttondropdown);
                    dd_shops_button.setOnClickListener(vh->{
                        setContentView(R.layout.available_shops);
                    });

                });

            setContentView(R.layout.vehicle_rental_customizer);
            //VEHICLE RENTAL CUSTOMIZER
                cancel = (Button) findViewById(R.id.cancel_button3);
            cancel.setOnClickListener(v4 -> {
                setContentView(R.layout.vehicle_selection);
            });
            setContentView(R.layout.vehicle_rental_customizer);
            //VEHICLE RENTAL CUSTOMIZER
            rent_this = (Button) findViewById(R.id.button5);
            rent_this.setOnClickListener(v7 -> {
                setContentView(R.layout.payment_screen);
            });

            setContentView(R.layout.activity_station);
            //ACTIVITY STATION
                vehicle_type = (Button) findViewById(R.id.button2);
                vehicle_type.setOnClickListener(v5 -> {
                    setContentView(R.layout.vehicle_selection);
                });
                setContentView(R.layout.vehicle_selection);
                vehicle = (ImageButton) findViewById(R.id.imageButton13);
                vehicle.setOnClickListener(v6 -> {
                    setContentView(R.layout.vehicle_rental_customizer);
                });
        });
        //REGISTER
        register_butt = (Button) findViewById(R.id.register_button);
        register_butt.setOnClickListener(v -> {
            setContentView(R.layout.register);
            register_user = (Button) findViewById(R.id.register_user_butt);
            register_user.setOnClickListener(v1 -> {
                //String usrname = ((TextInputEditText)findViewById(R.id.username_input)).getEditableText().toString();
                //String pass = ((TextInputEditText)findViewById(R.id.pass_input)).getEditableText().toString();
                //String email = ((TextInputEditText) findViewById(R.id.email_input)).getEditableText().toString();
                //String name = ((TextInputEditText) findViewById(R.id.name_input)).getEditableText().toString();
               // Register.registerUser(usrname, pass, email, name);
                setContentView(R.layout.log_in_start);

            });
            setContentView(R.layout.payment_screen);
            //PAYMENT
            cancel = (Button) findViewById(R.id.cancel_button2);
            cancel.setOnClickListener(v3 -> {
                setContentView(R.layout.vehicle_rental_customizer);
            });
        });





        // Μεχρι να συνδέσουμε τα activities, καντε uncomment τις γραμμές που δε θελετε
        // setContentView(R.layout.activity_station);
        //setContentView(R.layout.profile);
        //setContentView(R.layout.rewards);
        //setContentView(R.layout.available_shops);
        //setContentView(R.layout.payment_screen);
        //setContentView(R.layout.suggested_routes);
        //TODO suggested routes
        //setContentView(R.layout.vehicle_selection);
        //setContentView(R.layout.shop_info);

    }

}
