package com.sandiprai.clinicaltrial;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.file.FileAdapter;

import trial.SystemSettings;

public class MainMenuActivity extends ClinicalTrialActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(readAllowed()){
            FileAdapter fileAdapter = new FileAdapter();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //Get the toolbar and assign
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle.setText(R.string.app_name);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view1);
        navigationView.setNavigationItemSelectedListener(this);


    }



    /**
     * Method to run when buttonAddPatient is clicked
     * Creates and starts an intent to move from MainMenuActivity to AddPatientActivity
     * @param view
     */
    public void onClickAddPatient(View view){
        //Create the intent
        Intent intent = new Intent(MainMenuActivity.this,
                AddPatientActivity.class);
        startActivity(intent); //Start the intent
    }

    /**
     * Method to run when buttonAddClinic is clicked
     * Creates and starts an intent to move from MainMenuActivity to AddClinicActivity
     * @param view
     */
    public void onClickAddClinic(View view){
        //Create the intent
        Intent intent = new Intent(MainMenuActivity.this,
                AddClinicActivity.class);
        startActivity(intent); //Start the intent
    }

    /**
     * Method to run when buttonAddPatientInfo is clicked
     * Creates and starts an intent to move from MainMenuActivity to AddPatientInfoActivity
     * @param view
     */
    public void onClickAddPatientInfo(View view){
        //Create the intent
        Intent intent = new Intent(MainMenuActivity.this,
                AddPatientInfoActivity.class);
        startActivity(intent); //Start the intent
    }

    /**
     * Method to run when buttonPatientList is clicked
     * Creates and starts an intent to move from MainMenuActivity to PatientListActivity
     * @param view
     */
    public void onClickPatientList(View view){
        //Create the intent
        Intent intent = new Intent(MainMenuActivity.this,
                PatientListActivity.class);
        startActivity(intent); //Start teh intent
    }

    public void onClickSystemSettings(View view){
        //Create the intent
        Intent intent = new Intent(MainMenuActivity.this,
                SystemSettingsActivity.class);
        startActivity(intent); //Start the intent
    }

    public void onClickImportData(View view) {
        if (readAllowed()) {
            FileAdapter fileAdapter = new FileAdapter();
            fileAdapter.getFiles(clinicalTrial);
        }
    }

    public void onClickExportData(View view) {
        if (writeAllowed()) {
            FileAdapter fileAdapter = new FileAdapter();
            fileAdapter.writeFile(clinicalTrial);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        int id = item.getItemId();
        Intent intent = null;

        switch (id){
            case R.id.nav_add_patient:
                intent = new Intent(this, AddPatientActivity.class);
                break;
            case R.id.nav_add_clinic:
                intent = new Intent(this,AddClinicActivity.class);
                break;
            case R.id.nav_add_readings:
                intent = new Intent(this,PatientListActivity.class);
                break;
            case R.id.nav_patient_list:
                intent = new Intent(this,PatientListActivity.class);
                break;
            case R.id.nav_import_data:
                //intent = new Intent(this,ImportDataActivity.class);
                break;
            case R.id.nav_export_data:
                //intent = new Intent(this,ImportDataActivity.class);
                break;
            case R.id.nav_system_settings:
                intent = new Intent(this, SystemSettingsActivity.class);
                break;

        }

        if(intent != null){
            startActivity(intent);
        }

        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
