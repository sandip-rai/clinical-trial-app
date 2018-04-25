package com.sandiprai.clinicaltrial;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import trial.Clinic;
import trial.ClinicalTrial;

public class AddClinicActivity extends ClinicalTrialActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clinic);
        clinicalTrial = getClinicalTrial();
    }

    public void onClickAddToClinicList(View view){
        //Grab the editText field where the user enters the patientId
        EditText editTextClinicId = (EditText) findViewById(R.id.editTextClinicIdinAddClinic);
        EditText editTextClinicName = (EditText) findViewById(R.id.editTextClinicNameinAddClinic);
        String clinicId = editTextClinicId.getText().toString(); //Get the clinicId
        String clinicName = editTextClinicName.getText().toString(); //Get the clinicName
        //Try to add the clinic, if added returns the clinic,else returns null
        Clinic tempClinic = clinicalTrial.addClinic(clinicName,clinicId);

        // make sure the user has entered in the fields
        if ((clinicName == null || clinicName.equals(""))) {
            makeToast("Please fill the Clinic Name");
        } else if ( tempClinic != null) {
            //clinicalTrial.findPatient(patientId).setActive(true);
            makeToast("Successfully Added!");
            editTextClinicId.setText("");
            editTextClinicName.setText("");
        } else {
            makeToast("Clinic exists already.");
        }

    }

   public void onClickPatientListinAddClinic(View view){
        Intent intent = new Intent(AddClinicActivity.this, PatientListActivity.class);
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
