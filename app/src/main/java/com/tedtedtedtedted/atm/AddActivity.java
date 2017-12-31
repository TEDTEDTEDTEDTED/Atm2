package com.tedtedtedtedted.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    private static final int USER_INFOGGG = 2;
    Spinner city;

    Spinner dis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        city = (Spinner) findViewById(R.id.spinner2);
        dis = (Spinner) findViewById(R.id.spinner3);
        String[]data=new String[]{"台北市","新北市","基隆市"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        city.setAdapter(adapter);
        city.setOnItemSelectedListener(this);





    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String[]data=null;
        if(position==0){
            data=new String[]{"信義區","大安區","士林區"};
            Intent userinfolayout = new Intent(this,AreaActivity.class);
            userinfolayout.putExtra("data",data);
            startActivity(userinfolayout);
        }
        if(position==1){
            data=new String[]{"永和區","板橋區","新莊區"};
            Intent userinfolayout = new Intent(this,AreaActivity.class);
            userinfolayout.putExtra("data",data);
            startActivity(userinfolayout);
        }
        if(position==2){
            data=new String[]{"中正區","暖暖區","八堵區"};
            Intent userinfolayout = new Intent(this,AreaActivity.class);
            userinfolayout.putExtra("data",data);
            startActivity(userinfolayout);
        };
        ArrayAdapter adapter1 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        dis.setAdapter(adapter1);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    //@Override
   /* public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        String[]data=null;
        if(position==0){
            data=new String[]{"1","2","3"};
        }
        if(position==1){
            data=new String[]{"4","5","6"};
        }
        if(position==2){
            data=new String[]{"7","8","9"};
        }
        ArrayAdapter adapter1 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        dis.setAdapter( adapter1);

    }*/
}
