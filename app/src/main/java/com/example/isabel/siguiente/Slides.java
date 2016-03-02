package com.example.isabel.siguiente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Isabel on 26/2/16.
 */
public class Slides extends Fragment {

    TextView var;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View slides=inflater.inflate(R.layout.slides,container,false);

        var = (TextView)slides.findViewById(R.id.slides);
        String strtext = getArguments().getString("hola");
        var.setText(strtext);

        return slides;
    }
}
