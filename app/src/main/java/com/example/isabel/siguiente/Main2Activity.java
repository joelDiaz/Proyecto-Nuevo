package com.example.isabel.siguiente;

import android.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    TextView recibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recibido = (TextView) findViewById(R.id.contenedor);
        String loquendo = getIntent().getStringExtra("Comentario");
        recibido.setText(loquendo);





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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.content_fragment, new MainFragment()).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();

        int id = item.getItemId();

        if (id == R.id.nav_camera) {
//            Fragment fragment=null;
//            fragment = new Gallery();
//            Bundle bundle = new Bundle();
//            bundle.putString("hola", "sidwiiii iiiiiiiiii");
//            fragment.setArguments(bundle);
//            fragmentTransaction = true;
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//            Bundle b = new Bundle();
//            b.putString("Comentario", "tomaaaa");

            fm.beginTransaction()
                    .replace(R.id.content_fragment, new Fragment1())
                    .commit();


        } else if (id == R.id.nav_gallery) {


            Fragment fragment = null;
            fragment = new Gallery();
            Bundle bundle = new Bundle();
            bundle.putString("hola", getIntent().getStringExtra("Comentario"));
            fragment.setArguments(bundle);

            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_fragment, fragment);
            transaction.commit();



        } else if (id == R.id.nav_slideshow) {

            Fragment fragment = null;
            fragment = new Slides();
            Bundle bundle = new Bundle();
            bundle.putString("hola", getIntent().getStringExtra("Comentario2"));
            fragment.setArguments(bundle);

            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_fragment, fragment);
            transaction.commit();

        } else if (id == R.id.nav_manage) {

            fm.beginTransaction()
                    .replace(R.id.content_fragment, new Tools())
                    .commit();
        } else if (id == R.id.nav_share) {


        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
