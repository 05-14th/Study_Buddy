package com.example.studybuddy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.home_button) {
                Toast.makeText(MainActivity.this, "Home Selected", Toast.LENGTH_LONG).show();
            }
            else if(id == R.id.discussion)
            {
                Toast.makeText(MainActivity.this, "Discussion Selected", Toast.LENGTH_LONG).show();
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
        }});

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
        super.onBackPressed();
    }
}
