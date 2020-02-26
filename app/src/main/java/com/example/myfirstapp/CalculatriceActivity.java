package com.example.myfirstapp;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;


import java.util.Calendar;
import java.util.Objects;



public class CalculatriceActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView screenAns;
    private TextView screenMath;

    private StringBuilder textMath = new StringBuilder();
    private StringBuilder textAns = new StringBuilder("0");
    private StringBuilder screenTextMath = new StringBuilder();
    private int checkSubmit = 0;

    private final int[] idArray = {
            R.id.btnClear,
            R.id.btnSeven,R.id.btnNine,R.id.btnEight,R.id.btnDiv,R.id.btnMod,
            R.id.btnFour,R.id.btnFive,R.id.btnSix,R.id.btnMulti,R.id.btnPlusMoins,R.id.btnCall,
            R.id.btnOne,R.id.btnTwo,R.id.btnThree,R.id.btnMinus,R.id.btnAdd,R.id.btnResult,R.id.txtCal,
            R.id.btnZero,R.id.btnDot
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculatrice);

        screenAns = findViewById(R.id.txtResult);
        screenMath = findViewById(R.id.txtCal);

        for (int anIdArray : idArray) if(findViewById(anIdArray) != null) (findViewById(anIdArray)).setOnClickListener(this);

    }


    private void calculIntermediaire(String s) {
        //if(!Utils.isNotEmptyString(s)) s = "0";
        if (!s.matches("[a-wyzA-Z]+")){
            screenMath.setText(s);
            textMath = new StringBuilder(screenMath.getText().toString());
            screenTextMath = textMath;
            submit();
        } else {
            Toast.makeText(this, "Expression incorrecte", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        screenAns = findViewById(R.id.txtResult);
        screenMath = findViewById(R.id.txtCal);

        CharSequence reponse = screenAns.getText().toString();
        CharSequence expression = screenMath.getText().toString();

        outState.putCharSequence("reponse", reponse);
        outState.putCharSequence("expression", expression);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        screenAns = findViewById(R.id.txtResult);
        screenMath = findViewById(R.id.txtCal);

        CharSequence reponse =  Objects.requireNonNull(savedInstanceState.getCharSequence("reponse")).toString();
        CharSequence expression =  Objects.requireNonNull(savedInstanceState.getCharSequence("expression")).toString();
        screenAns.setText(reponse);
        screenMath.setText(expression);
    }



    private void submit(){

        StringToExpressionFix ITP = new  StringToExpressionFix();
        String[] elementMath = null;

        if (textMath.length()>0){

            char c = textMath.charAt(textMath.length() - 1);
            if(c == '-' || (c == '+') || (c == '/') || (c == '*')) {
                textMath.setLength(textMath.length() - 1);
                screenTextMath.setLength(screenTextMath.length() - 1);
                screenMath.setText(screenTextMath.toString());
            }

            try{
                if (!ITP.check_error) elementMath = ITP.processString(textMath.toString());
                //	On sépare l'expression en sous éléments
                if (!ITP.check_error) elementMath = ITP.postfix(elementMath);
                // 	On verifie les priorités et on formate le resultat pour l'affichage
                if (!ITP.check_error) textAns = new StringBuilder(ITP.valueMath(elementMath)); // On récupere le résultat

                screenAns.setText(textAns.toString());

                if (!ITP.check_error){

                    String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

                }

            }catch(Exception e){}

        }
    }



    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {

            case R.id.btnZero:
                if (screenTextMath.length() < 38) {    //if length < 38
                    if (checkSubmit == 1) {
                        screenTextMath = new StringBuilder();
                        textMath = new StringBuilder();
                        checkSubmit = 0;
                    }
                    textMath.append("0");
                    screenTextMath.append("0");
                }
                screenMath.setText(screenTextMath.toString());
                break;
            case R.id.btnOne:
                if (screenTextMath.length() < 38) {    //if length < 38
                    if (checkSubmit == 1) {
                        screenTextMath = new StringBuilder();
                        textMath = new StringBuilder();
                        checkSubmit = 0;
                    }
                    textMath.append("1");
                    screenTextMath.append("1");
                }
                screenMath.setText(screenTextMath.toString());
                break;
            case R.id.btnTwo:
                if (screenTextMath.length() < 38) {    //if length < 38
                    if (checkSubmit == 1) {
                        screenTextMath = new StringBuilder();
                        textMath = new StringBuilder();
                        checkSubmit = 0;
                    }
                    textMath.append("2");
                    screenTextMath.append("2");
                }
                screenMath.setText(screenTextMath.toString());
                break;
            case R.id.btnThree:
                if (screenTextMath.length() < 38) {    //if length < 38
                    if (checkSubmit == 1) {
                        screenTextMath = new StringBuilder();
                        textMath = new StringBuilder();
                        checkSubmit = 0;
                    }
                    textMath.append("3");
                    screenTextMath.append("3");
                }

                screenMath.setText(screenTextMath.toString());
                break;
            case R.id.btnFour:
                if (screenTextMath.length() < 38) {    //if length < 38
                    if (checkSubmit == 1) {
                        screenTextMath = new StringBuilder();
                        textMath = new StringBuilder();
                        checkSubmit = 0;
                    }
                    textMath.append("4");
                    screenTextMath.append("4");
                }
                screenMath.setText(screenTextMath.toString());
                break;
            case R.id.btnFive:
                if (screenTextMath.length() < 38) {    //if length < 38
                    if (checkSubmit == 1) {
                        screenTextMath = new StringBuilder();
                        textMath = new StringBuilder();
                        checkSubmit = 0;
                    }
                    textMath.append("5");
                    screenTextMath.append("5");
                }
                screenMath.setText(screenTextMath.toString());
                break;
            case R.id.btnSix:
                if (screenTextMath.length() < 38) {    //if length < 38
                    if (checkSubmit == 1) {
                        screenTextMath = new StringBuilder();
                        textMath = new StringBuilder();
                        checkSubmit = 0;
                    }
                    textMath.append("6");
                    screenTextMath.append("6");
                }
                screenMath.setText(screenTextMath.toString());
                break;
            case R.id.btnSeven:
                if (screenTextMath.length() < 38) {    //if length < 38
                    if (checkSubmit == 1) {
                        screenTextMath = new StringBuilder();
                        textMath = new StringBuilder();
                        checkSubmit = 0;
                    }
                    textMath.append("7");
                    screenTextMath.append("7");
                }
                screenMath.setText(screenTextMath.toString());
                break;
            case R.id.btnEight:
                if (screenTextMath.length() < 38) {    //if length < 38
                    if (checkSubmit == 1) {
                        screenTextMath = new StringBuilder();
                        textMath = new StringBuilder();
                        checkSubmit = 0;
                    }
                    textMath.append("8");
                    screenTextMath.append("8");
                }
                screenMath.setText(screenTextMath.toString());
                break;
            case R.id.btnNine:
                if (screenTextMath.length() < 38) {    //if length < 38
                    if (checkSubmit == 1) {
                        screenTextMath = new StringBuilder();
                        textMath = new StringBuilder();
                        checkSubmit = 0;
                    }
                    textMath.append("9");
                    screenTextMath.append("9");
                }
                screenMath.setText(screenTextMath.toString());
                break;
            case R.id.btnDot:

                if (screenMath.length() > 0 && textMath.length() > 0) {
                    char c = textMath.charAt(textMath.length() - 1);
                    if (c == '.') break;
                }

                if (screenTextMath.length() < 38) {    //if length < 38
                    if (checkSubmit == 1) {
                        screenTextMath = new StringBuilder();
                        textMath = new StringBuilder();
                        checkSubmit = 0;
                    }
                    if (textMath.length() > 0) {
                        char c = textMath.charAt(textMath.length() - 1);
                        if(c != '.') {
                            textMath.append(".");
                            screenTextMath.append(",");
                        }
                    }
                }
                screenMath.setText(screenTextMath.toString());
                break;

            case R.id.btnAdd:
                if (screenTextMath.length() > 0) {
                    if (screenTextMath.length() < 38) {    //if length < 38
                        if (checkSubmit == 1) {
                            screenTextMath = new StringBuilder();
                            textMath = new StringBuilder();
                            checkSubmit = 0;
                        }
                        if (textMath.length() > 0) {
                            char c = textMath.charAt(textMath.length() - 1);
                            if(c != '+' && (c != '*') && (c != '-') && (c != '/')) {
                                textMath.append("+");
                                screenTextMath.append("+");
                            }
                        }

                    }
                    screenMath.setText(screenTextMath.toString());
                }
                break;
            case R.id.btnMinus:
                if (screenTextMath.length() < 38) {    //if length < 38
                    if (checkSubmit == 1) {
                        screenTextMath = new StringBuilder();
                        textMath = new StringBuilder();
                        checkSubmit = 0;
                    }
                    if (textMath.length() > 0) {
                        char c = textMath.charAt(textMath.length() - 1);
                        if(c != '-' && (c != '+')) {
                            textMath.append("-");
                            screenTextMath.append("-");
                        }
                    }

                }
                screenMath.setText(screenTextMath.toString());
                break;
            case R.id.btnMulti:
                if (screenTextMath.length() > 0) {
                    if (screenTextMath.length() < 38) {    //if length < 38
                        if (checkSubmit == 1) {
                            screenTextMath = new StringBuilder();
                            textMath = new StringBuilder();
                            checkSubmit = 0;
                        }
                        if (textMath.length() > 0) {
                            char c = textMath.charAt(textMath.length() - 1);
                            if(c != '*' && (c != '/') && (c != '-') && (c != '+')) {
                                textMath.append("*");
                                screenTextMath.append("×");
                            }
                        }
                    }
                    screenMath.setText(screenTextMath.toString());
                }
                break;
            case R.id.btnDiv:
                if (screenTextMath.length() > 0) {
                    if (screenTextMath.length() < 38) {    //if length < 38
                        if (checkSubmit == 1) {
                            screenTextMath = new StringBuilder();
                            textMath = new StringBuilder();
                            checkSubmit = 0;
                        }
                        if (textMath.length() > 0) {
                            char c = textMath.charAt(textMath.length() - 1);
                            if(c != '/' && (c != '*') && (c != '-') && (c != '+') && (c != '@')) {
                                textMath.append("/");
                                screenTextMath.append("÷");
                            }
                        }

                    }
                    screenMath.setText(screenTextMath.toString());
                }
                break;

            case R.id.btnMod:
                if (screenTextMath.length() > 0) {
                    if (screenTextMath.length() < 38) {    //if length < 38
                        if (checkSubmit == 1) {
                            screenTextMath = new StringBuilder();
                            textMath = new StringBuilder();
                            checkSubmit = 0;
                        }
                        if (textMath.length() > 0) {
                            char c = textMath.charAt(textMath.length() - 1);
                            if(c != '/' && (c != '*') && (c != '-') && (c != '+') && (c != '@')) {
                                textMath.append("%");
                                screenTextMath.append("%");
                            }
                        }

                    }
                    screenMath.setText(screenTextMath.toString());
                }
                break;
            case R.id.btnPlusMoins:
                if (screenTextMath.length() < 1) screenTextMath = new StringBuilder("0");
                screenTextMath = new StringBuilder("-(" + screenTextMath + ")");
                textMath.append("~");
                screenMath.setText(screenTextMath.toString());
                if (checkSubmit == 0) submit();
                break;

            case R.id.btnResult:
                if (screenTextMath.length() == 0){
                    break;
                }

                if (textMath.length()>0) {
                    char c = textMath.charAt(textMath.length() - 1);
                    if (c == '@') {
                        textMath.append("1");
                        screenTextMath.append("1");
                        screenMath.append("1");
                    }
                }

                submit();
                break;
            case R.id.btnClear:
                textMath = new StringBuilder();
                screenTextMath = new StringBuilder();
                textAns = new StringBuilder("0");
                screenAns.setText(textAns.toString());
                screenMath.setText("|");
                break;

        }
    }


}
