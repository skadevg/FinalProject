package com.project.cibertec.finalproject.pedido;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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
public class DetallePedidoActivity extends AppCompatActivity {

    private Spinner spClientes;
    private SPAdapter spFirstAdapter;
    private TextView tvClienteNombrePedido;
    private RecyclerView mRVProductosListado;

    private RVAdapterListaProducto mRVAdapterListaProducto ;
    private ArrayList<Producto> mListaProducto;

    private Cliente mCliente = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedidos_detalle_lista);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarNuevoPedidoList);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.tituloDetallePedido);

        //Inflo el recycler y configuramos el Adapter
        mRVProductosListado = (RecyclerView) findViewById(R.id.rvPedidosDetalle);
        mRVProductosListado.setLayoutManager(new LinearLayoutManager(DetallePedidoActivity.this));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_save, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.abFirstAdd:

                //
                return true;
            case R.id.abSecondSave:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
