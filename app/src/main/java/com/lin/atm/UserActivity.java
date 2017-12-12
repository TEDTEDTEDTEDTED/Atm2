package com.lin.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserActivity extends AppCompatActivity {
    EditText edname;
    EditText edphone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }
    public void ok(View view){
        edname = (EditText) findViewById(R.id.ed＿name);
        edphone = (EditText) findViewById(R.id.ed_phone);
        String name = edname.getText().toString();
        String phone = edphone.getText().toString();
        getIntent().putExtra("USER_NAME",name);
        getIntent().putExtra("USER_PHONE",phone);
        setResult(RESULT_OK,getIntent());


    }
}
