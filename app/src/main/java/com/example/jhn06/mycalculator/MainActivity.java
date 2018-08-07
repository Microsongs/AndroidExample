package com.example.jhn06.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private int count = 0;
    private Button button1;
    private Button button2;
    private EditText Edit1;
    private EditText Edit2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    private void init(){
        textView = (TextView)findViewById(R.id.textView);
        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        Edit1 = (EditText)findViewById(R.id.editText1);
        Edit2 = (EditText)findViewById(R.id.editText2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        textView.setText("0");
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String value1 = Edit1.getText().toString();   //값가져오는 변수
        String value2 = Edit2.getText().toString();
        if(!Errorcheck(value1) || !Errorcheck(value2)) {
            textView.setText("숫자가 아니다.");
        }
        else {
            switch (id) {
                case R.id.button:
                    count = Integer.parseInt(value1) + Integer.parseInt(value2);
                    textView.setText(count + "");
                    break;
                case R.id.button2:
                    count = Integer.parseInt(value1) -  Integer.parseInt(value2);
                    textView.setText(count + "");
                    break;
            }
        }
    }

    private boolean Errorcheck(String e1){  //숫자 여부 체크
        try{
            Double.parseDouble(e1);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
