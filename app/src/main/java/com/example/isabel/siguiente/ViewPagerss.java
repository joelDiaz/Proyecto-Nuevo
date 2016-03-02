package com.example.isabel.siguiente;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ViewPagerss extends AppCompatActivity {



    Button comprobaciones ;
    Button Listacom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        comprobaciones = (Button)findViewById(R.id.comprobaciones);

        comprobaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewPagerss.this, Formulario.class);
                startActivity(intent);

            }
        });

        Listacom = (Button)findViewById(R.id.listacom);

        Listacom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewPagerss.this,ListViewcoment.class);
                startActivity(intent);
            }
        });

    }

}
