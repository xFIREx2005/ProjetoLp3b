package com.example.projetolp3b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Creditos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);
    }

    public void Voltar(View view){
        Intent it = new Intent(this, MenuPrincipal.class);
        startActivity(it);
    }
    public void siteBG(View view){
        String url = "https://www.instagram.com/etecbasilides/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public void siteWO(View view){
        String url = "https://www.instagram.com/older_wood_studio/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}