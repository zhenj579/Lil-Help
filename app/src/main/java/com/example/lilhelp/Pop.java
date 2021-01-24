package com.example.lilhelp;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
public class Pop extends Activity {
    Button home, ans, noAns;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.answer_questions_popup);

        home = findViewById(R.id.homeOnPop);
        ans = findViewById(R.id.AnswQ);
        noAns = findViewById(R.id.noAnsQ);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int W = dm.widthPixels;
        int H = dm.heightPixels;
        getWindow().setLayout((int)(W*.8),(int)(H*.6));
    }
    public void onClick(View v){
        if(v==home){
            finish();
        }
        else if(v==ans){

        }
        else if( v==noAns){

        }

    }
}
