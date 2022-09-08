package com.example.projetolp3b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import com.google.maps.android.SphericalUtil;


public class MainActivity extends AppCompatActivity {

    LatLng local1;
    LatLng local2;
    Double distance;

    EditText etPlace1;
    EditText etPlace2;
    Button btSubmit;
    TextView tvAddress;
    TextView tvAddress1;
    TextView tvAddress2;
    String prevAddress;
    String prevAddress1;
    String aDdress;
    String aDdress1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPlace1 = findViewById(R.id.et_place1);
        etPlace2 = findViewById(R.id.et_place2);
        btSubmit = findViewById(R.id.btn_submit);
        tvAddress = findViewById(R.id.tv_address);
        tvAddress1 = findViewById(R.id.tv_address2);
        tvAddress2 = findViewById(R.id.tv_address3);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Criando um Toast!!!!!", Toast.LENGTH_SHORT).show();

                aDdress = etPlace1.getText().toString();
                aDdress1 = etPlace2.getText().toString();

                GeoLocation geoLocation = new GeoLocation();
                geoLocation.getAddress(aDdress,getApplicationContext(),new GeoHandler());

                GeoLocation geoLocation1 = new GeoLocation();
                geoLocation.getAddress(aDdress1,getApplicationContext(),new GeoHandler1());

            }
        });

        //distance = SphericalUtil.computeDistanceBetween(sydney, Brisbane);
        //Toast.makeText(this, "Distance between Sydney and Brisbane is \n " + String.format("%.2f", distance / 1000) + "km", Toast.LENGTH_SHORT).show();

    }
    private class GeoHandler extends Handler{
        @Override
        public void  handleMessage (Message msg){
            String address;
            String lat;
            String lon;

            switch (msg.what){
                case 1:
                Bundle bundle = msg.getData();
                address = bundle.getString("address");
                lat = bundle.getString("lat");
                lon = bundle.getString("long");
                local1 = new LatLng( Double.valueOf(lat),Double.valueOf(lon));
                aDdress = address;
                break;
                default:
                    address = null;
            }
            tvAddress.setText(aDdress);
        }
    }
    private class GeoHandler1 extends Handler{
        @Override
        public void  handleMessage (Message msg){
            String address;
            String lat;
            String lon;

            switch (msg.what){
                case 1:
                    Bundle bundle = msg.getData();
                    address = bundle.getString("address");
                    lat = bundle.getString("lat");
                    lon = bundle.getString("long");
                    aDdress1 = address;
                    local2 = new LatLng( Double.valueOf(lat),Double.valueOf(lon));
                    break;
                default:
                    address = null;
            }
            tvAddress1.setText(aDdress1);
            distance = SphericalUtil.computeDistanceBetween(local1, local2);
            tvAddress2.setText(String.valueOf(distance / 1000));
        }
    }
}