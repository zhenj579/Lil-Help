package com.example.lilhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private Button cogButton,infoButton,JournToday, hisjournal, help;
    private TextView cogText, JourText, hisText, helpText, desc, infoText;
    private RelativeLayout relLay;
    private Boolean isClicked;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        isClicked =false;
        cogButton = findViewById(R.id.cogButton);
        infoButton = findViewById(R.id.informationButton);
        JournToday = findViewById(R.id.journalToday);
        intent = new Intent(this, Forward_Activity.class);
        JournToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        hisjournal = findViewById(R.id.previousJournals);
        help = findViewById(R.id.HELP);
        cogText = findViewById(R.id.cogtext);
        JourText = findViewById(R.id.journaltext);
        hisText = findViewById(R.id.histext);
        helpText = findViewById(R.id.helptext);
        desc = findViewById(R.id.descrip);
        relLay = findViewById(R.id.layout);
        infoText= findViewById(R.id.infotext);

        desc.setVisibility(View.INVISIBLE);
        helpText.setVisibility(View.INVISIBLE);
        hisText.setVisibility(View.INVISIBLE);
        JourText.setVisibility(View.INVISIBLE);
        cogText.setVisibility(View.INVISIBLE);
        infoText.setVisibility(View.INVISIBLE);


        //Setting click for help button
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, HelpResources.class));
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            // do something on back.
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onClick(View view){
        if(view == infoButton){
            if(isClicked==false){

                desc.setVisibility(View.VISIBLE);
                helpText.setVisibility(View.VISIBLE);
                hisText.setVisibility(View.VISIBLE);
                JourText.setVisibility(View.VISIBLE);
                cogText.setVisibility(View.VISIBLE);
                infoText.setVisibility(View.VISIBLE);
                isClicked=true;
            }
            else{

                desc.setVisibility(View.INVISIBLE);
                helpText.setVisibility(View.INVISIBLE);
                hisText.setVisibility(View.INVISIBLE);
                JourText.setVisibility(View.INVISIBLE);
                cogText.setVisibility(View.INVISIBLE);
                infoText.setVisibility(View.INVISIBLE);
                isClicked=false;

            }


        }
    }
}