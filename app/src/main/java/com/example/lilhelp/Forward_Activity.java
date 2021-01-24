package com.example.lilhelp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
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
        final EditText ans = (EditText) findViewById(R.id.gq_answer);
        Bundle saved = getIntent().getExtras();
        if(saved != null)
        {
            JournalEntry savedJE = (JournalEntry) saved.getSerializable(DataHandler.today);
            if(savedJE == null) {
                savedJE = new JournalEntry();
            }
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
        Button nextButton = (Button) findViewById(R.id.looking_forward_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Grateful_Activity.class);
                JournalEntry je = new JournalEntry();
                if(getIntent().getExtras() != null)
                {
                    je = (JournalEntry) getIntent().getExtras().getSerializable(DataHandler.today);
                }
                String content = ans.getText().toString();
                if(je.getFq() == null)
                {
                    ForwardQuestion fq = new ForwardQuestion();
                    fq.setAnswer(content);
                    je.setFq(fq);
                }
                else
                {
                    je.getFq().setAnswer(content);
                }
                Bundle b = new Bundle();
                b.putSerializable(DataHandler.today, (Serializable) je);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

}
