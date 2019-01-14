package com.example.justi.practical7;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.Manifest;

public class Practical6Receiver extends AppCompatActivity {
    Button reply;
    String phonenumber, message;
    private int SMS_PERMISSION=1,SMS_PERMISSION1=1,SMS_PERMISSION2=1;
    private static Practical6Receiver ins;
    private SmsManager manager = SmsManager.getDefault();
    TextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical6_receiver);
        ins=this;
        view=findViewById(R.id.message);
        SmsReceiver sms=new SmsReceiver();
        reply = findViewById(R.id.reply);
        phonenumber = "5554";
        message = "order received";

    }

    public void replier(View v){
        try {
            SmsManager smsman = SmsManager.getDefault();
            //SmsReceiver.
            smsman.sendTextMessage(phonenumber,null,message,null,null);
            Toast.makeText(getApplicationContext(),"Reply Sent",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Reply failed to send",Toast.LENGTH_SHORT).show();
        }
    }

    public void requestSMSPermission(){
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},SMS_PERMISSION);
    }
    public static Practical6Receiver getInstance(){
        return ins;
    }
    public void setText(String s){
        view.setText(s);
    }
    public void setNumber(String num){
        phonenumber=num;
    }
}