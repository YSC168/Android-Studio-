package com.webview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Button login;
    private CheckBox checkBox;
    private EditText accountedit;
    private EditText passwordedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        accountedit=findViewById(R.id.account);
        passwordedit=findViewById(R.id.password);
        checkBox=findViewById(R.id.check);
        login=findViewById(R.id.login);
        boolean isR=preferences.getBoolean("remeber_password",false);
        if(isR){
            String account=preferences.getString("account","");
            String password=preferences.getString("password","");
            accountedit.setText(account);
            passwordedit.setText(password);
            checkBox.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account=accountedit.getText().toString();
                String password=passwordedit.getText().toString();
                if(account.equals("ysc")&&password.equals("123456")){
                    editor=preferences.edit();
                    if(checkBox.isChecked()){
                        editor.putBoolean("remeber_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }
                    else{
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent= new Intent(DialogActivity.this,RecyclarLayout.
                            class);
                    DialogActivity.this.startActivity(intent);

                }
                else {
                    Toast.makeText(DialogActivity.this, "无效", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
