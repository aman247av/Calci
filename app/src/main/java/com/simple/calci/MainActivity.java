package com.simple.calci;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
TextView display;
String op="";
String oldNum="";
Button plus,minus,multi,div;
boolean New=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plus=findViewById(R.id.plus);
        minus=findViewById(R.id.minus);
        multi=findViewById(R.id.multi);
        div=findViewById(R.id.division);
        getSupportActionBar().hide();
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));

        display=findViewById(R.id.display1);

    }

    public void numberEvent(View view) {
        if (New)
            display.setText("0");
        New = false;
        int dot = 0;
        int min = 0;
        String number = display.getText().toString();
        if (number.length() < 10) {
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

            }
            if ((number.startsWith("-")) && number.charAt(1) == '0' && number.length() > 2)
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
        }


    }

    public void equalsEvent(View view) {
        String newNum=display.getText().toString();
        double result=0.0;
        multi.setTextColor(Color.parseColor("#FFFFFFFF"));
        div.setTextColor(Color.parseColor("#FFFFFFFF"));
        plus.setTextColor(Color.parseColor("#FFFFFFFF"));
        minus.setTextColor(Color.parseColor("#FFFFFFFF"));


        switch (op){
            case "+":

                result=Double.parseDouble(oldNum)+Double.parseDouble(newNum);
                break;
            case "-":

                result=Double.parseDouble(oldNum)-Double.parseDouble(newNum);
                break;
            case "*":

                result=Double.parseDouble(oldNum)*Double.parseDouble(newNum);
                break;
            case "/":

                result=Double.parseDouble(oldNum)/Double.parseDouble(newNum);
                break;
        }
        String dis=""+result;
        if(dis.length()>10)
            dis=dis.substring(0,8)+""+dis.substring(dis.length()-3);


        if((dis.substring((dis.length()-2)).equals(".0")))
            display.setText(dis.substring(0,dis.length()-2));
        else
            display.setText(dis+"");

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