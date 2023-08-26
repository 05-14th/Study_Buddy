package com.example.studybuddy.login_and_registration_forms;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import com.example.studybuddy.R;

public class UserAccountForm extends AppCompatActivity {
    EditText usernameText;
    EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginView();
    }

    void registerView(){
        setContentView(R.layout.signup_layout);
        Button BackButton = findViewById(R.id.backbutton);
        BackButton.setOnClickListener(view -> loginView());
    }

    void loginView(){
        setContentView(R.layout.login_layout);
        Button RegisterButton = findViewById(R.id.registerButton);
        RegisterButton.setOnClickListener(view -> registerView());
        Button LoginButton =findViewById((R.id.loginButton));
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernameText = findViewById(R.id.usernameLogin);
                passwordText = findViewById(R.id.passwordLogin);
                if(usernameText.getText().toString().equals("Administrator") && passwordText.getText().toString().equals("studybuddy12345")){
                    setContentView(R.layout.activity_main);
                }
            }
        });

    }


}