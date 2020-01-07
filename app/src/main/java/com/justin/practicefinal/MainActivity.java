package com.justin.practicefinal;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editName;
    private EditText editPassword;
    private EditText editMail;
    private Button start;
    private ImageView imageName;
    private ImageView imagePassword;
    private ImageView imageMail;
    boolean isName=true;
    boolean isPassword =true;
    boolean isMail =true;
    private String a;
    private String b;
    private String c;
    private ArrayList<String> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        editName = findViewById(R.id.edit_name1);
        editPassword = findViewById(R.id.edit_password);
        editMail = findViewById(R.id.edit_mail);
        a = editName.getText().toString();
        b = editPassword.getText().toString();
        c = editMail.getText().toString();
        start = findViewById(R.id.button_start);
        imageName = findViewById(R.id.image_name);
        imagePassword = findViewById(R.id.image_password);
        imageMail = findViewById(R.id.image_mail);
        array = new ArrayList<>();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,NameActivity.class);
                startActivityForResult(intent,10);
            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        a = editName.getText().toString();
        b = editPassword.getText().toString();
        c = editMail.getText().toString();
        if (requestCode == 10) {
            if (resultCode != RESULT_OK) {
                finish();
            } else {
                String name = getSharedPreferences("text", MODE_PRIVATE)
                        .getString("nameId", "dataName");
                String password = getSharedPreferences("text", MODE_PRIVATE)
                        .getString("passwordId", "password");
                String mail = getSharedPreferences("text", MODE_PRIVATE)
                        .getString("mailId", "mail");
                editName.setText(name);
                editPassword.setText(password);
                editMail.setText(mail);
                array.add(name);
                array.add(password);
                array.add(mail);
                /*if (!name.equals(a)){
                    isName=false;
                }
                if (!password.equals(b)){
                    isPassword=false;
                }
                if (!mail.equals(c)){
                    isMail=false;
                }
                if (isName) {
                    imageName.setImageResource(R.drawable.good);
                    imageName.setVisibility(View.VISIBLE);
                }else {
                    imageName.setImageResource(R.drawable.bad);
                    imageName.setVisibility(View.VISIBLE);
                }
                if (isPassword) {
                    imagePassword.setImageResource(R.drawable.good);
                    imagePassword.setVisibility(View.VISIBLE);
                }
                else {
                    imagePassword.setImageResource(R.drawable.bad);
                    imagePassword.setVisibility(View.VISIBLE);
                }
                if (isMail) {
                    imageMail.setImageResource(R.drawable.good);
                    imageMail.setVisibility(View.VISIBLE);
                }
                else {
                    imageMail.setImageResource(R.drawable.bad);
                    imageMail.setVisibility(View.VISIBLE);
                }*/
            }
        }
    }
    public void login (View view){
        String name = getSharedPreferences("text", MODE_PRIVATE)
                .getString("nameId", "");
        String password = getSharedPreferences("text", MODE_PRIVATE)
                .getString("passwordId", "");
        String mail = getSharedPreferences("text", MODE_PRIVATE)
                .getString("mailId", "");
        String dName =editName.getText().toString();
        boolean isTrue=false;
        for (int i=0;i<array.size();i++){
            if (array.get(i).equals(dName)) {
                isTrue = true;
                break;
            }
        }
        if (isTrue){
            Intent intent =new Intent(this,EnterActivity.class);
            startActivity(intent);
        }else {
            new AlertDialog.Builder(this)
                    .setTitle("FAILED")
                    .setMessage("no")
                    .setPositiveButton("ok",null)
                    .show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
