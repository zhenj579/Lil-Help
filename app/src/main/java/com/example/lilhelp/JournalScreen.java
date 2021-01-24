package com.example.lilhelp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public class JournalScreen extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_screen);
        final String today = LocalDateTime.now().toString().substring(0,10); // trim off clock portion of date
        TextView journal_date = (TextView) findViewById(R.id.journal_date);
        journal_date.setText(today);
        Button save = (Button) findViewById(R.id.saveButton);
        Button ansQuestion = (Button) findViewById(R.id.AnswerQuestionsButton);
        Button homeButton = (Button) findViewById(R.id.homeButtonJournalScreen);
        final EditText ans = (EditText) findViewById(R.id.journal_screen_ans);
        final Bundle b = getIntent().getExtras();
        final JournalEntry je = (JournalEntry) b.getSerializable(today);
        if(je.getText() != null)
        {
            ans.setText(je.getText());
        }
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
        ansQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = ans.getText().toString();
                je.setText(content);
                Intent intent = new Intent(getApplicationContext(), Forward_Activity.class);
                b.putSerializable(today,je);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = ans.getText().toString();
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                String s = je.getFq().getAnswer() + "\nGQ\n" + je.getGq().getAnswer() + "\nAQ\n" + je.getAq().getAnswer() + "\ntext\n" + content;
                try {
                    DataHandler.save(getApplicationContext(), s);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                startActivity(intent);
            }
        });
    }
}