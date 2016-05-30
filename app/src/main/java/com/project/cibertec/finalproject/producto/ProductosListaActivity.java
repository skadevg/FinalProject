package com.project.cibertec.finalproject.producto;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

import com.project.cibertec.finalproject.R;
import com.project.cibertec.finalproject.cliente.ClientesNuevoActivity;
import com.project.cibertec.finalproject.cliente.adapter.recyclerview.RVAdapterListaCliente;
import com.project.cibertec.finalproject.entities.Cliente;
import com.project.cibertec.finalproject.entities.Producto;
import com.project.cibertec.finalproject.producto.adapter.recyclerview.RVAdapterListaProducto;

public class ProductosListaActivity extends AppCompatActivity {

    private RVAdapterListaProducto mRVAdapterListaProducto;

    private DrawerLayout dlMenu;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private NavigationView nvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productos_lista_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarProdList);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Inflo el recycler y configuramos el Adapter
        RecyclerView mRvProductosListado = (RecyclerView) findViewById(R.id.rvProductosListado);

        mRvProductosListado.setLayoutManager(new LinearLayoutManager(ProductosListaActivity.this));
        mRvProductosListado.setHasFixedSize(true);

        mRVAdapterListaProducto = new RVAdapterListaProducto();

        Producto pro = new Producto();
        pro.setNombreProducto("Coca cola");
        pro.setDescripcionProducto("Botella de 500ml");
        pro.setPrecioProducto(3.20);
        mRVAdapterListaProducto.add(pro);

        pro = new Producto();
        pro.setNombreProducto("Panetón");
        pro.setDescripcionProducto("bolsa 5kg");
        pro.setPrecioProducto(10.50);
        mRVAdapterListaProducto.add(pro);

        pro = new Producto();
        pro.setNombreProducto("Arroz Costeño");
        pro.setDescripcionProducto("Bolsa 2Kg");
        pro.setPrecioProducto(3.5);
        mRVAdapterListaProducto.add(pro);

        mRvProductosListado.setAdapter(mRVAdapterListaProducto);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.drawer, menu);
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.abFirstAdd:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
