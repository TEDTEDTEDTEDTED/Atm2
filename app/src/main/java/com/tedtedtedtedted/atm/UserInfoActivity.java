package com.tedtedtedtedted.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {
    private static final int USER_INFOGG = 2;
    EditText edname;
    EditText edphone;
    Spinner agechoose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
       ArrayList<String> data = new ArrayList<>();
        for(int i=16;i<=40;i++){
            data.add(i+"");
        }
        edname = (EditText) findViewById(R.id.ed＿name);
        edphone = (EditText) findViewById(R.id.ed_phone);
       agechoose = (Spinner) findViewById(R.id.sp_age);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        agechoose.setAdapter(adapter);
        edname.setText(getSharedPreferences("atm", MODE_PRIVATE)
                .getString("NAME", ""));
        edphone.setText(getSharedPreferences("atm", MODE_PRIVATE)
                .getString("PHONE", ""));
    }
    public void ok(View view){
        String name = edname.getText().toString();
        String phone = edphone.getText().toString();
        getIntent().putExtra(getString(R.string.user_name), name);
        getIntent().putExtra("USER_PHONE", phone);
        setResult(RESULT_OK, getIntent());
        finish();
    }
    public void button6(View view){
        Intent userinfolayout = new Intent(this,CityActivity.class);
        startActivityForResult(userinfolayout,USER_INFOGG);
    }

}
