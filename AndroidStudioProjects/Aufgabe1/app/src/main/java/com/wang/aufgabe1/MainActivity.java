package com.wang.aufgabe1;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    Button btn_Hallo;
    Button btn_Change;
    TextView textV_Hallo;
    NumberPicker nPicker_Hallo;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button onClick
        btn_Hallo = (Button) findViewById(R.id.btn_Hallo);
        btn_Change = (Button)findViewById(R.id.btn_Change);
        textV_Hallo = (TextView) findViewById(R.id.textV_Hallo);

        nPicker_Hallo = (NumberPicker)findViewById(R.id.nPicker_Hallo);
        nPicker_Hallo.setMinValue(0);
        nPicker_Hallo.setMaxValue(50);
        nPicker_Hallo.setWrapSelectorWheel(true);
        nPicker_Hallo.setOnValueChangedListener((NumberPicker.OnValueChangeListener) this);

        btn_Hallo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                text = "Hallo, Dan!";
                textV_Hallo.setText(text);
            }
        });

        btn_Change.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //text = String.valueOf(nPicker_Hallo.getValue());
                //textV_Hallo.setText(text);
                float fontSize = nPicker_Hallo.getValue();
                textV_Hallo.setTextSize(font);
            }
        });


    }
}




