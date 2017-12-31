package com.tedtedtedtedted.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CityActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private static final int USER_INFOGG = 2;
    private String[] cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        ListView city =(ListView) findViewById(R.id.city);
        String[]data={"台北市","新北市","基隆市"};
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        city.setAdapter(adapter);
        city.setOnItemClickListener(this);



      //  Intent intent =getIntent();
      //  String dataGG=intent.getStringExtra("GG");
      //  Toast.makeText(this,dataGG,Toast.LENGTH_LONG).show();





    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        String[]data=null;
        Intent arealayout = new Intent(this,AreaActivity.class);

        if(position==0){
            data=new String[]{"信義區","大安區","士林區"};

        }
        if(position==1){
            data=new String[]{"永和區","板橋區","新莊區"};

        }
        if(position==2){
            data=new String[]{"中正區","暖暖區","八堵區"};
        }
        arealayout.putExtra("data",data);
        startActivityForResult(arealayout,USER_INFOGG);





    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==USER_INFOGG) {
            if (resultCode == RESULT_OK) {
                String area =data.getStringExtra("area");
                Toast.makeText(this,area,Toast.LENGTH_LONG).show();

            }


        }










    }
}
