package com.cryptoTRX.gabriel.cryptoconvert;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class termsActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;



    public  void openTerms()
    {
        Intent intent = new Intent(this,termsActivity.class);
        startActivity(intent);
    }

    public  void openSupport()
    {
        Intent intent = new Intent(this,supportActivity.class);
        startActivity(intent);
    }

    public  void openHome()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);
        drawerLayout= findViewById(R.id.drawer_layout);
        navigationView= findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.icon_home :
                        menuItem.setChecked(true);
                        openHome();
                        //drawerLayout.closeDrawers();
                        break;

                    case R.id.icon_support:
                        menuItem.setChecked(true);
                        openSupport();
                        //drawerLayout.closeDrawers();
                        break;
                    case R.id.icon_terms:
                        menuItem.setChecked(true);
                        openTerms();
                        //drawerLayout.closeDrawers();
                        break;

                }




                return false;
            }
        });
    }




}
