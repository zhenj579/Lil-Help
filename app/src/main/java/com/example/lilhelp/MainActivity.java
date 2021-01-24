package com.example.lilhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button gg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gg = findViewById(R.id.gotoHome);


    }
    public void click(View V){
        if(V == gg){
            Intent myIntent = new Intent(this, HomeActivity.class);
            this.startActivity(myIntent);

        }
    }
}