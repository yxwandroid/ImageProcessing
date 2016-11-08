package com.example.imageprocessing;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
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
    public static Bitmap cropCenter(Bitmap bitmap, int width, int height) {
        int startWidth = (bitmap.getWidth() - width) / 2;
        int startHeight = (bitmap.getHeight() - height) / 2;
        Rect rect = new Rect(startWidth, startHeight, startWidth + width, startHeight + height);

        int width1 = rect.width();
        int height1 = rect.height();

        Rect rect1 = new Rect(0, 0, width1, height1);
        Bitmap bitmap1 = Bitmap.createBitmap(width1, height1, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap1);
        canvas.drawBitmap(bitmap, rect, rect1, null);

        return bitmap1;


    }


    /**
     * 获得圆角矩形
     *
     * @param bitmap
     * @param roundPixels
     * @return
     */
    public static Bitmap getRoundCornerImage(Bitmap bitmap, int roundPixels) {
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
        Path path = new Path();
        path.moveTo(0, bitmap.getHeight());// 此点为多边形的起点
        path.lineTo(bitmap.getHeight(), bitmap.getWidth());
        path.lineTo(bitmap.getWidth(), 0);
        path.close(); // 使这些点构成封闭的多边形
        canvas.drawPath(path, paint);


//        canvas.drawRoundRect(rectF, roundPixels, roundPixels, paint);
        //设置相交模式
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        //把图片画到矩形去
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return roundConcerImage;
    }


    /**
     * 对图片进行缩放
     *
     * @param bitmap
     * @param w
     * @param h
     * @return
     */
    public static Bitmap resizeBitmap(Bitmap bitmap, int w, int h) {
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int newWidth = w;
            int newHeight = h;
            float scaleWidth = ((float) newWidth) / width;
            float scaleHeight = ((float) newHeight) / height;
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            return resizedBitmap;
        } else {
            return null;
        }
    }


    public static Bitmap rotateBotmap(Bitmap bitmap, int rotate) {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(bitmap1);
        Matrix matrix = new Matrix();
        matrix.setRotate(rotate, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        canvas.drawBitmap(bitmap, matrix, paint);
        return  bitmap1;
    }


    /**
     * 研究save的使用
     *
     * @param canvas
     */
    private void drawSave(Canvas canvas, Paint paint) {

        canvas.translate(100, 100); // 平移（100,100）
        canvas.drawRect(0, 0, 200, 200, paint); // 以原
        int save1 = canvas.save(); // 保存Canvas状态（状态1）
        canvas.scale(2, 2); // 放大2倍
        canvas.translate(100, 100); // 平移（100,100）
        canvas.drawRect(0, 0, 200, 200, paint); // 以原
        int save2 = canvas.save(); // 保存Canvas状态（状态2）

        canvas.scale(2, 2); // 放大2倍
        canvas.translate(100, 100); // 平移（100,100）
        canvas.drawRect(0, 0, 200, 200, paint); // 以原
        int save3 = canvas.save();

        canvas.restoreToCount(save3);

        canvas.translate(-200, 200);
        canvas.drawRect(0, 0, 200, 200, paint); // 以原
        canvas.restoreToCount(save2);
        // 手动指定的返回到 状态1
    }

    /**
     * 验证坐标
     *
     * @param canvas
     */
    private void drawXy(Canvas canvas, Paint paint) {


        paint.setColor(Color.argb(50, 255, 100, 100));
        canvas.drawRect(0, 0, 200, 200, paint); // 以原始Canvas画出一个矩形1
        canvas.translate(300, 300); // 将Canvas平移 (100,100)
        paint.setColor(Color.argb(50, 100, 255, 100));
        canvas.drawRect(0, 0, 200, 200, paint); // 矩形2

        canvas.rotate(30); //将Canvas旋转30
        paint.setColor(Color.argb(50, 100, 0, 255));
        canvas.drawRect(0, 0, 200, 200, paint); // 矩形3

        canvas.scale(2, 2); // 将Canvas以原点为中心，放大两倍
        paint.setColor(Color.argb(50, 255, 255, 0));
        canvas.drawRect(0, 0, 200, 200, paint); // 矩形4

    }

}