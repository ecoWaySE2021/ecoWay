package com.example.ecoway;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    private Button login_butt;
    private Button guest_login_butt;
    private Button register_butt;
    Register reg = new Register();

    public MainActivity() throws NoSuchAlgorithmException {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_start);

        login_butt = (Button) findViewById(R.id.login_button);
        login_butt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){}

            String username = ((TextInputEditText) findViewById(R.id.username)).getEditableText().toString();
            String password = ((TextInputEditText) findViewById(R.id.password)).getEditableText().toString();
            Boolean flg = false;

            {
                try {
                    flg = reg.findUser(username, password);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }

            {
                if (this.flg) {
                    setContentView(R.layout.home_google_map);
                }
            }
        });

        guest_login_butt = (Button) findViewById(R.id.login_guest);
        guest_login_butt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setContentView(R.layout.home_google_map);
            }
        });

        register_butt = (Button) findViewById(R.id.register_button);
        register_butt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setContentView(R.layout.register);
                Button register_user = (Button) findViewById(R.id.register_user_butt);
                register_user.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        String usrname = ((TextInputEditText) findViewById(R.id.username_input)).getEditableText().toString();
                        String pass = ((TextInputEditText) findViewById(R.id.pass_input)).getEditableText().toString();
                        String email = ((TextInputEditText) findViewById(R.id.email_input)).getEditableText().toString();
                        String name = ((TextInputEditText) findViewById(R.id.name_input)).getEditableText().toString();
                        try {
                            reg.registerUser(usrname, pass, email, name);
                            setContentView(R.layout.log_in_start);
                        } catch (NoSuchAlgorithmException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
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
