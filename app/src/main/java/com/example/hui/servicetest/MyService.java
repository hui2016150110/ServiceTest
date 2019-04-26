package com.example.hui.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    public MyService() {}
    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("MyService","onUnbind");
        return super.onUnbind(intent);
    }

    private MyBinder mMyBinder = new MyBinder();


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.i("MyService","onbind");
        return mMyBinder;
    }

    @Override
    public void onCreate() {
        Log.i("MyService","onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("MyService","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("MyService","onDestroy");
    }

    class MyBinder extends Binder{
        public void startDownload(){
            //具体下载任务
            Log.i("MyService","正在下载");
        }
    }
}
