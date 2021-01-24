package com.example.lilhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    Button cogButton,infoButton,JournToday, hisjournal, help;
    TextView cogText, JourText, hisText, helpText, desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        cogButton = findViewById(R.id.cogButton);
        infoButton = findViewById(R.id.informationButton);
        JournToday = findViewById(R.id.journalToday);
        hisjournal = findViewById(R.id.previousJournals);
        help = findViewById(R.id.HELP);
        cogText = findViewById(R.id.cogtext);
        JourText = findViewById(R.id.journaltext);
        hisText = findViewById(R.id.histext);
        helpText = findViewById(R.id.helptext);
        desc = findViewById(R.id.descrip);

    }
    public void onClick(View view){
        if(view = infoButton){

        }
    }
}