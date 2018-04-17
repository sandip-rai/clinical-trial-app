package com.sandiprai.clinicaltrial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import trial.Patient;
import trial.Reading;

public class PatientReadingsActivity extends AppCompatActivity {
    //Used for the intent putExtra()
    public static final String SELECTED_PATIENTID = "patientId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_readings);

        //Get the Patient object using the selected_patientId
        String selectedPatientId = (String)getIntent().getExtras().get(SELECTED_PATIENTID);
        Patient patient = AddPatientActivity.clinicalTrial.findPatient(selectedPatientId);

        //Fill the textView with the selectedPatient
        TextView textViewPatientId = (TextView) findViewById(R.id.textViewPatientIdinPatientReadings);
        textViewPatientId.setText(selectedPatientId);

        //Create an AdapterArray to hold the Readings ArrayList of the Patient
        ArrayAdapter<Reading> listAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,patient.getReadings());
        //Get the listView and set the adapter
        ListView listReadings = (ListView) findViewById(R.id.list_patient_readings);
        listReadings.setAdapter(listAdapter);
    }
}
