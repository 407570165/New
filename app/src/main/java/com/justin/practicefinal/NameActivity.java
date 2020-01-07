package com.justin.practicefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    private EditText name;
    private String dataName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        name = findViewById(R.id.edit_name1);
        dataName = name.getText().toString();

    }
    public void next(View view){
        dataName = name.getText().toString();
        SharedPreferences setting =getSharedPreferences("text",MODE_PRIVATE);
        setting.edit()
                .putString("nameId",dataName)
                .commit();
        Intent intent =new Intent(NameActivity.this,PasswordActivity.class);
        startActivity(intent);
        setResult(RESULT_OK);
        finish();
    }
}
