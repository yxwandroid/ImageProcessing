package com.example.imageprocessing;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    /** Called when the activity is first created. */
    private HandWrite handWrite = null;
    private ImageView imageView;
    private Button clear = null;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(new CustomView(this));
//        setContentView(R.layout.main);





//        handWrite = (HandWrite)findViewById(R.id.handwriteview);
//        imageView = (ImageView)findViewById(R.id.imageview);
//        clear = (Button)findViewById(R.id.clear);
//        clear.setOnClickListener(new clearListener());
//
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.xiaowu);
//        Bitmap roundCornerImage = ImageUtils.getRoundCornerImage(bitmap, 50);
//        imageView.setImageBitmap(roundCornerImage);
    }


    private class clearListener implements View.OnClickListener {

        public void onClick(View v)
        {
            handWrite.clear();
        }
    }
}
