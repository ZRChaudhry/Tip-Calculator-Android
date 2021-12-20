package com.example.tip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main Act";
    EditText bill;
    String billString;
    Double billDouble;

    EditText people;
    String peopleString;
    Double peopleDouble;

    Double tip;
    Double tipNum;
    Double tipTotal;
    Double tpp;
    Double over;
    Double overCheck;

    TextView tipAmount;
    TextView totalWithTip;
    TextView totalPerPerson;
    TextView overage;


    Button go;
    Button clear;

    RadioGroup tipGroup;
    RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "This Works");

        bill = findViewById(R.id.billInput);

        people = findViewById(R.id.numOfPeopleInput);

        tipAmount = findViewById(R.id.tipAmountOutput);
        totalWithTip = findViewById(R.id.totalWithTIpOutput);
        totalPerPerson = findViewById(R.id.totalPerPersonOutput);
        overage = findViewById(R.id.overageOutput);

        tipGroup =(RadioGroup)findViewById(R.id.radioGroup);

        clear = (Button) findViewById(R.id.clearButton);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clear works ");
                tipAmount.setText("");
                totalWithTip.setText("");
                totalPerPerson.setText("");
                overage.setText("");
            }
        });

        go = (Button) findViewById(R.id.goButton);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: go works ");
                peopleString = people.getText().toString();
                peopleDouble=Double.parseDouble(peopleString);
                tpp=Math.ceil((tipTotal/peopleDouble)*100.0)/100.0;

                overCheck=(tpp*(peopleDouble))-Math.round((tipTotal)*100.0)/100.0;

                totalPerPerson.setText(String.format("$%.2f",tpp));
                overage.setText(String.format("$%.2f",overCheck));
            }
        });
    }

    public void tipButton(View v){
        billString = bill.getText().toString();
        if (v.getId()==R.id.tip12) {
            radioButton = findViewById(R.id.tip12);
            if (billString.isEmpty()) {
                Log.d(TAG, "Missing Bill ");
                radioButton.setChecked(false);
            } else {
                radioButton.toggle();
                tip = 0.12;
                billDouble=Double.parseDouble(billString);
                tipNum=billDouble*tip;
                tipTotal=billDouble+tipNum;
                tipAmount.setText(String.format("$%.2f",tipNum));
                totalWithTip.setText(String.format("$%.2f",tipTotal));
                Log.d(TAG, "All Values Computed Successfully Tip 12 ");
            }
        }
        if (v.getId()==R.id.tip15) {
            radioButton = findViewById(R.id.tip15);
            if (billString.isEmpty()) {
                Log.d(TAG, "Missing Bill ");
                radioButton.setChecked(false);
            } else {
                radioButton.toggle();
                tip = 0.15;
                billDouble=Double.parseDouble(billString);
                tipNum=billDouble*tip;
                tipTotal=billDouble+tipNum;
                tipAmount.setText(String.format("$%.2f",tipNum));
                totalWithTip.setText(String.format("$%.2f",tipTotal));
                Log.d(TAG, "All Values Computed Successfully Tip 15 ");
            }
        }
        if (v.getId()==R.id.tip18) {
            radioButton = findViewById(R.id.tip18);
            if (billString.isEmpty()) {
                Log.d(TAG, "Missing Bill ");
                radioButton.setChecked(false);
            } else {
                radioButton.toggle();
                tip = 0.18;
                billDouble=Double.parseDouble(billString);
                tipNum=billDouble*tip;
                tipTotal=billDouble+tipNum;
                tipAmount.setText(String.format("$%.2f",tipNum));
                totalWithTip.setText(String.format("$%.2f",tipTotal));
                Log.d(TAG, "All Values Computed Successfully Tip 18 ");
            }
        }
        if (v.getId()==R.id.tip20) {
            radioButton = findViewById(R.id.tip20);
            if (billString.isEmpty()) {
                Log.d(TAG, "Missing Bill ");
                radioButton.setChecked(false);
            } else {
                radioButton.toggle();
                tip = 0.20;
                billDouble=Double.parseDouble(billString);
                tipNum=billDouble*tip;
                tipTotal=billDouble+tipNum;
                tipAmount.setText(String.format("$%.2f",tipNum));
                totalWithTip.setText(String.format("$%.2f",tipTotal));
                Log.d(TAG, "All Values Computed Successfully Tip 20");
            }
        }
        }
    }






