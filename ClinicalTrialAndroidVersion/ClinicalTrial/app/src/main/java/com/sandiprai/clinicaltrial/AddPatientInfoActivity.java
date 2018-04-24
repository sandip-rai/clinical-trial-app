package com.sandiprai.clinicaltrial;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import trial.Clinic;
import trial.Patient;

public class AddPatientInfoActivity extends AppCompatActivity {
    //Used for the intent putExtra()
    public static final String PATIENTID = "patientId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_info);

        //Get the Patient object using the PATIENTID and fill it to patientIdTextView
        String selectedPatientId = (String)getIntent().getExtras().get(PATIENTID);
        TextView patientIdText = (TextView) findViewById(R.id.textViewPatientId);
        patientIdText.setText(selectedPatientId);

        /**
         //Grab the spinner for PatientList
         Spinner patientListSpinner = (Spinner) findViewById(R.id.spinnerReadingPatientId);
         ArrayAdapter<Patient> adapter= new ArrayAdapter<>(this,
         android.R.layout.simple_spinner_item,
         AddPatientActivity.clinicalTrial.getAllPatients());
         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         patientListSpinner.setAdapter(adapter);
         **/

        //Grab the spinner for ClinicList
        Spinner clinicListSpinner = (Spinner) findViewById(R.id.spinnerClinicId);
        ArrayAdapter<Clinic> clinicListAdapter= new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                AddPatientActivity.clinicalTrial.getAllClinics());
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clinicListSpinner.setAdapter(clinicListAdapter);

    }

    public void onClickAddReadingsToSelectedPatient(View view){
        //get selected patients id from spinner and pass it to clinicalTrial to find that patient
        //Spinner patientListSpinner = (Spinner) findViewById(R.id.spinnerReadingPatientId);
        //String patientId = patientListSpinner.getSelectedItem().toString();

        //Get the patientId from the textView which is passed from PatientListActivity
        TextView patientIdText = (TextView) findViewById(R.id.textViewPatientId);
        String patientId = patientIdText.getText().toString();
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

        Spinner spinnerClinicId = (Spinner) findViewById(R.id.spinnerClinicId);
        String clinicInSpinner = null;
        String[] clinicArray;
        String clinicId = null;
        try {
            clinicInSpinner = spinnerClinicId.getSelectedItem().toString();
            clinicArray = clinicInSpinner.split(":");
            clinicId = clinicArray[0];
        } catch (NullPointerException e) {
            makeToast("Patient is not currently active.");
        }

        Clinic clinic = AddPatientActivity.clinicalTrial.findClinic(clinicId);

        String dateFormat =  AddPatientActivity.clinicalTrial.getSettings().getDateFormat();
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Date date = null; // Change date from String to Date
        try {
            date = formatter.parse(textDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (value.equals("") || textDate.equals("") || readingId.equals("") || clinicId.equals("")) {
            makeToast( "Please fill in the values for every field.");
        } else if(clinicInSpinner ==  null){
            makeToast( "Please select/add a clinic.");
        } else if(date == null){
            makeToast("Please enter date in a correct format");
        } else if (!patient.getState().toString().equals("Active")){
            makeToast("Patient is not currently active.");
        } else {
            // add the new readings to that patient
            if (patient.addReading(readingId,readingType, value, date, clinic)) {
                makeToast(  "New reading has been added."); //Prompt if the reading is added
                editTextReadingId.setText("");
                editTextDate.setText("");
                editTextValue.setText("");
            }
        }
    }

    public void onClickAddClinicinAddPatientInfo(View view){
        Intent intent = new Intent(AddPatientInfoActivity.this,AddClinicActivity.class);
        startActivity(intent);
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