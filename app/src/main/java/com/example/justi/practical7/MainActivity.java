package com.example.justi.practical7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button p1,p2,p3,p4,p5,p6_s,p6_r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1=findViewById(R.id.p1);
        p2=findViewById(R.id.p2);
        p3=findViewById(R.id.p3);
        p4=findViewById(R.id.p4);
        p5=findViewById(R.id.p5);
        p6_s=findViewById(R.id.p6_S);
        p6_r=findViewById(R.id.p6_R);

        p1.setOnClickListener(new Button_Click());
        p2.setOnClickListener(new Button_Click());
        p3.setOnClickListener(new Button_Click());
        p4.setOnClickListener(new Button_Click());
        p5.setOnClickListener(new Button_Click());
        p6_s.setOnClickListener(new Button_Click());
        p6_r.setOnClickListener(new Button_Click());
    }

    public class Button_Click implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if(view == p1){

            }
            if(view == p2){

            }
            if(view == p3){

            }
            if(view == p4){

            }
            if(view == p5){

            }
            if(view == p6_s){

            }
            if(view == p6_r){

            }
        }
    }
}
