package com.wang.aufgabe1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener{
    String viewText = "Hallo Dan!";

    Button btnHallo;
    TextView textView;
    NumberPicker numberPicker, colorPicker;

    String[] nums;
    final String[] farbe = {"Red", "Blue", "Yellow", "Black", "Green"};
    HashMap<String,Integer> colorDict = new HashMap<String, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHallo = (Button)findViewById(R.id.btnHallo);
        textView = (TextView)findViewById(R.id.textV);
        textView.setText(viewText);

        numberPicker = (NumberPicker)findViewById(R.id.nPicker);
        numberPicker.setMinValue(10);
        numberPicker.setMaxValue(40);
        numberPicker.setWrapSelectorWheel(true);
        numberPicker.setOnValueChangedListener(this);
        nums = new String[50];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.toString(i*5);
        }

        colorDict.put(farbe[0], Color.RED);
        colorDict.put(farbe[1], Color.BLUE);
        colorDict.put(farbe[2], Color.YELLOW);
        colorDict.put(farbe[3], Color.BLACK);
        colorDict.put(farbe[4], Color.GREEN);

        colorPicker = (NumberPicker)findViewById(R.id.nPfarbe);
        colorPicker.setMinValue(0);
        colorPicker.setMaxValue(farbe.length-1);
        colorPicker.setWrapSelectorWheel(true);
        colorPicker.setDisplayedValues(farbe);
        colorPicker.setOnValueChangedListener(this);

        setTextColorFromColorPicker();

        btnHallo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                textView.setText(viewText);
            }
        });
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
        if(numberPicker == numberPicker) {
            setTextSizeFromNumberPicker();
        }
        if(numberPicker == colorPicker){
            setTextColorFromColorPicker();
        }

        textView.refreshDrawableState();
    }

    private void setTextSizeFromNumberPicker(){
        float fontSize = numberPicker.getValue();
        textView.setTextSize(fontSize);
    }

    private void setTextColorFromColorPicker(){
        String color = farbe[colorPicker.getValue()];
        int colorInt = colorDict.get(color).intValue();
        textView.setTextColor(colorInt);
    }
}
