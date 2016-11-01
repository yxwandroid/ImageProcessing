package com.example.imageprocessing;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by yangxuewu on 2016/10/27.
 */

public class ImageUtils {


    /**
     * 对bitmap进行剪切
     *
     * @param bitmap 原图
     * @param width  剪切的宽
     * @param height 剪切的高
     * @return
     */
    public static  Bitmap cropCenter(Bitmap bitmap, int width, int height) {
        int startWidth = (bitmap.getWidth() - width) / 2;
        int startHeight = (bitmap.getHeight() - height) / 2;

        Rect rect = new Rect(startWidth, startHeight, startWidth + width, startHeight + height);
        return dividePart(bitmap,rect);
    }


    /**
     * 获得截取之后的图片
     * @param bitmap  原始图片
     * @param rect  截取的矩阵
     * @return
     */
    private static Bitmap dividePart(Bitmap bitmap, Rect rect) {
        int width = rect.width();
        int height = rect.height();
        Rect rect1=new Rect(0,0,width,height);
        Bitmap bitmap1=Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap1);
        canvas.drawBitmap(bitmap,rect,rect1,null);
        return bitmap;

    }


    /**
     * 获得圆角矩形
     * @param bitmap
     * @param roundPixels
     * @return
     */
    public static Bitmap getRoundCornerImage(Bitmap bitmap, int roundPixels)
    {
        //创建一个和原始图片一样大小位图
        Bitmap roundConcerImage = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        //创建带有位图roundConcerImage的画布
        Canvas canvas = new Canvas(roundConcerImage);
        //创建画笔
        Paint paint = new Paint();
        //创建一个和原始图片一样大小的矩形
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        // 去锯齿
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        //画一个和原始图片一样大小的圆角矩形
        canvas.drawRoundRect(rectF, roundPixels, roundPixels, paint);
        //设置相交模式
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        //把图片画到矩形去
        canvas.drawBitmap(bitmap, null, rect, paint);
        return roundConcerImage;
    }

    public static Bitmap getRoundCornerImage2(Bitmap bitmap, int roundPixels)
    {
        return bitmap;
    }
}