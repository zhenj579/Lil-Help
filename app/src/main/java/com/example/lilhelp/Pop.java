package com.example.lilhelp;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onClick(View v) throws IOException {
        Intent intent = new Intent();
        JournalEntry je = null;
        File f = new File(getApplicationContext().getFilesDir()+DataHandler.today);
        if(f.exists())
        {
            je = DataHandler.get(this, DataHandler.today);
            Bundle b = new Bundle();
            b.putSerializable(DataHandler.today, je);
            intent.putExtras(b);
        }
        if(v==home){
            finish();
        }
        else if(v==ans){
            intent.setClass(this, Forward_Activity.class);
            startActivity(intent);
        }
        else if( v==noAns){
            intent.setClass(this, JournalScreen.class);
            startActivity(intent);
        }
    }
}
