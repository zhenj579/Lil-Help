package com.example.lilhelp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Forward_Activity extends AppCompatActivity {



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looking_forward_question);
        final EditText ans = (EditText) findViewById(R.id.fq_answer);
        final String today = LocalDateTime.now().toString().substring(0,10); // trim off the clock portion of the date
        Bundle saved = getIntent().getExtras();
        if(saved != null)
        {
            JournalEntry savedJE = (JournalEntry) saved.getSerializable(today);
            String savedContent = savedJE.getFq().getAnswer();
            ans.setText(savedContent);
        }
        Button homeButton = (Button) findViewById(R.id.looking_forward_question_home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
        Button nextButton = (Button) findViewById(R.id.forward_question_next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Grateful_Activity.class);
                JournalEntry je = new JournalEntry();
                je.setFq(new ForwardQuestion());
                String content = ans.getText().toString();
                je.getFq().setAnswer(content);
                Bundle b = new Bundle();
                b.putSerializable(today, (Serializable) je);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

}
