package com.example.filehandling;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    TextView file;
    EditText data;
    Button save,display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save= (Button)findViewById(R.id.save);
        display=(Button)findViewById(R.id.display);

        file=(TextView) findViewById(R.id.file);
        data=(EditText) findViewById(R.id.data);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataFile=data.getText().toString();
                try {
                    FileOutputStream fout = openFileOutput("dataFile.txt",MODE_PRIVATE);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fout);
                    outputStreamWriter.write(data.getText().toString());
                    outputStreamWriter.close();
                    Toast.makeText(getBaseContext(),"File Saved",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataFile=data.getText().toString();
                try {
                    FileInputStream fin = openFileInput("dataFile.txt");
                    InputStreamReader inputStreamReader = new InputStreamReader(fin);
                    char[] inputBuffer = new char[100];
                    String str = "";
                    int charRead=0;

                    while(true){
                        try {
                            if(!((charRead= inputStreamReader.read(inputBuffer))!=-1))   break;
                        }
                        catch (IOException e){
                            e.printStackTrace();
                        }
                        String readString = String.copyValueOf(inputBuffer,0,charRead);
                        str+=readString;
                    }

                    inputStreamReader.close();
                    file.setText(str);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}