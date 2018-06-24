package com.webview;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mbtn,mbtn1,mbtn2,mbtn3,mbtn4,rl,send,mbtn5,mbtn6,mbtn7,mbtn8,mbtn9,mbtn10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity","ddddd");
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }//隐藏actibar
        mbtn1=findViewById(R.id.rec);
        mbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Recycler.class);
                MainActivity.this.startActivity(intent);
            }
        });
        mbtn=findViewById(R.id.open);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Web.class);
                MainActivity.this.startActivity(intent);
            }
        });
        mbtn2=findViewById(R.id.toast);
        mbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,ToastActicity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        mbtn3=findViewById(R.id.cardview);
        mbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,CardView.class);
                MainActivity.this.startActivity(intent);
            }
        });
        mbtn3=findViewById(R.id.javat);
        mbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Main.class);
                MainActivity.this.startActivity(intent);
            }
        });
        mbtn4=findViewById(R.id.network);
        mbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Fragment_Test.class);
                MainActivity.this.startActivity(intent);
            }
        });
        mbtn5=findViewById(R.id.file_save);
        mbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,File_save.class);
                MainActivity.this.startActivity(intent);
            }
        });
        mbtn6=findViewById(R.id.sharepre);
        mbtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Share_Pre.class);
                MainActivity.this.startActivity(intent);
            }
        });
        mbtn7=findViewById(R.id.sql_save);
        mbtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,SqlTest.class);
                MainActivity.this.startActivity(intent);
            }
        });
        mbtn2=findViewById(R.id.toast);
        mbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,ToastActicity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        mbtn8=findViewById(R.id.tzsj);
        mbtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(Intent.ACTION_VIEW);
               intent.setData(Uri.parse("http://www.yscblog.top"));
               startActivity(intent);
            }
        });
        mbtn9=findViewById(R.id.d);
        mbtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                MainActivity.this.startActivity(intent);
            }
            });
        mbtn10=findViewById(R.id.qxsq);
        mbtn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.
                permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this,new
                    String[]{Manifest.permission.CALL_PHONE},1);
                }
                else {
                    call();
                }

            }
        });
        rl=findViewById(R.id.rl);
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,RecyclarLayout.
                        class);
                MainActivity.this.startActivity(intent);
            }
        });
       send=findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("com.webview.MY_BROADCAST");
                sendBroadcast(intent);
            }
        });
    }
    private void call(){
        try{
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("tel:10001"));
            startActivity(intent);
        }catch (SecurityException e){
            e.printStackTrace();
        }

     }

    public void onRequestPermissionResult(int requestCode,String[] permission,int[] grantResults){
        switch (requestCode){
            case 1:
                if(grantResults.length>0&&grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    call();
                }
                else {
                    Toast.makeText(MainActivity.this, "普通Toast", Toast.LENGTH_SHORT).show();
                }
                break;
                default:
        }
}
}
