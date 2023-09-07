package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

    String oldNumber = "";
    String ope = " ";
    boolean isNewop  = true;
    EditText inputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTextView = findViewById(R.id.inputTextView);

        // Hide the status bar
//        getWindow().setFlags(WindowManager.LayoutParams.FIRST_APPLICATION_WINDOW, WindowManager.LayoutParams.FIRST_SUB_WINDOW);
//        setContentView(R.layout.activity_main);
        Window window = this.getWindow();
        window.setStatusBarColor(getColor(R.color.orangeDark));


    } // end of onCreate fxn


    public void onDigitClick(View view){
        if(isNewop) inputTextView.setText("");
        isNewop = false;
        String number = inputTextView.getText().toString();
            int id = view.getId();
        if(id == R.id.btn0){
            number += "0";
        }else if(id == R.id.btn1){
            number += "1";
        }else if(id == R.id.btn2){
            number += "2";
        }else if(id == R.id.btn3){
            number += "3";
        }else if(id == R.id.btn4){
            number += "4";
        }else if(id == R.id.btn5){
            number += "5";
        }else if(id == R.id.btn6){
            number += "6";
        }else if(id == R.id.btn7){
            number += "7";
        }else if(id == R.id.btn8){
            number += "8";
        }else if(id == R.id.btn9){
            number += "9";
        }else if(id == R.id.btnDot){
            number += ".";
        }else if(id == R.id.btnplusminus){
            number = "-"+number;
        }
        inputTextView.setText(number);

    }

    public void onOperatorClick(View view){
        isNewop = true;
        oldNumber = inputTextView.getText().toString();
        int id = view.getId();

        if(id == R.id.btnDivide){
            ope = "/";
        }if(id == R.id.btnMultiply){
            ope = "*";
        }if(id == R.id.btnPlus){
            ope = "+";
        }if(id == R.id.btnMinus){
            ope = "-";
        }
    }

    public void onEqualClick(View view){
        String text = inputTextView.getText().toString();

        String newNumber = inputTextView.getText().toString();
        double result = 0.0;

        if(!text.isEmpty()){
            if(ope == "+"){
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
            }else if(ope == "-"){
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
            }else if(ope == "/"){
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
            }else if(ope == "*"){
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
            }
        }

        inputTextView.setText(result +"");
    }

    public void onClearClick(View view) {
        inputTextView.setText("");
    }

    public void onBackspaceClick(View view) {

        String text = inputTextView.getText().toString();
        if (!text.isEmpty()) {
            text = text.substring(0, text.length() - 1);
            inputTextView.setText(text);
        }
    }


    public void onPercentClicks(View view) {
        String text = inputTextView.getText().toString();
        if(!text.isEmpty()){
            double no = Double.parseDouble(inputTextView.getText().toString())/100;
            inputTextView.setText(no+"");
        }
    }

}
