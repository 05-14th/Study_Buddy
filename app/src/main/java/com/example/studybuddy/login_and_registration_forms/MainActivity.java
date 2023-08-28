package com.example.studybuddy.login_and_registration_forms;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.studybuddy.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    EditText usernameText;
    EditText passwordText;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

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
                    mainActivity();
                }
            }
        });

    }

    void mainActivity() {
        setContentView(R.layout.activity_main);
        NavigationView navigationView;
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
                    Toast.makeText(MainActivity.this, "Flashcards Selected", Toast.LENGTH_LONG).show();
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
                    Toast.makeText(MainActivity.this, "Logout Selected", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });
    }

    void toggleVisibility(int _id_){
        LinearLayout linearLayout = findViewById(_id_);
        DrawerLayout drawerLayout1 = findViewById(R.id.drawer_layout);
        for(int i=0; i<drawerLayout1.getChildCount()-1; i++){
            if((drawerLayout1.getChildAt(i) instanceof LinearLayout) && !drawerLayout1.getChildAt(i).equals(_id_)) {
                drawerLayout1.getChildAt(i).setVisibility(View.INVISIBLE);
            }
            linearLayout.setVisibility(View.VISIBLE);
            DrawerLayout navDrawer = findViewById(R.id.nav_drawer);
            navDrawer.closeDrawer(GravityCompat.START);



        }
    }


}