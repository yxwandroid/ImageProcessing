package com.example.imageprocessing;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    /** Called when the activity is first created. */
    private HandWrite handWrite = null;
    private Button clear = null;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handWrite = (HandWrite)findViewById(R.id.handwriteview);
        clear = (Button)findViewById(R.id.clear);
        clear.setOnClickListener(new clearListener());
    }


    private class clearListener implements View.OnClickListener {

        public void onClick(View v)
        {
            handWrite.clear();
        }
    }
}
