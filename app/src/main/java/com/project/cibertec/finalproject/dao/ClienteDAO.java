package com.project.cibertec.finalproject.dao;

import android.database.Cursor;

import com.project.cibertec.finalproject.database.DataBaseSingleton;
import com.project.cibertec.finalproject.entities.Cliente;

import java.util.ArrayList;

/**
 * Created by thebe on 5/06/2016.
 */
public class ClienteDAO {

    public ArrayList<Cliente> listCliente() {
        Cursor cursor = DataBaseSingleton.getInstance().query("TB_Cliente", null, null, null, null, null, null);

        ArrayList<Cliente> lstCliente = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                lstCliente.add(transformCursorToCliente(cursor));
            } while (cursor.moveToNext());
        }

        if (cursor != null && !cursor.isClosed())
            cursor.close();

        return lstCliente;
    }

    private Cliente transformCursorToCliente(Cursor cursor) {
        Cliente cliente = new Cliente();
        cliente.setClienteId(cursor.getInt(cursor.getColumnIndex("clienteId")));
        cliente.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
        cliente.setApellido(cursor.getString(cursor.getColumnIndex("apellido")));
        cliente.setTelefono(cursor.getString(cursor.getColumnIndex("telefono")));
        cliente.setCorreo(cursor.getString(cursor.getColumnIndex("correo")));
        cliente.setEmpresa(cursor.getString(cursor.getColumnIndex("empresa")));
        cliente.setDireccion(cursor.getString(cursor.getColumnIndex("direccion")));
        cliente.setDistrito(cursor.getString(cursor.getColumnIndex("distrito")));
        cliente.setReferencia(cursor.getString(cursor.getColumnIndex("referencia")));
        cliente.setLatitud(cursor.getString(cursor.getColumnIndex("latitud")));
        cliente.setLongitud(cursor.getString(cursor.getColumnIndex("longitud")));

        return cliente;
    }

}
