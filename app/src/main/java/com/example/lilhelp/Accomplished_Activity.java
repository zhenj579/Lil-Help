package com.example.lilhelp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Accomplished_Activity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accomplished_);
        Bundle b = getIntent().getExtras();
        final String today = LocalDateTime.now().toString().substring(0,10); // trim off the clock portion of the date
        JournalEntry je = (JournalEntry)  b.getSerializable(today);
        final EditText ans = (EditText) findViewById(R.id.aq_answer);
        Bundle saved = getIntent().getExtras();
        if(saved != null)
        {
            JournalEntry savedJE = (JournalEntry) saved.getSerializable(today);
            String savedContent = savedJE.getAq().getAnswer();
            ans.setText(savedContent);
        }
        Button homeButton = (Button) findViewById(R.id.accomplished_question_home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
        Button nextButton = (Button) findViewById(R.id.accomplished_forward_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JournalScreen.java);
                JournalEntry je = new JournalEntry();
                if(getIntent().getExtras() != null)
                {
                    je = (JournalEntry) getIntent().getExtras().getSerializable(today);
                }
                String content = ans.getText().toString();
                if(je.getAq() == null)
                {
                    AccomplishQuestion aq = new AccomplishQuestion();
                    aq.setAnswer(content);
                    je.setAq(aq);
                }
                else
                {
                    je.getAq().setAnswer(content);
                }
                Bundle b = new Bundle();
                b.putSerializable(today, (Serializable) je);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
    }
}