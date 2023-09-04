package com.example.studybuddy.login_and_registration_forms;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.studybuddy.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    EditText usernameText;
    EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginView();
    }

    void registerView(){
        setContentView(R.layout.signup_layout);
        ImageButton BackButton = findViewById(R.id.backbutton);
        BackButton.setOnClickListener(view -> loginView());
    }

    void loginView(){
        setContentView(R.layout.login_layout);
        Button RegisterButton = findViewById(R.id.registerButton);
        RegisterButton.setOnClickListener(view -> registerView());
        Button LoginButton =findViewById((R.id.loginButton));
        LoginButton.setOnClickListener(view -> {
            usernameText = findViewById(R.id.usernameLogin);
            passwordText = findViewById(R.id.passwordLogin);
            if(usernameText.getText().toString().equals("Administrator") && passwordText.getText().toString().equals("studybuddy12345")){
                mainActivity();
            } else {
                Toast.makeText(MainActivity.this, "Please enter valid credentials", Toast.LENGTH_SHORT).show();
            }
        });

    }

    void mainActivity() {
        setContentView(R.layout.activity_main);
        NavigationView navigationView;
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.home_button) {
                toggleVisibility(R.id.home_layout);
            }
            else if(id == R.id.discussion)
            {
                toggleVisibility(R.id.discussion_layout);
            }
            else if(id == R.id.flashcards)
            {
                toggleVisibility(R.id.flashcard_layout);
            }
            else if(id == R.id.account)
            {
                Toast.makeText(MainActivity.this, "Accounts Selected", Toast.LENGTH_LONG).show();
            }
            else if(id == R.id.settings)
            {
                Toast.makeText(MainActivity.this, "Settings Selected", Toast.LENGTH_LONG).show();
            }
            else if(id == R.id.logout)
            {
                loginView();
            }
            return false;
        });
    }

    void toggleVisibility(int _id_){
        LinearLayout linearLayout = findViewById(_id_);
        @SuppressLint("CutPasteId") DrawerLayout drawerLayout1 = findViewById(R.id.drawer_layout);
        for(int i=0; i<drawerLayout1.getChildCount()-1; i++){
            if((drawerLayout1.getChildAt(i) instanceof LinearLayout) && !drawerLayout1.getChildAt(i).equals(_id_)) {
                drawerLayout1.getChildAt(i).setVisibility(View.INVISIBLE);
            }
            linearLayout.setVisibility(View.VISIBLE);
            @SuppressLint("CutPasteId") DrawerLayout navDrawer = findViewById(R.id.drawer_layout);
            navDrawer.closeDrawer(GravityCompat.START);



        }
    }


}