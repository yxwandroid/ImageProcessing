package com.example.imageprocessing;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

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


    private static Bitmap dividePart(Bitmap bitmap, Rect rect) {
        int width = rect.width();
        int height = rect.height();
        Rect rect1=new Rect(0,0,width,height);
        Bitmap bitmap1=Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap1);
        canvas.drawBitmap(bitmap,rect,rect1,null);
        return bitmap;

    }
}