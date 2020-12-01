package com.example.firebase;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView txtDetails;
    private EditText inputName;
    private EditText inputMobile;
    private Button btnSave;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDetails = findViewById(R.id.nameView);
        inputName = findViewById(R.id.name);
        inputMobile = findViewById(R.id.phone);
        btnSave = findViewById(R.id.submit);

        mFirebaseInstance = FirebaseDatabase.getInstance();

        mFirebaseDatabase = mFirebaseInstance.getReference("user");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputName.getText().toString();
                String mobile = inputMobile.getText().toString();

                if(TextUtils.isEmpty(userId)){
                    createUser(name,mobile);
                }else{
                    updateUser(name,mobile);
                }

            }
        });
        toggleButton();
    }

    private void toggleButton(){
        if(TextUtils.isEmpty(userId)){
            btnSave.setText(R.string.save);
        }
        else{
            btnSave.setText(R.string.update);
        }
    }


    private void updateUser(String name,String mobile){
        if(!TextUtils.isEmpty(name)){
            mFirebaseDatabase.child(userId).child("name").setValue(name);
        }
        if(!TextUtils.isEmpty(mobile)){
            mFirebaseDatabase.child(userId).child("mobile").setValue(mobile);
        }
    }

    private void createUser(String name, String moblie){
        if(TextUtils.isEmpty(userId)){
            userId=mFirebaseDatabase.push().getKey();
        }
        user user=new user(name,moblie);
        assert userId != null;
        mFirebaseDatabase.child(userId).setValue(user);
    }

}