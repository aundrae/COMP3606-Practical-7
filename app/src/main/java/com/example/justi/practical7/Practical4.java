package com.example.justi.practical7;

import android.content.Context;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Practical4 extends AppCompatActivity {
    protected ImageButton IB;
    protected ImageView im,giphy;
    protected ToggleButton toggleButton;
    protected EditText editText;
    protected Spinner spinner;
    protected TextView textView, highScores;
    protected  Button button;
    protected Random random=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical4);
        spinner=findViewById(R.id.spinner1);
        highScores=findViewById(R.id.highscores);
        button=findViewById(R.id.fileSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream outputStream;
                String s="";
                try{
                    outputStream=openFileOutput("highscores", Context.MODE_PRIVATE);
                    for (int i=0;i<3;i++){
                        int temp=(random.nextInt(8)+1);
                        s+=temp+"\n";
                    }
                    outputStream.write(s.getBytes());
                    outputStream.close();
                    Toast.makeText(getApplicationContext(),"File Updates Saved\n" + s,Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        IB = (ImageButton) findViewById(R.id.imageButton1);
        giphy=(ImageView) findViewById(R.id.giphyImg);
        toggleButton= findViewById(R.id.toggleButton);
        editText = findViewById(R.id.mark);
        textView=findViewById(R.id.percentage);
        IB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giphy.setVisibility(View.VISIBLE);
            }
        });
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        if(getIntent().getExtras()!=null){
            textView.setText(getIntent().getExtras().getString("percentage")+"%");
        }
    }
    public void ToggleClicked(View v){
        boolean on =toggleButton.isChecked();
        if(on){
            FileInputStream fileInputStream;
            String score="High Scores: \n";
            try {
                fileInputStream=openFileInput("highscores");
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line;
                while((line=bufferedReader.readLine())!=null){
                    score+=line+"\n";
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            highScores.setText(score);
            highScores.setVisibility(View.VISIBLE);
        }
        else highScores.setVisibility(View.INVISIBLE);
    }
    public void intentPage(View v){
        Intent i=new Intent(getApplicationContext(),IntentScreen.class);
        i.putExtra("mark",Integer.parseInt(editText.getText().toString()));
        startActivity(i);
        finish();
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
