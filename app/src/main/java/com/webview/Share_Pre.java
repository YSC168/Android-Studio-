package com.webview;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Share_Pre extends AppCompatActivity {
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share__pre);
        Button button=findViewById(R.id.save_data);
        textView=findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=getSharedPreferences("datayyy",MODE_PRIVATE).edit();
                editor.putString("name","Tom");
                editor.putInt("age",20);
                editor.putBoolean("married",false);
                editor.apply();
            }
        });
        Button restore=findViewById(R.id.restore_data);
        restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences perf=getSharedPreferences("datayyy",MODE_PRIVATE);
                String name=perf.getString("name","");
                int age=perf.getInt("age",0);
                boolean married=perf.getBoolean("married",false);
                Log.d("Share_Pre","name is"+name);
                Log.d("Share_Pre","age is"+age);
                Log.d("Share_Pre","married is"+married);
                textView.setText(name);
            }
        });

    }
}
