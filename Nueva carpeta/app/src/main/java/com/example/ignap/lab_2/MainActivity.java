package com.example.ignap.lab_2;

import android.app.Fragment;
import android.arch.persistence.room.Room;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    private static final String DATABASE_NAME = "form_db";
    private FormDatabase formDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        formDatabase = Room.databaseBuilder(getApplicationContext(),FormDatabase.class, DATABASE_NAME).build();




        getSupportFragmentManager();


        mDrawerLayout = findViewById(R.id.drawer_layout);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        final FragmentManager fragmentManager = getSupportFragmentManager();
                        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


                        int id = menuItem.getItemId();
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();
                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        if (id == R.id.nav_first){
                            fragmentTransaction.replace(R.id.content_frame, new FormularioFragment());
                            fragmentTransaction.commit();
                        }
                        else if (id == R.id.nav_second){
                            fragmentTransaction.replace(R.id.content_frame, new ResumenFragment());
                            fragmentTransaction.commit();
                        }
                        else if (id == R.id.nav_third) {
                            fragmentTransaction.replace(R.id.content_frame, new NewFormularioFragment());
                            fragmentTransaction.commit();
                        }


                        return true;
                    }
                });
    }

}

