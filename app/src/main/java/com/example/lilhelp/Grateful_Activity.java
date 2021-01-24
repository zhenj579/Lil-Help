package com.example.lilhelp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.time.LocalDateTime;

public class Grateful_Activity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grateful_);
        final EditText et = (EditText) findViewById(R.id.gq_answer);
        Button forward = (Button) findViewById(R.id.grateful_forward_button);
        Button back = (Button) findViewById(R.id.grateful_back_button);
        Button home = (Button) findViewById(R.id.grateful_question_home_button);
        final Bundle bn = getIntent().getExtras();
        final JournalEntry je = (JournalEntry) bn.getSerializable(DataHandler.today);
        if(je.getGq() != null)
        {
            GratefulQuestion gq = je.getGq();
            et.setText(gq.getAnswer());
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Forward_Activity.class);
                String content = et.getText().toString();
                if(je.getGq() == null)
                {
                    GratefulQuestion gq = new GratefulQuestion();
                    gq.setAnswer(content);
                    je.setGq(gq);
                }
                else
                {
                    je.getGq().setAnswer(content);
                }
                bn.putSerializable(DataHandler.today, je);
                intent.putExtras(bn);
                startActivity(intent);
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Accomplished_Activity.class);
                String content = et.getText().toString();
                if(je.getGq() == null)
                {
                    GratefulQuestion gq = new GratefulQuestion();
                    gq.setAnswer(content);
                    je.setGq(gq);
                }
                else
                {
                    je.getGq().setAnswer(content);
                }
                bn.putSerializable(DataHandler.today, je);
                intent.putExtras(bn);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}