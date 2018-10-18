package com.brins.fitness;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity implements View.OnClickListener{


    @BindView(R.id.username)
    EditText usered;
    @BindView(R.id.password)
    EditText passed;
    @BindView(R.id.loginbt)
    Button bt_login;
    @BindView(R.id.textlayout)
    TextInputLayout textInputLayout1;
    @BindView(R.id.textlayout2)
    TextInputLayout textInputLayout2;
    private SharedPreferences sp_info ;
    private SharedPreferences.Editor edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        bt_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String nametext= String.valueOf(usered.getText());
        String passtext= String.valueOf(passed.getText());

        if (nametext.isEmpty() | passtext.isEmpty()) {
            textInputLayout1.setErrorEnabled(true);
            textInputLayout1.setError("用户名不能为空");
            textInputLayout2.setErrorEnabled(true);
            textInputLayout2.setError("密码不能为空");
        } else {
            textInputLayout1.setError("");// 必须加上这个，否则会导致内容删除后，error信息显示为空白
            textInputLayout1.setErrorEnabled(false);
            textInputLayout2.setError("");
            textInputLayout2.setErrorEnabled(false);
            edit=getSharedPreferences("data",MODE_PRIVATE).edit();
            edit.putInt("islogin",1);
            edit.putString("username",nametext);
            edit.putString("password",passtext);
            Intent intent=new Intent(Login.this,MainActivity.class);
            startActivity(intent);
        }

    }
}
