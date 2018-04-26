package com.sandiprai.clinicaltrial;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import trial.ClinicalTrial;
import trial.Patient;
import trial.PatientStateActive;

public class AddPatientActivity extends ClinicalTrialActivity {
    ClinicalTrial clinicalTrial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        clinicalTrial = getClinicalTrial();

        //Get the toolbar and assign
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.add_patient);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Adds the patient to the Patient List in the Clinical Trial
     * Method assigned to buttonAddPatientToList
     * @param view the current view
     */
    public void onClickAddToPatientList(View view){
        //Grab the editText field where the user enters the patientId
        EditText editTextPatientId = (EditText) findViewById(R.id.editTextAddPatientId);
        String patientId = editTextPatientId.getText().toString(); //Get the patientId

        if (patientId == null || patientId.equals("")) {// make sure the user has entered a  patient ID
            makeToast("Please enter a patient ID");
        } else if (clinicalTrial.addPatient(patientId)) {
            Patient p = clinicalTrial.findPatient(patientId);
            p.setState(new PatientStateActive(p));
            makeToast("Added! Ready for next patient!");
            editTextPatientId.setText("");
        } else {
            makeToast("That patient is already in this trial.");
        }

    }

    /**
    public void onClickAddReadingsinAddPatient(View view){
        Intent intent = new Intent(AddPatientActivity.this, AddPatientInfoActivity.class);
        startActivity(intent);
    }
    **/

    /**
     *
     * @param view
     */
    public void onClickShowPatientList(View view){
        Intent intent = new Intent(AddPatientActivity.this, PatientListActivity.class);
        startActivity(intent);

    }
    /**
     * Creates toast messages
     * @param message the message in CharSequence to be displayed
     */
    public void makeToast(CharSequence message){
        //Create the context
        Context context = getApplicationContext();
        CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;

        //Create the toast and show it
        Toast toast = Toast.makeText(context,text,duration);
        toast.show();
    }
}
