package com.project.cibertec.finalproject;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class ListaClientesActivity extends AppCompatActivity {

    private DrawerLayout dlMenu;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private NavigationView nvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listaclientes_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dlMenu = (DrawerLayout) findViewById(R.id.dlMenu);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(ListaClientesActivity.this, dlMenu, R.string.app_name, R.string.app_name);

        dlMenu.addDrawerListener(mActionBarDrawerToggle);

        nvMenu = (NavigationView) findViewById(R.id.nvMenu);
        nvMenu.setNavigationItemSelectedListener(nvMenuOnNavigationItemSelectedListener);
    }

    NavigationView.OnNavigationItemSelectedListener nvMenuOnNavigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            nvMenu.setCheckedItem(item.getItemId());
            dlMenu.closeDrawer(GravityCompat.START);
            return true;
        }
    };

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
        return super.onOptionsItemSelected(item);
    }
}
