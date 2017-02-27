package com.zhanggb.VideoPlayerDemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.zhanggb.VideoPlayerDemo.activity.VideoPlayerActivity1;
import com.zhanggb.VideoPlayerDemo.activity.WebviewVideoActivity;

public class HomeActivity extends Activity {
    private Context context;
    private Button textView1;
    private Button textView2;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.context = this;
        initView();
    }

    private void initView() {
        textView1 = (Button) findViewById(R.id.text1);
        textView2 = (Button) findViewById(R.id.text2);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, VideoPlayerActivity1.class));
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, WebviewVideoActivity.class));
            }
        });
    }
}
