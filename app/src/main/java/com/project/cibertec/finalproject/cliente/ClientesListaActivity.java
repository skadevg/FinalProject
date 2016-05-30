package com.project.cibertec.finalproject.cliente;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.project.cibertec.finalproject.R;
import com.project.cibertec.finalproject.cliente.adapter.recyclerview.RVAdapterListaCliente;
import com.project.cibertec.finalproject.entities.Cliente;
import com.project.cibertec.finalproject.producto.ProductosListaActivity;

public class ClientesListaActivity extends AppCompatActivity {

    private RVAdapterListaCliente mRVAdapterListaCliente;

    private DrawerLayout dlMenu;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private NavigationView nvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarCliList);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Drawer Layout
        dlMenu = (DrawerLayout) findViewById(R.id.dlmenu);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(ClientesListaActivity.this, dlMenu, R.string.app_name, R.string.app_name);
        dlMenu.addDrawerListener(mActionBarDrawerToggle);

        //Navigation View
        nvMenu = (NavigationView) findViewById(R.id.nvMenu);
        nvMenu.setNavigationItemSelectedListener(nvMenuOnNavigationItemSelectedListener);

        View headerView = nvMenu.inflateHeaderView(R.layout.menu_header); //Header del drawer
        TextView txtUserName =  (TextView) headerView.findViewById(R.id.username);

        if (PreferenceManager.getDefaultSharedPreferences(ClientesListaActivity.this).getBoolean("ingreso", false)) {

            //LLenar head del drawer
            String nombreEmpleado = PreferenceManager.getDefaultSharedPreferences(ClientesListaActivity.this).getString("nombre","");
            txtUserName.setText(nombreEmpleado);

        }


        //Inflo el recycler y configuramos el Adapter
        RecyclerView rvClientesListado = (RecyclerView) findViewById(R.id.rvClientesListado);

        rvClientesListado.setLayoutManager(new LinearLayoutManager(ClientesListaActivity.this));
        rvClientesListado.setHasFixedSize(true);

        mRVAdapterListaCliente = new RVAdapterListaCliente();

        Cliente cli = new Cliente();
        cli.setEmpresa("Embotelladora Ramos");
        cli.setTelefono("986-123-567");
        cli.setDireccion("Av. arica 345");
        mRVAdapterListaCliente.add(cli);

        cli = new Cliente();
        cli.setEmpresa("Gloria S.A.");
        cli.setTelefono("992-442-523");
        cli.setDireccion("Av. El sol 4421");
        mRVAdapterListaCliente.add(cli);

        cli = new Cliente();
        cli.setEmpresa("Empresa de transportes SRL");
        cli.setTelefono("991-224-553");
        cli.setDireccion("Panam. norte km 22");
        mRVAdapterListaCliente.add(cli);

        rvClientesListado.setAdapter(mRVAdapterListaCliente);

    }

    private NavigationView.OnNavigationItemSelectedListener nvMenuOnNavigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {

            switch (item.getItemId()) {
                case R.id.nvItemclientes:
                    nvMenu.setCheckedItem(item.getItemId());
                    dlMenu.closeDrawer(GravityCompat.START);
                    return true;
                case R.id.nvItemProductos:
                    Intent listaProd = new Intent(ClientesListaActivity.this, ProductosListaActivity.class);
                    startActivity(listaProd);
                    return true;
                case R.id.nvItemPedidos:
                    return true;
                case R.id.nvItemCerrarSesion:
                    return true;
                default:
                    return true;
            }

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.drawer, menu);
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
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
