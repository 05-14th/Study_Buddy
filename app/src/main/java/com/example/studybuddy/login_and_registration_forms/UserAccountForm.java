package com.example.studybuddy.login_and_registration_forms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studybuddy.R;

public class UserAccountForm extends AppCompatActivity {

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
    }
}