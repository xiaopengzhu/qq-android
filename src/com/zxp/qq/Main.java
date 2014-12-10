package com.zxp.qq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Main extends Activity {
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
    }
    
    public void login(View v) {
        Intent intent = new Intent(Main.this, Frame.class);
        startActivity(intent);
        /*
        this.finish();
        if (username.getText().toString().equals("zxp") && password.getText().toString().equals("123")) {
            //Intent intent = new Intent(Main.this, Welcome.class);
            startActivity(intent);
            this.finish();
        } else {
            Toast.makeText(getApplicationContext(), "用户名或密码错误", Toast.LENGTH_SHORT).show();
        }*/
    }
    
    public void register(View v) {
        Intent intent = new Intent(Main.this, Register.class);
        startActivity(intent);
    }
    
    public void forgetPassword(View v) {
        Intent intent = new Intent(Main.this, ForgetPassword.class);
        startActivity(intent);
    }
}
