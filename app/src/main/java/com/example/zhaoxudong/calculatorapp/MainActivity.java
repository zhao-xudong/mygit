package com.example.zhaoxudong.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.function.DoublePredicate;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*
    数字
     */
    private Button number0;
    private Button number1;
    private Button number2;
    private Button number3;
    private Button number4;
    private Button number5;
    private Button number6;
    private Button number7;
    private Button number8;
    private Button number9;

    /*
    运算符
     */
    private Button add_but;//加法
    private Button sub_but;//减法
    private Button mult_but;//乘法
    private Button div_but;//除法

    /*
    等号
    小数点
    归零
     */
    private Button sign_but;//等号
    private Button spot_but;//小数点
    private Button CE_but;//归零键
    private Button del_but;
    private Button sin;
    private Button cos;
    /*
    结果
     */
    private EditText result;
    private boolean clear_flag;//清空标识

    /*
    对各个按钮的初始化
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        数字
         */
        number0 = (Button) findViewById(R.id.number0);
        number1 = (Button) findViewById(R.id.number1);
        number2 = (Button) findViewById(R.id.number2);
        number3 = (Button) findViewById(R.id.number3);
        number4 = (Button) findViewById(R.id.number4);
        number5 = (Button) findViewById(R.id.number5);
        number6 = (Button) findViewById(R.id.number6);
        number7 = (Button) findViewById(R.id.number7);
        number8 = (Button) findViewById(R.id.number8);
        number9 = (Button) findViewById(R.id.number9);
        /*
        运算符
         */
        add_but = (Button) findViewById(R.id.add_but);
        sub_but = (Button) findViewById(R.id.sub_but);
        mult_but = (Button) findViewById(R.id.mult_but);
        div_but = (Button) findViewById(R.id.div_but);
        /*
        等号
        小数点
        归零
         */
        sign_but = (Button) findViewById(R.id.sign_but);//等号
        spot_but = (Button) findViewById(R.id.spot_but);//小数点
        CE_but = (Button) findViewById(R.id.CE);//归零
        del_but = (Button) findViewById(R.id.del);
        sin=(Button) findViewById(R.id.sin);
        cos=(Button) findViewById(R.id.cos);
        /*
        结果
         */
        result = (EditText) findViewById(R.id.result_Text);


    /*
    初始化事件
     */

        number0.setOnClickListener(this);
        number1.setOnClickListener(this);
        number2.setOnClickListener(this);
        number3.setOnClickListener(this);
        number4.setOnClickListener(this);
        number5.setOnClickListener(this);
        number6.setOnClickListener(this);
        number7.setOnClickListener(this);
        number8.setOnClickListener(this);
        number9.setOnClickListener(this);

        add_but.setOnClickListener(this);
        sub_but.setOnClickListener(this);
        mult_but.setOnClickListener(this);
        div_but.setOnClickListener(this);

        sign_but.setOnClickListener(this);
        spot_but.setOnClickListener(this);
        CE_but.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str = result.getText().toString();
        switch (v.getId()) {
            /*
            数字
             */
            case R.id.number0:
            case R.id.number1:
            case R.id.number2:
            case R.id.number3:
            case R.id.number4:
            case R.id.number5:
            case R.id.number6:
            case R.id.number7:
            case R.id.number8:
            case R.id.number9:
            case R.id.spot_but:
              if (clear_flag)
              {
                  clear_flag=false;
                  str="";
                  result.setText("");
              }
                result.setText(str + ((Button) v).getText());
                break;
            /*
            sin
             */
            case R.id.sin:
                sinx();
                /*
                cos
                 */
            case R.id.cos:
                if (clear_flag) {
                    clear_flag=false;
                    result.setText("");
                }
            case R.id.add_but:
            case R.id.sub_but:
            case R.id.mult_but:
            case R.id.div_but:
                if (clear_flag) {
                    clear_flag=false;
                    result.setText("");
                }
                result.setText(str + " " + ((Button) v).getText() + " ");
                break;
            case R.id.CE:
                clear_flag=false;
                str="";
                result.setText("");
                break;
            case R.id.del:
                if (clear_flag) {
                    clear_flag=false;
                    str="";
                    result.setText("");
                } else if (str != null || str.equals("")) {
                    result.setText(str.substring(0, str.length() - 1));
                }
            case R.id.sign_but:
                getResult();
            default:
                break;


        }
    }

    /*
    sinx的运算函数
     */
    private void sinx(){
        clear_flag=true;
        String exp_2=result.getText().toString();
        double result_2;
        double e= Double.parseDouble(exp_2);
        result_2=Math.sin((e/180)*Math.PI);
        result.setText(result_2+"");


    }

    /*
    单独运算最后的结果
     */
    private void getResult() {
        clear_flag = true;
        String exp = result.getText().toString();
        double result_1 = 0;
        if(exp==null||exp.equals("")){
            return;
        }
        if(!exp.contains(" ")){
            return;
        }
        if (clear_flag){
            clear_flag=false;
        }
        clear_flag=true;
        String s1 = exp.substring(0, exp.indexOf(" "));//运算符前面的字符串
        String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);//截取到的运算符
        String s2 = exp.substring(exp.indexOf(" ") + 3);//运算符后面的字符串
        if (!s1.equals("") && !s2.equals("")) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")) {
                result_1 = d1 + d2;
            } else if (op.equals("-")) {
                result_1 = d1 - d2;

            } else if (op.equals("*")) {
                result_1 = d1 * d2;

            } else if (op.equals("/")) {
                if (d2 == 0)
                    result_1 = 0;
                result_1 = d1 / d2;

            }
            if (!s1.contains(".") && !s2.contains(".")&&!op.equals("/")) {
                int r = (int) result_1;
                result.setText(r + "");

            } else {
                result.setText(result_1 + "");
            }

        } else if (!s1.equals("") && s2.equals("")) {
            result.setText(exp);
        } else if (s1.equals("") && !s2.equals("")) {
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")) {
                result_1 = 0 + d2;
            } else if (op.equals("-")) {
                result_1 = 0 - d2;

            } else if (op.equals("*")) {
                result_1 = 0;

            } else if (op.equals("/")) {
                result_1 = 0;

            }
        } else {
            result.setText("");
        }
    }
}
