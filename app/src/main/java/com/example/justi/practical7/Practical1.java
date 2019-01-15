package com.example.justi.practical7;

import android.os.Bundle;

import android.app.Activity;

import android.content.Context;

import android.util.Log;

import android.view.Menu;

import android.view.View;

import android.widget.Button;

import android.widget.RadioButton;

import android.widget.RadioGroup;

import android.widget.CompoundButton;

import android.widget.CheckBox;

import android.widget.EditText;

import android.widget.TextView;

import android.widget.Toast;


public class Practical1 extends Activity {

    private Button myButton;

    private RadioButton radio1, radio2;

    private CheckBox check;

    private TextView view;

    private EditText text;
    private double vat=0,price=0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_practical1);


        myButton = (Button) findViewById(R.id.button1);

        view=findViewById(R.id.textView1);

        text=findViewById(R.id.EditText02);

        radio1 = (RadioButton) findViewById(R.id.radioButton);

        radio2 = (RadioButton) findViewById(R.id.radioButton2);

        check = (CheckBox) findViewById(R.id.checkBox);


        myButton.setOnClickListener(new Button_Clicker());

        radio1.setOnClickListener(new Button_Clicker());

        radio2.setOnClickListener(new Button_Clicker());


        check = (CheckBox) findViewById(R.id.checkBox);

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Log.d("MyApp", "Check box selected");
                if(isChecked)
                    vat=0.15;
                else
                    vat=0;
            }

        });

//**

    }


    class Button_Clicker implements Button.OnClickListener

    {

        @Override

        public void onClick(View v) {


            if (v == myButton)

            {

                myButton.setText("Clicked!");

                doCalculations();

                Log.d("MyApp", "I am here");

            } else if (v == radio1){
                view.setText("Red");
                price=5;
                text.setText(Double.toString(price));
            }

            else if (v == radio2){
                view.setText("Green");
                price=10;
                text.setText(Double.toString(price));
            }

                Log.d("MyApp", "radio2 clicked");


        }

    }


    public void doCalculations() {

        //TextView tv = (TextView)findViewById(R.id.textView1);

        Context context = getApplicationContext();

        CharSequence text = "In doCalculations()";

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);

        toast.show();


        //String text1="";

        EditText mEdit;


        mEdit = (EditText) findViewById(R.id.EditText01);

        int quantity = Integer.parseInt(mEdit.getText().toString());

        mEdit = (EditText) findViewById(R.id.EditText02);

        double price = Double.parseDouble(mEdit.getText().toString());

        double cost = price * quantity + (vat*(price*quantity));


        mEdit = (EditText) findViewById(R.id.EditText03);

        mEdit.setText(cost + "");

    }


    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.

        //getMenuInflater().inflate(R.menu.activity_main, menu);

        return true;

    }


}

/*

Some logcat output:

02-08 23:02:44.578    1008-1008/com.example.hellofirst D/MyAppÃ¯Â¹â€¢ radio2 clicked

02-08 23:02:46.495    1008-1008/com.example.hellofirst D/MyAppÃ¯Â¹â€¢ radio1 clicked

02-08 23:02:49.826    1008-1008/com.example.hellofirst D/MyAppÃ¯Â¹â€¢ Check box selected

02-08 23:03:15.575    1008-1008/com.example.hellofirst D/MyAppÃ¯Â¹â€¢ I am here





*/