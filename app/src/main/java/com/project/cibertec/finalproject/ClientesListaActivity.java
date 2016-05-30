package com.project.cibertec.finalproject;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ClientesListaActivity extends AppCompatActivity {

    private DrawerLayout dlMenu;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private NavigationView nvMenu;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clienteslista_activity);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nvMenu = (NavigationView) findViewById(R.id.nvMenu);

        nvMenu.setNavigationItemSelectedListener(nvMenuOnNavigationItemSelectedListener);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dlMenu = (DrawerLayout) findViewById(R.id.drawer);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(ClientesListaActivity.this, dlMenu, R.string.app_name, R.string.app_name);

        dlMenu.setDrawerListener(mActionBarDrawerToggle);

        mActionBarDrawerToggle.syncState();
    }

    NavigationView.OnNavigationItemSelectedListener nvMenuOnNavigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            nvMenu.setCheckedItem(item.getItemId());
            dlMenu.closeDrawer(GravityCompat.START);

            if (item.isChecked()) item.setChecked(false);
            else item.setChecked(true);

            //Closing drawer on item click
            dlMenu.closeDrawers();

            //Check to see which item was being clicked and perform appropriate action
            switch (item.getItemId()) {


                //Replacing the main content with ContentFragment Which is our Inbox View;
                case R.id.inbox:
                    startActivityForResult(new Intent(ClientesListaActivity.this, ClientesNuevoActivity.class), 999);
                    return true;
                case R.id.starred:
                    startActivityForResult(new Intent(ClientesListaActivity.this, ClientesListaActivity.class), 999);
                    return true;
                case R.id.sent_mail:
                    startActivityForResult(new Intent(ClientesListaActivity.this, ProductosListaActivity.class), 999);
                    return true;
                case R.id.drafts:
                    startActivityForResult(new Intent(ClientesListaActivity.this, PedidosListaActivity.class), 999);
                    return true;
                default:
                    Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                    return true;
            }


//            return true;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.drawer, menu);
        getMenuInflater().inflate(R.menu.clienteslista_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mActionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        if (item.getItemId() == R.id.abFirstAdd) {
            startActivityForResult(new Intent(ClientesListaActivity.this, ClientesNuevoActivity.class), 999);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
