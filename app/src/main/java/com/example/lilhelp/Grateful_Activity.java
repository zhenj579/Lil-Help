package com.example.lilhelp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.time.LocalDateTime;

public class Grateful_Activity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grateful_);

        Button b = (Button) findViewById(R.id.backButton);
        final Intent intent = new Intent(this, Forward_Activity.class);
        String today = LocalDateTime.now().toString().substring(0,10); // trim off the clock portion of the date
        final Bundle bn = getIntent().getExtras();
        JournalEntry je = (JournalEntry) bn.getSerializable(today);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtras(bn);
                startActivity(intent);
            }
        });
    }
}