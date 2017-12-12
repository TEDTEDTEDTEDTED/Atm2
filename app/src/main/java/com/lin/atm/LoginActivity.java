package com.lin.atm;

import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edUserid;
    EditText edpasswd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUserid = (EditText) findViewById(R.id.userid);
        edpasswd = (EditText) findViewById(R.id.passwd);
        /*getSharedPreferences("atm",MODE_PRIVATE)
                .getString("USERID'", "" );*/
        edUserid.setText(getSharedPreferences("atm",MODE_PRIVATE)
                .getString("ID", "" ));

    }
    public void login(View view){
        String userid = edUserid.getText().toString();
        String passwd = edpasswd.getText().toString();
        if("jack".equals(userid) && "1234".equals(passwd)){
            Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show();
            //SharedPreferences setting =
            getIntent().putExtra("EXRA_USERID",userid);
            getIntent().putExtra("EXRA_PASSWD",passwd);
            setResult(RESULT_OK,getIntent());
            finish();
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("登入")
                    .setMessage("登入失敗")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }
    public void cancel(View view){

    }
}
