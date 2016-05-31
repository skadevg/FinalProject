package com.project.cibertec.finalproject.producto;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
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

import java.util.ArrayList;
import java.util.List;

public class ProductosListaActivity extends AppCompatActivity {

    private RVAdapterListaProducto mRVAdapterListaProducto;

    private DrawerLayout dlMenu;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private NavigationView nvMenu;
    private  RecyclerView mRvProductosListado;
    private ArrayList<Producto> mListaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productos_lista_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarProdList);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Productos");

        //Inflo el recycler y configuramos el Adapter
        mRvProductosListado = (RecyclerView) findViewById(R.id.rvProductosListado);

        mRvProductosListado.setLayoutManager(new LinearLayoutManager(ProductosListaActivity.this));
        mRvProductosListado.setHasFixedSize(true);

        mRVAdapterListaProducto = new RVAdapterListaProducto();

        mListaProductos = new ArrayList<>();
        Producto pro = new Producto();
        pro.setNombreProducto("Coca cola");
        pro.setDescripcionProducto("Botella de 500ml");
        pro.setPrecioProducto(3.20);
        mListaProductos.add(pro);

        pro = new Producto();
        pro.setNombreProducto("Panetón");
        pro.setDescripcionProducto("Bolsa 5kg");
        pro.setPrecioProducto(10.50);
        mListaProductos.add(pro);

        pro = new Producto();
        pro.setNombreProducto("Arroz Costeño");
        pro.setDescripcionProducto("Bolsa 2Kg");
        pro.setPrecioProducto(3.5);
        mListaProductos.add(pro);

        mRVAdapterListaProducto.addAll(mListaProductos);
        mRvProductosListado.setAdapter(mRVAdapterListaProducto);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_search, menu);

        final MenuItem item = menu.findItem(R.id.abFirstSearch);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(itemOnQueryTextListener);

        return super.onCreateOptionsMenu(menu);
    }

    SearchView.OnQueryTextListener itemOnQueryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {return false;}

        @Override
        public boolean onQueryTextChange(String query) {
            final ArrayList<Producto> filteredProductList = filter(mListaProductos, query);
            mRVAdapterListaProducto.animateTo(filteredProductList);
            mRvProductosListado.scrollToPosition(0);
            return true;
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.abFirstAdd:
                Intent nuevoProd = new Intent(ProductosListaActivity.this, ProductosNuevoActivity.class);
                startActivityForResult(nuevoProd,99);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private ArrayList<Producto> filter(ArrayList<Producto> products, String query) {
        query = query.toLowerCase();

        final ArrayList<Producto> filteredProductList = new ArrayList<>();
        for (Producto producto : products) {
            final String nombre = producto.getNombreProducto().toLowerCase();
            final String descripcion = producto.getDescripcionProducto().toLowerCase();
            if (nombre.contains(query) || descripcion.contains(query)) {
                filteredProductList.add(producto);
            }
        }
        return filteredProductList;
    }

}
