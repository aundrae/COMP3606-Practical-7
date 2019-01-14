package com.example.justi.practical7;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class IntentScreen extends AppCompatActivity {
    TextView view;
    double value;
    DecimalFormat df=new DecimalFormat(".##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_screen);
        view=findViewById(R.id.view);
        value=getIntent().getExtras().getInt("mark");
        view.setText(view.getText().toString()+"\n\n"+value+"="+df.format(value*0.1)+"%");
        value=value*0.1;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),Practical4.class);
                intent.putExtra("percentage",df.format(value));
                startActivity(intent);
                finish();
            }
        },3000);
    }

}
