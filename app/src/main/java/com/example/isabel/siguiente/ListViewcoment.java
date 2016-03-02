package com.example.isabel.siguiente;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import java.util.ArrayList;

public class ListViewcoment extends AppCompatActivity {

    EditText comentario;
    ListView listacom;
    Button Comentar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (NullPointerException e) {

            Log.e("Toolbar", e.toString());

        }
        comentario = (EditText) findViewById(R.id.comentario);
        Comentar = (Button) findViewById(R.id.Comentar);
        listacom = (ListView) findViewById(R.id.listas_view);


        final ArrayList<String> lista = new ArrayList<>();
        final ArrayAdapter<String> adaptador;
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        final ListView selecte = (ListView) findViewById(R.id.listas_view);
        adaptador.setDropDownViewResource(android.R.layout.simple_list_item_1);
        selecte.setAdapter(adaptador);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Comentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((comentario.getText().toString().length() > 0)) {

                    lista.add(comentario.getText().toString());
                    adaptador.notifyDataSetChanged();
                    comentario.setText("");
                } else if ((comentario.getText().toString().equals(""))) {

                    new AlertDialog.Builder(ListViewcoment.this).setTitle("Error")
                            .setMessage("Debes escribir algo")
                            .setPositiveButton("OK", null).show();

                }


            }
        });


    }


}
