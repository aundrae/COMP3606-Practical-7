package com.example.justi.practical7;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class Practical2 extends AppCompatActivity {
    protected ImageButton IB;
    protected ImageView im,giphy;
    protected ToggleButton toggleButton;
    protected EditText editText;
    protected Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical2);
        spinner=findViewById(R.id.spinner1);
        IB = (ImageButton) findViewById(R.id.imageButton1);
        giphy=(ImageView) findViewById(R.id.giphyImg);
        im = (ImageView) findViewById((R.id.imageView));
        im.setVisibility(View.INVISIBLE);
        toggleButton= findViewById(R.id.toggleButton);
        editText = findViewById(R.id.mark);
        IB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giphy.setVisibility(View.VISIBLE);
            }
        });
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
    public void ToggleClicked(View v){
        boolean on =toggleButton.isChecked();
        if(on)
            im.setVisibility(View.VISIBLE);
        else im.setVisibility(View.INVISIBLE);
    }
    class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String name=adapterView.getItemAtPosition(i).toString();
            if(name.equals("COMP3150"))
                editText.setText("51");
            else if(name.equals("COMP3275"))
                editText.setText("69");
            else if(name.equals("COMP1603"))
                editText.setText("86");
            else if(name.equals("COMP1602"))
                editText.setText("84");
            else if(name.equals("COMP1601"))
                editText.setText("70");
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}
