package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech t1;
    EditText ed1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=findViewById(R.id.texttospeech);
        b1=findViewById(R.id.speak);

        t1=new TextToSpeech(getApplicationContext(), status -> {
            if(status!=TextToSpeech.ERROR){
                t1.setLanguage(Locale.UK);
            }
        });

        b1.setOnClickListener(v -> {
            String toSpeak=ed1.getText().toString();
            Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
            t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);
        });
    }

//    public void onPause(){
//        if(t1!=null){
//            t1.stop();
//            t1.shutdown();
//        }
//        super.onPause();
//    }
}