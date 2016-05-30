package com.project.cibertec.finalproject.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.cibertec.finalproject.R;

/**
 * Created by USUARIO on 28/05/2016.
 */
public class FragmentCliente extends Fragment{

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View view  = inflater.inflate(R.layout.fragment_cliente,container,false);
            //(FirstActivity)getActivity().getSupportActionBAR
            //final TextView  firstFragment = (TextView) view.findViewById(R.id.textone);
            return view;
        }

}
