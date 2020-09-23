package com.example.muath.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_calculateBMI(View view){

        /******************
         * GET INPUTS
         ******************/
        // Get Inputs (values from TextViews)
        EditText heightTF = (EditText) findViewById(R.id.editText2);
        EditText weightTF = (EditText) findViewById(R.id.editText);
        double height = Double.parseDouble(heightTF.getText().toString());
        double weight = Double.parseDouble(weightTF.getText().toString());

        /******************
         * CALCULATE BMI
         ******************/
        // Create a BMI Calculator object
        BmiCalculator bmiCalc = new BmiCalculator();
        // Calculate BMI using Calculator object
        bmiCalc.setHeight( height );
        bmiCalc.setWeight( weight );
        bmiCalc.calcBMI();


        /******************
         * RENDER RESULTS
         ******************/

        //format the string to display 2 digits after the decimal point
        String bmiString = "";
        String color = "";
        if(bmiCalc.getBmiVal() % 1 == 0) {
            bmiString = String.format("%.0f", bmiCalc.getBmiVal());
        } else {
            bmiString = String.format("%.1f", bmiCalc.getBmiVal());
        }
        bmiString = "Your BMI is " + bmiString + " - " + bmiCalc.getBmiResult();

        if(bmiCalc.getBmiResult().equals("Underweight")) {
            color = "RED";
        }
        else if(bmiCalc.getBmiResult().equals("Normal")) {
            color = "GREEN";
        }
        else if(bmiCalc.getBmiResult().equals("Overweight")) {
            color = "darkgray";
        }
        else {
            color = "RED";
        }


        // Set text color based on BMI
        int colorInt = Color.parseColor(color);
        TextView BMIResult = (TextView) findViewById(R.id.textView3);
        BMIResult.setTextColor(colorInt);
        BMIResult.setText(bmiString);


    }


}
