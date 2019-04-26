package com.example.hui.servicetest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MyService.MyBinder mMyBinder;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mMyBinder = (MyService.MyBinder) service;
            mMyBinder.startDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startService = (Button) findViewById(R.id.startService);
        startService.setOnClickListener(this);
        Button stopService = (Button) findViewById(R.id.stopService);
        stopService.setOnClickListener(this);
        Button bindService = (Button) findViewById(R.id.bindtService);
        bindService.setOnClickListener(this);
        Button unbindService = (Button) findViewById(R.id.unbindService);
        unbindService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.startService:
                intent = new Intent(this,MyService.class);;
                startService(intent);
                break;
            case R.id.stopService:
                intent = new Intent(this,MyService.class);;
                stopService(intent);
                break;
            case R.id.bindtService:
                intent = new Intent(this,MyService.class);;
                bindService(intent,mConnection,BIND_AUTO_CREATE);
                break;
            case R.id.unbindService:
                unbindService(mConnection);
                break;
        }
    }
}
