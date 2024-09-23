package com.example.jobportalplacement;

import android.content.Intent;
import android.graphics.ImageFormat;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nav = findViewById(R.id.nav_view);



        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id=menuItem.getItemId();
                if (id==R.id.nav_home){
                    Intent i1=new Intent(getApplicationContext(), Home.class);
                    startActivity(i1);
                    Toast.makeText(MainActivity.this, "Click to main item", Toast.LENGTH_SHORT).show();
                }
                if (id==R.id.nav_settings){
                    Intent i2=new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i2);
                }  if (id==R.id.nav_share){
                    Intent i3=new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i3);
                }
                if (id==R.id.nav_logout){
                    Intent i4=new Intent(getApplicationContext(), Login.class);
                    startActivity(i4);
                    Toast.makeText(MainActivity.this, "Logged Out", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        final DrawerLayout drawerLayout = findViewById(R.id.main);
        findViewById(R.id.nav_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        ImageView imageView=findViewById(R.id.img);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        ImageView navimg = findViewById(R.id.nav_img);
        navimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(intent);
                finish();
            }
        });


    }

}