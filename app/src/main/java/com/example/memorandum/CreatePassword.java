package com.example.memorandum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePassword extends AppCompatActivity {

    Button button;
    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);

        editText1 = (EditText) findViewById(R.id.etEnter);
        editText2 = (EditText) findViewById(R.id.etConfirm);
        button = (Button) findViewById(R.id.btStart);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();
                if(text1.equals("") || text2.equals("")) {
                    //there isn't any password
                    Toast.makeText(CreatePassword.this, "Please enter the password", Toast.LENGTH_SHORT).show();

                }else {
                    if(text1.equals(text2)){
                        //save the password
                        SharedPreferences settings = getSharedPreferences("PREFS", 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("Password", text1);
                        editor.apply();

                        //enter to the note pad main activity
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        //if the password does not match
                        Toast.makeText(CreatePassword.this, "Password doesn't match", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });



    }
}
