package com.example.elazarhalperin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.*;

import java.sql.SQLXML;

public class MainActivity extends AppCompatActivity {

    private boolean isDot;
    private Expression expression;
    private EditText editText;
    private int parenthesisNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.input);
        editText.setFocusableInTouchMode(false);
        editText.setText("");

        isDot = false;

        parenthesisNum = 0;
    }

    public void numberButtonCLicked(View view) {

        Button clickedBtn = (Button) view;
        if(clickedBtn.getText().equals(".") && isDot) return;
        if(clickedBtn.getText().equals(".")) {
            updateText(".");
            isDot = true;
            return;
        }

        try {
            String last = editText.getText().toString().substring(editText.getText().length() - 1);

            if (!editText.getText().equals("")) {
                if (last.equals("÷") && clickedBtn.getText().equals("0")) {
                    Toast.makeText(this, "Can't divide by 0", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        } catch (Exception e) {
            e.getCause();
        }
        updateText(clickedBtn.getText().toString());

    }




    public void addButton(View view) {
        if(isEmpty()) return;
        isDot = false;
        if(isSymbolBefore()) {
            replaceLast(((Button) view).getText().toString());
            return;
        }

        updateText(((Button) view).getText().toString());

    }

    public void subtractButton(View view) {
        if(isEmpty()) return;
        isDot = false;
        if(isSymbolBefore()) {
            replaceLast(((Button) view).getText().toString());
            return;
        }

        updateText(((Button) view).getText().toString());

    }

    public void deleteButton(View view)  {
        if(editText.getText().length() < 1) {
            return;
        }
        deleteLastChar();
    }

    public void multButton(View view) {
        if(isEmpty()) return;
        isDot = false;
        if(isSymbolBefore()) {
            replaceLast(((Button) view).getText().toString());
            return;
        }

        updateText(((Button) view).getText().toString());

    }

    public void divideButton(View view) {
        if(isEmpty()) return;
        isDot = false;
        if(isSymbolBefore()) {
            replaceLast(((Button) view).getText().toString());
            return;
        }

        updateText(((Button) view).getText().toString());
    }

    public void allClear(View view) {
        editText.setText("");
        isDot = false;
        parenthesisNum = 0;
    }

    public void equalButton(View view) {
        if(isEmpty()) return;
        if(parenthesisNum > 0) {
            Toast.makeText(this, " you have to close the parenthesis", Toast.LENGTH_SHORT).show();
            return;
        }
        Expression expression = new Expression(editText.getText().toString());
        double result = expression.calculate();
        Log.d("Error", expression.getErrorMessage());
        if(result % 1 == 0){
            editText.setText(Integer.toString((int) result));
            isDot = false;
        }
        else {

            editText.setText(Double.toString(result));
            isDot = true;
        }


    }

    public void parenthesisButton(View view) {
        String last = "";
        try {
            last = editText.getText().toString().substring(editText.getText().length() - 1);
        } catch (Exception e) {
            Log.d("error", "hi");
        }

        if(parenthesisNum == 0) {
            updateText("(");
            parenthesisNum++;
            isDot = false;
            return;
        }
        if(last.equals("(")) {
            updateText("(");
            parenthesisNum++;
            isDot = false;
            return;
        }
        if(isSymbolBefore()) {
            replaceLast(")");
            parenthesisNum--;
            return;
        }
        updateText(")");
        parenthesisNum--;
    }

    private void updateText(String text) {

        if (editText.getText().length() >= 40) {
            Toast.makeText(this, "Max characters is 40", Toast.LENGTH_SHORT).show();
            return;
        }
        editText.setText(editText.getText().toString() + text);
        if (editText.getText().length() >= 15) {
            editText.setTextSize(40);
        }

    }



    private void deleteLastChar() {
        String text =  editText.getText().toString().substring(0, editText.getText().length() - 1);
        editText.setText(text);
    }

    private boolean isEmpty() {
        return editText.getText().toString().equals("");
    }

    private boolean isSymbolBefore() {
        String textInput = editText.getText().toString();
        if(textInput.charAt(textInput.length() - 1) == '+') return true;
        if(textInput.charAt(textInput.length() - 1) == '-') return true;
        if(textInput.charAt(textInput.length() - 1) == '÷') return true;
        if(textInput.charAt(textInput.length() - 1) == '×') return true;
        return false;
    }

    private void replaceLast(String symbol) {
        String text = editText.getText().toString().substring(0, editText.getText().length() - 1);
        editText.setText(text + symbol);
    }


}