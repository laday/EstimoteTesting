package com.example.lday15.estimotetesting;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;


import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.estimote.sdk.connection.internal.protocols.Operation;
import com.estimote.sdk.connection.settings.Eddystone;


import java.util.List;
import java.util.UUID;


/**
 * Created by lday15 on 10/10/2016.
 */

public class MyApplication extends Application {

    private BeaconManager beaconManager = new BeaconManager(Context);
    private String scanId;


    beaconManager.setEddystoneListener(new beaconManager.EddystoneListener() {
        @Override public void onEddystonesFound(List<Eddystone> eddystones)
        {
            Log.d(TAG, "Nearby Eddystone Beacons: " + eddystones);
        }

    });

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

