package com.example.elazarhalperin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;




import java.sql.SQLXML;

public class MainActivity extends AppCompatActivity {

    private Calculator calc;

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.represent) ;
        editText.setFocusable(false);

        editText.setText("0");

        calc = new Calculator();
    }

    public void plusButton(View view) {
        calc.plus(Double.parseDouble(editText.getText().toString()));
        editText.setText("0");
    }

    public void minusButton(View view) {
        calc.minus(Double.parseDouble(editText.getText().toString()));
        editText.setText("0");
    }

    public void multButton(View view) {
        calc.mult(Double.parseDouble(editText.getText().toString()));
        editText.setText("0");
    }

    public void divideButton(View view) {
        calc.divide(Double.parseDouble(editText.getText().toString()));
        editText.setText("0");
    }

    public void allClearButton(View view) {
        editText.setText("0");
        calc.setFirstNum(0);
    }

}