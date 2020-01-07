package com.justin.practicefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class EnterActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ImageView down;
    private ImageView right;
    private ImageView left;
    private ImageView up;
    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        /*down = findViewById(R.id.imageView);
        right = findViewById(R.id.imageView2);
        left = findViewById(R.id.imageView3);
        up = findViewById(R.id.imageView4);*/
        findView();
        gameView = findViewById(R.id.game456);
    }
    public void findView(){
        findViewById(R.id.imageView).setOnClickListener(this);
        findViewById(R.id.imageView2).setOnClickListener(this);
        findViewById(R.id.imageView3).setOnClickListener(this);
        findViewById(R.id.imageView4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.imageView):
                Log.d(TAG,"onClick: Down");
                gameView.setFloatY(gameView.getFloatY()+50);
                gameView.invalidate();
                break;
            case(R.id.imageView2):
                Log.d(TAG,"onClick: Right");
                gameView.setFloatX(gameView.getFloatX()+50);
                gameView.invalidate();
                break;
            case(R.id.imageView3):
                Log.d(TAG,"onClick: Left");
                gameView.setFloatX(gameView.getFloatX()-50);
                gameView.invalidate();
                break;
            case(R.id.imageView4):
                Log.d(TAG,"onClick: Up");
                gameView.setFloatY(gameView.getFloatY()-50);
                gameView.invalidate();
                break;
        }
    }
}
