package com.sandiprai.clinicaltrial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import trial.Patient;
import trial.PatientStateActive;
import trial.PatientStateCompleted;
import trial.PatientStateFailed;
import trial.PatientStateWithdrawn;

import static com.sandiprai.clinicaltrial.AddPatientActivity.clinicalTrial;

public class PatientListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);

        //Grab the spinner
        final Spinner patientListSpinner = (Spinner) findViewById(R.id.spinnerPatientIdinPatientList);
        ArrayAdapter<Patient> adapter= new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                clinicalTrial.getAllPatients());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        patientListSpinner.setAdapter(adapter);

        //Status spinner
        final Spinner patientStatusSpinner = (Spinner) findViewById(R.id.spinnerStatusPatientList);
        final ArrayAdapter<CharSequence> adapterStatus= ArrayAdapter.createFromResource(this,
                R.array.statusList, android.R.layout.simple_spinner_item);
        adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        patientStatusSpinner.setAdapter(adapterStatus);

        //Update status spinner on patient spinner selection
        patientListSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (clinicalTrial.getAllPatients().size()>0) {
                    Patient p = (Patient) patientListSpinner.getSelectedItem();
                    String state = p.getState().toString();
                    if (state != null) {
                        int spinnerPosition = adapterStatus.getPosition(state);
                        patientStatusSpinner.setSelection(spinnerPosition);
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        })
        ;

        //Update patient state on status spinner selection
        patientStatusSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (clinicalTrial.getAllPatients().size()>0) {
                    Patient p = (Patient) patientListSpinner.getSelectedItem();

                    switch ((String) patientStatusSpinner.getSelectedItem()) {
                        case "Active":
                            p.setState(new PatientStateActive(p));
                            break;
                        case "Withdrawn":
                            p.setState(new PatientStateWithdrawn(p));
                            break;
                        case "Failed":
                            p.setState(new PatientStateFailed(p));
                            break;
                        case "Completed":
                            p.setState(new PatientStateCompleted(p));
                            break;
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    /**
     * Method that passes the intent from PatientList to AddPatientInfo activity
     * @param view
     */
    public void onClickAddNewReadingsinPatientList(View view){
        //Grab the spinner
        Spinner patientListSpinner = (Spinner) findViewById(R.id.spinnerPatientIdinPatientList);
        Spinner patientStatusSpinner = (Spinner) findViewById(R.id.spinnerStatusPatientList);

        if(patientListSpinner.getSelectedItem() != null &&
                patientStatusSpinner.getSelectedItem().equals("Active")){//Check if patient is selected or not
            //Get the selected patientId
            String patientId = patientListSpinner.getSelectedItem().toString();
            //Create an intent
            Intent intent = new Intent(PatientListActivity.this,
                    AddPatientInfoActivity.class);
            //Pass the patientId to the PatientReadingActivity
            intent.putExtra(AddPatientInfoActivity.PATIENTID,patientId);
            startActivity(intent); //Start the intent to move to the PatientReadingActivity
        }else if (patientListSpinner.getSelectedItem() != null &&
                !patientStatusSpinner.getSelectedItem().equals("Active")) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Add Readings only for Active Patients",Toast.LENGTH_SHORT);
            toast.show();
        }else{//Show the error message
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please select a patient. Add if no patient.",Toast.LENGTH_SHORT);
            toast.show();
        }


    }

    /**
     * buttonShowPatientReading calls this method
     * Method that passes the intent from PatientList to AddPatientInfo activity
     * @param view
     */
    public void onClickShowPatientReading(View view){
        //Grab the spinner
        Spinner patientListSpinner = (Spinner) findViewById(R.id.spinnerPatientIdinPatientList);
        Spinner patientStatusSpinner = (Spinner) findViewById(R.id.spinnerStatusPatientList);


        if(patientListSpinner.getSelectedItem() != null &&
                patientStatusSpinner.getSelectedItem().equals("Active")){//Check if patient is selected or not
            //Get the selected patientId
            String patientId = patientListSpinner.getSelectedItem().toString();
            //Create an intent
            Intent intent = new Intent(PatientListActivity.this,
                    PatientReadingsActivity.class);
            //Pass the patientId to the PatientReadingActivity
            intent.putExtra(PatientReadingsActivity.SELECTED_PATIENTID,patientId);
            startActivity(intent); //Start the intent to move to the PatientReadingActivity
        }else if (patientListSpinner.getSelectedItem() != null &&
                !patientStatusSpinner.getSelectedItem().equals("Active")) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Readings shown only for Active Patients",Toast.LENGTH_SHORT);
            toast.show();
        }
        else{//Show the error message
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please select a patient. Add if no patient.",Toast.LENGTH_SHORT);
            toast.show();
        }

    }

}
