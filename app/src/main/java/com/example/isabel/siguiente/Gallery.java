package com.example.isabel.siguiente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Isabel on 26/2/16.
 */
public class Gallery extends Fragment {

    TextView servicio;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista= inflater.inflate(R.layout.galery, container, false);
        servicio = (TextView)vista.findViewById(R.id.textgaleria);

        try {
            String strtext = getArguments().getString("hola");
            servicio.setText(strtext);
        }catch (NullPointerException e){
            Log.e("Errorr",e.toString());


        }


        return vista;



    }


}
