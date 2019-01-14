package com.example.justi.practical7;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SelectPizza extends AppCompatActivity {
    Spinner spinner;
    ImageButton increase, decrease, proceedToDetails;
    RadioGroup combos;
    TextView drinks;
    Switch aSwitch;
    int count=0;
    private boolean stuffedCrust=false;
    String comboSelected="", size="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_pizza);

        spinner=findViewById(R.id.spinner_sizes);
        increase=findViewById(R.id.increase);
        decrease=findViewById(R.id.decrease);
        proceedToDetails=findViewById(R.id.details_page);
        drinks=findViewById(R.id.drinks_count);
        combos=findViewById(R.id.radio);
        aSwitch=findViewById(R.id.crust);
        increase.setOnClickListener(new Button_Clicker());
        decrease.setOnClickListener(new Button_Clicker());
        proceedToDetails.setOnClickListener(new Button_Clicker());
        spinner.setOnItemSelectedListener(new ItemListener());
        combos.setOnCheckedChangeListener(new Radio_Groups());
        aSwitch.setOnCheckedChangeListener(new Switch_Check());

    }
    class Switch_Check implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            if(isChecked){
                Toast.makeText(getApplicationContext(),"Stuffed Crust Selected",Toast.LENGTH_SHORT).show();
                stuffedCrust=true;
            }
            else{
                stuffedCrust=false;
            }
        }
    }
    class Radio_Groups implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            RadioButton r=findViewById(i);
            String r1=r.getText().toString();
            Toast.makeText(getApplicationContext(),r1,Toast.LENGTH_LONG).show();
            comboSelected=r1;
        }
    }
    class Button_Clicker implements Button.OnClickListener{

        @Override
        public void onClick(View v) {
            if (v == increase || v == decrease) {
                if (v == increase)
                    count++;
                else
                    count--;
                if (count < 0)
                    count = 0;
                drinks.setText(Integer.toString(count));
            }
            else{
                Intent intent =new Intent(SelectPizza.this, DetailsPage.class);
                intent.putExtra("drinks",count);
                intent.putExtra("stuffedCrust",stuffedCrust);
                intent.putExtra("combo",comboSelected);
                intent.putExtra("size",size);
                startActivity(intent);
            }
        }
    }

    class ItemListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String value=parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(),value,Toast.LENGTH_LONG).show();
            size=value;
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
