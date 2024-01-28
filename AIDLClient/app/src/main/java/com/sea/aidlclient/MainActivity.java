package com.sea.aidlclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.sea.aidlserver.IAIDLColorInterface;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    IAIDLColorInterface iAIDLlColorInterface;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            iAIDLlColorInterface = IAIDLColorInterface.Stub.asInterface(iBinder);
            Log.d(TAG, "Remote config Service Connected!!!");

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent("AIDLColorService");
        intent.setPackage("com.sea.aidlserver");

        bindService(intent, mConnection, BIND_AUTO_CREATE);

        //  Create an onclick listener to button
        Log.d(TAG, "bindservice called");
        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int color = iAIDLlColorInterface.getColor();
                    view.setBackgroundColor(color);
                } catch (RemoteException e) {
                }
            }
        });

    }
}