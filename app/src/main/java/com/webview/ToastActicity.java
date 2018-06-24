package com.webview;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActicity extends AppCompatActivity {
private Button toast_1,toast_2,toast_3;
private Button btn,pd;
private EditText editText;
private ImageView imageView;
private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_acticity);
        pd=findViewById(R.id.pd);
        btn=findViewById(R.id.btne);
        editText=findViewById(R.id.ed);
        imageView=findViewById(R.id.iv);
        progressBar=findViewById(R.id.progress);
        toast_1 = findViewById(R.id.toast1);
        toast_2 = findViewById(R.id.toast2);
        toast_3 = findViewById(R.id.toast3);
        OnClick OnClick = new OnClick();
        imageView.setOnClickListener(OnClick);
        editText.setOnClickListener(OnClick);
        toast_1.setOnClickListener(OnClick);
        toast_2.setOnClickListener(OnClick);
        toast_3.setOnClickListener(OnClick);
        pd.setOnClickListener(OnClick);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.tx);//不能设置mipmap里的图片

                Toast.makeText(ToastActicity.this, "普通Toast", Toast.LENGTH_SHORT).show();
            }
        });
    }
       class OnClick implements View.OnClickListener{

           @Override
           public void onClick(View v) {
               switch (v.getId()){

                   case R.id.toast1:
                       Toast.makeText(ToastActicity.this, "普通Toast", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.toast2:
                       Toast toastcenter=Toast.makeText(getApplicationContext(),"居中Toast",Toast.LENGTH_SHORT);
                       toastcenter.setGravity(Gravity.CENTER,0,0);
                       toastcenter.show();

                       break;
                   case R.id.toast3:
                       Toast toastCustom=new Toast(ToastActicity.this);
                       //Toast toastCustom=new Toast(getApplicationContext());
                       LayoutInflater inflater=LayoutInflater.from(ToastActicity.this);
                       View view= inflater.inflate(R.layout.toast_layout,null);
                       ImageView imageView=view.findViewById(R.id.iv);
                       TextView textView=view.findViewById(R.id.tv);
                       imageView.setImageResource(R.drawable.tx);
                       textView.setText("自定义");
                       toastCustom.setView(v);
                       toastCustom.show();

                       break;
                   case R.id.ed:
                       String inputText=editText.getText().toString();
                       Toast.makeText(ToastActicity.this,inputText,Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.iv:
                       if(progressBar.getVisibility()==View.GONE){
                           progressBar.setVisibility(View.VISIBLE);
                       }
                       else {
                           progressBar.setVisibility(View.GONE);
                       }
                       break;
                   case R.id.pd:
                       ProgressDialog progressDialog=new ProgressDialog(ToastActicity.this);
                       progressDialog.setTitle("这是progressDialog");
                       progressDialog.setMessage("hello world");
                       progressDialog.setCancelable(true);
                       progressDialog.show();


                       break;
                       default:
                           break;

               }
           }
       }
    }
    class Puppy{
   int puppyAge;
   public Puppy(String name){
      // 这个构造器仅有一个参数：name
      System.out.println("小狗的名字是 : " + name );
   }

   public void setAge( int age ){
       puppyAge = age;
   }

   public int getAge( ){
       System.out.println("小狗的年龄为 : " + puppyAge );
       return puppyAge;
   }

   public static void main(String []args){
      /* 创建对象 */
      Puppy myPuppy = new Puppy( "tommy" );
      /* 通过方法来设定age */
      myPuppy.setAge( 2 );
      /* 调用另一个方法获取age */
      myPuppy.getAge( );
      /*你也可以像下面这样访问成员变量 */
      System.out.println("变量值 : " + myPuppy.puppyAge );
   }

}


