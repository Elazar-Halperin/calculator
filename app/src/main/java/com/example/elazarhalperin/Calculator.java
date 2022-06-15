package com.example.elazarhalperin;

public class Calculator {
    private double firstNum;

    private String symbol;

    public Calculator() {
        firstNum = 0;

        symbol = "";
    }

    public void setFirstNum(double num) {
        firstNum = num;
    }

    public void plus(double num) {
        firstNum = num;
        symbol = "+";
    }

    public void minus(double num) {
        firstNum = num;
        symbol = "-";

    }

    public void mult(double num) {
        firstNum = num;
        symbol = "*";
    }

    public void divide(double num) {
        firstNum = num;
        symbol = "/";
    }

    public double equal(double num) {
        switch (symbol) {
            case "+":
                return firstNum + num;
            case "-":
                return firstNum - num;
            case "*":
                return firstNum * num;
            case "/":
                if(num == 0) return -1;
                return firstNum / num;

        }
        return 0;
    }
}
