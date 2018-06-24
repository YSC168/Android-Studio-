package com.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SqlTest extends AppCompatActivity {
private MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_test);
        myDatabase=new MyDatabase(this,"Bookstore.db",null,2);
        Button button=findViewById(R.id.creat_sql);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabase.getWritableDatabase();
            }
        });
    }
}
