package com.sandiprai.clinicaltrial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.file.FileAdapter;

import static com.sandiprai.clinicaltrial.AddPatientActivity.clinicalTrial;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
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

    public void onClickImportData(View view){
        FileAdapter fileAdapter = new FileAdapter();
        fileAdapter.getFiles(clinicalTrial);
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        FileAdapter fileAdapter = new FileAdapter();
        fileAdapter.saveState(clinicalTrial);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)   {
        super.onRestoreInstanceState(savedInstanceState);
        FileAdapter fileAdapter = new FileAdapter();
        clinicalTrial = fileAdapter.loadState();
    }
}
