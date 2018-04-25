package com.sandiprai.clinicaltrial;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import trial.Patient;
import trial.Reading;

public class PatientReadingsActivity extends ClinicalTrialActivity {
    //Used for the intent putExtra()
    public static final String SELECTED_PATIENTID = "patientId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_readings);
        clinicalTrial = getClinicalTrial();

        //Get the Patient object using the selected_patientId
        String selectedPatientId = (String)getIntent().getExtras().get(SELECTED_PATIENTID);
        Patient patient = clinicalTrial.findPatient(selectedPatientId);

        //Fill the textView with the selectedPatient
        TextView textViewPatientId = (TextView) findViewById(R.id.textViewPatientIdinPatientReadings);
        textViewPatientId.setText(selectedPatientId);

        if (patient.getState().getReadings()!= null) {
            //Get the TableLayout
            TableLayout table = (TableLayout) findViewById(R.id.readingsTable);
            int count = 0; //Counter to count number of rows and setting colors to even rows
            for(Reading reading: patient.getReadings()) { //Get all the readings of the Patient
                //Create a table row using the readings_row XML
                TableRow row = (TableRow) LayoutInflater.from(PatientReadingsActivity.this)
                        .inflate(R.layout.readings_row, null);
                if (count % 2 == 0) { //set the color to even rows
                    row.setBackgroundColor(Color.LTGRAY);
                }
                //Fill the TextViews in the rows using the reading of the Patient Object
                ((TextView) row.findViewById(R.id.readingIdColumn)).setText(reading.getReadingId());
                ((TextView) row.findViewById(R.id.typeColumn)).setText(reading.getType());
                ((TextView) row.findViewById(R.id.valueColumn)).setText(reading.getValue());
                ((TextView) row.findViewById(R.id.dateColumn)).setText(reading.getDate().toString());
                ((TextView) row.findViewById(R.id.clinicIdColumn)).setText(reading.getClinic().getId());
                ((TextView) row.findViewById(R.id.clinicNameColumn)).setText(reading.getClinic().getName());

                table.addView(row); //Add the row to the TableLayout
                count++; 
            }
            table.requestLayout();
        }
    }
}
