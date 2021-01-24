package com.example.lilhelp;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public class PrevJournal_Activity extends AppCompatActivity {

    private CalendarView cv;
    private TextView fq, gq, aq, text;
    Button hm;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prevjournal);

        cv = (CalendarView) findViewById(R.id.calendarView2);
        fq = (TextView) findViewById(R.id.forwardAnswer);
        gq = (TextView) findViewById(R.id.gratefulAnswer);
        aq = (TextView) findViewById(R.id.accompAnswer);
        text = (TextView) findViewById(R.id.jorunal_text);
        LocalDate ld = LocalDate.now();
        update(ld.getYear(), ld.getMonth().getValue(), ld.getDayOfMonth());
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                update(year, month, dayOfMonth);
            }
        });
        hm= findViewById(R.id.PrevJHome);
        hm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void update(int year, int month, int dayOfMonth) {
        try {
            JournalEntry je = DataHandler.get(PrevJournal_Activity.super.getApplicationContext(),
                    year + "-" + ( month < 10 ? "0" + month : month + "" ) + "-" + dayOfMonth);
            fq.setText(je.getFq().getAnswer());
            gq.setText(je.getGq().getAnswer());
            aq.setText(je.getAq().getAnswer());
            text.setText(je.getText());
        } catch (FileNotFoundException e) {
            fq.setText("");
            gq.setText("");
            aq.setText("");
            text.setText("");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
