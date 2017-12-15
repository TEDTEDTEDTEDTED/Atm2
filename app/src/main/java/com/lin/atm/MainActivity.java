package com.lin.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    boolean login = false;
    public static final int  FUNG_LOGIN = 1 ;
    public static final int  USER_INFO = 2;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case FUNG_LOGIN:
                if(resultCode == RESULT_OK) {
                    String uid = data.getStringExtra("EXRA_USERID");
                    String pw = data.getStringExtra("EXRA_PASSWD");
                    Log.d("RESULT", uid + "/" + pw);
                    getSharedPreferences("atm",MODE_PRIVATE)
                            .edit()
                            .putString("ID",uid)
                            .apply();
                }
                else{
                        finish();
                }
                break;
            case USER_INFO:
                if(resultCode == RESULT_OK) {
                     String name = data.getStringExtra("USER_NAME");
                     String phone = data.getStringExtra("USER_PHONE");
                }
                else{
                        finish();
                }
                break;
        }
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!login){
            Intent loginlayout = new Intent(this,LoginActivity.class);
            startActivityForResult(loginlayout,FUNG_LOGIN);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent userinfolayout = new Intent(MainActivity.this, UserActivity.class);
                startActivityForResult(userinfolayout,USER_INFO);   
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
