package com.wang.digitaluhr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Date;

import static android.icu.text.DateFormat.getDateInstance;
import static android.icu.text.DateFormat.getDateTimeInstance;

public class MainActivity extends AppCompatActivity {
    //Definiton von Attributen
    private Button btnShowTime, btnClose;
    private TextView textVDate;
    private TextClock digitalClock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        digitalClock = (TextClock)findViewById(R.id.digitalClock);
        btnShowTime = (Button)findViewById(R.id.btnShowTime);
        btnClose = (Button)findViewById(R.id.btnClose);
        textVDate = (TextView)findViewById(R.id.textVDate);

        //digital uhr und systemdatum vesteckt
        digitalClock.setVisibility(View.INVISIBLE);
        textVDate.setVisibility(View.INVISIBLE);

        // textVDate mit aktuelle systemzeit verlinken
        textVDate.setText(this.getdate());

        btnShowTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnShowTime.setText("Click to show Time and Date!");
                    digitalClock.setVisibility(View.VISIBLE); // time wird angezeigt
                    textVDate.setVisibility(View.INVISIBLE); // date nicht anzeigen

                btnShowTime.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        digitalClock.setVisibility(View.INVISIBLE); // time wird angezeigt
                        textVDate.setVisibility(View.VISIBLE); // date nicht anzeigen
                    }
                });
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
    @SuppressLint("NewApi")
    public String getdate()
    {
        // string, um den Zeit aufnehmen von System
        String currDateTime;
        currDateTime = getDateTimeInstance().format(new Date());
        return currDateTime;
    }
}
