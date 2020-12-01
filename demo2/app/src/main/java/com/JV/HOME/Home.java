package com.JV.HOME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        String firstName = intent.getStringExtra(MainActivity.FN);
        String lastName = intent.getStringExtra(MainActivity.LN);
        String phone = intent.getStringExtra(MainActivity.PN);
        String mail = intent.getStringExtra(MainActivity.EM);

        ((TextView)findViewById(R.id.name)).setText(firstName+" "+lastName);
        ((TextView)findViewById(R.id.phone)).setText(phone);
        ((TextView)findViewById(R.id.mail)).setText(mail);

    }
}