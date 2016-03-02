package com.example.isabel.siguiente;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Formulario extends AppCompatActivity {

    EditText com1;
    EditText com2;
    Button Enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }catch (NullPointerException e){

            Log.e("Toolbar", e.toString());

        }

        com1=(EditText)findViewById(R.id.edit1);
        com2=(EditText)findViewById(R.id.edit2);
        Enviar = (Button)findViewById(R.id.Enviar);


        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if ((com1.getText().toString().equals(""))||((com1.getText().toString().length()<5))) {


                    com1.setError("Faltan caracteres");
//                    new AlertDialog.Builder(Formulario.this).setTitle("Error")
//                            .setMessage("Minimo 5 caracteres")
//                            .setPositiveButton("OK", null).show();

                } else if ((com2.getText().toString().equals(""))||((com2.getText().toString().length()<5))) {

                    com2.setError("Faltan caracteres");

//                    new AlertDialog.Builder(Formulario.this).setTitle("Error")
//                            .setMessage("Campo2 Minimo 5 caracteres")
//                            .setPositiveButton("OK", null).show();

                } else {


                    Intent intent = new Intent(Formulario.this, Main2Activity.class);

                    Bundle b = new Bundle();
                    b.putString("Comentario", com1.getText().toString());
                    b.putString("Comentario2", com2.getText().toString());


                    intent.putExtras(b);
                    startActivity(intent);


                }

            }
        });



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
    }

}
