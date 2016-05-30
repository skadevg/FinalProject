package com.project.cibertec.finalproject.cliente.adapter.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.cibertec.finalproject.R;
import com.project.cibertec.finalproject.entities.Cliente;

import java.util.ArrayList;

/**
 * Created by PC on 28/05/2016.
 */
public class RVAdapterListaCliente extends RecyclerView.Adapter<RVAdapterListaCliente.RVAdapterListaClienteViewHolder> {

    private ArrayList<Cliente> mLstCliente;

    public RVAdapterListaCliente() {
        mLstCliente = new ArrayList<>();
    }

    public void add(Cliente cliente) {
        mLstCliente.add(cliente);
        notifyItemInserted(mLstCliente.size() - 1);
    }

    @Override
    public RVAdapterListaClienteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVAdapterListaClienteViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_lista_clientes_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RVAdapterListaClienteViewHolder holder, int position) {
        Cliente cliente = mLstCliente.get(position);
        holder.tvListCliItemNombre.setText(cliente.getEmpresa());
        holder.tvListCliItemTelefono.setText(cliente.getTelefono());
        holder.tvListCliItemDireccion.setText(cliente.getDireccion());
        holder.ivListCliItemPuntero.setImageResource(R.drawable.google_map_marker_icon);
    }

    @Override
    public int getItemCount() {
        return mLstCliente.size();
    }

    static class RVAdapterListaClienteViewHolder extends RecyclerView.ViewHolder {

        private TextView tvListCliItemNombre, tvListCliItemTelefono, tvListCliItemDireccion;
        private ImageView ivListCliItemPuntero;

        public RVAdapterListaClienteViewHolder(View itemView) {
            super(itemView);

            tvListCliItemNombre = (TextView) itemView.findViewById(R.id.tvListCliItemNombre);
            tvListCliItemDireccion = (TextView) itemView.findViewById(R.id.tvListCliItemDireccion);
            tvListCliItemTelefono = (TextView) itemView.findViewById(R.id.tvListCliItemTelefono);
            ivListCliItemPuntero = (ImageView) itemView.findViewById(R.id.ivListCliItemPuntero);
        }
    }

}
