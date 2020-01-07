package com.justin.practicefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MailActivity extends AppCompatActivity {

    private EditText editText;
    private String mail;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        editText = findViewById(R.id.edit_mail1);
        mail = editText.getText().toString();
        button = findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail = editText.getText().toString();
                SharedPreferences setting =getSharedPreferences("text",MODE_PRIVATE);
                setting.edit()
                        .putString("mailId",mail)
                        .commit();
                finish();
            }
        });
    }
}
