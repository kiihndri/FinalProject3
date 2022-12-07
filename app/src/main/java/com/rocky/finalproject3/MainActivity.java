package com.rocky.finalproject3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {
    private Button button0, button1, button2, button3, button4, button5, button6,button7, button8, button9,  dotBtn, addBtn, subtractBtn, multiplyBtn, divideBtn, clearBtn, equalBtn, openParenthesesBtn, closeParenthesesBtn, plusMinusBtn, exponentBtn;
    private EditText input;
    private ImageButton deleteBtn;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        dotBtn = findViewById(R.id.dotBtn);
        addBtn = findViewById(R.id.addBtn);
        subtractBtn = findViewById(R.id.subtractBtn);
        multiplyBtn = findViewById(R.id.multiplyBtn);
        divideBtn = findViewById(R.id.divideBtn);
        clearBtn = findViewById(R.id.clearBtn);
        equalBtn = findViewById(R.id.equalBtn);
        input = findViewById(R.id.input);
        deleteBtn = findViewById(R.id.deleteBtn);
        openParenthesesBtn = findViewById(R.id.openBtn);
        closeParenthesesBtn = findViewById(R.id.closeBtn);
        plusMinusBtn = findViewById(R.id.plusMinusBtn);
        exponentBtn = findViewById(R.id.exponentBtn);
        output = findViewById(R.id.output);

        input.setShowSoftInputOnFocus(false);
        input.setSelection(input.getText().length());
        if(savedInstanceState != null){
            if(savedInstanceState.getString("input") != null || savedInstanceState.getString("input") != ""){
                output.setText(savedInstanceState.getString("input"));
                output.setVisibility(View.VISIBLE);
            }

            if(savedInstanceState.getString("output") != null || savedInstanceState.getString("output") != ""){
                output.setText(savedInstanceState.getString("output"));
                output.setVisibility(View.VISIBLE);
            }

        }


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInput("0");

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInput("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInput("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInput("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInput("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInput("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInput("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInput("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInput("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInput("9");
            }
        });

        dotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInput(".");
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInput("+");
            }
        });

        subtractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInput("-");
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInput("×");
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInput("÷");
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("");
                output.setVisibility(View.GONE);

            }
        });

        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Expression expression = new Expression(input.getText().toString().trim().replaceAll("÷","/").replaceAll("×","*"));

                output.setText(String.valueOf(expression.calculate()));
                output.setVisibility(View.VISIBLE);

            }
        });

        openParenthesesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInput("(");
            }
        });

        closeParenthesesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInput(")");
            }
        });

        plusMinusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldInput = input.getText().toString().trim();
                int cursorPosition = input.getSelectionStart();
                String plusMinusInput = oldInput.substring(0, cursorPosition);
                if(cursorPosition == 0){
                    input.setText("-" + input.getText().toString().trim());
                    input.setSelection(cursorPosition+1);
                    return;
                }
                for (int i=plusMinusInput.length() - 1;i>=0;i--){
                    char tempChar = plusMinusInput.charAt(i);
                    if(tempChar == ')' && i>0){
                        int j = i;
                        while(plusMinusInput.charAt(j) != '('){

                            if(plusMinusInput.charAt(j-1) == '(' && j>1){
                                if(j>=1){
                                    j--;
                                    if(plusMinusInput.charAt(j-1) == '+'){
                                        System.out.println("a");
                                        String leftInput = oldInput.substring(0, j-1);
                                        String rightInput = oldInput.substring(j);
                                        input.setText(leftInput+"-"+rightInput);
                                        input.setSelection(cursorPosition);
                                    }else if(plusMinusInput.charAt(j-1) == '-'){
                                        if (plusMinusInput.charAt(j-1) == '+' || plusMinusInput.charAt(j-1) == '×' || plusMinusInput.charAt(j-1) == '÷' ||plusMinusInput.charAt(j-1) == '%' ||plusMinusInput.charAt(j-1) == '^' ){
                                            System.out.println("b");
                                            StringBuilder strInput = new StringBuilder(oldInput);
                                            strInput.deleteCharAt(j-1);
                                            input.setText(strInput);
                                            input.setSelection(cursorPosition-1);
                                        }else if(plusMinusInput.charAt(j-1) == '-' && j-1 == 0){
                                            input.setText(oldInput.substring(j, oldInput.length()));
                                            input.setSelection(cursorPosition-1);

                                        }else{
                                            System.out.println("c");
                                            String leftInput = oldInput.substring(0, j-1);
                                            String rightInput = oldInput.substring(j);
                                            input.setText(leftInput + '+' + rightInput);
                                            input.setSelection(cursorPosition);
                                        }

                                    }  else{
                                        System.out.println("d");
                                        String leftInput = oldInput.substring(0, j+1);
                                        String rightInput = oldInput.substring(j+1);
                                        input.setText(leftInput+"-"+rightInput);
                                        input.setSelection(cursorPosition+1);
                                    }
                                }


                                break;
                            }else if(plusMinusInput.charAt(j-1) == '(' && (j == 1)){
                                if(plusMinusInput.charAt(j-1) == '-'){
                                    System.out.println("e");
                                    input.setText(oldInput.substring(j, oldInput.length()));
                                    input.setSelection(cursorPosition-1);
                                } else{
                                    System.out.println("f");
                                    input.setText("-" + input.getText().toString().trim());
                                    input.setSelection(cursorPosition+1);
                                }
                                break;
                            }else{
                                j--;
                            }
                        }
                        break;

                    }
                    else if( (tempChar == '+' || tempChar == '-' || tempChar == '×' || tempChar == '÷' || tempChar == '%' || tempChar == '^' || tempChar == '(' )&& i>0 ){
                        if(tempChar == '('){
                            if(tempChar == '+'){
                                System.out.println("gb");
                                String leftInput = oldInput.substring(0, i+1);
                                String rightInput = oldInput.substring(i+1);
                                input.setText(leftInput+"-"+rightInput);
                                input.setSelection(cursorPosition);
                            }else if(tempChar == '-'){

                                System.out.println("hb");
                                StringBuilder strInput = new StringBuilder(oldInput);
                                strInput.deleteCharAt(i);
                                input.setText(strInput);
                                input.setSelection(cursorPosition-1);


                            }  else{
                                System.out.println("jb");
                                String leftInput = oldInput.substring(0, i+1);
                                String rightInput = oldInput.substring(i+1);
                                input.setText(leftInput+"-"+rightInput);
                                input.setSelection(cursorPosition+1);
                            }
                        }else{
                            if(tempChar == '+'){
                                System.out.println("g");
                                String leftInput = oldInput.substring(0, i);
                                String rightInput = oldInput.substring(i+1);
                                input.setText(leftInput+"-"+rightInput);
                                input.setSelection(cursorPosition);
                            }else if(tempChar == '-'){
                                if (plusMinusInput.charAt(i-1) == '+' || plusMinusInput.charAt(i-1) == '×' || plusMinusInput.charAt(i-1) == '÷' ||plusMinusInput.charAt(i-1) == '%' ||plusMinusInput.charAt(i-1) == '^' ||plusMinusInput.charAt(i-1) == '(' ){
                                    System.out.println("h");
                                    StringBuilder strInput = new StringBuilder(oldInput);
                                    strInput.deleteCharAt(i);
                                    input.setText(strInput);
                                    input.setSelection(cursorPosition-1);
                                }else{
                                    System.out.println("i");
                                    String leftInput = oldInput.substring(0, i);
                                    String rightInput = oldInput.substring(i+1);
                                    input.setText(leftInput + '+' + rightInput);
                                    input.setSelection(cursorPosition);
                                }

                            }  else{
                                System.out.println("j");
                                String leftInput = oldInput.substring(0, i+1);
                                String rightInput = oldInput.substring(i+1);
                                input.setText(leftInput+"-"+rightInput);
                                input.setSelection(cursorPosition+1);
                            }
                        }


                        break;
                    }else if(i == 0){

                        if(tempChar == '-'){
                            System.out.println("k");
                            input.setText(oldInput.substring(i+1, oldInput.length()));
                            input.setSelection(cursorPosition-1);
                        }else if(tempChar == '('){
                            if(tempChar == '+'){
                                System.out.println("gb");
                                String leftInput = oldInput.substring(0, i+1);
                                String rightInput = oldInput.substring(i+1);
                                input.setText(leftInput+"-"+rightInput);
                                input.setSelection(cursorPosition);
                            }else if(tempChar == '-'){

                                System.out.println("hb");
                                StringBuilder strInput = new StringBuilder(oldInput);
                                strInput.deleteCharAt(i);
                                input.setText(strInput);
                                input.setSelection(cursorPosition-1);


                            }  else{
                                System.out.println("jb");
                                String leftInput = oldInput.substring(0, i+1);
                                String rightInput = oldInput.substring(i+1);
                                input.setText(leftInput+"-"+rightInput);
                                input.setSelection(cursorPosition+1);
                            }
                        }else{
                            System.out.println("l");
                            input.setText("-" + input.getText().toString().trim());
                            input.setSelection(cursorPosition+1);
                        }

                        break;

                    }

                }

            }
        });

        exponentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInput("^");
            }
        });


        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cursorPosition = input.getSelectionStart();
                int inputLength = input.getText().toString().trim().length();

                if (cursorPosition != 0 && inputLength != 0){
                    SpannableStringBuilder selection = (SpannableStringBuilder) input.getText();
                    selection.replace(cursorPosition-1, cursorPosition, "");
                    input.setText(selection);
                    input.setSelection(cursorPosition-1);
                }

                if(inputLength == 1){
                    output.setVisibility(View.GONE);
                }
            }
        });

    }

    private void updateInput(String inputText){
        String oldInput = input.getText().toString().trim();
        int cursorPosition = input.getSelectionStart();
        String leftInput = oldInput.substring(0, cursorPosition);
        String rightInput = oldInput.substring(cursorPosition);
        input.setText(leftInput+inputText+rightInput);
        input.setSelection(cursorPosition+1);
    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("input", input.getText().toString().trim());
        outState.putString("output", output.getText().toString().trim());
        super.onSaveInstanceState(outState);
    }


}