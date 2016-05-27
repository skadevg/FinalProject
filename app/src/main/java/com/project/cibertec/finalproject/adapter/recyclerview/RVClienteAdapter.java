package com.project.cibertec.finalproject.adapter.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.cibertec.finalproject.R;
import com.project.cibertec.finalproject.adapter.recyclerview.interfaces.IRVClienteAdapter;
import com.project.cibertec.finalproject.entities.Cliente;

import java.util.ArrayList;

/**
 * Created by thebe on 28/05/2016.
 */
public class RVClienteAdapter extends RecyclerView.Adapter<RVClienteAdapter.RVClienteAdapterViewHolder> {
//    extends RecyclerView.Adapter<RVClienteAdapter.RVClienteAdapterViewHolder>

    private ArrayList<Cliente> mLstCliente;
    private IRVClienteAdapter mIRVClienteAdapter;

    public RVClienteAdapter(IRVClienteAdapter mIRVClienteAdapter) {
        this.mIRVClienteAdapter = mIRVClienteAdapter;
        mLstCliente = new ArrayList<>();
    }

    public void add(Cliente cliente) {
        mLstCliente.add(cliente);
        notifyItemInserted(mLstCliente.size() - 1);
    }

    public void addAll(ArrayList<Cliente> lstCliente) {
        int position = mLstCliente.size();
        mLstCliente.addAll(lstCliente);
        notifyItemRangeInserted(position, lstCliente.size());
    }

    public void clearAndAddAll(ArrayList<Cliente> lstCliente) {
        mLstCliente.clear();
        mLstCliente.addAll(lstCliente);
        notifyDataSetChanged();
    }
    @Override
    public RVClienteAdapter.RVClienteAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVClienteAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cliente_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RVClienteAdapter.RVClienteAdapterViewHolder holder, int position) {
        Cliente cliente = mLstCliente.get(position);
        String codigo = "00000000" + String.valueOf(cliente.getClienteId());

        //----------------------------------------------------
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(itemViewOnClickListener);
    }

    View.OnClickListener itemViewOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = (int) v.getTag();
            mIRVClienteAdapter.onSelectItem(mLstCliente.get(position));
        }
    };

    @Override
    public int getItemCount() {return mLstCliente.size();
    }

    public class RVClienteAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView tvClienteClienteId, tvClienteNombre, tvClienteApellido, tvCliente;

        public RVClienteAdapterViewHolder(View itemView) {
            super(itemView);
        }
    }


}
