package com.sandiprai.clinicaltrial;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import trial.Clinic;
import trial.Patient;

public class AddPatientInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_info);

        //Grab the spinner
        Spinner patientListSpinner = (Spinner) findViewById(R.id.spinnerReadingPatientId);
        ArrayAdapter<Patient> adapter= new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                AddPatientActivity.clinicalTrial.getAllPatients());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        patientListSpinner.setAdapter(adapter);
    }

    public void onClickAddReadingsToSelectedPatient(View view){
        //get selected patients id from spinner and pass it to clinicalTrial to find that patient
        Spinner patientListSpinner = (Spinner) findViewById(R.id.spinnerReadingPatientId);
        String patientId = patientListSpinner.getSelectedItem().toString();
        Patient patient = AddPatientActivity.clinicalTrial.findPatient(patientId);

        //get selected reading type from spinner
        Spinner readingTypeSpinner = (Spinner) findViewById(R.id.spinnerReadingType);
        String readingType = readingTypeSpinner.getSelectedItem().toString();

        EditText editTextReadingId = (EditText) findViewById(R.id.editTextReadingId);
        String readingId = editTextReadingId.getText().toString();

        EditText editTextDate = (EditText) findViewById(R.id.editTextDate);
        String textDate = editTextDate.getText().toString();

        EditText editTextValue = (EditText) findViewById(R.id.editTextValue);
        String value = editTextValue.getText().toString();

        EditText editTextClinic = (EditText) findViewById(R.id.editTextClinic);
        String clinicId = editTextClinic.getText().toString();
        Clinic clinic = AddPatientActivity.clinicalTrial.findClinic(clinicId);

        String dateFormat =  AddPatientActivity.clinicalTrial.getSettings().getDateFormat();
        if (value.equals("") || textDate.equals("") || readingId.equals("") || clinicId.equals("")) {
            makeToast( "Please fill in the values for every field.");
        } else { // If all values are filled, add them to to corresponding Patient
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
            Date date = null; // Change date from String to Date
            try {
                date = formatter.parse(textDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // add the new readings to that patient
            if (patient.addReading(readingId,readingType, value, date, clinic)) {
                makeToast(  "New reading has been added."); //Prompt if the reading is added
                editTextReadingId.setText("");
                editTextDate.setText("");
                editTextValue.setText("");
                editTextClinic.setText("");
            } else {
                makeToast(  "Invalid reading."); //Prompt if patient is not active in trial
            }
        }

    }

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
