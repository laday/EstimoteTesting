package com.example.lday15.estimotetesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.estimote.sdk.SystemRequirementsChecker;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private BeaconManager beaconManager;
    private Region region;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        beaconManager = new BeaconManager(this);
        region = new Region("ranged region",
                UUID.fromString("ENTER UUID HERE"), null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SystemRequirementsChecker.checkWithDefaultDialogs(this);
    }

}

