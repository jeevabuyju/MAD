package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void addition(View view){
        Float n1=Float.parseFloat(((EditText) findViewById(R.id.no1)).getText().toString());
        Float n2=Float.parseFloat(((EditText) findViewById(R.id.no2)).getText().toString());
        Float result=n1+n2;
        ((EditText)findViewById(R.id.result)).setText(result.toString());

    }
    public void subtraction(View view){
        Float n1=Float.parseFloat(((EditText) findViewById(R.id.no1)).getText().toString());
        Float n2=Float.parseFloat(((EditText) findViewById(R.id.no2)).getText().toString());
        Float result=n1-n2;
        ((EditText)findViewById(R.id.result)).setText(result.toString());

    }
    public void multiplication(View view){
        Float n1=Float.parseFloat(((EditText) findViewById(R.id.no1)).getText().toString());
        Float n2=Float.parseFloat(((EditText) findViewById(R.id.no2)).getText().toString());
        Float result=n1*n2;
        ((EditText)findViewById(R.id.result)).setText(result.toString());

    }
    public void division(View view){
        Float n1=Float.parseFloat(((EditText) findViewById(R.id.no1)).getText().toString());
        Float n2=Float.parseFloat(((EditText) findViewById(R.id.no2)).getText().toString());
        Float result=n1/n2;
        ((EditText)findViewById(R.id.result)).setText(result.toString());

    }
}