package com.project.cibertec.finalproject.pedido;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
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
import com.project.cibertec.finalproject.entities.Pedido;
import com.project.cibertec.finalproject.pedido.adapter.recyclerview.RVAdapterListaPedido;
import com.project.cibertec.finalproject.pedido.adapter.recyclerview.SPAdapter;

import java.util.ArrayList;

public class PedidosListaActivity extends AppCompatActivity{

    private RVAdapterListaPedido mRVAdapterListaPedido;

    private DrawerLayout dlMenu;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private NavigationView nvMenu;
    private RecyclerView mRVPedidosListado;
    private ArrayList<Pedido> mListaPedidos;
    private Spinner spClientes;
    private SPAdapter spFirstAdapter;
    private TextView tvClienteNombrePedido;

    private Cliente mCliente = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedidos_seleccione_producto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarPedidosList);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.tituloPedidoLista);

        //Inflo el recycler y configuramos el Adapter
        mRVPedidosListado = (RecyclerView) findViewById(R.id.rvPedidosSeleccion);
        mRVPedidosListado.setLayoutManager(new LinearLayoutManager(PedidosListaActivity.this));
        mRVPedidosListado.setHasFixedSize(true);

        mRVAdapterListaPedido = new RVAdapterListaPedido();

        mListaPedidos = new ArrayList<>();
        Pedido pedido = new Pedido();
        pedido.setNombreCliente("Embotelladora García");
        pedido.setCantidadProductos(10);
        pedido.setTotalPedido(53.20);
        mListaPedidos.add(pedido);

        pedido = new Pedido();
        pedido.setNombreCliente("Gloria S.A");
        pedido.setCantidadProductos(23);
        pedido.setTotalPedido(102.50);
        mListaPedidos.add(pedido);

        pedido = new Pedido();
        pedido.setNombreCliente("Molitalia SRL");
        pedido.setCantidadProductos(33);
        pedido.setTotalPedido(301.5);
        mListaPedidos.add(pedido);

        mRVAdapterListaPedido.addAll(mListaPedidos);
        mRVPedidosListado.setAdapter(mRVAdapterListaPedido);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
                startActivity(new Intent(PedidosListaActivity.this,NuevoPedidoActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
