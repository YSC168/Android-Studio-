package com.webview;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        final Button titleback=(Button)findViewById(R.id.back);
        titleback.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                titleback.setText("ggg");
                Toast.makeText(getContext(), "vvvv", Toast.LENGTH_SHORT).show();

                ((Activity) getContext()).finish();

            }
        });
    }
}
