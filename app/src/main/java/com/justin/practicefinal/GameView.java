package com.justin.practicefinal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class GameView extends View {
    float floatX=400;
    float floatY=500;
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint =new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.dog);
        canvas.drawBitmap(bitmap,floatX,floatY,paint);
    }

    public float getFloatX() {
        return floatX;
    }

    public float getFloatY() {
        return floatY;
    }

    public void setFloatX(float floatX) {
        if (floatX>0&&floatX<1100)
            this.floatX=floatX;
    }

    public void setFloatY(float floatY) {
        if (floatY>0&&floatY<1300)
            this.floatY=floatY;
    }
}
