package com.project.cibertec.finalproject.adapter.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Android-SAB-PM on 14/05/2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVAdapterViewHolder>  {


    @Override
    public RVAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RVAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class RVAdapterViewHolder extends RecyclerView.ViewHolder{



        public RVAdapterViewHolder (View itemView){

            super (itemView);
        }

    }


}
