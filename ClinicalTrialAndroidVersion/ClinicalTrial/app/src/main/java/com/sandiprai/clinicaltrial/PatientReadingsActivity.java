package com.sandiprai.clinicaltrial;

import android.graphics.Color;
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

        if (patient.getState().getReadings()!= null) {
            TableLayout table = (TableLayout) findViewById(R.id.readingsTable);
            int count = 0;
            for(Reading reading: patient.getReadings()) {
                //
                // TableRow row = new TableRow(this);

                TableRow row = (TableRow) LayoutInflater.from(PatientReadingsActivity.this)
                        .inflate(R.layout.readings_row, null);
                if (count % 2 == 0) {
                    row.setBackgroundColor(Color.GRAY);
                }
                ((TextView) row.findViewById(R.id.readingIdColumn)).setText(reading.getReadingId());
                ((TextView) row.findViewById(R.id.typeColumn)).setText(reading.getType());
                ((TextView) row.findViewById(R.id.valueColumn)).setText(reading.getValue());
                //((TextView)row.findViewById(R.id.dateColumn)).setText(reading.getReadingId());
                ((TextView) row.findViewById(R.id.dateColumn)).setText("null");
                ((TextView) row.findViewById(R.id.clinicIdColumn)).setText(reading.getClinic().getId());
                ((TextView) row.findViewById(R.id.clinicNameColumn)).setText(reading.getClinic().getName());

                table.addView(row);
                count++;

            }
            table.requestLayout();
                /**
                TextView readingIdTextView = new TextView(this);
                readingIdTextView.setText(reading.getReadingId());
                readingIdTextView.setWidth(50);
                row.addView(readingIdTextView);

                TextView typeTextView = new TextView(this);
                readingIdTextView.setText(reading.getType());
                readingIdTextView.setWidth(50);
                row.addView(typeTextView);

                TextView valueTextView = new TextView(this);
                readingIdTextView.setText(reading.getValue());
                readingIdTextView.setWidth(50);
                row.addView(valueTextView);

                /***TO-DOOOOOOOOO*
                TextView dateTextView = new TextView(this);
                //readingIdTextView.setText(reading.getDate());
                readingIdTextView.setWidth(50);
                row.addView(dateTextView);

                TextView clinicIdTextView = new TextView(this);
                readingIdTextView.setText(reading.getClinic().getId());
                readingIdTextView.setWidth(50);
                row.addView(clinicIdTextView);

                TextView clinicNameTextView = new TextView(this);
                readingIdTextView.setText(reading.getClinic().getName());
                readingIdTextView.setWidth(50);
                row.addView(clinicNameTextView);

                table.addView(row);
                count++;

                **/
            //}
            /**
            //Create an AdapterArray to hold the Readings ArrayList of the Patient
            ArrayAdapter<Reading> listAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, patient.getState().getReadings());
            //Get the listView and set the adapter
            ListView listReadings = (ListView) findViewById(R.id.list_patient_readings);
            listReadings.setAdapter(listAdapter);
             **/

        }
    }
}
