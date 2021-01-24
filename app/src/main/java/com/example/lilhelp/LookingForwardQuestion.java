package com.example.lilhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LookingForwardQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looking_forward_question);
        Button homeButton = (Button) findViewById(R.id.looking_forward_question_home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToHomeScreen();
            }
        });
    }

    private void changeToHomeScreen()
    {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}