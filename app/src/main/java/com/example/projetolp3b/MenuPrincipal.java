package com.example.projetolp3b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }
    public void Dis(View view){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
    public void Loc(View view){
        Intent it = new Intent(this, Localizacao.class);
        startActivity(it);
    }
    public void Bus(View view){
        Intent it = new Intent(this, Bussula.class);
        startActivity(it);
    }
    public void Cre(View view){
        Intent it = new Intent(this, Creditos.class);
        startActivity(it);
    }
    public void myLoc(View view){
        Intent it = new Intent(this, myLoc.class);
        startActivity(it);
    }
}