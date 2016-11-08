package com.example.imageprocessing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by yangxuewu on 2016/11/7.
 */

public class MyView extends View {
    Paint mPaint;

    int mWidth;
    int mHeight;

    public MyView(Context context) {
        super(context);
        mPaint=new Paint();
        mPaint.setColor(Color.RED);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);

        canvas.drawCircle(0,0,400,mPaint);          // 绘制两个圆形
        canvas.drawCircle(0,0,380,mPaint);

        for (int i=0; i<=360; i+=10){               // 绘制圆形之间的连接线
            canvas.drawLine(0,380,0,400,mPaint);
            canvas.rotate(10);
        }
    }
}
