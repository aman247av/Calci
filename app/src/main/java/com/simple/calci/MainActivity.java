package com.simple.calci;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
TextView display;
String op="";
String oldNum="";
Button plus,minus,multi,div,rad;
boolean New=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        multi=findViewById(R.id.multi);
        div=findViewById(R.id.division);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));

        display=findViewById(R.id.display1);

        rad=findViewById(R.id.rad);


    }

    @SuppressLint("SetTextI18n")
    public void numberEvent(View view) {
        if (New)
            display.setText("0");
        New = false;
        int dot = 0;
        int min = 0;
        int dis_limit;
        String number = display.getText().toString();
        String diss=display.getText().toString();
        if(diss.endsWith("NaN") || diss.endsWith("Error") || diss.endsWith("Infinity"))
            number="";

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE)
            dis_limit=16;
        else
            dis_limit=10;

        if (number.length() < dis_limit) {
            for (int i = 0; i < number.length(); i++) {
                char ch = number.charAt(i);
                switch (ch) {
                    case '.':
                        dot++;
                        break;
                    case '-':
                        min++;
                }
            }
            try {

                switch (view.getId()) {
                    case R.id.one:
                        number += "1";
                        break;
                    case R.id.two:
                        number += "2";
                        break;
                    case R.id.three:
                        number += "3";
                        break;
                    case R.id.four:
                        number += "4";
                        break;
                    case R.id.five:
                        number += "5";
                        break;
                    case R.id.six:
                        number += "6";
                        break;
                    case R.id.seven:
                        number += "7";
                        break;
                    case R.id.eight:
                        number += "8";
                        break;
                    case R.id.nine:
                        number += "9";
                        break;
                    case R.id.zero:
                        if (!number.equals("0"))
                            number += "0";
                        break;
                    case R.id.point:
                        if (dot < 1)
                            number += ".";
                        break;
                    case R.id.plus_minus:
                        if (min < 1)
                            number = "-" + number;
                        else
                            number = number.substring(1);
                        break;
                    case R.id.ln:
                        number = "" + Math.log(Double.parseDouble(number));
                        break;
                    case R.id.logx:
                        number = "" + Math.log10(Double.parseDouble(number));
                        break;
                    case R.id._10:
                        number = "" + Math.pow(10.0, Double.parseDouble(number));
                        break;
                    case R.id.sq:
                        number = "" + Math.pow(Double.parseDouble(number), 2);
                        break;
                    case R.id.cb:
                        number = "" + Math.pow(Double.parseDouble(number), 3);
                        break;
                    case R.id.exp:
                        number = "" + Math.exp(Double.parseDouble(number));

                        break;
                    case R.id.recipo:
                        number = "" + (1 / Double.parseDouble(number));
                        break;
                    case R.id.sqroot:
                        number = "" + Math.sqrt(Double.parseDouble(number));
                        break;
                    case R.id.cbroot:
                        number = "" + Math.cbrt(Double.parseDouble(number));

                        break;
                    case R.id.perc:
                        number = "" + Double.parseDouble(number) / 100;
                        break;
                    case R.id.xfact:
                        int fact = 1;
                        for (int i = 1; i <= Double.parseDouble(number); i++)
                            fact *= i;
                        number = "" + fact;
                        break;
                    case R.id.sin:
                        number = "" + Math.sin(Double.parseDouble(number));
                        break;
                    case R.id.cos:
                        number = "" + Math.cos(Double.parseDouble(number));
                        break;
                    case R.id.tan:
                        number = "" + Math.tan(Double.parseDouble(number));
                        break;
                    case R.id.e:
                        if (number.equals("0"))
                            number = "" + 2.71828182845905;
                        break;
                    case R.id.sinh:
                        number = "" + Math.sinh(Double.parseDouble(number));
                        break;
                    case R.id.cosh:
                        number = "" + Math.cosh(Double.parseDouble(number));
                        break;
                    case R.id.tanh:
                        number = "" + Math.tanh(Double.parseDouble(number));
                        break;
                    case R.id.pi:
                        if (number.equals("0"))
                            number = "" + 3.14159265358979;
                        break;
                    case R.id.dzero:
                        if(!number.startsWith("0")||number.startsWith("0."))
                            number+="00";
                }
            }catch (Exception e) {
                display.setText("Error");
            }

            if ((number.startsWith("-")) && number.charAt(1) == '0' && number.length() > 2&&number.charAt(2)!='.')
                number = number.charAt(0) + "" + number.substring(2);
            if (number.charAt(0) == '0' && number.length() == 2)
                number = number.substring(1);
            if (number.length() == 1 && number.charAt(0) == '.')
                number = 0 + "" + number;

            display.setText(number);
        }
    }

    public void operatorEvent(View view) {
        New=true;
        oldNum=display.getText().toString();

        switch (view.getId()){
            case R.id.division:
                op="/";
                div.setTextColor(Color.parseColor("#000000"));
                minus.setTextColor(Color.parseColor("#FFFFFFFF"));
                multi.setTextColor(Color.parseColor("#FFFFFFFF"));
                plus.setTextColor(Color.parseColor("#FFFFFFFF"));
                break;
            case R.id.multi:
                op="*";
                minus.setTextColor(Color.parseColor("#FFFFFFFF"));
                div.setTextColor(Color.parseColor("#FFFFFFFF"));
                plus.setTextColor(Color.parseColor("#FFFFFFFF"));
                multi.setTextColor(Color.parseColor("#000000"));
                break;
            case R.id.plus:

                op="+";
                multi.setTextColor(Color.parseColor("#FFFFFFFF"));
                minus.setTextColor(Color.parseColor("#FFFFFFFF"));
                div.setTextColor(Color.parseColor("#FFFFFFFF"));
                plus.setTextColor(Color.parseColor("#000000"));
                break;
            case R.id.minus:
                op="-";
                multi.setTextColor(Color.parseColor("#FFFFFFFF"));
                div.setTextColor(Color.parseColor("#FFFFFFFF"));
                plus.setTextColor(Color.parseColor("#FFFFFFFF"));
                minus.setTextColor(Color.parseColor("#000000"));
                break;
            case R.id.xroot:
                op="pow";
                break;
            case R.id.yroot:
                op="root";
                break;
        }


    }

    @SuppressLint("SetTextI18n")
    public void equalsEvent(View view) {
        String newNum=display.getText().toString();
        double result=0.0;
        multi.setTextColor(Color.parseColor("#FFFFFFFF"));
        div.setTextColor(Color.parseColor("#FFFFFFFF"));
        plus.setTextColor(Color.parseColor("#FFFFFFFF"));
        minus.setTextColor(Color.parseColor("#FFFFFFFF"));

        try {

            switch (op) {
                case "+":

                    result = Double.parseDouble(oldNum) + Double.parseDouble(newNum);
                    break;
                case "-":

                    result = Double.parseDouble(oldNum) - Double.parseDouble(newNum);
                    break;
                case "*":

                    result = Double.parseDouble(oldNum) * Double.parseDouble(newNum);
                    break;
                case "/":

                    result = Double.parseDouble(oldNum) / Double.parseDouble(newNum);
                    break;
                case "pow":
                    result=Math.pow(Double.parseDouble(oldNum),Double.parseDouble(newNum));
                    break;
                case "root":
                    result=Math.round(Math.pow(Double.parseDouble(oldNum),1/Double.parseDouble(newNum)));
                    break;
            }
            String dis = "" + result;
            int orientation = getResources().getConfiguration().orientation;
            if (orientation != Configuration.ORIENTATION_LANDSCAPE) {
                // In landscape
                if (dis.length() > 10)
                    dis = dis.substring(0, 8) + "" + dis.substring(dis.length() - 3);
            }



            if ((dis.substring((dis.length() - 2)).equals(".0")))
                display.setText(dis.substring(0, dis.length() - 2));
            else
                display.setText(dis + "");
        }catch (Exception e){
            display.setText("Error");
        }

    }



    public void cEvent(View view) {
        display.setText("0");
        div.setTextColor(Color.parseColor("#FFFFFFFF"));
        minus.setTextColor(Color.parseColor("#FFFFFFFF"));
        multi.setTextColor(Color.parseColor("#FFFFFFFF"));
        plus.setTextColor(Color.parseColor("#FFFFFFFF"));
        New=true;
    }

    public void BackS(View view) {

            String ss=display.getText().toString();
            if(ss.length()!=1)
            display.setText(ss.substring(0,ss.length()-1));
            else
                display.setText("0");

        New=false;
    }
}