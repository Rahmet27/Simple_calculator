package com.example.hesap_makinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private TextView resultTextView, calculationTextView;
    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnEquals, btnClear,btnBackspace, btnDecimal;

    private double operand1 = Double.NaN;
    private double operand2;
    private String operator;

    private String currentCalculation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.result);
        calculationTextView = findViewById(R.id.calculation);

        btnZero = findViewById(R.id.btn_zero);
        btnOne = findViewById(R.id.btn_one);
        btnTwo = findViewById(R.id.btn_two);
        btnThree = findViewById(R.id.btn_three);
        btnFour = findViewById(R.id.btn_four);
        btnFive = findViewById(R.id.btn_five);
        btnSix = findViewById(R.id.btn_six);
        btnSeven = findViewById(R.id.btn_seven);
        btnEight = findViewById(R.id.btn_eight);
        btnNine = findViewById(R.id.btn_nine);
        btnAdd = findViewById(R.id.btn_add);
        btnSubtract = findViewById(R.id.btn_subtract);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnDivide = findViewById(R.id.btn_divide);
        btnEquals = findViewById(R.id.btn_equals);
        btnClear = findViewById(R.id.btn_clear);
        btnDecimal = findViewById(R.id.btn_dot);
        btnBackspace = findViewById(R.id.btn_backspace);

        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnDecimal.setOnClickListener(this);
        btnBackspace.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_zero:
                appendNumber("0");
                break;
            case R.id.btn_one:
                appendNumber("1");
                break;
            case R.id.btn_two:
                appendNumber("2");
                break;
            case R.id.btn_three:
                appendNumber("3");
                break;
            case R.id.btn_four:
                appendNumber("4");
                break;
            case R.id.btn_five:
                appendNumber("5");
                break;
            case R.id.btn_six:
                appendNumber("6");
                break;
            case R.id.btn_seven:
                appendNumber("7");
                break;
            case R.id.btn_eight:
                appendNumber("8");
                break;
            case R.id.btn_nine:
                appendNumber("9");
                break;
            case R.id.btn_add:
                performOperation("+");
                break;
            case R.id.btn_subtract:
                performOperation("-");
                break;
            case R.id.btn_multiply:
                performOperation("*");
                break;
            case R.id.btn_divide:
                performOperation("/");
                break;
            case R.id.btn_equals:
                performEquals();
                break;
            case R.id.btn_clear:
                clearCalculator();
                break;
            case R.id.btn_dot:
                appendDecimal();
                break;
            case R.id.btn_backspace:
                handleBackspace();
        }
    }

    private void appendNumber(String number) {
        String currentText = resultTextView.getText().toString();
        if (currentText.equals("0")) {
            resultTextView.setText(number);
        } else {
            resultTextView.setText(currentText + number);
        }
    }

    private void appendDecimal() {
        String currentText = resultTextView.getText().toString();
        if (!currentText.contains(".")) {
            resultTextView.setText(currentText + ".");
        }
    }

    private void handleBackspace() {
        String currentResultText = resultTextView.getText().toString();
        if (!currentResultText.isEmpty()) {
            resultTextView.setText(currentResultText.substring(0, currentResultText.length() - 1));
        } else {
            String currentCalculationText = calculationTextView.getText().toString();
            if (!currentCalculationText.isEmpty()) {
                calculationTextView.setText(currentCalculationText.substring(0, currentCalculationText.length() - 1));
            }
        }
    }


    private void performOperation(String operator) {
        String currentText = resultTextView.getText().toString();
        if (!currentText.isEmpty()) {
            this.operator = operator;
            operand1 = Double.parseDouble(currentText);
            calculationTextView.setText(currentText + " " + operator);
            resultTextView.setText("");

        }
    }

    private void performEquals() {
        String currentText = resultTextView.getText().toString();
        if (!Double.isNaN(operand1) && !currentText.isEmpty()) {
            operand2 = Double.parseDouble(currentText);
            double result = 0;
            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    result = operand1 / operand2;
                    break;
            }
            calculationTextView.setText(operand1 + " " + operator + " " + operand2);
            resultTextView.setText(Double.toString(result));
            operand1 = Double.NaN;
            operator = "";
        }
    }

    private void clearCalculator() {
        operand1 = Double.NaN;
        operand2 = 0;
        operator = "";
        resultTextView.setText("0");
        calculationTextView.setText("");
    }
}
