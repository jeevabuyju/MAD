package com.JV.HOME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String FN="com.example.demo2.MESSAGE";
    public static final String LN="com.example.demo2.MESSAGE0";
    public static final String PN="com.example.demo2.MESSAGE1";
    public static final String EM="com.example.demo2.MESSAGE2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clear(View view){
        ((EditText) findViewById(R.id.firstName)).setText("");
        ((EditText) findViewById(R.id.lastName)).setText("");
        ((EditText) findViewById(R.id.phoneNo)).setText("");
        ((EditText) findViewById(R.id.email)).setText("");
    }

    public void submit(View view){
        Intent intent = new Intent(this, Home.class);
        String first = ((EditText) findViewById(R.id.firstName)).getText().toString();
        intent.putExtra(FN,first);
        String last = ((EditText) findViewById(R.id.lastName)).getText().toString();
        intent.putExtra(LN,last);
        String phone = ((EditText) findViewById(R.id.phoneNo)).getText().toString();
        intent.putExtra(PN,phone);
        String mail = ((EditText) findViewById(R.id.email)).getText().toString();
        intent.putExtra(EM,mail);
        startActivity(intent);
    }
}