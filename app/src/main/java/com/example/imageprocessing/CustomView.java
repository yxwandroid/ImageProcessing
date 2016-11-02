package com.example.imageprocessing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    private Bitmap bitmap;

    public CustomView(Context context) {
        super(context);
        paint = new Paint(); //设置一个笔刷大小是3的黄色的画笔
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(3);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.xiaowu).copy(Bitmap.Config.ARGB_8888, true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bitmap = ImageUtils.resizeBitmap(this.bitmap, 300, 300);
        RectF rectF = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawBitmap(bitmap, null, rectF, paint);


    }


}
