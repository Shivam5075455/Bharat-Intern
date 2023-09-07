package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.temperatureconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{


    EditText etTemp;
    TextView tvResult;
    RadioGroup rdConv;
    Button btnCon;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        etTemp = findViewById(R.id.etTemperatureInput);
        tvResult = findViewById(R.id.tvResult);
        rdConv = findViewById(R.id.rdConversion);
        btnCon = findViewById(R.id.btnConvert);

        Window window = this.getWindow();
        window.setStatusBarColor(getColor(R.color.statusBar));

        } // end of onCreate fxn

    public void convertTemperature(View view){
        String temperatureText = etTemp.getText().toString();
            double temperature = Double.parseDouble(temperatureText);
        if(!temperatureText.isEmpty()){
            RadioButton selectionRadioButton = findViewById(rdConv.getCheckedRadioButtonId());
            if(selectionRadioButton.getId() == R.id.toFahrenheit){
                double fahrenheit = (temperature * 9/5)+32;
                String result = String.format("%.2f °F",fahrenheit);
                tvResult.setText(result);
            }else if(selectionRadioButton.getId() == R.id.toCelsius){
//                double celsius = Double.parseDouble((temperatureText));
                double celsius = (temperature -32)*5/9;
                String result = String.format("%.2f °C",celsius);
                tvResult.setText(result);
            }else{
                tvResult.setText("Please enter temperature");
            }
        }
    }

}