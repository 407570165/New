package com.justin.practicefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PasswordActivity extends AppCompatActivity {

    private EditText editText;
    private String password;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        editText = findViewById(R.id.edit_password1);
        password = editText.getText().toString();
        button = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password = editText.getText().toString();
                SharedPreferences setting =getSharedPreferences("text",MODE_PRIVATE);
                setting.edit()
                        .putString("passwordId",password)
                        .commit();
                Intent intent =new Intent(PasswordActivity.this,MailActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
