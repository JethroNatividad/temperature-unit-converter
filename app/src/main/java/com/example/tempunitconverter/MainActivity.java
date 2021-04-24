package com.example.tempunitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    private EditText inputEditText;
    private EditText outputEditText;
    private Spinner inputUnitSpinner;
    private Spinner outputUnitSpinner;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEditText = findViewById(R.id.input);
        outputEditText = findViewById(R.id.output);
        inputUnitSpinner = findViewById(R.id.inputSpinner);
        outputUnitSpinner = findViewById(R.id.outputSpinner);
        convertButton = findViewById(R.id.convertButton);

        convertButton.setOnClickListener(this::convert);
    }


    public void convert(View v){
        String inputUnit = inputUnitSpinner.getSelectedItem().toString();
        String outputUnit = outputUnitSpinner.getSelectedItem().toString();
        Double inputNumber = 0.0;

        if(!TextUtils.isEmpty(inputEditText.getText().toString())){
            inputNumber = Double.parseDouble(inputEditText.getText().toString());
        } else{
            Toast.makeText(this, "Can't convert nothing", Toast.LENGTH_SHORT).show();
        }

        Double result = inputNumber;

        if(inputUnit.equals("Celsius") && outputUnit.equals("Fahrenheit")){
            result = (inputNumber * 1.8) + 32;
        }
        if(inputUnit.equals("Celsius") && outputUnit.equals("Kelvin")){
            result = inputNumber + 273.15;
        }
        if(inputUnit.equals("Kelvin") && outputUnit.equals("Celsius")){
            result = inputNumber - 273.15;
        }
        if(inputUnit.equals("Kelvin") && outputUnit.equals("Fahrenheit")){
            result = (inputNumber - 273.15) * 1.8 + 32;
        }
        if(inputUnit.equals("Fahrenheit") && outputUnit.equals("Celsius")){
            result = (inputNumber - 32) * 0.5556;
        }
        if(inputUnit.equals("Fahrenheit") && outputUnit.equals("Kelvin")){
            result = (inputNumber - 32) * 5/9 + 273.15;
        }

        outputEditText.setText(String.valueOf(new DecimalFormat("#.###").format(result)));
    }

}