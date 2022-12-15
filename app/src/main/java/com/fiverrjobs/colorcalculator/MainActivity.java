package com.fiverrjobs.colorcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText firstNumber = findViewById(R.id.button), secondNumber = findViewById(R.id.button2);
        RadioGroup operators = findViewById(R.id.operators);
        RadioButton plus = findViewById(R.id.plus), minus = findViewById(R.id.minus), multi = findViewById(R.id.multi), div = findViewById(R.id.div);
        Button equals = findViewById(R.id.equals), sign = findViewById(R.id.sign);
        TextView result = findViewById(R.id.result);
        ConstraintLayout layout = findViewById(R.id.layout);
            plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sign.setText("+");
                }
            });
            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sign.setText("-");
                }
            });
            multi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sign.setText("x");
                }
            });
            div.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sign.setText("/");
                }
            });
            sign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (color != 0) {
                        findViewById(R.id.layout).setBackgroundResource(R.color.white);
                        color = 0;
                    }else{
                            if (sign.getText().equals("/")) {
                                findViewById(R.id.layout).setBackgroundResource(R.color.div);
                                color = 1;
                            } else if (sign.getText().equals("x")) {
                                findViewById(R.id.layout).setBackgroundResource(R.color.multi);
                                color = 2;
                            } else if (sign.getText().equals("+")) {
                                findViewById(R.id.layout).setBackgroundResource(R.color.plus);
                                color = 3;
                            } else if (sign.getText().equals("-")) {
                                findViewById(R.id.layout).setBackgroundResource(R.color.minus);
                                color = 4;
                            }
                        }
                    }
            });
            equals.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!(firstNumber.getText().toString().equals("")) && !(secondNumber.getText().toString().equals(""))) {
                        double firstNumValue = Double.parseDouble(firstNumber.getText().toString()), secondNumValue = Double.parseDouble(secondNumber.getText().toString());
                        int operatorButtonId = operators.getCheckedRadioButtonId();
                        Double answer = 0.0;
                        if (operatorButtonId == plus.getId()) {
                            answer = firstNumValue + secondNumValue;
                        } else if (operatorButtonId == minus.getId()) {
                            answer = firstNumValue - secondNumValue;
                        }
                        else if (operatorButtonId == multi.getId()) {
                            answer = firstNumValue * secondNumValue;
                        }
                        else if (operatorButtonId == div.getId()) {
                            answer = firstNumValue / secondNumValue;
                        }
                        result.setText(answer.toString());
                    }
                }
            });
        }
    }