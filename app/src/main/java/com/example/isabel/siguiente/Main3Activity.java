package com.example.isabel.siguiente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    RadioButton radiob1, radiob2, radiob3;
    Button comprobaciones, Listacom;
    RadioGroup GroupRadio;
    ViewPager vistapagina;
    SectionsPagerAdapter mSectionsPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        radiob1 = (RadioButton) findViewById(R.id.radio1);
        radiob2 = (RadioButton) findViewById(R.id.radio2);
        radiob3 = (RadioButton) findViewById(R.id.radio3);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        vistapagina = (ViewPager) findViewById(R.id.container);
        vistapagina.setAdapter(mSectionsPagerAdapter);
        Listacom = (Button) findViewById(R.id.listacom);
        comprobaciones = (Button) findViewById(R.id.comprobaciones);


        comprobaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, Formulario.class);
                startActivity(intent);

            }
        });


        Listacom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, ListViewcoment.class);
                startActivity(intent);
            }
        });
        radiob1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPage();
            }
        });
        radiob2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPage();
            }
        });
        radiob3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPage();
            }
        });

        vistapagina.addOnPageChangeListener(new ViewPager.OnPageChangeListener()

        {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radiob1.setChecked(true);
                        radiob2.setChecked(false);
                        radiob3.setChecked(false);
                        break;
                    case 1:
                        radiob1.setChecked(false);
                        radiob2.setChecked(true);
                        radiob3.setChecked(false);
                        break;
                    case 2:
                        radiob1.setChecked(false);
                        radiob2.setChecked(false);
                        radiob3.setChecked(true);
                        break;
                }
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });

    }

    private void showPage() {
        if (radiob1.isChecked()) {
            vistapagina.setCurrentItem(0);
        }
        if (radiob2.isChecked()) {
            vistapagina.setCurrentItem(1);
        }
        if (radiob3.isChecked()) {
            vistapagina.setCurrentItem(2);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }


        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main3, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return Main3Activity.PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 3;
        }


        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    radiob1.setChecked(true);
                    return "SECTION 1";
                case 1:
                    radiob2.setChecked(true);
                    return "SECTION 2";
                case 2:
                    radiob3.setChecked(true);
                    return "SECTION 3";
            }
            return null;
        }

    }
}
