package com.example.lilhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    private SeekBar notifBar;
    private TextView numNotif;
    private Button homeButton;
    private static int notifsPerDay = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Home Button
        homeButton = findViewById(R.id.homeButton2);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Saving
        final String notifKey = "notifKey";

        final SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        notifsPerDay = sharedPreferences.getInt(notifKey, 1);

        //Setting seekbar and text
        notifBar = findViewById(R.id.notifBar);
        numNotif = findViewById(R.id.numNotif);

        numNotif.setText(String.valueOf(notifsPerDay) + " Times a Day");

        notifBar.setMax(10);
        notifBar.setProgress(notifsPerDay);

        notifBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                notifsPerDay = progress;
                numNotif.setText(String.valueOf(progress) + " Times a Day");
                editor.putInt(notifKey, progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                editor.apply();
            }
        });

    }

    public static int getNotifsPerDay() {
        return notifsPerDay;
    }
}