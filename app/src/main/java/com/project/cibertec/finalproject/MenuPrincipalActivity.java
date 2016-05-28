package com.project.cibertec.finalproject;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.project.cibertec.finalproject.fragments.FragmentCliente;
import com.project.cibertec.finalproject.fragments.FragmentPedidos;

public class MenuPrincipalActivity extends AppCompatActivity {

    private DrawerLayout dlMenu;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private NavigationView nvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuprincipal_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dlMenu = (DrawerLayout) findViewById(R.id.dlMenu);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(MenuPrincipalActivity.this, dlMenu, R.string.app_name, R.string.app_name);

        dlMenu.addDrawerListener(mActionBarDrawerToggle);
        nvMenu = (NavigationView) findViewById(R.id.nvMenu);
        nvMenu.setNavigationItemSelectedListener(nvMenuOnNavigationItemSelectedListener);

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
        return super.onOptionsItemSelected(item);
    }
    NavigationView.OnNavigationItemSelectedListener nvMenuOnNavigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // nvMenu.setCheckedItem(item.getItemId());
            // dlMenu.closeDrawer(GravityCompat.START);
            // return true;
            switch (item.getItemId()) {
                case R.id.navMenuClientes :
                    item.setChecked(true);
                    setFragment(0);
                    dlMenu.closeDrawer(GravityCompat.START);
                    return true;
                case R.id.navMenuProductos:
                    setFragment(1);
                    dlMenu.closeDrawer(GravityCompat.START);
                    return true;
                case R.id.navMenuPedidos :
                    item.setChecked(true);
                    setFragment(0);
                    dlMenu.closeDrawer(GravityCompat.START);
                    return true;
                case R.id.navMenuCerrarSesion:
                    setFragment(1);
                    dlMenu.closeDrawer(GravityCompat.START);
                    return true;
                default: return  false;
            }
        }
    };

    public void setFragment (int pos){
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction ;
        switch (pos){
            case 0:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                FragmentCliente fragmentCliente = new FragmentCliente();
                fragmentTransaction.replace(R.id.idFragment,fragmentCliente);
                fragmentTransaction.commit();
                break;
            case 1 :
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                FragmentPedidos fragmentPedidos = new FragmentPedidos();
                fragmentTransaction.replace(R.id.idFragment,fragmentPedidos);
                fragmentTransaction.commit();
                break;

        }

    }
}
