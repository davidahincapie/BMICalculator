package com.example.davidhincapie.bmicalculator;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    private EditText heightIn;
    private EditText weightIn;
    private Button btnCalcBMI;
    private double weight = 0;
    private double height = 0;
    private TextView bmiOut;
    private TextView bmiStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeApp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void initializeApp(){
        weightIn = (EditText) findViewById(R.id.weightInput);
        heightIn = (EditText) findViewById(R.id.heightInput);
        btnCalcBMI = (Button) findViewById(R.id.btnCalcBMI);
        bmiOut = (TextView) findViewById(R.id.bmiOut);
        bmiStatus = (TextView) findViewById(R.id.bmiStatus);


    }//end of initializeApp

    public void calculateBMI(View v){
        Log.i("calculateBMI","Button was pressed");

        try {
            weight = Double.parseDouble(weightIn.getText().toString());
            height = Double.parseDouble(heightIn.getText().toString());
        }catch (NumberFormatException e){
            weight = 0.0;
            height = 0.0;
        }//end of try caatch

        double bmi = (weight /(height*height)) * 703.0;
        String result = String.format("%.2f", bmi);
        Log.d("My Activity", result);
        bmiOut.setText(result, TextView.BufferType.NORMAL);

        String status = "Status";

        if (bmi < 16.0){
            status = "Seriously Underweight";
        }else if (bmi >= 16.0 && bmi < 18.0){
            status = "Underweight";
        }else if (bmi >= 18.0 && bmi < 24.0){
            status = "Normal Weight";
        }else if (bmi >= 24.0 && bmi < 29.0){
            status = "Overweight";
        }else if (bmi >= 29.0 && bmi < 35){
            status = "Seriously Overweight";
        }else if (bmi >= 35.0){
            status = "Gravely Overweight";
        }//end of if

        bmiStatus.setText(status);
    }//end of calculateBMI
}
