package com.example.imageprocessing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by yangxuewu on 2016/10/28.
 */

public class CustomView extends View {
    private final Paint paint;

    public CustomView(Context context) {
        super(context);
        paint = new Paint(); //设置一个笔刷大小是3的黄色的画笔   
        paint.setColor(Color.YELLOW);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF  rectf=new RectF(50,50,100,100);
        canvas.drawArc(rectf,0,180,false,paint);
    }
}
