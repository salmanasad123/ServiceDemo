package com.example.teamas.servicedemotoplayringtone;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startService;
    private Button stopService;
    private Button startIntentService;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService = findViewById(R.id.btn_start_service);
        stopService = findViewById(R.id.btn_stop_service);
        startIntentService = findViewById(R.id.btn_start_intnet_service);

        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
        startIntentService.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_start_service) {
            intent = new Intent(MainActivity.this, MyService.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(intent);
            }
        }
        if (v.getId() == R.id.btn_stop_service) {
            intent = new Intent(MainActivity.this, MyService.class);
            stopService(intent);
        }

        if (v.getId() == R.id.btn_start_intnet_service) {
            intent = new Intent(MainActivity.this, MyIntentService.class);
            startService(intent);
        }
    }
}
