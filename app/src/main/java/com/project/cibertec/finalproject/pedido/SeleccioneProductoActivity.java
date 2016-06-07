package com.project.cibertec.finalproject.pedido;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.project.cibertec.finalproject.R;
import com.project.cibertec.finalproject.entities.Cliente;
import com.project.cibertec.finalproject.entities.Producto;
import com.project.cibertec.finalproject.pedido.adapter.recyclerview.SPAdapter;
import com.project.cibertec.finalproject.producto.adapter.recyclerview.RVAdapterListaProducto;

import java.util.ArrayList;

/**
 * Created by V825727 on 6/7/2016.
 */
public class SeleccioneProductoActivity extends AppCompatActivity {



    private TextView tvClienteNombrePedido;
    private RecyclerView mRVProductosListado;

    private RVAdapterListaProducto mRVAdapterListaProducto ;
    private ArrayList<Producto> mListaProducto;

    private Cliente mCliente = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedidos_seleccione_producto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarSelectProd);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.tituloSeleccioneProducto);

        //Inflo el recycler y configuramos el Adapter
        mRVProductosListado = (RecyclerView) findViewById(R.id.rvPedidosSeleccion);
        mRVProductosListado.setLayoutManager(new LinearLayoutManager(SeleccioneProductoActivity.this));
        mRVProductosListado.setHasFixedSize(true);

        mRVAdapterListaProducto = new RVAdapterListaProducto();
        mListaProducto = new ArrayList<>();
        Producto producto = new Producto();
        producto.setNombreProducto("Sprite");
        producto.setDescripcionProducto("Esta es una gaseosa");
        producto.setPrecioProducto(5.4);
        mListaProducto.add(producto);

        producto = new Producto();
        producto.setNombreProducto("Coca Cola");
        producto.setDescripcionProducto("Esta es una Coke");
        producto.setPrecioProducto(10.5);
        mListaProducto.add(producto);

        mRVAdapterListaProducto.addAll(mListaProducto);
        mRVProductosListado.setAdapter(mRVAdapterListaProducto);

    }



}
