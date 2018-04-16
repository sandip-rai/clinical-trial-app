package com.sandiprai.clinicaltrial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import trial.Patient;

public class PatientListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);

        //Grab the spinner
        Spinner patientListSpinner = (Spinner) findViewById(R.id.spinnerPatientIdinPatientList);
        ArrayAdapter<Patient> adapter= new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                AddPatientActivity.clinicalTrial.getAllPatients());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        patientListSpinner.setAdapter(adapter);
    }

    /**
     * Method that passes the intent from PatientList to AddPatientInfo activity
     * @param view
     */
    public void onClickAddNewReadingsinPatientList(View view){
        Intent intent = new Intent(PatientListActivity.this,
                AddPatientInfoActivity.class);
        startActivity(intent);

    }

}
