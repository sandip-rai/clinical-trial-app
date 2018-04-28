package com.sandiprai.clinicaltrial;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import 	android.R.layout;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.file.FileAdapter;

import trial.ClinicalTrial;


public class ClinicalTrialActivity extends AppCompatActivity {
    protected ClinicalTrial clinicalTrial;

   private FileAdapter fileAdapter = new FileAdapter();

    private ClinicalTrial getClinicalTrial() {
        clinicalTrial = new ClinicalTrial();
        if (readAllowed()) {
            clinicalTrial = fileAdapter.loadState(getApplicationContext());
        }
        return clinicalTrial;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getClinicalTrial();
    }

    @Override
    protected void onResume(){
        super.onResume();
        getClinicalTrial();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (writeAllowed()){
                fileAdapter.saveState(clinicalTrial, getApplicationContext());
        }

    }

    @Override
    protected void onPause()   {
        super.onPause();
        if(writeAllowed()){
            fileAdapter.saveState(clinicalTrial, getApplicationContext());
        }

    }

    protected boolean writeAllowed(){
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            return true;
        }
    }

    protected boolean readAllowed(){
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            return true;
        }
    }
}
