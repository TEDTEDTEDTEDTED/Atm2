package com.tedtedtedtedted.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AreaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final int USER_INFOGGG = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        ListView area =(ListView) findViewById(R.id.area);
        Intent intent =getIntent();
        String[]data=intent.getStringArrayExtra("data");
        //String[]data={"台北市","新北市","基隆市"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        area.setAdapter(adapter);
        area.setOnItemClickListener(this);



    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        //
        Intent intent =getIntent();
        String[]data=intent.getStringArrayExtra("data");


        if(position==0){
            getIntent().putExtra("area",data[0]);
            setResult(RESULT_OK,getIntent());
            finish();
          //  intent.putExtra("GG",data[0]);

        }
        if(position==1){
            getIntent().putExtra("area",data[1]);
            setResult(RESULT_OK,getIntent());
            finish();
           // intent.putExtra("GG",data[1]);

        }
        if(position==2){
            getIntent().putExtra("area",data[2]);
            setResult(RESULT_OK,getIntent());
            finish();
           // intent.putExtra("GG",data[2]);
        }















    }
}
