package com.example.administrator.clinicaltrial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner patientIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Set up the dropdown list of patient Ids
        ArrayAdapter<CharSequence> patientIdsSpinerAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.patientID_spinter, R.layout.support_simple_spinner_dropdown_item);
        patientIdsSpinerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        patientIds = (Spinner) findViewById(R.id.patientIds);
        patientIds.setAdapter(patientIdsSpinerAdapter);
        patientIds.setOnItemSelectedListener(this);

        //Set up Start Patient Trail button
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(patientIds.getSelectedItem().toString().equals("New Patient")){
                    Intent newPatientIntent = new Intent(MainActivity.this, NewPatientActivity.class);
                    startActivity(newPatientIntent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_systemSettings) {
            Intent systemSettingsIntent = new Intent(this, SystemSettingsActivity.class);
            startActivity(systemSettingsIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
