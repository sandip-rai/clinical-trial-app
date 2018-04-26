package com.sandiprai.clinicaltrial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SystemSettingsActivity extends ClinicalTrialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_settings);

        //Get the toolbar and assign
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.system_settings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        clinicalTrial = getClinicalTrial();

        // initiate a Switch
        final Switch switchJasonAddPatients = (Switch) findViewById(R.id.switchJasonAddPatients);
        final Switch switchJasonAddReadings = (Switch) findViewById(R.id.switchJasonAddReadings);
        final Switch switchXMLAddPatientes = (Switch) findViewById(R.id.switchXMLAddPatientes);
        final Switch switchXMLAddReadings = (Switch) findViewById(R.id.switchXMLAddReadings);

        //check the current switch state
        refreshSwitches(switchJasonAddPatients,switchJasonAddReadings, switchXMLAddPatientes, switchXMLAddReadings);

        //attach a listener to check for changes in state
        switchJasonAddPatients.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    clinicalTrial.getSettings().setJsonAddUnknownPatients(true);
                    switchJasonAddReadings.setClickable(true);
                    refreshSwitches(switchJasonAddPatients,switchJasonAddReadings, switchXMLAddPatientes, switchXMLAddReadings);
                } else {
                    clinicalTrial.getSettings().setJsonAddUnknownPatients(false);
                    switchJasonAddReadings.setClickable(false);
                    clinicalTrial.getSettings().setJsonAddUnknownReadings(false);
                    refreshSwitches(switchJasonAddPatients,switchJasonAddReadings, switchXMLAddPatientes, switchXMLAddReadings);
                }
            }
        });

        switchJasonAddReadings.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    clinicalTrial.getSettings().setJsonAddUnknownReadings(true);
                    refreshSwitches(switchJasonAddPatients,switchJasonAddReadings, switchXMLAddPatientes, switchXMLAddReadings);
                } else {
                    clinicalTrial.getSettings().setJsonAddUnknownReadings(false);
                    refreshSwitches(switchJasonAddPatients,switchJasonAddReadings, switchXMLAddPatientes, switchXMLAddReadings);
                }
            }
        });

        switchXMLAddPatientes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    clinicalTrial.getSettings().setXmlAddUnknownPatients(true);
                    switchXMLAddReadings.setClickable(true);
                    refreshSwitches(switchJasonAddPatients,switchJasonAddReadings, switchXMLAddPatientes, switchXMLAddReadings);
                } else {
                    clinicalTrial.getSettings().setXmlAddUnknownPatients(false);
                    switchXMLAddReadings.setClickable(false);
                    clinicalTrial.getSettings().setXmlAddUnknownReadings(false);
                    refreshSwitches(switchJasonAddPatients,switchJasonAddReadings, switchXMLAddPatientes, switchXMLAddReadings);
                }
            }
        });

        switchXMLAddReadings.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    clinicalTrial.getSettings().setXmlAddUnknownReadings(true);
                    refreshSwitches(switchJasonAddPatients,switchJasonAddReadings, switchXMLAddPatientes, switchXMLAddReadings);
                } else {
                    clinicalTrial.getSettings().setXmlAddUnknownReadings(false);
                    refreshSwitches(switchJasonAddPatients,switchJasonAddReadings, switchXMLAddPatientes, switchXMLAddReadings);
                }
            }
        });
    }

    public void refreshSwitches(Switch switchJasonAddPatients, Switch switchJasonAddReadings,  Switch switchXMLAddPatientes, Switch switchXMLAddReadings){
        if (clinicalTrial.getSettings().jsonAddUnknownPatients()) {
            switchJasonAddPatients.setChecked(true);
            switchJasonAddReadings.setClickable(true);
        } else {
            switchJasonAddPatients.setChecked(false);
            switchJasonAddReadings.setClickable(false);
        }

        if (clinicalTrial.getSettings().jsonAddUnknownReadings()) {
            switchJasonAddReadings.setChecked(true);
        } else {
            switchJasonAddReadings.setChecked(false);
        }

        if (clinicalTrial.getSettings().xmlAddUnknownPatients()) {
            switchXMLAddPatientes.setChecked(true);
            switchXMLAddReadings.setClickable(true);
        } else {
            switchXMLAddPatientes.setChecked(false);
            switchXMLAddReadings.setClickable(false);
        }

        if (clinicalTrial.getSettings().xmlAddUnknownReadings()) {
            switchXMLAddReadings.setChecked(true);
        } else {
            switchXMLAddReadings.setChecked(false);
        }
    }
}
