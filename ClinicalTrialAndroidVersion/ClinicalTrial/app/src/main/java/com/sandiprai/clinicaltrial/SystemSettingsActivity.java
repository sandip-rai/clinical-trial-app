package com.sandiprai.clinicaltrial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SystemSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_settings);

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
                    AddPatientActivity.clinicalTrial.getSettings().setJsonAddUnknownPatients(true);
                    switchJasonAddReadings.setClickable(true);
                    refreshSwitches(switchJasonAddPatients,switchJasonAddReadings, switchXMLAddPatientes, switchXMLAddReadings);
                } else {
                    AddPatientActivity.clinicalTrial.getSettings().setJsonAddUnknownPatients(false);
                    switchJasonAddReadings.setClickable(false);
                    AddPatientActivity.clinicalTrial.getSettings().setJsonAddUnknownReadings(false);
                    refreshSwitches(switchJasonAddPatients,switchJasonAddReadings, switchXMLAddPatientes, switchXMLAddReadings);
                }
            }
        });

        switchJasonAddReadings.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AddPatientActivity.clinicalTrial.getSettings().setJsonAddUnknownReadings(true);
                    refreshSwitches(switchJasonAddPatients,switchJasonAddReadings, switchXMLAddPatientes, switchXMLAddReadings);
                } else {
                    AddPatientActivity.clinicalTrial.getSettings().setJsonAddUnknownReadings(false);
                    refreshSwitches(switchJasonAddPatients,switchJasonAddReadings, switchXMLAddPatientes, switchXMLAddReadings);
                }
            }
        });

        switchXMLAddPatientes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AddPatientActivity.clinicalTrial.getSettings().setXmlAddUnknownPatients(true);
                    switchXMLAddReadings.setClickable(true);
                    refreshSwitches(switchJasonAddPatients,switchJasonAddReadings, switchXMLAddPatientes, switchXMLAddReadings);
                } else {
                    AddPatientActivity.clinicalTrial.getSettings().setXmlAddUnknownPatients(false);
                    switchXMLAddReadings.setClickable(false);
                    AddPatientActivity.clinicalTrial.getSettings().setXmlAddUnknownReadings(false);
                    refreshSwitches(switchJasonAddPatients,switchJasonAddReadings, switchXMLAddPatientes, switchXMLAddReadings);
                }
            }
        });

        switchXMLAddReadings.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AddPatientActivity.clinicalTrial.getSettings().setXmlAddUnknownReadings(true);
                    refreshSwitches(switchJasonAddPatients,switchJasonAddReadings, switchXMLAddPatientes, switchXMLAddReadings);
                } else {
                    AddPatientActivity.clinicalTrial.getSettings().setXmlAddUnknownReadings(false);
                    refreshSwitches(switchJasonAddPatients,switchJasonAddReadings, switchXMLAddPatientes, switchXMLAddReadings);
                }
            }
        });
    }

    public void refreshSwitches(Switch switchJasonAddPatients, Switch switchJasonAddReadings,  Switch switchXMLAddPatientes, Switch switchXMLAddReadings){
        if (AddPatientActivity.clinicalTrial.getSettings().jsonAddUnknownPatients()) {
            switchJasonAddPatients.setChecked(true);
            switchJasonAddReadings.setClickable(true);
        } else {
            switchJasonAddPatients.setChecked(false);
            switchJasonAddReadings.setClickable(false);
        }

        if (AddPatientActivity.clinicalTrial.getSettings().jsonAddUnknownReadings()) {
            switchJasonAddReadings.setChecked(true);
        } else {
            switchJasonAddReadings.setChecked(false);
        }

        if (AddPatientActivity.clinicalTrial.getSettings().xmlAddUnknownPatients()) {
            switchXMLAddPatientes.setChecked(true);
            switchXMLAddReadings.setClickable(true);
        } else {
            switchXMLAddPatientes.setChecked(false);
            switchXMLAddReadings.setClickable(false);
        }

        if (AddPatientActivity.clinicalTrial.getSettings().xmlAddUnknownReadings()) {
            switchXMLAddReadings.setChecked(true);
        } else {
            switchXMLAddReadings.setChecked(false);
        }
    }
}
