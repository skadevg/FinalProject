package com.project.cibertec.finalproject.producto.adapter.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.cibertec.finalproject.R;
import com.project.cibertec.finalproject.entities.Producto;

import java.util.ArrayList;

/**
 * Created by PC on 28/05/2016.
 */
public class RVAdapterListaProducto extends RecyclerView.Adapter<RVAdapterListaProducto.RVAdapterListaProductoViewHolder> {

    private ArrayList<Producto> mLstProducto;

    public RVAdapterListaProducto() {
        mLstProducto = new ArrayList<>();
    }

    public void add(Producto producto) {
        mLstProducto.add(producto);
        notifyItemInserted(mLstProducto.size() - 1);
    }

    @Override
    public RVAdapterListaProductoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVAdapterListaProductoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_lista_productos_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RVAdapterListaProductoViewHolder holder, int position) {
        Producto producto = mLstProducto.get(position);
        holder.tvProductoListItemNombre.setText(producto.getNombreProducto());
        holder.tvProductoListItemDesc.setText(producto.getDescripcionProducto());
        holder.tvProductoListItemPrecio.setText(String.valueOf(producto.getPrecioProducto()));
    }

    @Override
    public int getItemCount() {
        return mLstProducto.size();
    }

    static class RVAdapterListaProductoViewHolder extends RecyclerView.ViewHolder {

        private TextView tvProductoListItemNombre, tvProductoListItemDesc, tvProductoListItemPrecio;

        public RVAdapterListaProductoViewHolder(View itemView) {
            super(itemView);

            tvProductoListItemNombre = (TextView) itemView.findViewById(R.id.tvProductoListItemNombre);
            tvProductoListItemDesc = (TextView) itemView.findViewById(R.id.tvProductoListItemDesc);
            tvProductoListItemPrecio = (TextView) itemView.findViewById(R.id.tvProductoListItemPrecio);
        }
    }

}
