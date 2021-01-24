package com.example.lilhelp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TitleScreen_Activity extends AppCompatActivity {

    private ExecutorService es = Executors.newSingleThreadExecutor();
    private TextView tv;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title_screen);
        NotificationHandler.setContext(getApplicationContext());
        NotificationHandler.createNotificationChannel("Lil Help", "App Notification Channel", getApplicationContext());
        NotificationHandler.startNotif();
        tv = (TextView)findViewById(R.id.title);
        es.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    for (float i = (float) (Math.PI / 2); i < Math.PI; i += 0.01f) {
                        tv.setAlpha((float) Math.sin(i));
                        Thread.sleep(15);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
    }

    public void finish(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
