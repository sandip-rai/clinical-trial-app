package com.sandiprai.clinicaltrial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

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

    /**
     * buttonShowPatientReading calls this method
     * Method that passes the intent from PatientList to AddPatientInfo activity
     * @param view
     */
    public void onClickShowPatientReading(View view){
        //Grab the spinner
        Spinner patientListSpinner = (Spinner) findViewById(R.id.spinnerPatientIdinPatientList);


        if(!patientListSpinner.getSelectedItem().equals(null)){//Check if patient is selected or not
            //Get the selected patientId
            String patientId = patientListSpinner.getSelectedItem().toString();
            //Create an intent
            Intent intent = new Intent(PatientListActivity.this, PatientReadingsActivity.class);
            //Pass the patientId to the PatientReadingActivity
            intent.putExtra(PatientReadingsActivity.SELECTED_PATIENTID,patientId);
            startActivity(intent); //Start the intent to move to the PatientReadingActivity
        } else{//Show the error message
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please select a patient. Add if no patient.",Toast.LENGTH_SHORT);
            toast.show();
        }

    }

}
