package com.sandiprai.clinicaltrial;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import trial.Clinic;

import static com.sandiprai.clinicaltrial.AddPatientActivity.clinicalTrial;

public class AddClinicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clinic);
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
        } else {
            makeToast("Clinic exists already.");
        }

    }

    public void onClickBackinAddClinic(View view){
        Intent intent = new Intent(AddClinicActivity.this, AddPatientInfoActivity.class);
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
