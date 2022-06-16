package com.example.elazarhalperin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import org.mariuszgromada.math.mxparser.*;

import java.sql.SQLXML;

public class MainActivity extends AppCompatActivity {

    private boolean isDot;
    private Expression expression;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.input);
        editText.setFocusableInTouchMode(false);
        editText.setText("");

        isDot = false;
    }

    public void numberButtonCLicked(View view) {
        Button clickedBtn = (Button) view;
        if(clickedBtn.getText().equals(".") && isDot) return;
        if(clickedBtn.getText().equals(".")) {
            updateText(".");
            isDot = true;
            return;
        }
        updateText(clickedBtn.getText().toString());
    }

    private void updateText(String text) {
        editText.setText(editText.getText().toString() + text);
    }


    public void addButton(View view) {
        if(isEmpty()) return;

    }

    private boolean isEmpty() {
        return editText.getText().toString().equals("");
    }

    private isSymbolBefore()

}