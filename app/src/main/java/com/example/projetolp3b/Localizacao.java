package com.example.projetolp3b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

public class Localizacao extends AppCompatActivity {

    EditText etView;
    Button btSubmit;
    TextView txtLoc;
    String aDdress;
    String lat;
    String lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacao);

        etView = findViewById(R.id.etView);
        btSubmit = findViewById(R.id.btnSubmit);
        txtLoc = findViewById(R.id.txtLoc);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Localizacao.this, "Criando um Toast!!!!!", Toast.LENGTH_SHORT).show();

                aDdress = etView.getText().toString();

                GeoLocation geoLocation = new GeoLocation();
                geoLocation.getAddress(aDdress,getApplicationContext(),new Localizacao.GeoHandler());
            }
        });
    }
    private class GeoHandler extends Handler {
        @Override
        public void  handleMessage (Message msg){
            String address;

            switch (msg.what){
                case 1:
                    Bundle bundle = msg.getData();
                    address = bundle.getString("address");
                    lat = bundle.getString("lat");
                    lon = bundle.getString("long");
                    aDdress = address;
                    break;
                default:
                    address = null;
            }
            txtLoc.setText(aDdress);
            mostrarGoogleMaps(Double.valueOf(lat),Double.valueOf(lon));
        }
    }

    public void mostrarGoogleMaps(double latitude, double longitude) {
        WebView wv = findViewById(R.id.webv);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://www.google.com/maps/search/?api=1&query=" + latitude + "," + longitude);
    }
}