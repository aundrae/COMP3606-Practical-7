package com.example.justi.practical7;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DetailsPage extends AppCompatActivity {
    TextView ps,pd,pt,pstuff,s,d,t,stuff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ps = (TextView)findViewById(R.id.SPrice);
        pd = (TextView)findViewById(R.id.DPrice);
        pt = (TextView)findViewById(R.id.TPrice);
        pstuff = (TextView)findViewById(R.id.stuffPrice);
        s = (TextView)findViewById(R.id.size);
        d = (TextView)findViewById(R.id.drinks);
        t = (TextView)findViewById(R.id.type);
        stuff = (TextView)findViewById(R.id.stuffed);
        s.setText("Size: "+getIntent().getStringExtra("size"));
        d.setText("No. of Drinks: "+getIntent().getExtras().getInt("drinks"));
        t.setText("Pizza Type: "+getIntent().getStringExtra("combo"));
        stuff.setText("Stuffed Crust: "+getIntent().getExtras().getBoolean("stuffedCrust"));
        ps.setText(""+sizeprice());
        pt.setText(""+typeprice());
        pstuff.setText(""+crustprice());
    }

    private double crustprice(){
        boolean x = getIntent().getExtras().getBoolean("stuffedCrust");
        if(x){
            return 4.0;
        }else{
            return 0.0;
        }
    }

    private double sizeprice(){
        String x = getIntent().getStringExtra("size");
        if(x.equals("Small")){
            return 25.0;
        }else if(x.equals("Medium")){
            return 50.0;
        }else if(x.equals("Large")){
            return 80.0;
        }else{
            return 110.0;
        }
    }

    private double typeprice(){
        String x = getIntent().getStringExtra("combo");
        if(x.equals("Meat Lovers Pizza")){
            return 15.0;
        }else if(x.equals("Vegetarian")){
            return 10.0;
        }else if(x.equals("Hawaiian")){
            return 20.0;
        }else{
            return 0.0;
        }
    }
    public void backbutton(View view){
        Intent intent = new Intent(DetailsPage.this, SelectPizza.class);
        startActivity(intent);
    }
    public void confirm(View view){
        Intent intent = new Intent(DetailsPage.this, Calculation.class);
        intent.putExtra("size",sizeprice());
        intent.putExtra("type",typeprice());
        intent.putExtra("crust",crustprice());
        intent.putExtra("drinks",getIntent().getExtras().getInt("drinks"));
        startActivity(intent);
    }
}
