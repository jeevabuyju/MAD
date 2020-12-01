package com.example.sqldb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText usn = findViewById(R.id.usn);
        final EditText name = findViewById(R.id.name);
        final EditText email = findViewById(R.id.email);
        final EditText phone = findViewById(R.id.phone);
        Button add = findViewById(R.id.add);
        Button search = findViewById(R.id.search);
        Button delete = findViewById(R.id.delete);
        Button clear = findViewById(R.id.clear);

        // create DB and table
        final SQLiteDatabase db = openOrCreateDatabase("studentDB", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(usn VARCHAR,name VARCHAR,email VARCHAR,phone VARCHAR);");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((usn.getText().toString().trim().length()==0) || (name.getText().toString().trim().length()==0) || (email.getText().toString().trim().length()==0) || (phone.getText().toString().trim().length()==0)){
                    Toast.makeText(MainActivity.this,"ERROR, Please Enter the Values",Toast.LENGTH_SHORT).show();
                    return;
                }
                db.execSQL("INSERT INTO student VALUES('"+usn.getText()+"','"+name.getText()+"','"+email.getText()+"','"+phone.getText()+"');");
                Toast.makeText(MainActivity.this,"Student Record ADDED",Toast.LENGTH_SHORT).show();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usn.getText().toString().trim().length() == 0) {
                    Toast.makeText(MainActivity.this, "ERROR, Please Enter USN", Toast.LENGTH_SHORT).show();
                    return;
                }
                Cursor c = db.rawQuery("SELECT * FROM student WHERE usn='" + usn.getText() + "';", null);
                if(c.moveToFirst()){
                usn.setText(c.getString(0));
                name.setText(c.getString(1));
                email.setText(c.getString(2));
                phone.setText(c.getString(3));
                c.close();
            } else{
                    Toast.makeText(MainActivity.this, "ERROR, Invalid USN", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usn.getText().toString().trim().length() == 0) {
                    Toast.makeText(MainActivity.this, "ERROR, Please Enter USN", Toast.LENGTH_SHORT).show();
                    return;
                }
                Cursor c = db.rawQuery("SELECT * FROM student WHERE usn='" + usn.getText() + "';", null);
                if(c.moveToFirst()){
                    db.execSQL("DELETE FROM student WHERE usn='"+usn.getText()+"';");
                    name.setText("");
                    email.setText("");
                    phone.setText("");
                    Toast.makeText(MainActivity.this,"Student Record Deleted",Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(MainActivity.this, "ERROR, Invalid USN", Toast.LENGTH_SHORT).show();
                }
                c.close();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usn.setText("");
                name.setText("");
                email.setText("");
                phone.setText("");
            }
        });

    }
}