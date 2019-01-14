package com.example.justi.practical7;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Calculation extends AppCompatActivity {
    double price, size, type, crust;
    int drinks;
    TextView total;
    String s="";
    private int SMS_PERMISSION=1;

    //Update to number desired

    private String phoneNumber="5556";
    private SmsManager manager=SmsManager.getDefault();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
        if(ContextCompat.checkSelfPermission(Calculation.this, Manifest.permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED){
            requestSMSPermission();
        }
        size = getIntent().getExtras().getDouble("size");
        type = getIntent().getExtras().getDouble("type");
        crust = getIntent().getExtras().getDouble("crust");
        drinks = getIntent().getExtras().getInt("drinks");

        if(size==25)
            s+="Pizza: Small\n";
        else if(size==50)
            s+="Pizza: Medium\n";
        else if(size==80)
            s+="Pizza: Large\n";
        else if(size==110)
            s+="Pizza: Extra Large\n";
        if(type==15)
            s+="Type: Meat Lovers Pizza\n";
        if(type==10)
            s+="Type: Vegetarian\n";
        if(type==12)
            s+="Type: Hawaiian\n";
        if(crust==4)
            s+="Stuffed Crust: Yes\n";
        else
            s+="Stuffed Crust: No\n";
        s+="Drinks :"+drinks+"\n";
        price = size + type + crust + (drinks*6);
        total = (TextView)findViewById(R.id.total);
        total.setText("Total: "+price);
    }
    public void order(View view){
        Toast.makeText(getApplicationContext(), "Pizza Ordered", Toast.LENGTH_SHORT).show();
        try{

            manager.sendTextMessage(phoneNumber, null, s, null,
                    null);
        }catch (Exception e){

        }
    }
    private void requestSMSPermission(){
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},SMS_PERMISSION);
    }
}
