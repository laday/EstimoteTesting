package com.example.lday15.estimotetesting;

import android.app.Application;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;

import java.util.UUID;

/**
 * Created by lday15 on 10/10/2016.
 */

public class MyApplication extends Application {

    private BeaconManager beaconManager;


    @Override
    public void onCreate() {
        super.onCreate();

        beaconManager = new BeaconManager(getApplicationContext());

        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startMonitoring(new Region(
                        "monitored region",
                        UUID.fromString("/*UUID FROM OUR BEACON*/"),
                        /*MAJOR*/22504, /*MINOR*/48827));
            }
        });
    }
}